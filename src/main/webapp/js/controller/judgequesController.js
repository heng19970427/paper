 //控制层 
app.controller('judgequesController' ,function($scope,$controller,judgequesService,quescateService,knowledgeService,courseService){
    //继承
	$controller('baseController',{$scope:$scope});
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		judgequesService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){
		judgequesService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		judgequesService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.jId!=null){//如果有ID
			serviceObject=judgequesService.update($scope.entity); //修改
		}else{
			serviceObject=judgequesService.add($scope.entity);//增加
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询
		        	$scope.reloadList();//重新加载
				}else{
					alert("试题添加失败,"+response.msg);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		judgequesService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		judgequesService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    //题目类型下拉列表数据
    $scope.quescateListSelect={};
    //课程编号
    $scope.quescate={pId:3,cId:null};
    $scope.getQuescateListSelect=function(){
        quescateService.getQuescateListSelect($scope.quescate).success(
            function (response) {
                $scope.quescateListSelect={data:response};
            }
        )
    }

    //定义知识下拉列表数据
    $scope.knowListSelect={};
    //没用的变量，防止400
    $scope.knowledgeNull={};
    $scope.getKnowledgeOption=function () {
        knowledgeService.getKnowledgeOption($scope.knowledgeNull).success(
            function (response) {
                $scope.knowListSelect={data:response};
            }
        )
    }

    //定义课程下拉列表数据
    $scope.courseListSelect={data:[{id:1,text:'联想'},{id:2,text:'华为'},{id:3,text:'小米'}]};
    $scope.getCourseOptionList=function () {
        courseService.getCourseOptionList().success(
            function (response) {
                $scope.courseListSelect={data:response};
            }
        )
    }

});	
