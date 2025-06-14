package com.jprestes.service;

import com.jprestes.domain.entity.Student;
import com.jprestes.exceptions.MissingStudentIdException;
import com.jprestes.exceptions.StudentNotFoundException;
import com.jprestes.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Student updateStudent(Student student) {
        if (student.getId() == null) {
            throw new MissingStudentIdException("O ID do aluno é obrigatório para atualização.");
        }

        if (!studentRepository.existsById(student.getId())) {
            throw new IllegalArgumentException("Aluno com ID: " + student.getId() + " não encontrado.");
        }

        validateStudent(student);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id) {
        if (id == null) {
            throw new MissingStudentIdException("O ID do aluno é obrigatório para exclusão.");
        }

        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Aluno com ID: " + id + " não encontrado.");
        }

        studentRepository.deleteById(id);
    }

    private void validateStudent(Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty() ||
            student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome e email do aluno são obrigatórios.");
        }
    }
}
