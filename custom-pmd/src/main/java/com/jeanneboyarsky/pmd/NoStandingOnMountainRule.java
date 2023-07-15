package com.jeanneboyarsky.pmd;

import net.sourceforge.pmd.RuleContext;
import net.sourceforge.pmd.lang.java.ast.ASTVariableDeclaratorId;
import net.sourceforge.pmd.lang.java.rule.*;

public class NoStandingOnMountainRule extends AbstractJavaRule {

    private boolean sawStanding;

    @Override
    public void start(RuleContext ctx) {
        sawStanding = false;
    }

    @Override
    // includes instance/static/local variable
    public Object visit(ASTVariableDeclaratorId node, Object data) {

        if (node.getName().equalsIgnoreCase("standing")) {
            sawStanding = true;
        }
        if (sawStanding && node.getName().equalsIgnoreCase("mountain")) {
            asCtx(data).addViolation(node);
        }
        return super.visit(node, data);
    }

}
