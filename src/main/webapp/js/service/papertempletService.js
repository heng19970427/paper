//服务层
app.service('papertempletService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../papertemplet/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../papertemplet/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../papertemplet/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../papertemplet/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../papertemplet/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../papertemplet/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../papertemplet/search?page='+page+"&rows="+rows, searchEntity);
	}

	this.updatePaperTempSelect=function (papertempletGroup) {
		return $http.post('../papertemplet/updatePaperTempSelect', papertempletGroup);
    }
});
