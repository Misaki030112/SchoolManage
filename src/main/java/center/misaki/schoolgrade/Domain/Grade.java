package center.misaki.schoolgrade.Domain;

import lombok.Data;

@Data
public class Grade {
    //学号
    private String studentId;
    private String studentName;
    private String courseName;
    //课程代码
    private Integer courseCode;
    //成绩
    private Integer grade;
}
