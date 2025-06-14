package com.jprestes.controller.course;

import com.jprestes.domain.dto.ApiResponseDTO;
import com.jprestes.domain.dto.CourseCreateDTO;
import com.jprestes.domain.dto.CourseDTO;
import com.jprestes.domain.dto.CourseUpdateDTO;
import com.jprestes.domain.entity.Course;
import com.jprestes.service.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Cursos", description = "Operações com cursos")
@RestController
@RequestMapping("/cursos")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<?> findAllOrFilterByName(@RequestParam(value = "nome", required = false) String nome) {

        List<CourseDTO> courses = courseService.getAllCourses().stream()
                .filter(course -> nome == null ||
                        (course.getName() != null && course.getName().toLowerCase().contains(nome.toLowerCase())))
                .map(this::toDTO)
                .collect(Collectors.toList());

        if (nome != null) {
            return ResponseEntity.ok(new ApiResponseDTO<>(true, "Cursos filtrados com sucesso", courses));
        }
        return ResponseEntity.ok(courses);
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<CourseDTO>> createCourse(@Valid @RequestBody CourseCreateDTO createDTO) {

        Course created = courseService.createCourse(toEntity(createDTO));
        CourseDTO createdDTO = toDTO(created);

        ApiResponseDTO<CourseDTO> response = new ApiResponseDTO<>(true, "Curso criado com sucesso", createdDTO);
        return ResponseEntity.created(URI.create("/cursos/" + createdDTO.getId())).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<CourseDTO>> updateCourse(@PathVariable Long id, @Valid @RequestBody CourseUpdateDTO updateDTO) {

        Course courseToUpdate = toEntity(updateDTO);
        courseToUpdate.setId(id);

        Course updatedCourse = courseService.updateCourse(courseToUpdate);
        CourseDTO updatedDTO = toDTO(updatedCourse);

        ApiResponseDTO<CourseDTO> response = new ApiResponseDTO<>(true, "Curso atualizado com sucesso", updatedDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Void>> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(new ApiResponseDTO<>(true, "Curso deletado com sucesso", null));
    }

    // --- Métodos auxiliares ---
    private CourseDTO toDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setDescription(course.getDescription());
        return dto;
    }

    // Sobrecarga para diferentes DTOs
    private Course toEntity(CourseCreateDTO dto) {
        Course entity = new Course();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

    private Course toEntity(CourseUpdateDTO dto) {
        Course entity = new Course();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
