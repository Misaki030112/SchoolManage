package center.misaki.schoolgrade.Dao;

import center.misaki.schoolgrade.Pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends JpaRepository<SysUser,Integer> {
        SysUser findByUsername(String username);
}
