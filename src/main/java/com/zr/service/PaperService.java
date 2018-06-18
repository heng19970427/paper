package com.zr.service;

import com.zr.dao.QuestionMapper;
import com.zr.pojo.*;
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

        Random random=new Random();
        List<Integer> repeatList=new ArrayList<Integer>();
        int quesLibNum;
        StringBuffer sb;
        StringBuffer answersb;
        int lowSelectedNum;
        double difficultyLevelCon;
        boolean flag;
        String targetQues;
        String targetQuesAnswer;

        //生成填空题
        //查询所有填空题的List
        List<FillBlankQues> fillBlankQuesList = questionMapper.queryAllFillBlankQues();
        sb=new StringBuffer();
        answersb=new StringBuffer();
        quesLibNum=fillBlankQuesList.size();
        //最低被选中次数
        lowSelectedNum=fillBlankQuesList.get(0).getSelectedNum();
        //难度系数控制
        difficultyLevelCon=0;

        for(int i = 1; i <= fillBlankQuesNum; i++){
            //随机题号
            int num=random.nextInt(quesLibNum);
            FillBlankQues fillBlankQues = fillBlankQuesList.get(num);
            //选择次数
            int selectedNum = fillBlankQues.getSelectedNum();
            //当前平均难度系数
            //difficultyLevelCon=(difficultyLevelCon*(i-1)+fillBlankQues.getDifficultyLevel())/i;
            //生成过程难度系数状态
            flag=(difficultyLevelCon-difficultyLevel)>=0 ? true :false;
            if(flag){
                //选一题低于difficultyLevel的
                //重复、试题被多次出题、难度系数过大重新选择，
                if(repeatList.contains(num) && (selectedNum-lowSelectedNum<=3 ? true : false) && (fillBlankQues.getDifficultyLevel()<=difficultyLevel ? true :false)){
                    repeatList.add(num);
                    sb.append(i+"."+fillBlankQues.getTitle()+"<w:br/>");
                    answersb.append(i+"."+fillBlankQues.getAnswer()+"  ");
                }else {
                    i--;
                    continue;
                }
            }
            else{
                //选一题高于difficultyLevel的，不高于就重来
                if(fillBlankQues.getDifficultyLevel()>=difficultyLevel ? true :false){
                    repeatList.add(num);
                    sb.append(i+"."+fillBlankQues.getTitle()+"<w:br/>");
                    answersb.append(i+"."+fillBlankQues.getAnswer()+"  ");
                }else {
                    i--;
                    continue;
                }

            }
        }
        targetQues=sb.toString();
        targetQuesAnswer=answersb.toString();
        targetQuesAnswer=targetQuesAnswer.replace("&", "&#38;");
        targetQues=targetQues.replace("&", "&#38;");
        map.put("fillBlankQuesMap",targetQues);
        //填空题答案
        map.put("fillBlankAnswer",targetQuesAnswer);
        System.out.println(difficultyLevelCon);
        repeatList.clear();

        //生成选择题
        //查询所有选择题的List
        List<SelectQues> selectQuesList = questionMapper.queryAllSelectQues();
        sb=new StringBuffer();
        answersb=new StringBuffer();
        //题库中选择题总数
        quesLibNum=selectQuesList.size();
        //最低被选中次数
        lowSelectedNum=selectQuesList.get(0).getSelectedNum();

        //难度系数控制
        difficultyLevelCon=0;
        for(int i = 1; i <= selectQuesNum; i++){
            //随机题号
            int num=random.nextInt(quesLibNum);
            SelectQues selectQues = selectQuesList.get(num);
            //选择次数
            int selectedNum = selectQues.getSelectedNum();
            //当前平均难度系数
            //difficultyLevelCon=(difficultyLevelCon*(i-1)+selectQues.getDifficultyLevel())/i;
            //生成过程难度系数状态
            flag=(difficultyLevelCon-difficultyLevel)>=0 ? true :false;
            if(flag){
                //选一题低于difficultyLevel的
                //重复、试题被多次出题、难度系数过大重新选择，
                if(repeatList.contains(num) && (selectedNum-lowSelectedNum<=3 ? true : false) && (selectQues.getDifficultyLevel()<=difficultyLevel ? true :false)){
                    i--;
                    continue;
                }
                else{
                    repeatList.add(num);
                    String[] options = selectQues.getOption().split("###");
                    char opLetter='A';
                    sb.append(i+"."+selectQues.getTitle()+"<w:br/>");
                    answersb.append(i+"."+selectQues.getAnswer()+"  ");
                    //生成选项
                    for (int j = 1; j <options.length ; j++) {
                        sb.append(opLetter+"."+options[j]+"<w:br/>");
                        opLetter++;
                    }
                }
            }
            else{
                //选一题高于difficultyLevel的，不高于就重来
                if(selectQues.getDifficultyLevel()>=difficultyLevel ? true :false){
                    i--;
                    continue;
                }
                repeatList.add(num);
                String[] options = selectQues.getOption().split("###");
                char opLetter='A';
                sb.append(i+"."+selectQues.getTitle()+"<w:br/>");
                answersb.append(i+"."+selectQues.getAnswer()+"  ");
                //生成选项
                for (int j = 1; j <options.length ; j++) {
                    sb.append(opLetter+"."+options[j]+"<w:br/>");
                    opLetter++;
                }
            }
        }
        //将选择题放入map
        targetQues=sb.toString();
        //处理特殊字符
        targetQues=targetQues.replace("&", "&#38;");
        targetQuesAnswer=answersb.toString();
        targetQuesAnswer=targetQuesAnswer.replace("&", "&#38;");
        //选择题答案
        map.put("selectAnswer",targetQuesAnswer);
        System.out.println(difficultyLevelCon);
        map.put("selectQuesMap",targetQues);

        //生成判断题
        //查询所有判断题的List
        List<JudgeQues> judgeQuesList = questionMapper.queryAllJudgeQues();
        sb=new StringBuffer();
        answersb=new StringBuffer();
        quesLibNum=judgeQuesList.size();
        //最低被选中次数
        lowSelectedNum=judgeQuesList.get(0).getSelectedNum();
        //难度系数控制
        difficultyLevelCon=0;

        for(int i = 1; i <= judgeQuesNum; i++){
            //随机题号
            int num=random.nextInt(quesLibNum);
            JudgeQues judgeQues = judgeQuesList.get(num);
            //选择次数
            int selectedNum = judgeQues.getSelectedNum();
            //当前平均难度系数
            //difficultyLevelCon=(difficultyLevelCon*(i-1)+fillBlankQues.getDifficultyLevel())/i;
            //生成过程难度系数状态
            flag=(difficultyLevelCon-difficultyLevel)>=0 ? true :false;
            if(flag){
                //选一题低于difficultyLevel的
                //重复、试题被多次出题、难度系数过大重新选择，
                if(repeatList.contains(num) && (selectedNum-lowSelectedNum<=3 ? true : false) && (judgeQues.getDifficultyLevel()<=difficultyLevel ? true :false)){
                    repeatList.add(num);
                    sb.append(i+"."+judgeQues.getTitle()+"<w:br/>");
                    answersb.append(i+"."+judgeQues.getAnswer()+"   ");
                }else {
                    i--;
                    continue;
                }
            }
            else{
                //选一题高于difficultyLevel的，不高于就重来
                if(judgeQues.getDifficultyLevel()>=difficultyLevel){
                    repeatList.add(num);
                    sb.append(i+"."+judgeQues.getTitle()+" (  )<w:br/>");
                    answersb.append(i+"."+judgeQues.getAnswer()+"  ");
                }else {
                    i--;
                    continue;
                }
            }
        }
        targetQues=sb.toString();
        targetQues=targetQues.replace("&", "&#38;");
        targetQuesAnswer=answersb.toString();
        targetQuesAnswer=targetQuesAnswer.replace("&", "&#38;");
        map.put("judgeQuesMap",targetQues);
        //判断题答案
        map.put("judgeAnswer",targetQuesAnswer);
        repeatList.clear();

        //生成编程题
        //查询所有编程题的List
        List<BigQues> bigQuesList = questionMapper.queryAllBigQues();
        sb=new StringBuffer();
        answersb=new StringBuffer();
        quesLibNum=bigQuesList.size();
        //最低被选中次数
        lowSelectedNum=bigQuesList.get(0).getSelectedNum();
        //难度系数控制
        difficultyLevelCon=0;

        for(int i = 1; i <= bigQuesNum; i++){
            //随机题号
            int num=random.nextInt(quesLibNum);
            BigQues bigQues = bigQuesList.get(num);
            //选择次数
            int selectedNum = bigQues.getSelectedNum();
            //当前平均难度系数
            //difficultyLevelCon=(difficultyLevelCon*(i-1)+fillBlankQues.getDifficultyLevel())/i;
            //生成过程难度系数状态
            flag=(difficultyLevelCon-difficultyLevel)>=0 ? true :false;
            if(flag){
                if(repeatList.contains(num) && (selectedNum-lowSelectedNum<=3) && (bigQues.getDifficultyLevel()<=difficultyLevel ? true :false)){
                    repeatList.add(num);
                    sb.append(i+"."+bigQues.getTitle()+"<w:br/>");
                    answersb.append(i+"."+bigQues.getAnswer()+"  ");
                }else {
                    i--;
                    continue;
                }
            }
            else{
                //选一题高于difficultyLevel的，不高于就重来
                if(bigQues.getDifficultyLevel()>=difficultyLevel){
                    repeatList.add(num);
                    sb.append(i+"."+bigQues.getTitle()+"<w:br/>");
                    answersb.append(i+"."+bigQues.getAnswer()+"  ");
                }else {
                    i--;
                    continue;
                }
            }
        }
        targetQues=sb.toString();
        targetQues=targetQues.replace("&", "&#38;");
        targetQuesAnswer=answersb.toString();
        targetQuesAnswer=targetQuesAnswer.replace("&", "&#38;");
        //大题答案
        map.put("bigQuesAnswer",targetQuesAnswer);
        map.put("bigQuesMap",targetQues);
        repeatList.clear();

        //2.将试卷保存到数据库

        //3.返回试卷内容的Map集合用于生成pdf文件

        //测试用例
        return map;
    }

    public QuestionMapper getQuestionMapper(){
        return questionMapper;
    }

    public void setQuestionMapper(QuestionMapper questionMapper){
        this.questionMapper = questionMapper;
    }
}
