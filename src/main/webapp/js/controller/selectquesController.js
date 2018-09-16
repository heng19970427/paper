 //控制层 
app.controller('selectquesController' ,function($scope,$controller,selectquesService,quescateService,knowledgeService,courseService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		selectquesService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		selectquesService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		selectquesService.findOne(id).success(
			function(response){
				$scope.entity= response;
				$scope.quescate.cId=$scope.entity.selectques.quescate.cId;
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.selectques.sId!=null){						 //如果有ID
			serviceObject=selectquesService.update( $scope.entity ); //修改  
		}else{
			serviceObject=selectquesService.add($scope.entity);//增加
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
		selectquesService.dele( $scope.selectIds ).success(
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
		selectquesService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	//题目类型下拉列表数据
    $scope.quescateListSelect={};
	//课程编号
    $scope.quescate={pId:1,cId:null};
	$scope.getQuescateListSelect=function(){
        quescateService.getQuescateListSelect($scope.quescate).success(
        	function (response) {
                $scope.quescateListSelect={data:response};
            }
		)
    }

    //定义知识下拉列表数据
    $scope.knowListSelect={};
    $scope.knowledge={cId:null};
    $scope.getKnowledgeOption=function () {
        knowledgeService.getKnowledgeOption($scope.knowledge).success(
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

    $scope.addTableRow=function () {
        $scope.entity.optionList.push({});
    }

    $scope.deleTableRow=function(index){
        $scope.entity.optionList.splice(index,1);//删除
    }


});	
