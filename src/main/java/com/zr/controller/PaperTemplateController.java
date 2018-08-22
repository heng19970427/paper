package com.zr.controller;

import com.zr.pojo.Course;
import com.zr.pojo.Knowledge;
import com.zr.pojo.PaperTemplet;
import com.zr.pojo.Response;
import com.zr.service.BaseService;
import com.zr.service.PaperTempletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
@RequestMapping("paperTemplate")
public class PaperTemplateController {
    @Autowired
    private PaperTempletService templetService;

    @Autowired
    ServletContext servletContext;

    @Autowired
    private BaseService baseService;

    @RequestMapping("showTemp")
    public String showPage(Model model){
        List<Course> courseList=baseService.queryAllCourse();
        model.addAttribute("courseList",courseList);
        return "paperTemplate";
    }

    @RequestMapping("getTemps")
    @ResponseBody
    public Object getTemps(String c_id){
        System.out.println(c_id);
        return templetService.queryAllPaperTemp(c_id);
    }

    @RequestMapping("getKnowledgeList")
    public @ResponseBody
    List<Knowledge> getKnowledgeList(Integer c_id){
        return templetService.createTemp1(c_id);
    }

    @RequestMapping("createTemp")
    public @ResponseBody Object createTemp(PaperTemplet paperTemplet){
        Response response = new Response();
        if (templetService.saveTemplet(paperTemplet)){
            response.setCode(0);
            response.setMsg("保存成功!");
        }else {
            response.setCode(1);
            response.setMsg("保存失败!");
        }
        return response;
    }

    @RequestMapping("delTemp")
    public @ResponseBody Object delTemp(String pt_id){
        Response resp = new Response();
        if (templetService.delTemp(pt_id) == 1){
            resp.setCode(0);
            resp.setMsg("删除成功");
        }else {
            resp.setCode(1);
            resp.setError("删除失败");
        }
        return resp;
    }

    @RequestMapping("updateTemp")
    public @ResponseBody Object updateTemp(PaperTemplet paperTemplet){
        Response resp = new Response();
        if (templetService.updatePaperTemp(paperTemplet)){
            resp.setCode(0);
            resp.setMsg("更新成功");
        }else {
            resp.setCode(1);
            resp.setError("更新失败");
        }
        return resp;
    }

    @RequestMapping("editTemp")
    public @ResponseBody
    PaperTemplet editTemp(String pt_id){
        PaperTemplet paperTemplet=templetService.queryPaperTempByPtId(pt_id);
        return paperTemplet;
    }



    public PaperTempletService getTempletService() {
        return templetService;
    }

    public void setTempletService(PaperTempletService templetService) {
        this.templetService = templetService;
    }
}
