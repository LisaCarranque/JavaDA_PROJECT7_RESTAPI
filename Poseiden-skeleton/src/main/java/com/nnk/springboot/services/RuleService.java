package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.repositories.RuleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is responsible for managing Rule data by calling RuleRepository
 */
@Service
@Log4j2
public class RuleService implements IRuleService {

    @Autowired
    RuleRepository ruleNameRepository;

    /**
     * This method displays all rules by calling findAll method from RuleRepository
     * @return a list of all rules existing in database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Rule> findAll() {
        log.info("Find all rules");
        return ruleNameRepository.findAll();
    }

    /**
     * This method adds a rule by calling save method from RuleRepository
     * @param rule the rule to add
     * @return the new rule saved into database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Rule add(Rule rule) {
        log.info("Add a rule");
        return ruleNameRepository.save(rule);
    }

    /**
     * This method updates a rule by calling save method from RuleRepository
     * @param rule the rule to update
     * @return the updated rule
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Rule update(Rule rule) {
        log.info("Update a rule");
        return ruleNameRepository.save(rule);
    }

    /**
     * This method selects an existing rule by id from database by calling getOne method of RuleRepository
     * @param id the id of the targeted rule
     * @return the selected rule from database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Rule getById(Integer id) {
        log.info("Find a rule by id");
        return ruleNameRepository.getOne(id);
    }

    /**
     * This method removes a rule from database by calling delete method from RuleRepository
     * @param rule the rule to remove
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(Rule rule) {
        log.info("Delete a rule");
        ruleNameRepository.delete(rule);
    }

}
