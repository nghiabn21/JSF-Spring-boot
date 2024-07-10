package org.xtremebiker.jsfspring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String value;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
//    @JsonManagedReference
    private Student student;
}
