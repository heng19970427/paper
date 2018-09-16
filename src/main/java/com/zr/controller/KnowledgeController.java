package com.zr.controller;

import com.zr.pojo.*;
import com.zr.pojo_group.PapertempletGroup;
import com.zr.service.CourseService;
import com.zr.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("knowledge")
public class KnowledgeController {
    @Autowired
    private KnowledgeService knowledgeService;


    @Autowired
    private CourseService courseService;

    @RequestMapping("knowledgeInfo")
    public String knowledgeInfo(Model model,Integer c_id) {
        List<Knowledge> knowledgeList = knowledgeService.queryKnowledgeList(c_id);
        List<Course> courseList = courseService.queryAllCourse();

        model.addAttribute("knowledgeList",knowledgeList);
        model.addAttribute("courseList",courseList);
        return "knowledgeInfo";
    }



    @RequestMapping("getAllKnowledge")
    @ResponseBody
    public List<Knowledge> getAllKnowledge(){
        return knowledgeService.getAllKnowledge();
    }

    @RequestMapping("delete")
    @ResponseBody
    public Response deleteKnowledge(int[] ids){
        try {
            knowledgeService.deleteKnowledge(ids);
            return new Response(true ,"成功添加");
        }catch (Exception e){
            return new Response(false,"添加失败");
        }
    }

    @RequestMapping("add")
    @ResponseBody
    public Response addKnowledge(@RequestBody Knowledge knowledge){
        try {
            knowledgeService.addKnowledge(knowledge);
            return new Response(true ,"成功添加");
        }catch (Exception e){
            return new Response(false,"添加失败");
        }

    }

    /**
     * 查询+分页
     * @param knowledge
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/search")
    @ResponseBody
    public PageResult search(@RequestBody(required = false) Knowledge knowledge, int page, int rows  ){
        return knowledgeService.findPage(knowledge, page, rows);
    }

    @RequestMapping(value = "/findOne")
    @ResponseBody
    public Knowledge findOne(int id){
        return knowledgeService.findOne(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public Response update(@RequestBody Knowledge knowledge){
        try {
            knowledgeService.updateKnowledge(knowledge);
            return new Response(true ,"更新成功");
        }catch (Exception e){
            return new Response(false,"更新失败");
        }

    }

    @RequestMapping("getKnowledgeOption")
    @ResponseBody
    public List<Map> getKnowledgeOption(@RequestBody Knowledge knowledge){
        List<Map> knowledgeOption = knowledgeService.getKnowledgeOption(knowledge);
        return knowledgeOption;
    }
}
