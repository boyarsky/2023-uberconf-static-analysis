package com.jeanneboyarsky.sonar;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.List;

public class DenverRegistrar implements CheckRegistrar {

    /**
     * Register the classes that will be used to instantiate checks during analysis.
     */
    @Override
    public void register(RegistrarContext registrarContext) {
        // Call to registerClassesForRepository to associate the classes with the correct repository key
        registrarContext.registerClassesForRepository(DenverRuleDefinition.REPOSITORY_KEY, checkClasses(), testCheckClasses());
    }

    /**
     * Lists all the main checks provided by the plugin
     */
    public static List<Class<? extends JavaCheck>> checkClasses() {
        return RulesList.getJavaChecks();
    }

    /**
     * Lists all the test checks provided by the plugin
     */
    public static List<Class<? extends JavaCheck>> testCheckClasses() {
        return RulesList.getJavaTestChecks();
    }
}