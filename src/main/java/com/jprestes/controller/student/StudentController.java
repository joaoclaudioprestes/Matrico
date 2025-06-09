package com.jprestes.controller.student;

import com.jprestes.domain.dto.ApiResponseDTO;
import com.jprestes.domain.dto.StudentDTO;
import com.jprestes.domain.entity.Student;
import com.jprestes.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/alunos")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<StudentDTO>> createStudent(@RequestBody StudentDTO studentDTO) {
        Student created = studentService.createStudent(toEntity(studentDTO));
        StudentDTO createdDTO = toDTO(created);

        ApiResponseDTO<StudentDTO> response = new ApiResponseDTO<>(true, "Aluno criado com sucesso", createdDTO);
        return ResponseEntity.created(URI.create("/alunos/" + createdDTO.getId())).body(response);
    }

    private StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        return dto;
    }

    private Student toEntity(StudentDTO dto) {
        Student entity = new Student();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}