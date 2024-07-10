package org.xtremebiker.jsfspring.service;

import org.springframework.stereotype.Service;
import org.xtremebiker.jsfspring.dto.StudentDto;
import org.xtremebiker.jsfspring.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudent();

    Student saveStudent(StudentDto student);
}
