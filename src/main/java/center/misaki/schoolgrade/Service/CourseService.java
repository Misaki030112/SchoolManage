package center.misaki.schoolgrade.Service;

import center.misaki.schoolgrade.Pojo.SysCourse;
import center.misaki.schoolgrade.Domain.Course;

import java.util.List;

public interface CourseService {
    //返回所有课程清单
    List<SysCourse> getAllCourses();

    //修改一门课程
    void ModifyCourse(Course course);

    //删除一门课程
    void DeleteCourse(Course course);

    //新增一门课程
    void AddCourse(Course course);

    //得到这个老师教的所有课程
    List<SysCourse> getAllCoursesByTeacher(String TeacherName);

    //根据学号得到这个学生的所有课程
    List<SysCourse> getAllCoursesByStudentId(String StudentId);
}
