package center.misaki.schoolgrade.Domain;

import lombok.Data;

@Data
public class Course {
    //课程代码
    private Integer courseCode;
    private String courseName;
    //授课老师
    private String courseTeacher;
    //开课班级
    private Integer courseClass;
}
