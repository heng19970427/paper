package com.zr.service;

import com.zr.dao.BaseMapper;
import com.zr.dao.PaperMapper;
import com.zr.pojo.Knowledge;
import com.zr.pojo.KnowledgeTemplet;
import com.zr.pojo.PaperTemplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.interfaces.ECKey;
import java.util.List;

@Service
public class PaperTempletService {
    @Autowired
    private BaseMapper baseMapper;

    @Autowired
    private PaperMapper paperMapper;
    //查询某科目所有知识点
    public List<Knowledge> createTemp1(String c_id){
        return baseMapper.queryKnowledgeList(c_id);
    }

    //保存试卷模板
    public boolean saveTemplet(PaperTemplet paperTemplet) {
        boolean result = true;
        //插入试卷模板
        if (paperMapper.insertPaperTemplet(paperTemplet)<=0) result=false;
        //插入相关的知识点模板
        List<KnowledgeTemplet> knowledgeTempletList=paperTemplet.getKnowledgeTemplets();
        for (KnowledgeTemplet templet: knowledgeTempletList) {
            templet.setPaperTemplet(paperTemplet);
            if (paperMapper.insertKnowledgeTemplet(templet)<=0) result=false;
        }
        return result;
    }

    //查询某科目所有试卷模板
    public List<PaperTemplet> queryAllPaperTemp(String c_id) {
        return paperMapper.queryAllPaperTemp(c_id);
    }

    @Transactional
    public int delTemp(String pt_id) {
        //删除与试卷模板相关的知识点模板            //删除试卷模板
        if (paperMapper.delKnowTemp(pt_id)!=0 && paperMapper.delTemp(pt_id)!=0)
            return 1;
        else
            return 0;
    }

    @Transactional
    public PaperTemplet queryPaperTempByPtId(String pt_id) {
        //封装模板
        PaperTemplet paperTemplet=paperMapper.queryPaperTempByPtId(pt_id);
        //封装知识点模板到试卷模板中
        List<KnowledgeTemplet> knowledgeTempletList=paperMapper.queryKnowledgeTemp(pt_id);
        paperTemplet.setKnowledgeTemplets(knowledgeTempletList);
        return paperTemplet;
    }

    @Transactional
    public boolean updatePaperTemp(PaperTemplet paperTemplet) {
        boolean result = true;
        //更新试卷模板
        if (paperMapper.updatePaperTemplet(paperTemplet) != 1) result=false;
        //更新相关的知识点模板
        List<KnowledgeTemplet> knowledgeTempletList=paperTemplet.getKnowledgeTemplets();
        for (KnowledgeTemplet templet: knowledgeTempletList) {
            templet.setPaperTemplet(paperTemplet);
            if (paperMapper.updateKnowledgeTemplet(templet) != 1) result=false;
        }
        return result;
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


}
