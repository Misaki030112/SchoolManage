package center.misaki.schoolgrade.Service.Impl;

import center.misaki.schoolgrade.Dao.StudentGradeDao;
import center.misaki.schoolgrade.Dao.SysCourseDao;
import center.misaki.schoolgrade.Pojo.StudentGrade;
import center.misaki.schoolgrade.Pojo.SysCourse;
import center.misaki.schoolgrade.Service.GradeService;
import center.misaki.schoolgrade.Utils.GradeCompare;
import center.misaki.schoolgrade.Domain.GDeatail;
import center.misaki.schoolgrade.Domain.Grade;
import center.misaki.schoolgrade.Domain.GradeGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    StudentGradeDao studentGradeDao;

    @Autowired
    SysCourseDao sysCourseDao;

    @Override
    public List<StudentGrade> getAllStudentGrades() {
        return studentGradeDao.findAll();
    }

    @Override
    public void ModifyStudentGrade(Grade grade) {
        StudentGrade byStudentIdAndCourseCode = studentGradeDao.findByStudentIdAndCourseCode(grade.getStudentId(),grade.getCourseCode());
        byStudentIdAndCourseCode.setGrade(grade.getGrade());
        studentGradeDao.save(byStudentIdAndCourseCode);
    }

    @Override
    public void DeleteStudentGrade(Grade grade) {
        StudentGrade byStudentIdAndCourseCode = studentGradeDao.findByStudentIdAndCourseCode(grade.getStudentId(),grade.getCourseCode());
        studentGradeDao.delete(byStudentIdAndCourseCode);
    }

    @Override
    public List<GDeatail> getAllGradeDetail(String teacherName) {
        List<SysCourse> courses = sysCourseDao.findByCourseTeacher(teacherName);
        List<StudentGrade> grades = studentGradeDao.findByCourseTeacher(teacherName);
        List<GDeatail> gDeatails=new ArrayList<GDeatail>();
        for (SysCourse cours : courses) {
            int[] temp = getHighAndLow(cours.getCourseName(), grades);
            gDeatails.add(new GDeatail(cours.getCourseName(),temp[0],temp[1]));
        }
        return gDeatails;
    }

    /**
     * 根据任课老师返回这门课学生的成绩排序
     * @author 汪世胤
     * @param teacherName 老师姓名
     * @return 返回排序后的东西
     */
    @Override
    public Map<String, List<Integer>> getOrder(String teacherName) {
        List<SysCourse> courses = sysCourseDao.findByCourseTeacher(teacherName);
        List<StudentGrade> grades = studentGradeDao.findByCourseTeacher(teacherName);
        grades.sort(new GradeCompare());
        HashMap<String, List<Integer>> map = new HashMap<>();
        for (SysCourse cours : courses) {
            LinkedList<Integer> orders = new LinkedList<>();
            for (StudentGrade grade : grades) {
                if(!Objects.equals(grade.getCourseName(), cours.getCourseName())) continue;
                orders.add(grade.getGrade());
            }
            map.put(cours.getCourseName(),orders);
        }
        return map;
    }

    /**
     * 返回教师的成绩概括图中的数据
     * @param teacherName 老师姓名
     * @return 返回每门课的数据结合
     */
    @Override
    public List<GradeGraph> getDataForGraph(String teacherName) {
        Map<String, List<Integer>> map = getOrder(teacherName);
        List<GradeGraph> graphs = new ArrayList<>();
        List<SysCourse> courses = sysCourseDao.findByCourseTeacher(teacherName);
        for (SysCourse cours : courses) {
            List<Integer> scores = map.get(cours.getCourseName());
            int B60=0,B60_70=0,B70_80=0,B80_90=0,B90_100=0;
            for (Integer score : scores) {
                if(score<60) B60++;
                if(score>=60&&score<70) B60_70++;
                if(score>=70&&score<80) B70_80++;
                if(score>=80&&score<90) B80_90++;
                if(score>=90&&score<100) B90_100++;
            }
            graphs.add(new GradeGraph(cours.getCourseName(), B60,B60_70,B70_80,B80_90,B90_100));
        }
        return graphs;
    }

    @Override
    public List<StudentGrade> getStudentGradeByTeacherName(String teacherName) {
        return studentGradeDao.findByCourseTeacher(teacherName);
    }

    @Override
    public List<StudentGrade> getStudentGradeByStudentId(String studentId) {
        return studentGradeDao.findByStudentId(studentId);
    }


    /**
     * 删选出特定课程的最高分与最低分
     */
    public int[] getHighAndLow(String courseName,List<StudentGrade> grades){
        int high=0,low=100;
        for (StudentGrade grade : grades) {
            if(!Objects.equals(grade.getCourseName(), courseName)) continue;
            if(high<=grade.getGrade()){
                high=grade.getGrade();
            }
            if(low>=grade.getGrade()){
                low=grade.getGrade();
            }
        }
        return new int[]{high,low};
    }





}
