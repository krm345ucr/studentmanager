package com.javaileri.studentmanager.repository;


import com.javaileri.studentmanager.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
