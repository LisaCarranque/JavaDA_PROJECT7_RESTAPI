package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;

import java.util.List;

public interface IRuleNameService {

    public List<RuleName> findAll();

    public RuleName add(RuleName ruleName);

    public RuleName validate(RuleName ruleName);

    public RuleName update(RuleName ruleName);

    public RuleName getById(Integer id);

    public void delete(RuleName ruleName);
}
