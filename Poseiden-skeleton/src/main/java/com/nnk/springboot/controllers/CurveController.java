package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.ICurveService;
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
 * This class is responsible for mapping Curve CRUD
 */
@Log4j2
@Controller
public class CurveController {

    @Autowired
    ICurveService curveService;

    @RequestMapping("/curvePoint/list")
    public String home(Model model) {
        log.trace("Load curve point data" );
        model.addAttribute("curvePoint", curveService.findAll());
        log.trace("Display curvePoint/list view");
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        log.trace("Display curvePoint/add view");
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.error("Invalid curvePoint");
            return "curvePoint/add";
        } else {
            curveService.add(curvePoint);
            log.info("New curvePoint added: "+curvePoint.getCurveId());
            model.addAttribute("curveList", curveService.findAll());
            log.trace("Redirect to curvePoint/list view");
            return "redirect:/curvePoint/list";
        }
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("curvePointToUpdate", curveService.getById(id));
        log.info("CurvePoint to update selected by id: "+id);
        log.trace("Display curvePoint/update view");
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                            BindingResult result, Model model) {
        curveService.update(curvePoint);
        log.info("curvePoint updated: " +id);
        model.addAttribute("curveList", curveService.findAll());
        log.trace("Redirect to curvePoint/list view");
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        curveService.delete(curveService.getById(id));
        log.info("curvePoint deleted: "+id);
        model.addAttribute("curveList", curveService.findAll());
        log.trace("Redirect to curvePoint/list view");
        return "redirect:/curvePoint/list";
    }
}
