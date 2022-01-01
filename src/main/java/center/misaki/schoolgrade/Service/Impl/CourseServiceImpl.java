package center.misaki.schoolgrade.Service.Impl;



import center.misaki.schoolgrade.Dao.SysCourseDao;
import center.misaki.schoolgrade.Pojo.SysCourse;
import center.misaki.schoolgrade.Service.CourseService;
import center.misaki.schoolgrade.Domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    SysCourseDao sysCourseDao;

    @Override
    public List<SysCourse> getAllCourses() {
        return sysCourseDao.findAll();
    }

    @Override
    public void ModifyCourse(Course course) {
        SysCourse byCourseCode = sysCourseDao.findByCourseCodeAndCourseTeacher(course.getCourseCode(), course.getCourseTeacher());
        if(byCourseCode==null){
            AddCourse(course);
        }else{
            byCourseCode.setCourseCode(course.getCourseCode());
            byCourseCode.setCourseClass(course.getCourseClass());
            byCourseCode.setCourseName(course.getCourseName());
            byCourseCode.setCourseTeacher(course.getCourseTeacher());
            sysCourseDao.save(byCourseCode);
        }
    }

    @Override
    public void DeleteCourse(Course course) {
        SysCourse byCourseCode = sysCourseDao.findByCourseCodeAndCourseTeacher(course.getCourseCode(), course.getCourseTeacher());
        sysCourseDao.delete(byCourseCode);
    }

    @Override
    public void AddCourse(Course course) {
        SysCourse byCourseCode = new SysCourse();
        byCourseCode.setCourseCode(course.getCourseCode())
                .setCourseTeacher(course.getCourseTeacher())
                .setCourseName(course.getCourseName())
                .setCourseClass(course.getCourseClass());
        sysCourseDao.save(byCourseCode);
    }

    @Override
    public List<SysCourse> getAllCoursesByTeacher(String TeacherName) {
        return sysCourseDao.findByCourseTeacher(TeacherName);
    }

    @Override
    public List<SysCourse> getAllCoursesByStudentId(String StudentId) {
       return  sysCourseDao.getAllCourseByStudentId(StudentId);
    }


}
