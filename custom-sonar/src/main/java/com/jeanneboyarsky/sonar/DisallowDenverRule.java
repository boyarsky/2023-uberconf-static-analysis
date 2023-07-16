package com.jeanneboyarsky.sonar;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.CompilationUnitTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.LiteralTree;

@Rule(key = "DisallowDenver")
public class DisallowDenverRule extends BaseTreeVisitor implements JavaFileScanner {

    private JavaFileScannerContext context;

    @Override
    public void scanFile(final JavaFileScannerContext context) {
        this.context = context;
        scan(context.getTree());
    }

    @Override
    public void visitLiteral(LiteralTree tree) {
        if (tree.value().toLowerCase().contains("denver")){
            context.reportIssue(this, tree, "Do not use 'Denver'");
        }
        super.visitLiteral(tree);
    }

    @Override
    public void visitIdentifier(IdentifierTree tree) {
        if (tree.name().toLowerCase().contains("denver")){
            context.reportIssue(this, tree, "Do not use 'Denver'");
        }
        super.visitIdentifier(tree);
    }
}
