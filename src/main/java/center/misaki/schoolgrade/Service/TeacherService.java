package center.misaki.schoolgrade.Service;

import center.misaki.schoolgrade.Pojo.Teacher;
import center.misaki.schoolgrade.Domain.Teac;

import java.util.List;

public interface TeacherService {

    //获取所有的教师
    List<Teacher> getAllTeachers();

    //修改一个教师
    void ModifiedTeacher(Teac teac);

    //增加一个教师
    void AddTeacher(Teac teac);

    //删除一个教师
    void DelTeacher(Teac teac);

    Teacher getTeacher(String teacherName);

    Teacher getTeacherByUsername(String username);

    void ModifyTeacherMessage(String workId,String secret);
}
