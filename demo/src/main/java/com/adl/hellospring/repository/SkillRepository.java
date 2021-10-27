package com.adl.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adl.hellospring.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
