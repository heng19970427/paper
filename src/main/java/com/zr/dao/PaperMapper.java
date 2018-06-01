package com.zr.dao;

import com.zr.pojo.KnowledgeTemplet;
import com.zr.pojo.PaperTemplet;

import java.util.List;

public interface PaperMapper {
     void insertPaperTemplet(PaperTemplet paperTemplet);

    void insertKnowledgeTemplet(KnowledgeTemplet templet);

    List<PaperTemplet> queryAllPaperTemp(String c_id);

    //删除模板
    void delTemp(String pt_id);

    //删除知识点模板
    void delKnowTemp(String pt_id);

    PaperTemplet queryPaperTempByPtId(String pt_id);

    List<KnowledgeTemplet> queryKnowledgeTemp(String pt_id);
}
