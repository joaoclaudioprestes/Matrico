package com.jprestes.service;

import com.jprestes.domain.dto.registration.RegistrationCreateDTO;
import com.jprestes.domain.entity.Course;
import com.jprestes.domain.entity.Registration;
import com.jprestes.domain.entity.Student;
import com.jprestes.exceptions.course.CourseNotFoundException;
import com.jprestes.exceptions.registration.InvalidRegistrationException;
import com.jprestes.exceptions.registration.RegistrationNotFoundException;
import com.jprestes.exceptions.student.StudentNotFoundException;
import com.jprestes.repositories.CourseRepository;
import com.jprestes.repositories.RegistrationRepository;
import com.jprestes.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public RegistrationService(RegistrationRepository registrationRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.registrationRepository = registrationRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Registration createRegistration(RegistrationCreateDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId()).orElseThrow(() -> new StudentNotFoundException("Estudante não encontrado"));

        Course course = courseRepository.findById(dto.getCourseId()).orElseThrow(() -> new CourseNotFoundException("Curso não encontrado"));

        Registration registration = new Registration();
        registration.setStudent(student);
        registration.setCourse(course);
        registration.setRegistrationDate(LocalDate.now());
        registration.setStatus("ativo");

        validateRegistration(registration);

        return registrationRepository.save(registration);
    }

    public Registration deleteRegistration(Long dto) {
        Registration registration = registrationRepository.findById(dto.getCourseId()).orElseThrow(() -> new RegistrationNotFoundException("Matricula não encontrada!"));

        registrationRepository.delete(registration);

        return registration;
    }


    private void validateRegistration(Registration registration) {
        if (registration.getStudent() == null || registration.getCourse() == null) {
            throw new InvalidRegistrationException("Estudante e curso são obrigatórios para a matrícula.");
        }
    }
}
