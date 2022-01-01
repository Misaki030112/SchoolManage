package center.misaki.schoolgrade.Service;

import center.misaki.schoolgrade.Pojo.StudentGrade;
import center.misaki.schoolgrade.Domain.GDeatail;
import center.misaki.schoolgrade.Domain.Grade;
import center.misaki.schoolgrade.Domain.GradeGraph;

import java.util.List;
import java.util.Map;

public interface GradeService {
    //返回所有学生的成绩
    List<StudentGrade> getAllStudentGrades();

    //修改一个成绩
    void ModifyStudentGrade(Grade grade);

    //删除一个成绩
    void DeleteStudentGrade(Grade grade);

    //根据任课老师计算它的计算各门课程的最高分，最低分，平均分。
    List<GDeatail> getAllGradeDetail(String teacherName);

    //根据任课老师计算它的各科学生排名
    Map<String, List<Integer>> getOrder(String teacherName);

    //根据任课老师返回它所任课程的课程图数据
    List<GradeGraph> getDataForGraph(String teacherName);

    //返回这个任课老师教的所有学生的成绩
    List<StudentGrade> getStudentGradeByTeacherName(String teacherName);

    //根据学生学号返回这个学生的所有成绩
    List<StudentGrade> getStudentGradeByStudentId(String studentId);

}
