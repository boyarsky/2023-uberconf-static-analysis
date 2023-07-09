package com.jeanneboyarsky.spotbugs;

import java.nio.file.Paths;

import org.junit.Rule;
import org.junit.Test;

import edu.umd.cs.findbugs.BugCollection;
import edu.umd.cs.findbugs.test.SpotBugsRule;

import static org.junit.Assert.*;

public class DisallowDenverTest {

    private static final String FOLDER = "build/classes/java/test/com/jeanneboyarsky/spotbugs";

    @Rule
    public SpotBugsRule spotbugs = new SpotBugsRule();

    @Test
    public void testGoodCase() {
        var path = Paths.get(FOLDER, "GoodCase.class");
        BugCollection bugCollection = spotbugs.performAnalysis(path);

        assertFalse("DENVER rule should not found", hasRuleTriggered(bugCollection));
    }

    @Test
    public void testBadCase() {
        var path = Paths.get(FOLDER, "BadDenverCase.class");
        BugCollection bugCollection = spotbugs.performAnalysis(path);

        assertTrue("DENVER rule should be found", hasRuleTriggered(bugCollection));
    }

    @Test
    public void testBadStringCase() {
        var path = Paths.get(FOLDER, "BadStringCase.class");
        BugCollection bugCollection = spotbugs.performAnalysis(path);

        assertTrue("DENVER rule should be found", hasRuleTriggered(bugCollection));
    }

    private static boolean hasRuleTriggered(BugCollection bugCollection) {
        return bugCollection.getCollection().stream()
                .anyMatch(b -> "DENVER".equals(b.getBugPattern().getType()));
    }
}
