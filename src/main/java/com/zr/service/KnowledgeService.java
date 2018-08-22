package com.zr.service;

import com.zr.dao.KnowledgeMapper;
import com.zr.pojo.Knowledge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeService {
    @Autowired
    private KnowledgeMapper knowledgeMapper;

    public List<Knowledge> getAllKnowledge(){
        return knowledgeMapper.queryAllKnowledge();
    }

    public void addKnowledge(Knowledge knowledge){
        knowledgeMapper.insertKnowledge(knowledge);
    }

    public void deleteKnowledge(int k_id){
        knowledgeMapper.deleteKnowledge(k_id);
    }

    public void updateKnowledge(Knowledge knowledge){
        knowledgeMapper.updateKnowledge(knowledge);
    }

    public List<Knowledge> queryKnowledgeList(Integer c_id){
        return knowledgeMapper.queryKnowledgeList(c_id);
    }
}
