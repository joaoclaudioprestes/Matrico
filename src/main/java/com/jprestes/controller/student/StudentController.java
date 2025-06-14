package com.jprestes.controller.student;

import com.jprestes.domain.dto.ApiResponseDTO;
import com.jprestes.domain.dto.student.StudentCreateDTO;
import com.jprestes.domain.dto.student.StudentDTO;
import com.jprestes.domain.dto.student.StudentUpdateDTO;
import com.jprestes.domain.entity.Student;
import com.jprestes.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Alunos", description = "Operações com alunos")
@RestController
@RequestMapping("/alunos")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() {
        List<StudentDTO> studentDTOs = studentService.getAllStudents().stream().map(this::toDTO).collect(Collectors.toList());

        return ResponseEntity.ok(studentDTOs);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<StudentDTO>> createStudent(@Valid @RequestBody StudentCreateDTO createDTO) {
        Student created = studentService.createStudent(toEntity(createDTO));
        StudentDTO createdDTO = toDTO(created);

        ApiResponseDTO<StudentDTO> response = new ApiResponseDTO<>(true, "Aluno criado com sucesso", createdDTO);
        return ResponseEntity.created(URI.create("/alunos/" + createdDTO.getId())).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<StudentDTO>> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentUpdateDTO updateDTO) {
        Student updated = studentService.updateStudent(toEntity(updateDTO));
        StudentDTO updatedDTO = toDTO(updated);

        ApiResponseDTO<StudentDTO> response = new ApiResponseDTO<>(true, "Aluno atualizado com sucesso", updatedDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);

        ApiResponseDTO<Void> response = new ApiResponseDTO<>(true, "Aluno deletado com sucesso", null);
        return ResponseEntity.ok(response);
    }

    // --- Métodos auxiliares ---
    private StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        return dto;
    }

    private Student toEntity(StudentCreateDTO dto) {
        Student entity = new Student();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    private Student toEntity(StudentUpdateDTO dto) {
        Student entity = new Student();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}