package com.jeanneboyarsky.spotbugs;

import edu.umd.cs.findbugs.*;
import edu.umd.cs.findbugs.bcel.AnnotationDetector;
import org.apache.bcel.classfile.*;

// logic based off https://github.com/spotbugs/spotbugs/blob/master/spotbugs/src/main/java/edu/umd/cs/findbugs/detect/DontUseEnum.java
public class DisallowDenver extends AnnotationDetector {

    private static final String KEY = "DENVER";
    private final BugReporter bugReporter;

    public DisallowDenver(BugReporter bugReporter) {
        this.bugReporter = bugReporter;
    }

    private static boolean containsDenver(String name) {
        return name.contains("Denver");
    }

    @Override
    public void visit(JavaClass obj) {
        super.visit(obj);
        if (containsDenver(obj.getClassName())) {
            var bug = new BugInstance(this, KEY, HIGH_PRIORITY)
                    .addClass(this);
            bugReporter.reportBug(bug);
        }
    }

    @Override
    public void visit(Method obj) {
        super.visit(obj);
        if (containsDenver(obj.getName())) {
            var bug = new BugInstance(this, KEY, HIGH_PRIORITY)
                    .addClassAndMethod(this);
            bugReporter.reportBug(bug);
        }
    }


    @Override
    public void visit(Field obj) {
        super.visit(obj);
        if (containsDenver(obj.getName())) {
            var bug = new BugInstance(this, KEY, HIGH_PRIORITY)
                    .addClass(this).addField(this);
            bugReporter.reportBug(bug);
        }
    }

    @Override
    public void visit(LocalVariable obj) {
        super.visit(obj);
        if (containsDenver(obj.getName())) {
            var variable = new LocalVariableAnnotation(obj.getName(), obj.getIndex(), obj.getStartPC());
            var source = SourceLineAnnotation.fromVisitedInstruction(getClassContext(), this, obj.getStartPC());
            var bug = new BugInstance(this, KEY, HIGH_PRIORITY)
                    .addClassAndMethod(this).add(variable).add(source);
            bugReporter.reportBug(bug);
        }
    }

    @Override
    public void visit(ConstantString obj) {
        super.visit(obj);
        var value = obj.getConstantValue(getConstantPool()).toString();
        if (containsDenver(value)) {
            var bug = new BugInstance(this, KEY, HIGH_PRIORITY)
                    .addClass(this);
            bugReporter.reportBug(bug);
        }
    }
}