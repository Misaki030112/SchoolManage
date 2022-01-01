package center.misaki.schoolgrade.Pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Table
@Entity
@Accessors(chain = true)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String username;
    //学号
    private String studentId;
    //年级
    private String grade_level;
    //班级
    private Integer classId;
}
