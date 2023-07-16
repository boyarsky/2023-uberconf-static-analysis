package com.jeanneboyarsky.sonar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

import static org.junit.jupiter.api.Assertions.*;

class DisallowDenverRuleTest {

    private DisallowDenverRule rule;

    @BeforeEach
    void createRole() {
        rule = new DisallowDenverRule();
    }

    @Test
    void detected() {
        CheckVerifier.newVerifier()
                .onFile("src/test/resources/BadDenver.java")
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