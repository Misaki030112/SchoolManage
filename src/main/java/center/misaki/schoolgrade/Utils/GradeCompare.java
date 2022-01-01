package center.misaki.schoolgrade.Utils;

import center.misaki.schoolgrade.Pojo.StudentGrade;

import java.util.Comparator;

/**
 * 自定义排序容器
 */
public class GradeCompare implements Comparator<StudentGrade> {

    @Override
    public int compare(StudentGrade o1, StudentGrade o2) {
        return -o1.getGrade()+o2.getGrade();
    }
}
