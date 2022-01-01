package center.misaki.schoolgrade.Dao;

import center.misaki.schoolgrade.Pojo.SysCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SysCourseDao extends JpaRepository<SysCourse,Integer> {
    SysCourse findByCourseCode(Integer courseCode);

    SysCourse findByCourseCodeAndCourseTeacher(Integer courseCode, String courseTeacher);

    //得到这个老师教的所有课程
    List<SysCourse> findByCourseTeacher(String courseTeacher);


    @Query(value = "select * from sys_course where course_teacher in (select  course_teacher from student_grade where student_id=?1)\n" +
            "and course_code in (select  course_code from student_grade where student_id=?1)",nativeQuery = true)
    List<SysCourse> getAllCourseByStudentId(String StudentId);

}
