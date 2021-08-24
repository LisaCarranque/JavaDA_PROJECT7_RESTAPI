package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rule;

import java.util.List;

public interface IRuleService {

    public List<Rule> findAll();

    public Rule add(Rule rule);

    public Rule update(Rule rule);

    public Rule getById(Integer id);

    public void delete(Rule rule);
}
