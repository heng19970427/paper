//服务层
app.service('paperService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../paper/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../paper/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http({
			method:'get',
			url:"../paper/findOne?id="+id,
            responseType: "arraybuffer"
		});
	}
	//增加 
	this.add=function(entity){
		return  $http({
            method:'post',
            url:"../paper/createPaper",
			data:entity,
            responseType: "arraybuffer"
        });
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../paper/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../paper/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../paper/search?page='+page+"&rows="+rows, searchEntity);
	}    	
});
