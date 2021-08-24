package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.services.IRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * This class is responsible for mapping Rule CRUD
 */
@Controller
public class RuleController {

    @Autowired
    IRuleService ruleService;

    @RequestMapping("/rule/list")
    public String home(Model model) {
        model.addAttribute("rules", ruleService.findAll());
        return "rule/list";
    }

    @GetMapping("/rule/add")
    public String addRuleForm(Rule bid) {
        return "rule/add";
    }

    @PostMapping("/rule/validate")
    public String validate(@Valid Rule rule, BindingResult result, Model model) {
        ruleService.add(rule);
        model.addAttribute("rules", ruleService.findAll());
        return "rule/list";
    }

    @GetMapping("/rule/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("ruleToUpdate", ruleService.getById(id));
        return "rule/update";
    }

    @PostMapping("/rule/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid Rule rule,
                                 BindingResult result, Model model) {
        ruleService.update(rule);
        model.addAttribute("rules", ruleService.findAll());
        return "redirect:/rule/list";
    }

    @GetMapping("/rule/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        ruleService.delete(ruleService.getById(id));
        model.addAttribute("rules", ruleService.findAll());
        return "redirect:/rule/list";
    }
}
