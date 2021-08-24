package com.nnk.springboot.TU.services;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.repositories.RuleRepository;
import com.nnk.springboot.services.RuleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RuleServiceTest {

    @Mock
    RuleRepository ruleRepository;

    @InjectMocks
    RuleService ruleService;

    @Test
    public void findAll() {
        List<Rule> rule = ruleService.findAll();
        verify(ruleRepository, times(1)).findAll();
    }

    @Test
    public void add() {
        Rule rule = Rule.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        ruleService.add(rule);
        verify(ruleRepository, times(1)).save(rule);
    }

    @Test
    public void update() {
        Rule rule = Rule.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        ruleService.update(rule);
        verify(ruleRepository, times(1)).save(rule);
    }

    @Test
    public void getById() {
        ruleService.getById(1);
        verify(ruleRepository, times(1)).getOne(1);
    }

    @Test
    public void delete() {
        Rule rule = Rule.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        ruleService.delete(rule);
        verify(ruleRepository, times(1)).delete(rule);
    }

}
