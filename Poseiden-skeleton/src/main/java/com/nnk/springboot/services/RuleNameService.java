package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleNameService implements IRuleNameService {

    @Autowired
    RuleNameRepository ruleNameRepository;

    @Override
    public List<RuleName> findAll() {
        return ruleNameRepository.findAll();
    }

    @Override
    public RuleName add(RuleName ruleName) {
        return ruleNameRepository.save(ruleName);
    }

    @Override
    public RuleName validate(RuleName ruleName) {
        //TODO check valid data
        return null;
    }

    @Override
    public RuleName update(RuleName ruleName) {
        return ruleNameRepository.save(ruleName);
    }

    @Override
    public RuleName getById(Integer id) {
        return ruleNameRepository.getOne(id);
    }

    @Override
    public void delete(RuleName ruleName) {
        ruleNameRepository.delete(ruleName);
    }

}
