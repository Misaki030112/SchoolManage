package center.misaki.schoolgrade.Domain;

import lombok.Data;

@Data
public class Stu {
    private String name;
    private String username;
    //学号
    private String studentId;
    //年级
    private String grade_level;
    //班级
    private Integer classId;
}
