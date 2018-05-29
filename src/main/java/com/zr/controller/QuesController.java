package com.zr.controller;

import com.zr.pojo.*;
import com.zr.resolver.MyExcelViewResolver;
import com.zr.service.BaseService;
import com.zr.service.QuestionService;
import com.zr.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuesController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private BaseService baseService;
    //.后面的可以不写
    @RequestMapping("/list")
    public String showPage(QueryVo qv,Model model){
        //显示所有查询条件
        List<Course> courseList=baseService.queryAllCourse();
        List<ProbCate> cateList = baseService.queryAllProbCate();

        model.addAttribute("courseList",courseList);
        model.addAttribute("cateList",cateList);
        //展示title,answer,difficultyLevel,description
        Page<Question> page=questionService.queryAllQuestion(qv);
        model.addAttribute("page",page);

        //数据回显
        model.addAttribute("quesName",qv.getQuesName());
        model.addAttribute("category",qv.getCategory());
        model.addAttribute("quesSub",qv.getQuesSub());
        model.addAttribute("probQues",qv.getProbQues());
        return "seeQues";
    }

//    @RequestMapping("getQues")
//    public String getQues(QueryVo qv, Model model){
//        System.out.println(qv);
//        /*
//            if(probCate=="" && quesCate=="")
//            //查询所有题目
//            //修改qv的probCate
//            else{
//                questionService
//            }
//         */
//        return "seeQues";
//    }

    @RequestMapping("getQuesCate")
    public @ResponseBody
    List<List> getQuesCate(QueryVo qv,Model model) {
        List<QuesCate> quesCateList = baseService.queryQuesCate(qv);
        List<Knowledge> knowledgeList=baseService.queryKnowledgeList(qv.getQuesSub());
        List<List> quesAndKnow=new ArrayList<>();
        quesAndKnow.add(quesCateList);
        quesAndKnow.add(knowledgeList);
        return quesAndKnow;
    }

    @RequestMapping("deleteQues")
    public @ResponseBody
    String delQues(String p_id,String id){
        questionService.delQues(p_id,id);
        return "OK";
    }

    @RequestMapping("editQuesInfo")
    public @ResponseBody
    QuesQuery editQuesInfo(String p_id,String id) {
        return questionService.queryOneQues(p_id,id);
    }

    @RequestMapping("updateQuestion")
    public @ResponseBody
    String updateQuestion(QuesQuery quesQuery){
        System.out.println(quesQuery);
        questionService.updateQuestion(quesQuery);
        return "OK";
    }


    @RequestMapping("addQuestion")
    public @ResponseBody
    String addQuestion(QuesQuery quesQuery){
        System.out.println(quesQuery);
        questionService.addQuestion(quesQuery);
        return "OK";
    }

    @RequestMapping("showQuesCate")
    public @ResponseBody
    List<QuesCate> showQuesCate(String c_id){
        return baseService.queryQuesCateByCId(c_id);
    }

    @RequestMapping("tempDownload")
    public ModelAndView tempDownload(String[] addMany_qcName, ModelMap model){
        List<QuesCate> quesCateList=baseService.createExcelTemp(addMany_qcName);
        model.addAttribute("quesCateList",quesCateList);
        return new ModelAndView(new MyExcelViewResolver(),model);
    }

    @RequestMapping("excelUpload")
    public String excelUpload(String quesSub,MultipartFile excel, HttpServletRequest request,Model model) throws Exception {
        if(excel==null){
            return null;
        }
        //获取文件名
        String fileName = excel.getOriginalFilename();
        boolean result=baseService.importExcel(excel,fileName,quesSub);
        if(result)
        return "uploadSuccess";
        else{
            model.addAttribute("msg","文件导入失败");
            return "redirect:/question/list.do";
        }
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
}
