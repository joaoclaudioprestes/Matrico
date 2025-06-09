package com.jprestes.service;

import com.jprestes.domain.entity.Student;
import com.jprestes.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        validateStudent(student);
        return studentRepository.save(student);
    }

    private void validateStudent(Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty() ||
            student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome e email do aluno são obrigatórios.");
        }
    }
}
