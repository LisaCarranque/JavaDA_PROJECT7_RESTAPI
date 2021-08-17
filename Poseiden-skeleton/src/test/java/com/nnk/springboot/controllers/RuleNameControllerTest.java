package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.services.RuleNameService;
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
public class RuleNameControllerTest {


    @Mock
    RuleNameService ruleNameService;

    @InjectMocks
    RuleNameController ruleNameController;

    @Spy
    BindingResult bindingResult;

    @Spy
    Model model;

    @Test
    public void home() {
        ruleNameController.home(model);
        verify(ruleNameService, times(1)).findAll();
    }

    @Test
    public void validate() {
        RuleName ruleName = RuleName.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        ruleNameController.validate(ruleName, bindingResult, model);
        verify(ruleNameService, times(1)).add(ruleName);
    }

    @Test
    public void showUpdateForm() {
        ruleNameController.showUpdateForm(1, model);
        verify(ruleNameService, times(1)).getById(1);
    }

    @Test
    public void updateRuleName() {
        RuleName ruleName = RuleName.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        ruleNameController.updateRuleName(1, ruleName, bindingResult, model);
        verify(ruleNameService, times(1)).update(ruleName);
        verify(ruleNameService, times(1)).findAll();
    }

    @Test
    public void deleteBid() {
        RuleName ruleName = RuleName.builder().id(1).name("name")
                .description("description").sqlPart("sql part").sqlStr("sql str")
                .json("json").build();
        when(ruleNameService.getById(1)).thenReturn(ruleName);
        ruleNameController.deleteRuleName(1, model);
        verify(ruleNameService, times(1)).getById(1);
        verify(ruleNameService, times(1)).delete(ruleName);
    }

}
