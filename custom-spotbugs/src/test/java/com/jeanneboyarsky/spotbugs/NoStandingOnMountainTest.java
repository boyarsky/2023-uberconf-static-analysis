package com.jeanneboyarsky.spotbugs;

import edu.umd.cs.findbugs.BugCollection;
import edu.umd.cs.findbugs.test.SpotBugsRule;
import org.junit.Rule;
import org.junit.Test;

import java.nio.file.Paths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NoStandingOnMountainTest {

    private static final String FOLDER = "build/classes/java/test/com/jeanneboyarsky/spotbugs";

    @Rule
    public SpotBugsRule spotbugs = new SpotBugsRule();

    @Test
    public void testGoodCase() {
        var path = Paths.get(FOLDER, "GoodCase.class");
        BugCollection bugCollection = spotbugs.performAnalysis(path);

        assertFalse("MOUNTAIN rule should not found", hasRuleTriggered(bugCollection));
    }

    @Test
    public void testBadCase() {
        var path = Paths.get(FOLDER, "NoStandingOnMountain.class");
        BugCollection bugCollection = spotbugs.performAnalysis(path);

        assertTrue("MOUNTAIN rule should be found", hasRuleTriggered(bugCollection));
    }

    private static boolean hasRuleTriggered(BugCollection bugCollection) {
        return bugCollection.getCollection().stream()
                .anyMatch(b -> "MOUNTAIN".equals(b.getBugPattern().getType()));
    }
}
