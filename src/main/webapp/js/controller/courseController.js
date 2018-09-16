 //控制层 
app.controller('courseController' ,function($scope,$controller,courseService,quescateService,knowledgeService,knowledgetempletService,papertempletService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		courseService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		courseService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		courseService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.c_id!=null){//如果有ID
			serviceObject=courseService.update($scope.entity); //修改
		}else{
			serviceObject=courseService.add($scope.entity);//增加
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert("保存失败");
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		courseService.dele( $scope.selectIds ).success(
			function(response){
				if(response=="OK"){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){
		courseService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	//被选择的知识点数组
    $scope.selectedknowListSelect=[];

    $scope.updatePaperTempSelect=function () {
        //$scope.knowListSelect
        //$scope.selectedknowListSelect=$scope.entity.kId.split(",");
		papertempletService.updatePaperTempSelect($scope.papertempletGroup).success(
			function (response) {
				$scope.papertempletGroup=response;
            }
		)
    }

    //题目类型下拉列表数据
    $scope.quescateListSelect={};
    //课程编号
    $scope.quescate={pId:null,cId:null};
    $scope.getQuescateListSelect=function(cId){
        $scope.quescate.cId=cId;
        quescateService.getQuescateListSelect($scope.quescate).success(
            function (response) {
                $scope.quescateListSelect={data:response};
            }
        )
    }

    //定义知识下拉列表数据
    $scope.knowListSelect={};
    $scope.knowledge={cId:null};
    $scope.getKnowledgeOption=function(cId){
        $scope.knowledge.cId=cId;
        knowledgeService.getKnowledgeOption($scope.knowledge).success(
            function (response) {
                $scope.knowListSelect={data:response};
            }
        )
    }

    //添加知识模板
	$scope.addKnowledgeTemp=function () {
		knowledgetempletService.adds($scope.knowTempList).success(
			function (reponse) {
				if(reponse.success){
                    $scope.reloadList();
				}else {
					alert(reponse.msg);
				}
            }
		)
    }

    $scope.papertempletGroup={knowledgetempletList:[]};
    //添加试卷模板
    $scope.addpaperTemp=function () {
		papertempletService.add($scope.papertempletGroup).success(
			function (response) {
				if(response.success){
					alert("创建成功");
				}else {
					alert(response.msg);
				}
            }
		)
    }

});	
