package com.nnk.springboot.TU.domain;

import com.nnk.springboot.domain.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RuleTest {

    @Test
    public void setTest() {
        Rule rule = Rule.builder().build();
        rule.setName("name");
        rule.setId(1);
        rule.setDescription("description");
        rule.setJson("json");
        rule.setSqlStr("sql str");
        rule.setSqlPart("sql part");
        assertEquals(Integer.valueOf(1), rule.getId());
        assertEquals("description", rule.getDescription());
        assertEquals("json", rule.getJson());
        assertEquals("name", rule.getName());
        assertEquals("sql part", rule.getSqlPart());
        assertEquals("sql str", rule.getSqlStr());
    }

    @Test
    public void getTest() {
        Rule rule = Rule.builder().build();
        rule.setName("name");
        rule.setId(1);
        rule.setDescription("description");
        rule.setJson("json");
        rule.setSqlStr("sql str");
        rule.setSqlPart("sql part");
        assertEquals(Integer.valueOf(1), rule.getId());
        assertEquals("description", rule.getDescription());
        assertEquals("json", rule.getJson());
        assertEquals("name", rule.getName());
        assertEquals("sql part", rule.getSqlPart());
        assertEquals("sql str", rule.getSqlStr());
    }

}
