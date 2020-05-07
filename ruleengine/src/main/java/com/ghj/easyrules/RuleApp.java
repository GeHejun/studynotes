package com.ghj.easyrules;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.easyrules.core.RulesEngineParameters;


/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/5/7 18:45
 */
public class RuleApp {

    public static void main(String[] args) {
        RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build();
        rulesEngine.registerRule(new WeatherRules());
        rulesEngine.fireRules();
    }
}
