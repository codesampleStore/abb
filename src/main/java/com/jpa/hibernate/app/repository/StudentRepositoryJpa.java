package com.jpa.hibernate.app.repository;

import com.jpa.hibernate.app.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepositoryJpa extends JpaRepository<Student, Long> {

  Student findStudentById(Long id);

  @Query(value = "SELECT id, passport_id, name,grade_avg FROM Student WHERE ROWNUM <= 3 ORDER BY grade_avg DESC", nativeQuery = true)
  List<Student> findTopStudents3ByGradeAvg();
}
