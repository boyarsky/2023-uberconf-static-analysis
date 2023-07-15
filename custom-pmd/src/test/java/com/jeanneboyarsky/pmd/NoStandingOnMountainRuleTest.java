package com.jeanneboyarsky.pmd;

import net.sourceforge.pmd.testframework.SimpleAggregatorTst;

public class NoStandingOnMountainRuleTest extends SimpleAggregatorTst {
    @Override
    protected void setUp() {
        addRule("com/jeanneboyarsky/pmd/mountain.xml", "NoStandingOnMountain");
    }
}
