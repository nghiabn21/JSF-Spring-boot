package org.xtremebiker.jsfspring.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.context.annotation.RequestScope;
import org.xtremebiker.jsfspring.dto.StudentDto;
//import org.xtremebiker.jsfspring.entity.Student;
//import org.xtremebiker.jsfspring.repository.SkillRepo;
//import org.xtremebiker.jsfspring.service.StudentService;

import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.servlet.Filter;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

@Component
@RequestScope
@ManagedBean(name = "myBean", eager = true)
@Validated
public class MyBean {
//    @Autowired
//    private StudentService studentService;

    @Valid
    StudentDto student = new StudentDto();

    //
//    public MyBean() {
//        System.out.println("Created!");
//    }
//
    public List<StudentDto> getAllStudent() {
        List<StudentDto> studentDtos = new ArrayList<>();
        studentDtos.add(new StudentDto(1, "Nghĩa", "24", "Hà Nội", "Male", "Tester", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        studentDtos.add(new StudentDto(2, "Nghĩa", "24", "Hà Nội", "Male", "Tester", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        studentDtos.add(new StudentDto(3, "Nghĩa", "24", "Hà Nội", "Male", "Tester", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        studentDtos.add(new StudentDto(4, "Nghĩa", "24", "Hà Nội", "Male", "Tester", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        studentDtos.add(new StudentDto(5, "Nghĩa", "24", "Hà Nội", "Male", "Tester", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        studentDtos.add(new StudentDto(6, "Nghĩa", "24", "Hà Nội", "Male", "Tester", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        studentDtos.add(new StudentDto(7, "Nghĩa", "24", "Hà Nội", "Male", "Tester", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        studentDtos.add(new StudentDto(8, "Nghĩa", "24", "Hà Nội", "Male", "Tester", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        studentDtos.add(new StudentDto(9, "Nghĩa", "24", "Hà Nội", "Male", "Tester", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
        return studentDtos;
    }

    //
//    public Boolean saveStudent() {
//        System.out.println("Student: " + student);
//        Student test = studentService.saveStudent(student);
//        return true;
//    }
//
//
    public StudentDto getStudent() {
        return student;
    }

    public String moveToPage2() {
        return "update"; // outcome
    }

    public String getDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public void closeDialog() {
        RequestContext.getCurrentInstance().execute("PF('" + "dialogDetail" + "').hide();");
    }

    public void viewDetail(StudentDto studentDto) {
        student = studentDto;
        RequestContext.getCurrentInstance().execute("PF('" + "dialogDetail" + "').show();");
    }

}
