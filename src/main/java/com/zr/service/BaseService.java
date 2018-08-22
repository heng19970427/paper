package com.zr.service;

import com.zr.dao.BaseMapper;
import com.zr.dao.QuestionMapper;
import com.zr.pojo.*;
import com.zr.utils.ReadExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BaseService {
    @Autowired
    BaseMapper baseMapper;

    @Autowired
    QuestionMapper questionMapper;
    //查询所有科目试题类型
    public List<Course> queryAllCourse(){
        return baseMapper.queryAllCourse();
    }
    //查询所有试题类型
    public List<ProbCate> queryAllProbCate(){
        return baseMapper.queryAllProbCate();
    }
    //根据c_id和p_id查询具体类型
    public List<Quescate> queryQuesCate(QueryVo qv){
        return baseMapper.queryQuesCate(qv);
    }

    //根据c_id查询具体类型
    public List<Quescate> queryQuesCateByCId(String c_id){
        return baseMapper.queryQuesCateByCId(c_id);
    }

    public BaseMapper getBaseMapper() {
        return baseMapper;
    }

    public void setBaseMapper(BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
    }

    public List<Quescate> createExcelTemp(String[] qcNames) {
        //根据数组创建QuesCate集合
        List<Quescate> quesCateList=new ArrayList<Quescate>();
        for (int i = 0; i <qcNames.length ; i++) {
            Quescate quesCate=baseMapper.queryQuesCateByQId(qcNames[i]);
            quesCateList.add(quesCate);
        }
        return quesCateList;
    }

    public boolean importExcel(MultipartFile excel, String fileName,String c_id) {
        boolean result=true;
        /*
        * 1.根据试题科目查询类型，封装QuesCate
        * 2.取出所有页面名称
        * 3.根据页面名称从QuesCate中取出p_id
        * 判断插入不同的表
        * */
        //创建excel读取工具
        //1.根据试题科目查询类型，封装QuesCate
        List<Quescate> quesCateList = baseMapper.queryQuesCateByCId(c_id);

        ReadExcelUtils readExcelUtils=new ReadExcelUtils(fileName,excel);
        int pages = readExcelUtils.getNumPages();
        //遍历每一页
        try {
            for(int j=0;j<pages;j++){
                Map<Integer, Map<Integer, Object>> excelContent = readExcelUtils.readExcelContent(j);
                String sheetName = readExcelUtils.getSheetName(j);
                boolean flag=false;
                for (Quescate cate:quesCateList) {
                    //判断是否存在该题型，若存在则插入
                    if((cate.getQcName()).equals(sheetName)){
                        //取出p_id，判断插入的表
                        int p_id = cate.getProbCate().getP_id();
                        //封装quesQuery,插入数据库
                        QuesQuery quesQuery=new QuesQuery();
                        quesQuery.setQuesCate(cate);
                        Course course=new Course();
                        course.setC_id(Integer.valueOf(c_id));
                        quesQuery.setCourse(course);
                        for (int i = 1; i <=excelContent.size();i++) {
                            //得到每一行的内容
                            Map<Integer, Object> rowContent = excelContent.get(i);
                            //遍历每一列，封装quesQuery
                            quesQuery.setTitle(rowContent.get(0).toString());

                            //判断题目类型
                            if(p_id==1){
                                Integer blankNum = cate.getBlankNum();
                                String option="";
                                //遍历选项
                                for (int k = 1; k <=blankNum; k++) {
                                    //拼接
                                    option=option+"###"+rowContent.get(k);
                                }
                                quesQuery.setOption(option);
                                quesQuery.setBlankNum(blankNum);
                                quesQuery.setAnswer(rowContent.get(blankNum+1).toString());

                                //封装知识点 用户可选
                                Knowledge knowledge=baseMapper.queryKnowledge(rowContent.get(blankNum+2).toString());
                                if(knowledge==null){
                                    break;
                                }
                                quesQuery.setKnowledge(knowledge);
                                quesQuery.setDifficultyLevel( Integer.valueOf(rowContent.get(blankNum+3).toString().trim().substring(0,1)));
                                quesQuery.setDescription(rowContent.get(blankNum+4).toString());
                                questionMapper.insertSelectQues(quesQuery);
                                continue;
                            }

                            quesQuery.setAnswer(rowContent.get(1).toString());
                            //如果知识点不存在就跳过这一行
                            Knowledge knowledge=baseMapper.queryKnowledge(rowContent.get(2).toString());
                            if(knowledge==null){
                                break;
                            }

                            quesQuery.setKnowledge(knowledge);
                            quesQuery.setDifficultyLevel( Integer.valueOf(rowContent.get(3).toString().trim().substring(0,1)) );
                            quesQuery.setDescription(rowContent.get(4).toString());
                            if(p_id==2){
                                quesQuery.setBlankNum(Integer.valueOf(rowContent.get(5).toString().trim().substring(0,1)));
                                questionMapper.insertFillBlankQues(quesQuery);
                            }
                            if(p_id==3){
                                questionMapper.insertJudgeQues(quesQuery);
                            }
                            if(p_id==4){
                                questionMapper.insertBigQues(quesQuery);
                            }
                        }

                    }
                }
            }
        }catch (Exception e){
            System.out.println(e);
            result=false;
        }
        return result;
    }

    public QuestionMapper getQuestionMapper() {
        return questionMapper;
    }

    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

}
