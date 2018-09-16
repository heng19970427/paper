 //控制层 
app.controller('papertempletController' ,function($scope,$controller   ,quescateService,knowledgeService,papertempletService,courseService,paperService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		papertempletService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		papertempletService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){
		papertempletService.findOne(id).success(
			function(response){
				$scope.papertempletGroup= response;

			}
		);				
	}
	
	//保存 
	$scope.save=function(){
		var serviceObject;//服务层对象
        serviceObject=papertempletService.update($scope.papertempletGroup); //修改
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
		papertempletService.dele( $scope.selectIds ).success(
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
		papertempletService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    //定义课程下拉列表数据
    $scope.courseListSelect={data:[]};
    $scope.getCourseOptionList=function () {
        courseService.getCourseOptionList().success(
            function (response) {
                $scope.courseListSelect={data:response};
            }
        )
    }

    //被选择的知识点数组
    $scope.selectedknowListSelect=[];

    $scope.updateKnow=function () {
        //$scope.knowListSelect
        $scope.selectedknowListSelect=$scope.entity.kId.split(",");
        knowledgetempletService.updateKnow($scope.selectedknowListSelect).success(
            function (response) {
                $scope.knowledgetempletList=response;
            }
        )
    }

    //题目类型下拉列表数据
    $scope.quescateListSelect={data:[]};
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
    $scope.knowListSelect={data:[]};
    $scope.knowledge={cId:null};
    $scope.getKnowledgeOption=function(cId){

    	$scope.knowledge.cId=cId;
        knowledgeService.getKnowledgeOption($scope.knowledge).success(
            function (response) {
                $scope.knowListSelect={data:response};
            }
        )
    }

    $scope.papertempletGroup={knowledgetempletList:[]};
    $scope.updatePaperTempSelect=function () {
		papertempletService.updatePaperTempSelect($scope.papertempletGroup).success(
			function (response) {
                $scope.papertempletGroup=response;
            }
		)
    }

    $scope.paper={paId:""};
    $scope.initPaper=function (ptId) {
        $scope.paper.paId=ptId;
    }

    $scope.createPaper=function () {
		paperService.add($scope.paper).success(
			function (response) {
                // 这里会弹出一个下载框，增强用户体验
                var blob = new Blob([response], {type: "application/msword"});
                var objectUrl = URL.createObjectURL(blob);
                //  创建a标签模拟下载
                var aForExcel = $("<a><span class='forExcel'>下载word</span></a>").attr("href",objectUrl);
                $("body").append(aForExcel);
                $(".forExcel").click();
                aForExcel.remove();

            }
		)
    }
});	
