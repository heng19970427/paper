package com.zr.pojo;

import javax.validation.constraints.NotEmpty;

public class Option {

    @NotEmpty
    private String optionName;

    public Option(String s) {
        this.optionName=s;
    }

    public Option() {
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}