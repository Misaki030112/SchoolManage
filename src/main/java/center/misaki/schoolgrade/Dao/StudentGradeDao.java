package center.misaki.schoolgrade.Dao;

import center.misaki.schoolgrade.Pojo.StudentGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentGradeDao extends JpaRepository<StudentGrade,Integer> {

    //返回单个学生的所有学科的成绩
    List<StudentGrade> findAllByStudentId(String studentId);

    //返回这个班级内这个学科所有学生的成绩
    @Query(value = "select * from student_grade where\n" +
            "student_name in (\n" +
            "    select name from student where class_id= ?1\n" +
            "    )\n" +
            "and course_name= ?2" ,nativeQuery = true)
    List<StudentGrade> getAllGradeInClassForSubject(Integer class_id,String course_name);

    //查询某门学科下所有学生的成绩
    List<StudentGrade> findAllByCourseName(String courseName);


    //根据学生ID与课程Id查询出一条记录
    StudentGrade findByStudentIdAndCourseCode(String StudentId,Integer CourseCode);


    //查询到这个老师教的所有的学生的成绩
    List<StudentGrade> findByCourseTeacher(String CourseTeacher);


    List<StudentGrade> findByStudentId(String StudentId);




}
