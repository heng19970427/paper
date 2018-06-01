package com.zr.service;

import com.zr.dao.BaseMapper;
import com.zr.dao.PaperMapper;
import com.zr.pojo.Knowledge;
import com.zr.pojo.KnowledgeTemplet;
import com.zr.pojo.PaperTemplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperTempletService {
    @Autowired
    private BaseMapper baseMapper;

    @Autowired
    private PaperMapper paperMapper;
    public List<Knowledge> createTemp1(String c_id){

        return baseMapper.queryKnowledgeList(c_id);
    }

    public void saveTemplet(PaperTemplet paperTemplet) {
        //插入试卷模板
        paperMapper.insertPaperTemplet(paperTemplet);
        //插入相关的知识点模板
        List<KnowledgeTemplet> knowledgeTempletList=paperTemplet.getKnowledgeTemplets();
        Integer p_id=paperTemplet.getPt_id();
        for (KnowledgeTemplet templet: knowledgeTempletList) {
            templet.setPaperTemplet(paperTemplet);
            paperMapper.insertKnowledgeTemplet(templet);
        }
    }

    public List<PaperTemplet> queryAllPaperTemp(String c_id) {
        return paperMapper.queryAllPaperTemp(c_id);
    }

    public BaseMapper getBaseMapper() {
        return baseMapper;
    }

    public void setBaseMapper(BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
    }

    public PaperMapper getPaperMapper() {
        return paperMapper;
    }

    public void setPaperMapper(PaperMapper paperMapper) {
        this.paperMapper = paperMapper;
    }


    public void delTemp(String pt_id) {
        //删除与试卷模板相关的知识点模板
        paperMapper.delKnowTemp(pt_id);
        //删除试卷模板
        paperMapper.delTemp(pt_id);
    }

    public PaperTemplet editTemp(String pt_id) {
        //封装模板
        PaperTemplet paperTemplet=paperMapper.queryPaperTempByPtId(pt_id);
        //封装知识点模板到试卷模板中
        List<KnowledgeTemplet> knowledgeTempletList=paperMapper.queryKnowledgeTemp(pt_id);
        paperTemplet.setKnowledgeTemplets(knowledgeTempletList);
        return paperTemplet;
    }
}
