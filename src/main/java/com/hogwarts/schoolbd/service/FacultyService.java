package com.hogwarts.schoolbd.service;

import com.hogwarts.schoolbd.entity.Student;
import com.hogwarts.schoolbd.repository.FacultyRepository;
import org.springframework.stereotype.Service;
import com.hogwarts.schoolbd.entity.Faculty;
import java.util.Optional;

import java.util.*;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(null);
        return facultyRepository.save(faculty   );
    }

    public Optional<Faculty> findFaculty(long id) {
        return facultyRepository.findById(id);
    }

    public Optional<Faculty> editFaculty(long id, Faculty newFaculty) {
        return facultyRepository.findById(id)
                .map(oldStudent -> {
                    oldStudent.setName(newFaculty.getName());
                    oldStudent.setColor(newFaculty.getColor());
                    return facultyRepository.save(oldStudent);
                });
    }

    public Optional<Faculty> deleteFaculty(long id) {
        return facultyRepository.findById(id)
                .map(faculty -> {
                    facultyRepository.delete(faculty);
                    return faculty;
                });
    }

    // Service
    public List<Student> findByColor(String color) {
        return facultyRepository.findAllByColor(color);
    }

}
