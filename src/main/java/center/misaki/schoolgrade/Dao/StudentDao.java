package center.misaki.schoolgrade.Dao;

import center.misaki.schoolgrade.Pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {
     Student findByUsername(String username);

     Student findByStudentId(String studentId);
}
