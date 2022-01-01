package center.misaki.schoolgrade.Pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@Accessors(chain = true)
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    /**
     * 角色身份
     * 1、老师
     * 2、学生
     * 3、超级管理员
     */
    private Integer roleId;
}
