package com.jeanneboyarsky.checkstyle;

import com.puppycrawl.tools.checkstyle.api.AbstractFileSetCheck;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.FileText;

import java.io.File;

public class DisallowDenver extends AbstractFileSetCheck  {

    @Override
    protected void processFiltered(File file, FileText fileText) throws CheckstyleException {
        var lines = fileText.toLinesArray();
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains("Denver")) {
                log(i, "denver.present", lines[i]);
            }
        }
    }
}