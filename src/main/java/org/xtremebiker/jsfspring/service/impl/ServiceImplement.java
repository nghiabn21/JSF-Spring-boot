package org.xtremebiker.jsfspring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xtremebiker.jsfspring.dto.StudentDto;
import org.xtremebiker.jsfspring.entity.Skill;
import org.xtremebiker.jsfspring.entity.Student;
import org.xtremebiker.jsfspring.repository.SkillRepo;
import org.xtremebiker.jsfspring.repository.StudentRepository;
import org.xtremebiker.jsfspring.service.StudentService;

import java.util.List;

@Service
@Slf4j
public class ServiceImplement implements StudentService {

    private static Logger logger = LoggerFactory.getLogger(ServiceImplement.class);

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SkillRepo skillRepo;

    @Override
    public List<Student> getAllStudent() {

        List<Student> students = studentRepository.findAll();
        System.out.println(students);
        if (students != null) {
            students = studentRepository.findAll();
        } else {
            students = null;
        }
        return students;
    }

    @Override
    public Student saveStudent(StudentDto student) {
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setAddress(student.getAddress());
        student1.setGender(student.getGender());
        student1.setMajor(student.getMajor());

        studentRepository.save(student1);

        List<String> skills = student.getSkills();
        String test = skills.get(0);
        logger.info("Test: {}", test);
//        List<Skill> skillList = skillRepo.findAllByValue(skills);
        System.out.println("List skill:" + skills);
        for (int i = 0; i < skills.size(); i++) {
            Skill skill = new Skill();
            skill.setValue(skills.get(i));
            skill.setStudent(student1);
            skillRepo.save(skill);
        }
        return studentRepository.save(student1);
    }
}
