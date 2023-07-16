package com.jeanneboyarsky.sonar;

import org.sonar.plugins.java.api.JavaCheck;

import java.util.List;

public class RulesList {

    public static List<Class<? extends JavaCheck>> getChecks() {
        return List.of(DisallowDenverRule.class, NoStandingOnTheMountainRule.class);
    }

    /**
     * These rules are going to target MAIN code only
     */
    public static List<Class<? extends JavaCheck>> getJavaChecks() {
        return getChecks();
    }

    /**
     * These rules are going to target TEST code only
     */
    public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
        return List.of();
    }
}
