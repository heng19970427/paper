package com.zr.service;

import com.zr.dao.QuestionMapper;
import com.zr.pojo.*;
import com.zr.utils.Convert;
import com.zr.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper mapper;
    public List<Quescate> queryQuesCate() {
        return mapper.queryQuesCate();
    }

    //分页查询试题信息
    public Page<Question> queryAllQuestion(QueryVo qv){
        //设置查询条件,从那条数据开始查
        qv.setStart((qv.getPage()-1)*qv.getRows());
        //共有多少条数据
        int total=mapper.queryAllQuestionRows(qv);
        List<Question> list=mapper.queryAllQuestion(qv);

        //封装Page
        Page<Question> page=new Page<Question>();
        page.setRows(list);
        page.setPage(qv.getPage());
        page.setTotal(total);
        page.setSize(qv.getRows());
        return page;
    }

    public void delQues(String p_id,String id){
        String[] tableInfo=Convert.whichTable(p_id).split("-");
        mapper.delQues(tableInfo[0],tableInfo[1],id);
    }
    //根据条件查询试题
//    public List<ProbCate> queryQues(){
//        return mapper.queryQues();
//    }

    public QuesQuery queryOneQues (String p_id, String id)  {
        if(p_id.equals("1")){
            return mapper.querySelectQues(id);
        }
        if(p_id.equals("2")){
            return mapper.queryFillBlankQues(id);
        }
        if(p_id.equals("3")){
            return mapper.queryJudgeQues(id);
        }
        if(p_id.equals("4")){
            return mapper.queryBigQues(id);
        }
        return null;
    }

    public void updateQuestion (QuesQuery quesQuery)  {
        if((quesQuery.getProbCate().getP_id())==1){
             mapper.updateSelectQues(quesQuery);
        }
        if((quesQuery.getProbCate().getP_id())==2){
            mapper.updateFillBlankQues(quesQuery);
        }
        if((quesQuery.getProbCate().getP_id())==3){
            mapper.updateJudgeQues(quesQuery);
        }
        if((quesQuery.getProbCate().getP_id())==4){
            mapper.updateBigQues(quesQuery);
        }
    }

    public void addQuestion (QuesQuery quesQuery)  {
        if((quesQuery.getProbCate().getP_id())==1){
            mapper.insertSelectQues(quesQuery);
        }
        if((quesQuery.getProbCate().getP_id())==2){
            mapper.insertFillBlankQues(quesQuery);
        }
        if((quesQuery.getProbCate().getP_id())==3){
            mapper.insertJudgeQues(quesQuery);
        }
        if((quesQuery.getProbCate().getP_id())==4){
            mapper.insertBigQues(quesQuery);
        }
    }
    public QuestionMapper getMapper() {
        return mapper;
    }

    public void setMapper(QuestionMapper mapper) {
        this.mapper = mapper;
    }
}
