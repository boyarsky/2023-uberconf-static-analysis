package com.jeanneboyarsky.sonar;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.LiteralTree;

@Rule(key = "NoStandingOnTheMountain")
public class NoStandingOnTheMountainRule extends BaseTreeVisitor implements JavaFileScanner {

        private boolean seenStanding;

        private JavaFileScannerContext context;

        @Override
        public void scanFile(final JavaFileScannerContext context) {
            this.context = context;
            scan(context.getTree());
        }

        @Override
        public void visitIdentifier(IdentifierTree tree) {
            if (tree.name().toLowerCase().contains("standing")) {
                seenStanding = true;
            }  else if (seenStanding && tree.name().toLowerCase().contains("mountain")){
                context.reportIssue(this, tree, "Do not have 'standing' before 'mountain'");
            }
            super.visitIdentifier(tree);
        }
}
