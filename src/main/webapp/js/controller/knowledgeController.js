 //控制层 
app.controller('knowledgeController' ,function($scope,$controller ,knowledgeService,courseService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		knowledgeService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		knowledgeService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	//查询实体 
	$scope.findOne=function(id){				
		knowledgeService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}


	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.k_id!=null){//如果有ID
            alert($scope.entity.k_id)
			serviceObject=knowledgeService.update( $scope.entity ); //修改  
		}else{
			serviceObject=knowledgeService.add( $scope.entity  );//增加 
		}
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		knowledgeService.dele( $scope.selectIds ).success(
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
		knowledgeService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    //定义下拉列表数据
    $scope.courseListSelect={data:[{id:1,text:'联想'},{id:2,text:'华为'},{id:3,text:'小米'}]};
    $scope.getCourseOptionList=function () {
        courseService.getCourseOptionList().success(
            function (response) {
                $scope.courseListSelect={data:response};
            }
        )
    }
});	
