package com.jprestes.controller;

import com.jprestes.annotations.CourseApiResponses;
import com.jprestes.domain.dtos.CourseDTO;
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
    @CourseApiResponses
    public ResponseEntity<String> createCourse(@RequestBody CourseDTO courseDTO) {
        Course courseEntity = new Course();
        courseEntity.setName(courseDTO.getName());
        courseEntity.setDescription(courseDTO.getDescription());

        Course createdCourse = courseService.createCourse(courseEntity);

        CourseDTO createdCourseDTO = new CourseDTO();
        createdCourseDTO.setName(createdCourse.getName());
        createdCourseDTO.setDescription(createdCourse.getDescription());

        return ResponseEntity.status(201).body("Curso criado com sucesso: " + createdCourseDTO.getName());
    }
}
