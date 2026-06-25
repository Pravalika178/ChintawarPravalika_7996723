package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.SkillRepository;

@Service
public class SkillService {

    @Autowired
    private SkillRepository repository;

    public Skill get(int id){
        return repository.findById(id).get();
    }

    public void save(Skill skill){
        repository.save(skill);
    }
}