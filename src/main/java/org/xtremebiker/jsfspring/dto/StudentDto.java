package org.xtremebiker.jsfspring.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.xtremebiker.jsfspring.entity.Skill;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {


    @NotNull(message = "Name is requied")
    private String name;

    @Column(length = 128, nullable = false)
    private String age;

    @Column(length = 128, nullable = false)
    private String address;

    @Column(length = 128, nullable = false)
    private String gender;

    @Column(length = 128, nullable = false)
    private String major;

    private List<String> skills;
}
