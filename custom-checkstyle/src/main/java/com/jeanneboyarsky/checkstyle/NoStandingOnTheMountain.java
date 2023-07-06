package com.jeanneboyarsky.checkstyle;

import com.puppycrawl.tools.checkstyle.api.*;

import java.io.File;

public class NoStandingOnTheMountain extends AbstractCheck {

    private boolean encounteredStanding;

    // the three token sets are often the same
    // https://checkstyle.sourceforge.io/writingchecks.html
    @Override
    public int[] getDefaultTokens() {
        return new int[]{TokenTypes.VARIABLE_DEF };
    }

    @Override
    public int[] getAcceptableTokens() {
        return getDefaultTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        return getDefaultTokens();
    }

    @Override
    public void visitToken(DetailAST ast) {
        final DetailAST nameAst = ast.findFirstToken(TokenTypes.IDENT);
        final String name = nameAst.getText();
        if ("STANDING".equalsIgnoreCase(name)) {
            encounteredStanding = true;
        }
        if (encounteredStanding && "MOUNTAIN".equalsIgnoreCase(name)) {
            log(ast.getLineNo(), "standing.mountain");
        }

    }
}