//服务层
app.service('courseService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../course/findAll');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../course/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../course/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../course/addCourse',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../course/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../course/deleteCourse?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.get('../course/search?page='+page+"&rows="+rows, searchEntity);
	}

	//获取课程选项
	this.getCourseOptionList=function () {
        return $http.get('../course/getCourseOptionList');
    }

});
