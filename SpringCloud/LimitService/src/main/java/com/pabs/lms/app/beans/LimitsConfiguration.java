package com.pabs.lms.app.beans;

public class LimitsConfiguration {



    private int minimm;

    private int maximum;



    public int getMinimm() {
        return minimm;
    }

    public int getMaximum() {
        return maximum;
    }

    public LimitsConfiguration(int minimm, int maximum) {
        super();
        this.minimm = minimm;
        this.maximum = maximum;
    }


    public LimitsConfiguration() {
    }
}
