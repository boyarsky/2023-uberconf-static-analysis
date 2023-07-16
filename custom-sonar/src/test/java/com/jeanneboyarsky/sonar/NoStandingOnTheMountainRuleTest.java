package com.jeanneboyarsky.sonar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

class NoStandingOnTheMountainRuleTest {

    private NoStandingOnTheMountainRule rule;

    @BeforeEach
    void createRole() {
        rule = new NoStandingOnTheMountainRule();
    }

    @Test
    void detected() {
        CheckVerifier.newVerifier()
                .onFile("src/test/resources/BadStandingOnMountain.java")
                .withCheck(rule)
                .verifyIssues();
    }

    @Test
    void notDetected() {
        CheckVerifier.newVerifier()
                .onFile("src/test/resources/GoodFile.java")
                .withCheck(rule)
                .verifyNoIssues();
    }
}