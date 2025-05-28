package com.jprestes.service;

import com.jprestes.domain.entity.Course;
import com.jprestes.exceptions.CourseValidationException;
import com.jprestes.repositories.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    public Course createCourse(Course course) {
        if (course.getName() == null || course.getName().trim().isEmpty() ||
                course.getDescription() == null || course.getDescription().trim().isEmpty()) {
            throw new CourseValidationException("Nome e descrição do curso são obrigatórios.");
        }

        return courseRepository.save(course);
    }
}
