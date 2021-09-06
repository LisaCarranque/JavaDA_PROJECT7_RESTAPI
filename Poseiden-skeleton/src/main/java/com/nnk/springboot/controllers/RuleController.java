package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rule;
import com.nnk.springboot.services.IRuleService;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
@Controller
public class RuleController {

    @Autowired
    IRuleService ruleService;

    @RequestMapping("/rule/list")
    public String home(Model model) {
        log.trace("Load rule data");
        model.addAttribute("rules", ruleService.findAll());
        log.trace("Display rule/list view");
        return "rule/list";
    }

    @GetMapping("/rule/add")
    public String addRuleForm(Rule bid) {
        log.trace("Display rule/add view");
        return "rule/add";
    }

    @PostMapping("/rule/validate")
    public String validate(@Valid Rule rule, BindingResult result, Model model) {
        ruleService.add(rule);
        log.info("New rule added: " + rule.getId());
        model.addAttribute("rules", ruleService.findAll());
        log.trace("Redirect to rule/list view");
        return "rule/list";
    }

    @GetMapping("/rule/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("ruleToUpdate", ruleService.getById(id));
        log.info("Rule to update selected by id: " + id);
        log.trace("Display rule/update view");
        return "rule/update";
    }

    @PostMapping("/rule/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid Rule rule,
                                 BindingResult result, Model model) {
        ruleService.update(rule);
        log.info("rule updated: " + id);
        model.addAttribute("rules", ruleService.findAll());
        log.trace("Redirect to rule/list view");
        return "redirect:/rule/list";
    }

    @GetMapping("/rule/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        log.info("rule deleted: " + id);
        ruleService.delete(ruleService.getById(id));
        model.addAttribute("rules", ruleService.findAll());
        log.trace("Redirect to rule/list view");
        return "redirect:/rule/list";
    }
}
