package com.zr.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zr.dao.*;
import com.zr.pojo.*;
import com.zr.pojo_group.PapertempletGroup;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.springframework.stereotype.Service;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class PapertempletService{

	@Autowired
	private PapertempletMapper papertempletMapper;

	@Autowired
	private KnowledgetempletMapper knowledgetempletMapper;

	@Autowired
	private CourseMapper courseMapper;

	@Autowired
	KnowledgeMapper knowledgeMapper;

	@Autowired
	QuescateMapper quescateMapper;
	/**
	 * 查询全部
	 */
	public List<Papertemplet> findAll() {
		return papertempletMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */

	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Papertemplet> page=   (Page<Papertemplet>) papertempletMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */

	public void add(PapertempletGroup papertempletGroup) {
		List<Knowledgetemplet> knowledgetempletList = papertempletGroup.getKnowledgetempletList();
		Papertemplet papertemplet = papertempletGroup.getPapertemplet();
		//通过查询知识点的课程id封装到试卷模板中
		//knowledgetempletList.get(0).getkId();
		papertempletMapper.insert(papertemplet);
		for (Knowledgetemplet knowTemp:knowledgetempletList){
			knowTemp.setPtId(papertemplet.getPtId());
			knowTemp.setkId(knowTemp.getKnowledge().getkId());
			knowledgetempletMapper.insert(knowTemp);
		}

	}

	
	/**
	 * 修改
	 * @param papertempletGroup
	 */
	public void update(PapertempletGroup papertempletGroup){
		Papertemplet papertemplet = papertempletGroup.getPapertemplet();
		List<Knowledgetemplet> knowledgetempletList = papertempletGroup.getKnowledgetempletList();

		//属于该模板的全部删除
		KnowledgetempletExample knowledgetempletExample=new KnowledgetempletExample();
		KnowledgetempletExample.Criteria criteria = knowledgetempletExample.createCriteria();
		criteria.andPtIdEqualTo(papertemplet.getPtId());
		knowledgetempletMapper.deleteByExample(knowledgetempletExample);
		//重新插入
		for(Knowledgetemplet knowledgetemplet:knowledgetempletList){
				knowledgetemplet.setPtId(papertemplet.getPtId());
				knowledgetempletMapper.insert(knowledgetemplet);
		}

		//封装知识点Ids和题型Ids
        List<Map> knowledgeMap = papertempletGroup.getKnowledgeMap();
        List<Map> quesCateMap = papertempletGroup.getQuesCateMap();
        String knowledgeIds="";
        String quesCateIds="";
        for(Map map:knowledgeMap){
            knowledgeIds=knowledgeIds+","+map.get("id");
        }
        knowledgeIds=knowledgeIds.substring(1);
        for(Map map:quesCateMap){
            quesCateIds=quesCateIds+","+map.get("id");
        }
        quesCateIds=quesCateIds.substring(1);
        papertemplet.setKnowledgeIds(knowledgeIds);
        papertemplet.setQuescateIds(quesCateIds);
        papertempletMapper.updateByPrimaryKey(papertemplet);
	}	


	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */

	public PapertempletGroup findOne(Integer id){
		PapertempletGroup papertempletGroup=new PapertempletGroup();
		Papertemplet papertemplet = papertempletMapper.selectByPrimaryKey(id);

		//用于显示的知识点Map
		List<Map> knowledgeMapList=new ArrayList<>();
		List<Map> quescateMapList=new ArrayList<>();

		//条件查询，封装 知识点模板
		KnowledgetempletExample knowledgetempletExample=new KnowledgetempletExample();
		KnowledgetempletExample.Criteria criteria = knowledgetempletExample.createCriteria();
		criteria.andPtIdEqualTo(papertemplet.getPtId());
		List<Knowledgetemplet> knowledgetempletList = knowledgetempletMapper.selectByExample(knowledgetempletExample);
		for(Knowledgetemplet knowledgetemplet:knowledgetempletList){
			Knowledge knowledge = knowledgeMapper.selectByPrimaryKey(knowledgetemplet.getkId());
			//封装显示的知识点Map
            HashMap<String,String> knowHashMap=new HashMap<>();
            knowledgeMapList.add(knowHashMap);
            knowHashMap.put("id",knowledge.getkId().toString());
            knowHashMap.put("text",knowledge.getKnowledgename());
			knowledgetemplet.setKnowledge(knowledge);
		}

		//条件查询，封装 题目类型模板
		String[] quescateIds = papertemplet.getQuescateIds().split(",");
		for(int i=0;i<quescateIds.length;i++){
			Quescate quescate = quescateMapper.selectByPrimaryKey(Integer.valueOf(quescateIds[i]));
			//封装显示的题型Map
			HashMap<String,String> quescateHashMap=new HashMap<>();
			quescateHashMap.put("id",quescate.getqId().toString());
			quescateHashMap.put("text",quescate.getQcname());
			quescateMapList.add(quescateHashMap);
		}

		papertempletGroup.setQuesCateMap(quescateMapList);
		papertempletGroup.setKnowledgeMap(knowledgeMapList);
		papertempletGroup.setPapertemplet(papertemplet);
		papertempletGroup.setKnowledgetempletList(knowledgetempletList);
		return papertempletGroup;
	}

	/**
	 * 批量删除
	 */

	public void delete(Integer[] ids) {
		for(Integer id:ids){
			papertempletMapper.deleteByPrimaryKey(id);
		}
	}
	
	

	public PageResult findPage(Papertemplet papertemplet, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		PapertempletExample example=new PapertempletExample();
		PapertempletExample.Criteria criteria = example.createCriteria();
		if(papertemplet!=null){			
						if(papertemplet.getTempletname()!=null && papertemplet.getTempletname().length()>0){
				criteria.andTempletnameLike("%"+papertemplet.getTempletname()+"%");
			}
		}

		List<Papertemplet> papertempletList = papertempletMapper.selectByExample(example);
		for(Papertemplet papertemplet1:papertempletList){
			Course course = courseMapper.selectCourseById(papertemplet1.getcId());
			papertemplet1.setCourse(course);
		}
		Page<Papertemplet> page= (Page<Papertemplet>)papertempletList;
		return new PageResult(page.getTotal(), page.getResult());
	}

	public PapertempletGroup updatePaperTempSelect(PapertempletGroup papertempletGroup){
		Papertemplet papertemplet=papertempletGroup.getPapertemplet();
		String[] knowledgeIds = papertempletGroup.getPapertemplet().getKnowledgeIds().split(",");
		if(papertemplet.getPtId()==null){
			//添加
			List<Knowledgetemplet> knowledgetempletList=new ArrayList<Knowledgetemplet>();
			for(int i=0;i<knowledgeIds.length;i++){
				Knowledgetemplet knowledgetemplet=new Knowledgetemplet();
				Knowledge knowledge = knowledgeMapper.selectByPrimaryKey(Integer.valueOf(knowledgeIds[i]));
				knowledgetemplet.setKnowledge(knowledge);
				knowledgetempletList.add(knowledgetemplet);
			}
			papertempletGroup.setKnowledgetempletList(knowledgetempletList);
		}else {
			//修改
			List<Knowledgetemplet> knowledgetempletList = papertempletGroup.getKnowledgetempletList();
			//新的knowledgetempletList
			List<Knowledgetemplet> newKnowledgetempletList=new ArrayList<Knowledgetemplet>();
			//判断kId是否已存在集合中
			for(int i=0;i<knowledgeIds.length;i++){
				boolean flag=false;
				for(Knowledgetemplet knowledgetemplet:knowledgetempletList){
					if(knowledgetemplet.getkId()==Integer.valueOf(knowledgeIds[i])){
						//集合中存在
						newKnowledgetempletList.add(knowledgetemplet);
						flag=true;
						break;
					}
				}
				if(!flag){
					//不存在
					Knowledgetemplet knowledgetemplet=new Knowledgetemplet();
					Knowledge knowledge = knowledgeMapper.selectByPrimaryKey(Integer.valueOf(knowledgeIds[i]));
					knowledgetemplet.setKnowledge(knowledge);
					newKnowledgetempletList.add(knowledgetemplet);
				}


			}
			papertempletGroup.setKnowledgetempletList(newKnowledgetempletList);
		}

		return papertempletGroup;
	}
}
