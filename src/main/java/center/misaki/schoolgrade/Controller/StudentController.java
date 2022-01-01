package center.misaki.schoolgrade.Controller;

import center.misaki.schoolgrade.Pojo.Student;
import center.misaki.schoolgrade.Pojo.StudentGrade;
import center.misaki.schoolgrade.Pojo.SysCourse;
import center.misaki.schoolgrade.Service.CourseService;
import center.misaki.schoolgrade.Service.GradeService;
import center.misaki.schoolgrade.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 此控制器类处理学生的请求
 */
@Controller
public class StudentController {
    @Autowired
    GradeService gradeService;
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;

    @RequestMapping("/student/grade/c")
    public String studnetC(HttpSession session, Model model){
        String studentId = (String) session.getAttribute("StudentId");
        List<StudentGrade> grades = gradeService.getStudentGradeByStudentId(studentId);
        model.addAttribute("AllGrades",grades);
        return "pages/student-gradec";
    }


    @RequestMapping("/student/course/c")
    public String studentCourseC(HttpSession session,Model model){
        String studentId = (String) session.getAttribute("StudentId");
        List<SysCourse> courses = courseService.getAllCoursesByStudentId(studentId);
        model.addAttribute("allCourses",courses);
        return "pages/student-coursec";
    }

    @RequestMapping("/student/message/c")
    public String studentMessageC(HttpSession session,Model model){
        String studentId = (String) session.getAttribute("StudentId");
        Student student = studentService.getStudent(studentId);
        model.addAttribute("student",student);
        return "pages/student-messagec";
    }

    @RequestMapping("/student/message/u")
    public String StudentMessageU(Model model){
        return "pages/student-messageu";
    }


    @PostMapping("/student/message/mima")
    public String StudentMessageU1(String studentId, String secret,Model model,HttpSession session){

        String studentId1 = (String) session.getAttribute("StudentId");
        if(!studentId1.equals(studentId)){
            model.addAttribute("msg","修改失败，学号错误！");
            return "pages/student-messageu";
        }
        studentService.ModifyStudents(studentId1,secret);
        model.addAttribute("msg","修改成功！");
        return "pages/student-messageu";
    }

    @RequestMapping("/student/logout")
    public String StudnetL(HttpSession session){
        session.removeAttribute("StudentId");
        session.removeAttribute("role");
        return "login";
    }

}
