package com.jeanneboyarsky.staticanalysis;

import java.util.HashSet;

public class SuppressSonar {
    @SuppressWarnings("java:S1854")
    public static void main(String[] args) {
        var set = new HashSet<String>();
    }

}