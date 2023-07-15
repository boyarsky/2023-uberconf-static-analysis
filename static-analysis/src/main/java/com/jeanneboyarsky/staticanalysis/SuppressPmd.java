package com.jeanneboyarsky.staticanalysis;

import java.util.HashSet;

public class SuppressPmd {
    @SuppressWarnings("PMD.UnusedLocalVariable")
    public static void main(String[] args) {
        var set = new HashSet<String>();
    }

}