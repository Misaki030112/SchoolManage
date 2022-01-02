package center.misaki.schoolgrade.Controller;

import center.misaki.schoolgrade.Domain.Grade;
import center.misaki.schoolgrade.Pojo.StudentGrade;
import center.misaki.schoolgrade.Pojo.SysCourse;
import center.misaki.schoolgrade.Pojo.Teacher;
import center.misaki.schoolgrade.Service.CourseService;
import center.misaki.schoolgrade.Service.GradeService;
import center.misaki.schoolgrade.Service.TeacherService;
import center.misaki.schoolgrade.Domain.GDeatail;
import center.misaki.schoolgrade.Domain.GradeGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 汪世胤
 * 此控制器类控制老师的各种行为
 */
@Controller
public class TeacherController {

    @Autowired
    GradeService gradeService;
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/teacher/grade/d")
    public String teacherGraded(HttpSession session,Model model){
        String teacherName = (String) session.getAttribute("teacherName");
        List<GDeatail> detail = gradeService.getAllGradeDetail(teacherName);
        Map<String, List<Integer>> order = gradeService.getOrder(teacherName);
        model.addAttribute("order",order);
        return "pages/teacher-graded";
    }


    @ResponseBody
    @RequestMapping("/teacher/grade/graph")
    public List<GradeGraph> teacherGh(HttpSession session){
        String teacherName = (String) session.getAttribute("teacherName");
        return gradeService.getDataForGraph(teacherName);
    }

    @RequestMapping("/teacher/grade/c")
    public String teacherC( HttpSession session,Model model){
        String teacherName = (String) session.getAttribute("teacherName");
        List<StudentGrade> allStudentGrades = gradeService.getStudentGradeByTeacherName(teacherName);
        model.addAttribute("AllGrades",allStudentGrades);
        return "pages/teacher-gradec";
    }


    @RequestMapping("/teacher/grade/u")
    public String teacherU(HttpSession session,Model model){
        String teacherName = (String) session.getAttribute("teacherName");
        List<StudentGrade> allStudentGrades = gradeService.getStudentGradeByTeacherName(teacherName);
        model.addAttribute("AllGrades",allStudentGrades);
        return "pages/teacher-gradeu";
    }

    @ResponseBody
    @PostMapping("/teacher/gradeModify/ing")
    public String teacherModify(HttpSession session, Grade grade){
        if(gradeService.isHave(grade)){
            gradeService.ModifyStudentGrade(grade);
            return "修改成功！";
        }else{
            String teacherName = (String) session.getAttribute("teacherName");
            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setGrade(grade.getGrade()).setCourseTeacher(teacherName).setCourseCode(grade.getCourseCode()).setCourseName(grade.getCourseName())
                            .setStudentId(grade.getStudentId()).setStudentName(grade.getStudentName());
            gradeService.AddStudentGrade(studentGrade);
        }
        return "添加成功!";
    }

    @RequestMapping("/teacher/course/c")
    public String teacherCourseC(HttpSession session,Model model){
        String teacherName = (String) session.getAttribute("teacherName");
        List<SysCourse> allCourses = courseService.getAllCoursesByTeacher(teacherName);
        model.addAttribute("allCourses",allCourses);
        return "pages/teacher-coursec";
    }
    @ResponseBody
    @PostMapping("/teacher/gradeModify/del")
    public String gradeDelete(Grade grade){
        gradeService.DeleteStudentGrade(grade);
        return "删除成功！";
    }


    @RequestMapping("/teacher/message/c")
    public String teacherMessageC(HttpSession session,Model model){
        String teacherName = (String) session.getAttribute("teacherName");
        Teacher teacher = teacherService.getTeacher(teacherName);
        model.addAttribute("teacher",teacher);
        return "pages/teacher-message";
    }

    @RequestMapping("/teacher/message/u")
    public String teacherMessu(){
        return "pages/teacher-messageu";
    }

    @PostMapping("/teacher/message/mima")
    public String StudentMessageU1(String workId, String secret,Model model,HttpSession session){

        String teacherName = (String) session.getAttribute("teacherName");
        Teacher teacher = teacherService.getTeacher(teacherName);
        if(!workId.equals(teacher.getWorkId())){
            model.addAttribute("msg","修改失败，工号错误！");
            return "pages/teacher-messageu";
        }
        teacherService.ModifyTeacherMessage(workId,secret);
        model.addAttribute("msg","修改成功！");
        return "pages/teacher-messageu";
    }

    @RequestMapping("/teacher/logout")
    public String teacherL(HttpSession session){
        session.removeAttribute("teacherName");
        session.removeAttribute("role");
        return "login";
    }
}
