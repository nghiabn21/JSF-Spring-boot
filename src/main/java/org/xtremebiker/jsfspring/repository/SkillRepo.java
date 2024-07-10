package org.xtremebiker.jsfspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.xtremebiker.jsfspring.entity.Skill;

import java.util.List;

public interface SkillRepo extends JpaRepository<Skill, Integer> {

    @Query(value = "select s from Skill s where s.value in :skills")
    List<Skill> findAllByValue(List<Skill> skills);
}
