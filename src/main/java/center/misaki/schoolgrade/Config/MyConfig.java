package center.misaki.schoolgrade.Config;

import center.misaki.schoolgrade.Interceptor.AdminInterceptor;
import center.misaki.schoolgrade.Interceptor.LoginInterceptor;
import center.misaki.schoolgrade.Interceptor.StudentInterceptor;
import center.misaki.schoolgrade.Interceptor.TeacherInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类，配置访问权限
 * @author  汪世胤
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/", "/login/submit", "/css/**", "/images/**", "/js/**", "/fonts/**","/static/**");

        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
        registry.addInterceptor(new StudentInterceptor()).addPathPatterns("/student/**");
        registry.addInterceptor(new TeacherInterceptor()).addPathPatterns("/teacher/**");
    }
}
