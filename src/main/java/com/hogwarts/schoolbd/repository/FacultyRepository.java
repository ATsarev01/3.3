package com.hogwarts.schoolbd.repository;

import com.hogwarts.schoolbd.entity.Faculty;
import com.hogwarts.schoolbd.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Student> findAllByColor(String color);
}
