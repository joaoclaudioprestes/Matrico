package com.jprestes.service;

import com.jprestes.domain.entity.Course;
import com.jprestes.repositories.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }
}
