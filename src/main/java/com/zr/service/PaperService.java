package com.zr.service;

import com.zr.dao.QuestionMapper;
import com.zr.pojo.Paper;
import com.zr.pojo.PaperAllQues;
import com.zr.pojo.PaperTemplet;
import com.zr.pojo.SelectQues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaperService {
    private Map<String,String> testMap;

    @Autowired
    private QuestionMapper questionMapper;

    public Map<String,String> createPaper(PaperTemplet paperTemplet,String paperName){
        //保存了试卷信息的map
        Map<String,String> map=new HashMap<String, String>();
        Paper paper=new Paper();
        PaperAllQues paperAllQues=new PaperAllQues();

        paper.setPaperName(paperName);
        paper.setPaperTemplet(paperTemplet);
        map.put("paperName",paperName);

        //试卷难度系数
        Integer difficultyLevel = paperTemplet.getDifficultyLevel();
        //明天写
        Integer selectQuesNum = paperTemplet.getSelectQuesNum();
        Integer fillBlankQuesNum = paperTemplet.getFillBlankQuesNum();
        Integer judgeQuesNum = paperTemplet.getJudgeQuesNum();
        Integer bigQuesNum = paperTemplet.getBigQuesNum();

        //1.根据试卷模板生成试卷，封装map,PaperAllQues
        map.put("fillBlankQuesScore",paperTemplet.getFillBlankQuesScore().toString());
        Integer fillBlankQuesTotalScore=paperTemplet.getFillBlankQuesScore()*fillBlankQuesNum;
        map.put("fillBlankQuesTotalScore",fillBlankQuesTotalScore.toString());

        map.put("selectQuesScore",paperTemplet.getSelectQuesScore().toString());
        Integer selectQuesTotalScore=paperTemplet.getFillBlankQuesScore()*selectQuesNum;
        map.put("selectQuesTotalScore",selectQuesTotalScore.toString());

        map.put("judgeQuesScore",paperTemplet.getJudgeQuesScore().toString());
        Integer judgeQuesTotalScore=paperTemplet.getJudgeQuesScore()*judgeQuesNum;
        map.put("judgeQuesTotalScore",judgeQuesTotalScore.toString());

        map.put("bigQuesScore",paperTemplet.getBigQuesScore().toString());
        Integer bigQuesTotalScore=paperTemplet.getBigQuesScore()*bigQuesNum;
        map.put("bigQuesTotalScore",bigQuesTotalScore.toString());
        //生成选择题
        //查询所有选择题的List
        List<SelectQues> selectQuesList = questionMapper.queryAllSelectQues();
        Random random=new Random();
        List<Integer> repeatList=new ArrayList<Integer>();

        StringBuffer sb=new StringBuffer();

        for(int i = 0; i < selectQuesNum; i++){

            int num=random.nextInt(selectQuesList.size());
            if(repeatList.contains(num)){
                i--;
                continue;
            }
            else{
                repeatList.add(num);
                SelectQues selectQues = selectQuesList.get(num);
                String[] options = selectQues.getAnswer().split("#");
                char opLetter='A';
                sb.append(selectQues.getTitle()+"<w:br/>");
                for (int j = 0; j <options.length ; j++) {
                    sb.append(opLetter+"."+options[j]+"<w:br/>");
                    opLetter++;
                }
            }



        }

        //2.将试卷保存到数据库

        //3.返回试卷内容的Map集合用于生成pdf文件

        //测试用例
        return map;
    }

    public QuestionMapper getQuestionMapper() {
        return questionMapper;
    }

    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }
}
