package com.zr.pojo_group;

import com.zr.pojo.Option;
import com.zr.pojo.Selectques;

import java.util.List;

public class SelectGroup {
    private Selectques selectques;
    private List<Option> optionList;

    public Selectques getSelectques() {
        return selectques;
    }

    public void setSelectques(Selectques selectques) {
        this.selectques = selectques;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}
