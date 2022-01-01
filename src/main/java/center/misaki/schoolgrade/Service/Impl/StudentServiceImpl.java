package center.misaki.schoolgrade.Service.Impl;

import center.misaki.schoolgrade.Dao.StudentDao;
import center.misaki.schoolgrade.Dao.SysUserDao;
import center.misaki.schoolgrade.Pojo.Student;
import center.misaki.schoolgrade.Pojo.SysUser;
import center.misaki.schoolgrade.Service.StudentService;
import center.misaki.schoolgrade.Utils.MD5Util;
import center.misaki.schoolgrade.Domain.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;
    @Autowired
    SysUserDao sysUserDao;

    @Override
    public List<Student> getAllStudent() {
        return studentDao.findAll();
    }

    @Override
    public void ModifyStudent(Stu stu) {
        Student byUsername = studentDao.findByUsername(stu.getUsername());
        if(byUsername!=null) {
            byUsername.setStudentId(stu.getStudentId())
                    .setClassId(stu.getClassId())
                    .setName(stu.getName())
                    .setGrade_level(stu.getGrade_level());
            studentDao.save(byUsername);
        }else{
            AddStudent(stu);
        }
    }

    @Override
    public void DeleteStudent(Stu stu) {
        Student byUsername = studentDao.findByUsername(stu.getUsername());
        studentDao.delete(byUsername);
    }

    @Override
    public void AddStudent(Stu stu) {
        Student student = new Student();
        student.setStudentId(stu.getStudentId())
                .setClassId(stu.getClassId())
                .setName(stu.getName())
                .setGrade_level(stu.getGrade_level())
                .setUsername(stu.getUsername());
        studentDao.save(student);
    }

    @Override
    public Student getStudent(String StudentId) {
        return studentDao.findByStudentId(StudentId);
    }

    @Override
    public void ModifyStudents(String StudentId,String secret) {
        Student byStudentId = studentDao.findByStudentId(StudentId);
        String s = MD5Util.string2MD5(secret);
        SysUser byUsername = sysUserDao.findByUsername(byStudentId.getUsername());
        byUsername.setPassword(s);
        sysUserDao.save(byUsername);
    }

    @Override
    public Student getStudentU(String username) {
        return studentDao.findByUsername(username);
    }
}
