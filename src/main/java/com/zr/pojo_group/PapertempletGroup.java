package com.zr.pojo_group;

import com.zr.pojo.Knowledge;
import com.zr.pojo.Knowledgetemplet;
import com.zr.pojo.Papertemplet;
import com.zr.pojo.Response;

import java.util.List;
import java.util.Map;

public class PapertempletGroup {
    private Papertemplet papertemplet;
    private List<Knowledgetemplet> knowledgetempletList;
    private List<Map> knowledgeMap;
    private List<Map> quesCateMap;

    public List<Map> getQuesCateMap() {
        return quesCateMap;
    }

    public void setQuesCateMap(List<Map> quesCateMap) {
        this.quesCateMap = quesCateMap;
    }

    public List<Map> getKnowledgeMap() {
        return knowledgeMap;
    }

    public void setKnowledgeMap(List<Map> knowledgeMap) {
        this.knowledgeMap = knowledgeMap;
    }

    public Papertemplet getPapertemplet() {
        return papertemplet;
    }

    public void setPapertemplet(Papertemplet papertemplet) {
        this.papertemplet = papertemplet;
    }

    public List<Knowledgetemplet> getKnowledgetempletList() {
        return knowledgetempletList;
    }

    public void setKnowledgetempletList(List<Knowledgetemplet> knowledgetempletList) {
        this.knowledgetempletList = knowledgetempletList;
    }
    public static Response dataValidate(PapertempletGroup papertempletGroup){

        List<Knowledgetemplet> knowledgetempletList=papertempletGroup.getKnowledgetempletList();
        Papertemplet papertemplet=papertempletGroup.getPapertemplet();

        //防止空指针
        if(papertemplet.getJudgequesnum()==null){
            papertemplet.setJudgequesnum(0);
            papertemplet.setJudgequesscore(0);
        }
        if(papertemplet.getSelectquesnum()==null){
            papertemplet.setSelectquesnum(0);
            papertemplet.setSelectquesscore(0);
        }
        if(papertemplet.getFillblankquesnum()==null){
            papertemplet.setFillblankquesnum(0);
            papertemplet.setFillblankquesscore(0);
        }
        if(papertemplet.getBigquesnum()==null){
            papertemplet.setBigquesnum(0);
            papertemplet.setBigquesscore(0);
        }

        int judgeNum=0;
        int selectNum=0;
        int fillBlankNum=0;
        int bigNum=0;
        int totalScore=0;
        for (Knowledgetemplet knowledgetemplet:knowledgetempletList){
            judgeNum+=knowledgetemplet.getJudgequesnum();
            selectNum+=knowledgetemplet.getSelectquesnum();
            fillBlankNum+=knowledgetemplet.getFillblankquesnum();
            bigNum+=knowledgetemplet.getBigquesnum();
        }
        totalScore=judgeNum*papertemplet.getJudgequesscore()+selectNum*papertemplet.getSelectquesscore()+fillBlankNum*papertemplet.getFillblankquesscore()+bigNum*papertemplet.getBigquesscore();
        if(judgeNum!=papertemplet.getJudgequesnum()){
            return new Response(false,"判断题数目与设定数目不相等");
        }
        if(selectNum!=papertemplet.getSelectquesnum()){
            return new Response(false,"选择题数目与设定数目不相等");
        }
        if(fillBlankNum!=papertemplet.getFillblankquesnum()){
            return new Response(false,"填空题数目与设定数目不相等");
        }
        if(bigNum!=papertemplet.getBigquesnum()){
            return new Response(false,"综合题数目与设定数目不相等");
        }
        if(totalScore!=papertemplet.getScore()){
            return new Response(false,"综合题数目与设定数目不相等");
        }
        if(papertemplet.getKnowledgeIds()==null){
            return new Response(false,"创建失败,必须选择至少一个知识点!");
        }
        if(papertemplet.getQuescateIds()==null){
            return new Response(false,"创建失败,必须选择试卷出现的题型!");
        }
        return new Response(true,"数据合格");
    }
}
