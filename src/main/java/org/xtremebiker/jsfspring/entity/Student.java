package org.xtremebiker.jsfspring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name is requied")
    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 128, nullable = false)
    private String age;

    @Column(length = 128, nullable = false)
    private String address;

    @Column(length = 128, nullable = false)
    private String gender;

    @Column(length = 128, nullable = false)
    private String major;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student")
//    @JsonBackReference
    private List<Skill> skills;
}
