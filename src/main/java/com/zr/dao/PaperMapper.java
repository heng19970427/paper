package com.zr.dao;

import com.zr.pojo.KnowledgeTemplet;
import com.zr.pojo.PaperTemplet;

import java.util.List;

public interface PaperMapper {
    void insertPaperTemplet(PaperTemplet paperTemplet);

    void insertKnowledgeTemplet(KnowledgeTemplet templet);

    List<PaperTemplet> queryAllPaperTemp(String c_id);

    //删除模板
    int delTemp(String pt_id);

    //删除知识点模板
    int delKnowTemp(String pt_id);

    PaperTemplet queryPaperTempByPtId(String pt_id);

    List<KnowledgeTemplet> queryKnowledgeTemp(String pt_id);

    void updatePaperTemplet(PaperTemplet paperTemplet);

    void updateKnowledgeTemplet(KnowledgeTemplet templet);

    //测试函数
    //返回十道选择题的字符串

}
