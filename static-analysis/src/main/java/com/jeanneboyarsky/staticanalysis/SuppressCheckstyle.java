package com.jeanneboyarsky.staticanalysis;

public class SuppressCheckstyle {

    @SuppressWarnings("checkstyle:linelength")
    public static void main(String[] args) {
        var text = """
                abcdefghizklmnopqrstuvwxyz abcdefghizklmnopqrstuvwxyz abcdefghizklmnopqrstuvwxyz abcdefghizklmnopqrstuvwxyz abcdefghizklmnopqrstuvwxyz abcdefghizklmnopqrstuvwxyz abcdefghizklmnopqrstuvwxyz abcdefghizklmnopqrstuvwxyz abcdefghizklmnopqrstuvwxyz abcdefghizklmnopqrstuvwxyz
                """;
    }

}