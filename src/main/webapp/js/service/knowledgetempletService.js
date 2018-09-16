//服务层
app.service('knowledgetempletService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../knowledgetemplet/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../knowledgetemplet/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../knowledgetemplet/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../knowledgetemplet/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../knowledgetemplet/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../knowledgetemplet/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../knowledgetemplet/search.do?page='+page+"&rows="+rows, searchEntity);
	}

    //批量增加
    this.adds=function(entity){
        return  $http.post('../knowledgetemplet/adds',entity );
    }

    this.updateKnow=function (kIds) {
        return $http.get('../knowledgetemplet/updateKnow?kIds='+kIds);
    }
});
