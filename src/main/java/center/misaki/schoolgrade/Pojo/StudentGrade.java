package center.misaki.schoolgrade.Pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class StudentGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //行号，无意义
    private Integer id;
    //学号
    private String studentId;
    private String studentName;
    //成绩
    private Integer grade;
    //授课老师
    private String courseTeacher;

    private String courseName;
    //课程代码
    private Integer courseCode;
}
