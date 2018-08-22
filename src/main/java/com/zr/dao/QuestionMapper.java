package com.zr.dao;

import com.zr.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    List<Quescate> queryQuesCate();
    //查询所有判断题
    List<JudgeQues> queryAllJudgeQues();
    //查询所有填空题
    List<FillBlankQues> queryAllFillBlankQues();
    //查询所有选择题
    List<SelectQues> queryAllSelectQues();
    //查询所有大题
    List<BigQues> queryAllBigQues();
    //查询一道选择题
    QuesQuery querySelectQues(String id);
    //查询一道填空题
    QuesQuery queryFillBlankQues(String id);
    //查询一道判断题
    QuesQuery queryJudgeQues(String id);
    //查询一道大题
    QuesQuery queryBigQues(String id);

    //跟新一道选择题
    void updateSelectQues(QuesQuery quesQuery);
    //跟新一道填空题
    void updateFillBlankQues(QuesQuery quesQuery);
    //跟新一道判断题
    void updateJudgeQues(QuesQuery quesQuery);
    //跟新一道大题
    void updateBigQues(QuesQuery quesQuery);
    List<BigQues> queryBigQues();
    //查询所有题目
    List<Question> queryAllQuestion(QueryVo qv);
    //查询所有题目总行数
    int queryAllQuestionRows(QueryVo qv);
    void insertJudgeQues(QuesQuery quesQuery);
    void insertSelectQues(QuesQuery quesQuery);
    void insertFillBlankQues(QuesQuery quesQuery);
    void insertBigQues(QuesQuery quesQuery);
    void delQues(@Param("table") String table,@Param("table_id") String table_id,@Param("id") String id);
}
