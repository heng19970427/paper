package com.zr.service;

import com.zr.pojo.Paper;
import com.zr.pojo.PaperAllQues;
import com.zr.pojo.PaperTemplet;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaperService {
    private Map<String,String> testMap;
    public Map<String,String> createPaper(PaperTemplet paperTemplet,String paperName){
        //保存了试卷信息的map
        Map<String,String> map=new HashMap<String, String>();
        Paper paper=new Paper();
        PaperAllQues paperAllQues=new PaperAllQues();

        paper.setPaperName(paperName);
        paper.setPaperTemplet(paperTemplet);
        map.put("paperName",paperName);

        paperTemplet.getDifficultyLevel();
        //明天写 修改数据库题目难度系数
        Integer selectQuesNum = paperTemplet.getSelectQuesNum();
        Integer fillBlankQuesNum = paperTemplet.getFillBlankQuesNum();
        Integer judgeQuesNum = paperTemplet.getJudgeQuesNum();
        Integer bigQuesNum = paperTemplet.getBigQuesNum();

        //1.根据试卷模板生成试卷，封装map,PaperAllQues

        //2.将试卷保存到数据库

        //3.返回试卷内容的Map集合用于生成pdf文件

        //测试用例
        return map;
    }
}
