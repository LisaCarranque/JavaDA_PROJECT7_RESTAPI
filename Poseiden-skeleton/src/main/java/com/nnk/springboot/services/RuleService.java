package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.repositories.RuleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
public class RuleService implements IRuleService {

    @Autowired
    RuleRepository ruleNameRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Rule> findAll() {
        log.info("Find all rules");
        return ruleNameRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Rule add(Rule rule) {
        log.info("Add a rule");
        return ruleNameRepository.save(rule);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Rule update(Rule rule) {
        log.info("Update a rule");
        return ruleNameRepository.save(rule);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Rule getById(Integer id) {
        log.info("Find a rule by id");
        return ruleNameRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(Rule rule) {
        log.info("Delete a rule");
        ruleNameRepository.delete(rule);
    }

}
