package center.misaki.schoolgrade.Controller;

import center.misaki.schoolgrade.Pojo.Student;
import center.misaki.schoolgrade.Pojo.StudentGrade;
import center.misaki.schoolgrade.Pojo.SysCourse;
import center.misaki.schoolgrade.Pojo.Teacher;
import center.misaki.schoolgrade.Service.CourseService;
import center.misaki.schoolgrade.Service.GradeService;
import center.misaki.schoolgrade.Service.StudentService;
import center.misaki.schoolgrade.Service.TeacherService;
import center.misaki.schoolgrade.Domain.Course;
import center.misaki.schoolgrade.Domain.Grade;
import center.misaki.schoolgrade.Domain.Stu;
import center.misaki.schoolgrade.Domain.Teac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 汪世胤
 * 从控制器类用于响应管理员的的各种行为
 */
@Controller
public class AdminController {
    @Autowired
    GradeService gradeService;
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping("/admin")
    public String admin(){
        return "redirect:/admin/gradeSelect";
    }

    @RequestMapping("/admin/gradeSelect")
    public String gradeSelect(Model model){
        List<StudentGrade> allStudentGrades = gradeService.getAllStudentGrades();
        model.addAttribute("AllGrades",allStudentGrades);
        return "pages/admin-grade";
    }

    @RequestMapping("/admin/gradeModify")
    public String gradeM(Model model){
        List<StudentGrade> allStudentGrades = gradeService.getAllStudentGrades();
        model.addAttribute("AllGrades",allStudentGrades);
        return "pages/admin-grademodify";
    }
    @ResponseBody
    @PostMapping("/admin/gradeModify/ing")
    public String gradeModify(Grade grade){
        gradeService.ModifyStudentGrade(grade);
        return "修改成功！";
    }

    @ResponseBody
    @PostMapping("/admin/gradeModify/del")
    public String gradeDelete(Grade grade){
        gradeService.DeleteStudentGrade(grade);
        return "删除成功！";
    }

    @RequestMapping("/admin/course/c")
    public String courseAdminc(Model model){
        List<SysCourse> allCourses = courseService.getAllCourses();
        model.addAttribute("allCourses",allCourses);
        return "pages/admin-coursec";
    }


    @RequestMapping("/admin/course/u")
    public String courseAdminu(Model model){
        List<SysCourse> allCourses = courseService.getAllCourses();
        model.addAttribute("allCourses",allCourses);
        return "pages/admin-courseu";
    }

    @ResponseBody
    @PostMapping("/admin/course/modify")
    public String courseM(Course course){
        courseService.ModifyCourse(course);
        return "修改成功！";
    }

    @ResponseBody
    @PostMapping("/admin/course/del")
    public String courseD(Course course){
        courseService.DeleteCourse(course);
        return "删除成功！";
    }


    @RequestMapping("/admin/studnt/c")
    public String studentAdminc(Model model){
        List<Student> allStudents=studentService.getAllStudent();
        model.addAttribute("allStudents",allStudents);
        return "pages/admin-studentsc";
    }

    @RequestMapping("/admin/studnt/u")
    public String studentAdminu(Model model){
        List<Student> allStudents=studentService.getAllStudent();
        model.addAttribute("allStudents",allStudents);
        return "pages/admin-studentsu";
    }

    @ResponseBody
    @PostMapping("/admin/student/modify")
    public String studentmodify(Stu stu){
        studentService.ModifyStudent(stu);
        return "修改成功！";
    }

    @ResponseBody
    @PostMapping("/admin/student/del")
    public String studentD(Stu stu){
        studentService.DeleteStudent(stu);
        return "删除成功！";
    }

    @RequestMapping("/admin/teacher/c")
    public String teacherAdminc(Model model){
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        model.addAttribute("allTeachers",allTeachers);
        return "pages/admin-teacherc";
    }

    @RequestMapping("/admin/teacher/u")
    public String teacherAdminu(Model model){
        List<Teacher> allTeachers = teacherService.getAllTeachers();
        model.addAttribute("allTeachers",allTeachers);
        return "pages/admin-teacheru";
    }

    @ResponseBody
    @PostMapping("/admin/teacher/modify")
    public String teacherModify(Teac teac){
        teacherService.ModifiedTeacher(teac);
        return "修改成功!";
    }

    @ResponseBody
    @PostMapping("/admin/teacher/del")
    public String teacherD(Teac teac){
        teacherService.DelTeacher(teac);
        return "删除成功!";
    }
    @RequestMapping("/admin/logout")
    public String AdminL(HttpSession session){
        session.removeAttribute("role");
        return "login";
    }


}
