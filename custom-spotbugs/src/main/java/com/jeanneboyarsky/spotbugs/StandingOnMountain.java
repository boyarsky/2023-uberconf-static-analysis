package com.jeanneboyarsky.spotbugs;

import edu.umd.cs.findbugs.BugInstance;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.bcel.AnnotationDetector;
import org.apache.bcel.classfile.*;

public class StandingOnMountain extends AnnotationDetector {

    private static final String KEY = "MOUNTAIN";
    private final BugReporter bugReporter;

    private boolean seenStanding;

    public StandingOnMountain(BugReporter bugReporter) {
        this.bugReporter = bugReporter;
    }

    @Override
    public void visit(Field obj) {
        super.visit(obj);

        checkOrder(obj.getName());
    }

    @Override
    public void visit(LocalVariable obj) {
        super.visit(obj);

        checkOrder(obj.getName());
    }

    private void checkOrder(String name1) {
        if ("standing".equalsIgnoreCase(name1)) {
            seenStanding = true;
        } else if (seenStanding && "mountain".equalsIgnoreCase(name1)) {
            var bug = new BugInstance(this, KEY, HIGH_PRIORITY)
                    .addClass(this).addField(this);
            bugReporter.reportBug(bug);
        }
    }
}