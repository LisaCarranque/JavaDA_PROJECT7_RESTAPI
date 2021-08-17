package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RuleNameServiceTest {

    @Mock
    RuleNameRepository ruleNameRepository;

    @InjectMocks
    RuleNameService ruleNameService;

    @Test
    public void findAll() {
        List<RuleName> ruleName = ruleNameService.findAll();
        verify(ruleNameRepository, times(1)).findAll();
    }

    @Test
    public void add() {
        RuleName ruleName = RuleName.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        ruleNameService.add(ruleName);
        verify(ruleNameRepository, times(1)).save(ruleName);
    }

    @Test
    public void update() {
        RuleName ruleName = RuleName.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        ruleNameService.update(ruleName);
        verify(ruleNameRepository, times(1)).save(ruleName);
    }

    @Test
    public void getById() {
        ruleNameService.getById(1);
        verify(ruleNameRepository, times(1)).getOne(1);
    }

    @Test
    public void delete() {
        RuleName ruleName = RuleName.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        ruleNameService.delete(ruleName);
        verify(ruleNameRepository, times(1)).delete(ruleName);
    }

}
