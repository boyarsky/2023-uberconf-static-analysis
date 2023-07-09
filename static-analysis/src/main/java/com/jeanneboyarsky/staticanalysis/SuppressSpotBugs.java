package com.jeanneboyarsky.staticanalysis;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.HashSet;

public class SuppressSpotBugs {
    @SuppressFBWarnings(value="DLS_DEAD_LOCAL_STORE",
            justification="Ignore me")
    public static void main(String[] args) {
        var set = new HashSet<String>();
    }

}