package center.misaki.schoolgrade.Dao;

import center.misaki.schoolgrade.Pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<Teacher,Integer> {
    Teacher findByUsername(String username);

    Teacher findByName(String name);

    Teacher findByWorkId(String workId);
}
