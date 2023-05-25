package com.hogwarts.schoolbd.service;

import com.hogwarts.schoolbd.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.hogwarts.schoolbd.entity.Student;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public Optional<Student> findStudent(long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> editStudent(long id, Student newStudent) {
        return studentRepository.findById(id)
                .map(oldStudent -> {
                    oldStudent.setName(newStudent.getName());
                    oldStudent.setAge(newStudent.getAge());
                    return studentRepository.save(oldStudent);
                });
    }

    public Collection<Student> getALl() {
        return Collections.unmodifiableCollection(studentRepository.findAll());
    }

    public Optional<Student> deleteStudent(long id) {
     return studentRepository.findById(id)
             .map(student -> {
                 studentRepository.delete(student);
                 return student;
             });
    }


    public Collection<Student> findByAge(int age) {
        return studentRepository.findAllByAge(age);
    }
}
