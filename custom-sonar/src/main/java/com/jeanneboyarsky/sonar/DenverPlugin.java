package com.jeanneboyarsky.sonar;

import org.sonar.api.Plugin;

import javax.naming.Context;

public class DenverPlugin implements Plugin {
    @Override
    public void define(Context context) {
        context.addExtension(DenverRuleDefinition.class);
        context.addExtension(DenverRegistrar.class);
    }
}
