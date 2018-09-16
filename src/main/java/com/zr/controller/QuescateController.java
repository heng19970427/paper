package com.zr.controller;

import com.zr.pojo.PageResult;
import com.zr.pojo.Quescate;
import com.zr.pojo.Response;
import com.zr.service.QuescateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("quescate")
@RestController
public class QuescateController {

    @Autowired
    private QuescateServiceImpl quescateService;

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<Quescate> findAll(){
        return quescateService.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int page, int rows){
        return quescateService.findPage(page, rows);
    }



    /**
     * 增加
     * @param quescate
     * @return
     */
    @RequestMapping("/add")
    public Response add(@RequestBody Quescate quescate){
        try {
            quescateService.add(quescate);
            return new Response(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param quescate
     * @return
     */
    @RequestMapping("/update")
    public Response update(@RequestBody Quescate quescate){
        try {
            quescateService.update(quescate);
            return new Response(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, "修改失败");
        }
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public Quescate findOne(int id){
        return quescateService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Response delete(int [] ids){
        try {
            quescateService.delete(ids);
            return new Response(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param quescate
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody Quescate quescate, int page, int rows  ){
        return quescateService.findPage(quescate, page, rows);
    }

    @RequestMapping("getQuescateListSelect")
    @ResponseBody
    public List<Map> getQuescateListSelect(@RequestBody Quescate quescate){
        List<Map> quescateListSelect = quescateService.getQuescateListSelect(quescate);
        return quescateListSelect;
    }

}
