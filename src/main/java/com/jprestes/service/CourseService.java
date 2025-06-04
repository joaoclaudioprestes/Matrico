package com.jprestes.service;

import com.jprestes.domain.entity.Course;
import com.jprestes.exceptions.MissingCourseIdException;
import com.jprestes.exceptions.CourseNotFoundException;
import com.jprestes.exceptions.InvalidCourseException;
import com.jprestes.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    private CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        if (course.getName() == null || course.getName().trim().isEmpty() ||
                course.getDescription() == null || course.getDescription().trim().isEmpty()) {
            throw new InvalidCourseException("Nome e descrição do curso são obrigatórios.");
        }

        return courseRepository.save(course);
    }

    public Course updateCourse(Course course) {
        if (course.getId() == null) {
            throw new MissingCourseIdException("O ID do curso é obrigatório para atualização.");
        }

        if (!courseRepository.existsById(course.getId())) {
            throw new CourseNotFoundException("Curso com ID: " + course.getId() + " não encontrado.");
        }

        if (course.getName() == null || course.getName().trim().isEmpty() ||
                course.getDescription() == null || course.getDescription().trim().isEmpty()) {
            throw new InvalidCourseException("Nome e descrição do curso são obrigatórios.");
        }

        return courseRepository.save(course);
    }

    public ArrayList<Course> getAllCourses() {
        return (ArrayList<Course>) courseRepository.findAll();
    }

    public void deleteCourse(Long id) {
        if (id == null) {
            throw new MissingCourseIdException("O ID do curso é obrigatório para exclusão.");
        }

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Curso com ID: " + id + " não encontrado."));

        courseRepository.delete(course);
    }
}
