package com.jprestes.repositories;

import com.jprestes.domain.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Additional query methods can be defined here if needed
}
