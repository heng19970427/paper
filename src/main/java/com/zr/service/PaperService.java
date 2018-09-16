package com.zr.service;
import java.io.IOException;
import java.util.*;

import com.zr.dao.*;
import com.zr.pojo.*;
import com.zr.utils.JsonUtil;
import com.zr.utils.StringUtil;
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
public class PaperService {

    @Autowired
    private PapertempletMapper papertempletMapper;

	@Autowired
	private PaperMapper paperMapper;

	@Autowired
    private KnowledgetempletMapper knowledgetempletMapper;

	@Autowired
    private KnowledgeMapper knowledgeMapper;

	@Autowired
    private QuescateMapper quescateMapper;

	@Autowired
    private SelectquesMapper selectquesMapper;

	@Autowired
    private FillblankquesMapper fillblankquesMapper;

	@Autowired
    private JudgequesMapper judgequesMapper;

	@Autowired
    private BigquesMapper bigquesMapper;
	/**
	 * 查询全部
	 */

	public List<Paper> findAll() {
		return paperMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */

	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Paper> page=   (Page<Paper>) paperMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */

	public void add(Paper paper) {
		paperMapper.insert(paper);		
	}

	
	/**
	 * 修改
	 */

	public void update(Paper paper){
		paperMapper.updateByPrimaryKey(paper);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id 试卷id
	 * @return Paper
	 */

	public Paper findOne(Integer id){
		return paperMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */

	public void delete(Integer[] ids) {
		for(Integer id:ids){
			paperMapper.deleteByPrimaryKey(id);
		}		
	}
	

	public PageResult findPage(Paper paper, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		PaperExample example=new PaperExample();
		PaperExample.Criteria criteria = example.createCriteria();
		//按时间排序
		example.setOrderByClause("createtime DESC");
		if(paper!=null){			
						if(paper.getPath()!=null && paper.getPath().length()>0){
				criteria.andPathLike("%"+paper.getPath()+"%");
			}
			if(paper.getPapername()!=null && paper.getPapername().length()>0){
				criteria.andPapernameLike("%"+paper.getPapername()+"%");
			}
		}
		
		Page<Paper> page= (Page<Paper>)paperMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

    public Map<String,String> createPaper(Integer id,String paperName) {
	    //根据模板id查询所属模板及其所有知识点列表
        Papertemplet papertemplet = papertempletMapper.selectByPrimaryKey(id);
        KnowledgetempletExample knowledgetempletExample=new KnowledgetempletExample();
        KnowledgetempletExample.Criteria criteria = knowledgetempletExample.createCriteria();
        criteria.andPtIdEqualTo(id);

		//保存了试卷信息的map
		Map<String,String> map=new HashMap<>();
		map.put("paperName",paperName);

		//试卷难度系数
		Integer difficultyLevel = papertemplet.getDifficultylevel();
		//明天写
		Integer selectQuesNum = papertemplet.getSelectquesnum();
		Integer fillBlankQuesNum = papertemplet.getFillblankquesnum();
		Integer judgeQuesNum = papertemplet.getJudgequesnum();
		Integer bigQuesNum = papertemplet.getBigquesnum();

		//1.根据试卷模板生成试卷，封装map,PaperAllQues
		map.put("fillBlankQuesScore",papertemplet.getFillblankquesscore().toString());
		Integer fillBlankQuesTotalScore=papertemplet.getFillblankquesscore()*fillBlankQuesNum;
		map.put("fillBlankQuesTotalScore",fillBlankQuesTotalScore.toString());

		map.put("selectQuesScore",papertemplet.getSelectquesscore().toString());
		Integer selectQuesTotalScore=papertemplet.getSelectquesscore()*selectQuesNum;
		map.put("selectQuesTotalScore",selectQuesTotalScore.toString());

		map.put("judgeQuesScore",papertemplet.getJudgequesscore().toString());
		Integer judgeQuesTotalScore=papertemplet.getJudgequesscore()*judgeQuesNum;
		map.put("judgeQuesTotalScore",judgeQuesTotalScore.toString());

		map.put("bigQuesScore",papertemplet.getBigquesscore().toString());
		Integer bigQuesTotalScore=papertemplet.getBigquesscore()*bigQuesNum;
		map.put("bigQuesTotalScore",bigQuesTotalScore.toString());

        //试卷所有知识点占比
        List<Knowledgetemplet> knowledgetempletList = knowledgetempletMapper.selectByExample(knowledgetempletExample);
        //试卷所有知识点
        List<Knowledge> knowledgeList=new ArrayList<>();
        //知识点Id集合
		List<Integer> knowledgeIdList=new ArrayList<>();
		//题型Id集合
		List<Integer> quescateIdList=new ArrayList<>();
        //试卷所有的题型
        List<Quescate> quescateList=new ArrayList<>();
        //所有的选择题
        List<Selectques> selectquesList;
        //所有的填空题
        List<Fillblankques> fillblankquesList;
        //所有的判断题
        List<Judgeques> judgequesList;
        //所有的综合题
        List<Bigques> bigquesList;

        //随机种子
		Random random=new Random();

        //数据封装
        String[] knowledgeIds = papertemplet.getKnowledgeIds().split(",");
		StringUtil.StringToInteger(knowledgeIds,knowledgeIdList);

        String[] quescateIds = papertemplet.getQuescateIds().split(",");
        StringUtil.StringToInteger(quescateIds,quescateIdList);

        for(int i=0;i<knowledgeIds.length;i++){
            Knowledge knowledge = knowledgeMapper.selectByPrimaryKey(Integer.valueOf(knowledgeIds[i]));
            knowledgeList.add(knowledge);
        }
        for(int i=0;i<quescateIds.length;i++){
            Quescate quescate = quescateMapper.selectByPrimaryKey(Integer.valueOf(quescateIds[i]));
            quescateList.add(quescate);
        }

        //筛选符合 知识点和题型 的题目
        SelectquesExample selectquesExample=new SelectquesExample();
		SelectquesExample.Criteria selectCriteria = selectquesExample.createCriteria();
		selectCriteria.andKIdIn(knowledgeIdList);
		selectCriteria.andQcIdIn(quescateIdList);

		FillblankquesExample fillblankquesExample=new FillblankquesExample();
		FillblankquesExample.Criteria fillblankCriteria = fillblankquesExample.createCriteria();
		fillblankCriteria.andKIdIn(knowledgeIdList);
		fillblankCriteria.andQcIdIn(quescateIdList);

		JudgequesExample judgequesExample=new JudgequesExample();
		JudgequesExample.Criteria judgeCriteria = judgequesExample.createCriteria();
		judgeCriteria.andKIdIn(knowledgeIdList);
		judgeCriteria.andQcIdIn(quescateIdList);

		BigquesExample bigquesExample=new BigquesExample();
		BigquesExample.Criteria bigCriteria = bigquesExample.createCriteria();
		bigCriteria.andKIdIn(knowledgeIdList);
		bigCriteria.andQcIdIn(quescateIdList);
		selectquesList=selectquesMapper.selectByExample(selectquesExample);
        fillblankquesList=fillblankquesMapper.selectByExample(fillblankquesExample);
        judgequesList=judgequesMapper.selectByExample(judgequesExample);
        bigquesList=bigquesMapper.selectByExample(bigquesExample);
        //筛选:先选择知识点，后选择题型,剩余的题目判断难度系数
        //遍历四大题型，生成试卷题目

		int quesLibNum;
		StringBuffer sb;
		StringBuffer answersb;
		int lowSelectedNum;
		double difficultyLevelCon;
		boolean flag;
		String targetQues;
		String targetQuesAnswer;
		//随机题号
        int num;
        //循环次数控制
        int repeteCon=0;


		//生成填空题
		//查询所有填空题的List
		sb=new StringBuffer();
		answersb=new StringBuffer();
		quesLibNum=fillblankquesList.size();
		//最低被选中次数
		lowSelectedNum=fillblankquesList.get(0).getSelectednum();
		//难度系数控制
		difficultyLevelCon=0;

		//随机生成一道填空题作为开始
        num=random.nextInt(quesLibNum);
        //随机题号
        Fillblankques fillBlankQues = fillblankquesList.get(num);
		for(int i = 1; i<= fillBlankQuesNum; i++){
			if(repeteCon++>500){
				throw new RuntimeException("查找试题失败，题目数量不足");
			}
			//选择次数
			int selectedNum = fillBlankQues.getSelectednum();
			//当前平均难度系数
			difficultyLevelCon=(difficultyLevelCon*(i-1)+fillBlankQues.getDifficultylevel())/i;
			//生成过程难度系数状态
			flag=(difficultyLevelCon-difficultyLevel)>=0;
			if(flag){
				//选一题低于difficultyLevel的
				//重复、试题被多次出题、难度系数过大重新选择，
				num=random.nextInt(quesLibNum);
				//随机题号
				fillBlankQues = fillblankquesList.get(num);
				if((selectedNum-lowSelectedNum<=3) && (fillBlankQues.getDifficultylevel()<=difficultyLevel)){
					quesLibNum--;
					fillblankquesList.remove(num);
					sb.append(i+"."+fillBlankQues.getTitle()+"<w:br/>");
					answersb.append(i+"."+fillBlankQues.getAnswer()+"  ");
				}else {
					i--;
				}
			}
			else{
				//选一题高于difficultyLevel的，不高于就重来
				num=random.nextInt(quesLibNum);
				//随机题号
				fillBlankQues = fillblankquesList.get(num);
				if((selectedNum-lowSelectedNum<=3) && fillBlankQues.getDifficultylevel()>=difficultyLevel){
					quesLibNum--;
					//删除被生成的试题
					fillblankquesList.remove(num);
					sb.append(i+"."+fillBlankQues.getTitle()+"<w:br/>");
					answersb.append(i+"."+fillBlankQues.getAnswer()+"  ");
				}else {
					i--;
				}

			}
		}
		targetQues=sb.toString();
		targetQuesAnswer=answersb.toString();
		targetQuesAnswer=targetQuesAnswer.replace("&", "&#38;");
		targetQues=targetQues.replace("&", "&#38;");
		map.put("fillBlankQuesMap",targetQues);
		//填空题答案
		map.put("fillBlankAnswer",targetQuesAnswer);
		System.out.println(difficultyLevelCon);


		//生成选择题
		//查询所有选择题的List
		sb=new StringBuffer();
		answersb=new StringBuffer();
		//题库中选择题总数
		quesLibNum=selectquesList.size();
		//最低被选中次数
		lowSelectedNum=selectquesList.get(0).getSelectednum();

		//难度系数控制
		difficultyLevelCon=0;
        //随机题号
        num=random.nextInt(quesLibNum);
        Selectques selectQues = selectquesList.get(num);
		for(int i = 1; i <= selectQuesNum; i++){
			if(repeteCon++>500){
				throw new RuntimeException("查找试题失败，题目数量不足");
			}
			//选择次数
			int selectedNum = selectQues.getSelectednum();
			//当前平均难度系数
			difficultyLevelCon=(difficultyLevelCon*(i-1)+selectQues.getDifficultylevel())/i;
			//生成过程难度系数状态
			flag=(difficultyLevelCon-difficultyLevel)>=0;
			if(flag){
				//选一题低于difficultyLevel的
				num=random.nextInt(quesLibNum);
				selectQues = selectquesList.get(num);
				//重复、试题被多次出题、难度系数过大重新选择，
				if((selectedNum-lowSelectedNum<=3 ) && (selectQues.getDifficultylevel()<=difficultyLevel )){
					i--;
				}
				else{
					try {
					List<Option> options= JsonUtil.toListObject(selectQues.getOption(), List.class,Option.class);
					char opLetter='A';
					sb.append(i+"."+selectQues.getTitle()+"<w:br/>");
					answersb.append(i+"."+selectQues.getAnswer()+"  ");
					//生成选项

					for (Option option:options) {
						sb.append(opLetter+"."+option.getOptionName()+"<w:br/>");
						opLetter++;
					} } catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			else{
				//选一题高于difficultyLevel的，不高于就重来
				num=random.nextInt(quesLibNum);
				selectQues = selectquesList.get(num);
				if(selectQues.getDifficultylevel()>=difficultyLevel){
					i--;
					continue;
				}
				try {
					List<Option> options= JsonUtil.toListObject(selectQues.getOption(), ArrayList.class,Option.class);
					char opLetter='A';
					sb.append(i+"."+selectQues.getTitle()+"<w:br/>");
					answersb.append(i+"."+selectQues.getAnswer()+"  ");
					//生成选项

					for (Option option:options) {
						sb.append(opLetter+"."+option.getOptionName()+"<w:br/>");
						opLetter++;
					} } catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//将选择题放入map
		targetQues=sb.toString();
		//处理特殊字符
		targetQues=targetQues.replace("&", "&#38;");
		targetQuesAnswer=answersb.toString();
		targetQuesAnswer=targetQuesAnswer.replace("&", "&#38;");
		//选择题答案
		map.put("selectAnswer",targetQuesAnswer);
		System.out.println(difficultyLevelCon);
		map.put("selectQuesMap",targetQues);

		//生成判断题
		//查询所有判断题的List
		sb=new StringBuffer();
		answersb=new StringBuffer();
		quesLibNum=judgequesList.size();
		//最低被选中次数
		lowSelectedNum=judgequesList.get(0).getSelectednum();
		//难度系数控制
		difficultyLevelCon=0;
		num=random.nextInt(quesLibNum);
        Judgeques judgeQues = judgequesList.get(num);
		for(int i = 1; i <= judgeQuesNum; i++){
			if(repeteCon++>500){
				throw new RuntimeException("查找试题失败，题目数量不足");
			}
			int selectedNum = judgeQues.getSelectednum();
			//当前平均难度系数
			//difficultyLevelCon=(difficultyLevelCon*(i-1)+fillBlankQues.getDifficultyLevel())/i;
			//生成过程难度系数状态
			flag=(difficultyLevelCon-difficultyLevel)>=0;
			if(flag){
				//选一题低于difficultyLevel的
				//重复、试题被多次出题、难度系数过大重新选择，
				num=random.nextInt(quesLibNum);
				judgeQues = judgequesList.get(num);
				if((selectedNum-lowSelectedNum<=3) && (judgeQues.getDifficultylevel()<=difficultyLevel)){
					sb.append(i+"."+judgeQues.getTitle()+"<w:br/>");
					answersb.append(i+"."+judgeQues.getAnswer()+"   ");
				}else {
					i--;
				}
			}
			else{
				//选一题高于difficultyLevel的，不高于就重来
				num=random.nextInt(quesLibNum);
				judgeQues = judgequesList.get(num);
				if(judgeQues.getDifficultylevel()>=difficultyLevel){
					sb.append(i+"."+judgeQues.getTitle()+" (  )<w:br/>");
					answersb.append(i+"."+judgeQues.getAnswer()+"  ");
				}else {
					i--;
				}
			}
		}
		targetQues=sb.toString();
		targetQues=targetQues.replace("&", "&#38;");
		targetQuesAnswer=answersb.toString();
		targetQuesAnswer=targetQuesAnswer.replace("&", "&#38;");
		map.put("judgeQuesMap",targetQues);
		//判断题答案
		map.put("judgeAnswer",targetQuesAnswer);

		//生成编程题
		//查询所有编程题的List
		sb=new StringBuffer();
		answersb=new StringBuffer();
		quesLibNum=bigquesList.size();
		//最低被选中次数
		lowSelectedNum=bigquesList.get(0).getSelectednum();
		//难度系数控制
		difficultyLevelCon=0;

        //随机题号
        num=random.nextInt(quesLibNum);
        Bigques bigQues = bigquesList.get(num);
		for(int i = 1; i <= bigQuesNum; i++){
			if(repeteCon++>500){
				throw new RuntimeException("查找试题失败，题目数量不足");
			}
			//选择次数
			int selectedNum = bigQues.getSelectednum();
			//当前平均难度系数
			difficultyLevelCon=(difficultyLevelCon*(i-1)+bigQues.getDifficultylevel())/i;
			//生成过程难度系数状态
			flag=(difficultyLevelCon-difficultyLevel)>=0;
			if(flag){
				num=random.nextInt(quesLibNum);
				bigQues = bigquesList.get(num);
				if((selectedNum-lowSelectedNum<=3) && (bigQues.getDifficultylevel()<=difficultyLevel)){
					//封装当前试题的小题
					try {
						List<Option> options= JsonUtil.toListObject(bigQues.getOption(), List.class,Option.class);

						sb.append(i+"."+bigQues.getTitle()+"<w:br/>");
						for(int j=1;j<=options.size();j++){
							sb.append("("+i+")"+"."+options.get(j-1)+"<w:br/>");
						}
						answersb.append(i+"."+bigQues.getAnswer()+"  ");
					} catch (IOException e) {
						e.printStackTrace();
					}

				}else {
					i--;
				}
			}
			else{
				//选一题高于difficultyLevel的，不高于就重来
				num=random.nextInt(quesLibNum);
				bigQues = bigquesList.get(num);
				if(bigQues.getDifficultylevel()>=difficultyLevel){
					sb.append(i+"."+bigQues.getTitle()+"<w:br/>");
					answersb.append(i+"."+bigQues.getAnswer()+"  ");
				}else {
					i--;
				}
			}
		}
		targetQues=sb.toString();
		targetQues=targetQues.replace("&", "&#38;");
		targetQues=targetQues.replace("<", "&lt;");
		targetQues=targetQues.replace(">", "&gt;");
		targetQuesAnswer=answersb.toString();
		targetQuesAnswer=targetQuesAnswer.replace("<","&lt;");
		targetQuesAnswer=targetQuesAnswer.replace(">","&gt;");
		targetQuesAnswer=targetQuesAnswer.replace("&", "&#38;");
		//大题答案
		map.put("bigQuesAnswer",targetQuesAnswer);
		map.put("bigQuesMap",targetQues);
		//2.将试卷保存到数据库
		//3.返回试卷内容的Map集合用于生成pdf文件
		//测试用例
		return map;
	}
}