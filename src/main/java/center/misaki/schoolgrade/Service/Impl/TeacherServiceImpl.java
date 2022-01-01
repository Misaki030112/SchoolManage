package center.misaki.schoolgrade.Service.Impl;

import center.misaki.schoolgrade.Dao.SysUserDao;
import center.misaki.schoolgrade.Dao.TeacherDao;
import center.misaki.schoolgrade.Pojo.SysUser;
import center.misaki.schoolgrade.Pojo.Teacher;
import center.misaki.schoolgrade.Service.TeacherService;
import center.misaki.schoolgrade.Utils.MD5Util;
import center.misaki.schoolgrade.Domain.Teac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherDao teacherDao;
    @Autowired
    SysUserDao sysUserDao;

    @Override
    public List<Teacher> getAllTeachers() {
        return  teacherDao.findAll();
    }

    @Override
    public void ModifiedTeacher(Teac teac) {
        Teacher byUsername = teacherDao.findByUsername(teac.getUsername());
        if(byUsername!=null){
            byUsername.setName(teac.getName())
                    .setWorkId(teac.getWorkId());
            teacherDao.save(byUsername);
        }else{
            AddTeacher(teac);
        }
    }

    @Override
    public void AddTeacher(Teac teac) {
        Teacher teacher = new Teacher();
        teacher.setUsername(teac.getUsername())
                .setName(teac.getName())
                .setWorkId(teac.getWorkId());
        teacherDao.save(teacher);
    }

    @Override
    public void DelTeacher(Teac teac) {
        Teacher byUsername = teacherDao.findByUsername(teac.getUsername());
        teacherDao.delete(byUsername);
    }

    @Override
    public Teacher getTeacher(String teacherName) {
        return teacherDao.findByName(teacherName);
    }

    @Override
    public Teacher getTeacherByUsername(String username) {
        return teacherDao.findByUsername(username);
    }

    @Override
    public void ModifyTeacherMessage(String workId, String secret) {
        Teacher teacher = teacherDao.findByWorkId(workId);
        SysUser byUsername = sysUserDao.findByUsername(teacher.getUsername());
        byUsername.setPassword(MD5Util.string2MD5(secret));
        sysUserDao.save(byUsername);
    }
}
