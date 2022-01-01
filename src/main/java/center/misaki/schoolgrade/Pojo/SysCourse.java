package center.misaki.schoolgrade.Pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Table
@Entity
@Accessors(chain = true)
public class SysCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer courseCode;
    private String courseName;
    //授课老师
    private String courseTeacher;
    //开课班级
    private Integer courseClass;
}
