package com.jeanneboyarsky.staticanalysis;

import java.util.HashMap;
import java.util.HashSet;

public class ProblemClass {

    public static class Rabbit {
        public int numHops = 0;
    }

    public static void main(String[] args) {
        Object empty = null;
        Object num = Double.valueOf(42);
        if (empty != null && num instanceof Long) {

        }
        if ("test" != "test") {

        }

        var set = new HashSet<Rabbit>();
        set.add(new Rabbit());
    }

}