package com.jprestes.controller.course;

import com.jprestes.domain.dto.ApiResponseDTO;
import com.jprestes.domain.dto.CourseDTO;
import com.jprestes.domain.entity.Course;
import com.jprestes.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<CourseDTO>> createCourse(@RequestBody CourseDTO courseDTO) {
        Course courseEntity = new Course();
        courseEntity.setName(courseDTO.getName());
        courseEntity.setDescription(courseDTO.getDescription());

        Course createdCourse = courseService.createCourse(courseEntity);

        CourseDTO createdCourseDTO = new CourseDTO();
        createdCourseDTO.setName(createdCourse.getName());
        createdCourseDTO.setDescription(createdCourse.getDescription());

        ApiResponseDTO<CourseDTO> response = new ApiResponseDTO<>(true, "Curso criado com sucesso", createdCourseDTO);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<CourseDTO>> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        Course courseEntity = new Course();
        courseEntity.setId(id);
        courseEntity.setName(courseDTO.getName());
        courseEntity.setDescription(courseDTO.getDescription());

        Course updatedCourse = courseService.updateCourse(courseEntity);

        CourseDTO updatedCourseDTO = new CourseDTO();
        updatedCourseDTO.setName(updatedCourse.getName());
        updatedCourseDTO.setDescription(updatedCourse.getDescription());

        ApiResponseDTO<CourseDTO> response = new ApiResponseDTO<>(true, "Curso atualizado com sucesso", updatedCourseDTO);
        return ResponseEntity.ok(response);
    }
}
