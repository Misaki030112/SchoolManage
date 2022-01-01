package center.misaki.schoolgrade.Controller;

import center.misaki.schoolgrade.Service.StudentService;
import center.misaki.schoolgrade.Service.TeacherService;
import center.misaki.schoolgrade.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;


    @GetMapping("/")
    public String Login1(){
        return "login";
    }


    @PostMapping("/login/submit")
    public String login2(String username, String password, HttpSession session,Model model){
        if(Objects.equals(username, "")||username==null){
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
        boolean success = userService.isLoginSuccess(username, password);
        if(success){
            String s = userService.roleGet(username);
            session.setAttribute("role",s);
            if(Objects.equals(s, "Teacher")) {
                session.setAttribute("teacherName",teacherService.getTeacherByUsername(username).getName());
                return "forward:/teacher/grade/d";
            }
            if(Objects.equals(s, "Admin"))
                return "forward:/admin/gradeSelect";
            if(Objects.equals(s, "Student")){
                session.setAttribute("StudentId",studentService.getStudentU(username).getStudentId()) ;
                return "forward:/student/grade/c";
            }
            return "login";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }

    }
}
