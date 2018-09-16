//服务层
app.service('knowledgeService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../knowledge/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../knowledge/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../knowledge/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../knowledge/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../knowledge/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../knowledge/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../knowledge/search?page='+page+"&rows="+rows, searchEntity);
	}

	this.getKnowledgeOption=function (entity) {
		return $http.post('../knowledge/getKnowledgeOption',entity);
    }


});
