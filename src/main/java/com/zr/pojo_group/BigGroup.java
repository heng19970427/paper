package com.zr.pojo_group;

import com.zr.pojo.Bigques;
import com.zr.pojo.Option;
import com.zr.pojo.Response;

import java.util.List;

public class BigGroup {
    private Bigques bigques;
    private List<Option> optionList;

    public BigGroup(Bigques bigques, List<Option> optionList) {
        this.bigques = bigques;
        this.optionList = optionList;
    }

    public BigGroup() {
    }

    public Bigques getBigques() {
        return bigques;
    }

    public void setBigques(Bigques bigques) {
        this.bigques = bigques;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    public static Response dataValidate(List<Option> optionList){
        if(optionList==null||optionList.size()==0){
            return new Response(false,"综合题的小题不能为空");
        }
        for (Option option:optionList){
            if(option.getOptionName()=="" ||option.getOptionName()==null){
                return new Response(false,"综合题的小题题目不能为空");
            }
        }
        return new Response(true,"校验合格");
    }
}
