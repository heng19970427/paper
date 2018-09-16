//服务层
app.service('quescateService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../quescate/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../quescate/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../quescate/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../quescate/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../quescate/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../quescate/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../quescate/search?page='+page+"&rows="+rows, searchEntity);
	}

    this.getQuescateListSelect=function (quescate) {
        return $http.post('../quescate/getQuescateListSelect',quescate);
    }
});
