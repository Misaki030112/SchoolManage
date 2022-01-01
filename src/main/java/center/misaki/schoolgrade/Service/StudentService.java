package center.misaki.schoolgrade.Service;

import center.misaki.schoolgrade.Pojo.Student;
import center.misaki.schoolgrade.Domain.Stu;

import java.util.List;

public interface StudentService {

    //返回所有的学生
    List<Student> getAllStudent();

    //修改一个学生的信息
    void ModifyStudent(Stu stu);

    //删除一个学生的信息
    void DeleteStudent(Stu stu);

    //增加一个学生的信息
    void AddStudent(Stu stu);

    //根据学号查寻一个学生的信息
    Student getStudent(String StudentId);

    //修改一个学生的密码
    void ModifyStudents(String StudentId,String secret);

    Student getStudentU(String username);
}
