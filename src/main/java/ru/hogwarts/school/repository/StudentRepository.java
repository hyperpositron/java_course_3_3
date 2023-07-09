package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Collection<Student> getStudents(Long facultyId) {
        Scanner studentRepository;
        return studentRepository.findAll().stream()
                .filter(s -> s.getFaculty().getId() == facultyId)
                .collect(Collectors.toList());
    }

    Collection<Student> findByAgeLessThan(int age);
    Collection<Student> findStudentsByAgeBetween(int minAge, int maxAge);
}