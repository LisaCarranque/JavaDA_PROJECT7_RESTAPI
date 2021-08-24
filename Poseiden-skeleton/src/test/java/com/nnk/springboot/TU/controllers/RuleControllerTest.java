package com.nnk.springboot.TU.controllers;

import com.nnk.springboot.controllers.RuleController;
import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.services.RuleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RuleControllerTest {

    @Mock
    RuleService ruleService;

    @InjectMocks
    RuleController ruleController;

    @Spy
    BindingResult bindingResult;

    @Spy
    Model model;

    @Test
    public void home() {
        ruleController.home(model);
        verify(ruleService, times(1)).findAll();
    }

    @Test
    public void validate() {
        Rule rule = Rule.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        ruleController.validate(rule, bindingResult, model);
        verify(ruleService, times(1)).add(rule);
    }

    @Test
    public void showUpdateForm() {
        ruleController.showUpdateForm(1, model);
        verify(ruleService, times(1)).getById(1);
    }

    @Test
    public void updateRuleName() {
        Rule rule = Rule.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        ruleController.updateRuleName(1, rule, bindingResult, model);
        verify(ruleService, times(1)).update(rule);
        verify(ruleService, times(1)).findAll();
    }

    @Test
    public void deleteBid() {
        Rule rule = Rule.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        when(ruleService.getById(1)).thenReturn(rule);
        ruleController.deleteRuleName(1, model);
        verify(ruleService, times(1)).getById(1);
        verify(ruleService, times(1)).delete(rule);
    }

}
