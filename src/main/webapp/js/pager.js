var path="/ssh";
$(function(){
        var columns=[
            {
                checkbox: true,
                align: 'center',
                valign: 'middle',
            },
            {
                title: '用户名',
                field: 'username',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '性别',
                field: 'sex',
                align: 'center',
            },
            {
                title: '昵称',
                field: 'nickname',
                align: 'center',
            },
            {
                title: '操作',
                field: 'uid',
                align: 'center',
                formatter:function(value,row,index){
                	var a = '<button href="#" class="btn" data-toggle="modal" onclick="getRole(\''+row.uid+'\')">授予角色</button> ';
                    var e = '<button href="#" class="btn btn-primary"  onclick="edit(\''+ row.uid + '\')">编辑</button> ';
                    var d = '<button href="#" class="btn btn-danger"  onclick="del(\''+ row.uid +'\')">删除</button> ';
                    return a+e+d;
                }
            }
        ];
        getList('jsonlist',columns);  

    });
	//获取集合数据封装到table中：args1:请求获取用户集合的url,args2:封装到列信息
    function getList (dataurl,columns) {
    	//table id
        $('#userList').bootstrapTable({
            url: dataurl,
            method:"post",
            dataType: "json",
            contentType: "application/x-www-form-urlencoded",
            striped:true,//隔行变色
            cache:false,  //是否使用缓存
            showColumns:false,// 列
//            toobar:'#toolbar',
            pagination: true, //分页
            paginationLoop:false,
            paginationPreText:'上一页',
            paginationNextText:'下一页',
//            showFooter:true,//显示列脚
//            showRefresh:true,//显示刷新
            showPaginationSwitch:false,//是否显示数据条数选择框
            sortable: false,           //是否启用排序
            singleSelect: false,
            search:false, //显示搜索框
            buttonsAlign: "right", //按钮对齐方式
            showRefresh:false,//是否显示刷新按钮
            sidePagination: "server", //服务端处理分页
            pageNumber:1,
            pageSize:5,
            pageList:[5,10, 25, 50, 100],
            undefinedText:'--',
            uniqueId: "id", //每一行的唯一标识，一般为主键列
            queryParamsType:'',
            queryParams: queryParams,//传递参数（*）
            columns: columns
        });

        //得到查询的参数
        function queryParams (params) {
            var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                username: $("#search_username").val(),//后台请求传的查询参数
                name:$("#search_name").val(),
                sex:$("#search_sex").val(),
                phone:$("#search_mobile").val(),
                email:$("#search_email").val(),
            };
            return temp;
        };
    }
    
    var  id;
    
    //获取用户对应的角色
    function getRole(uid){
    	var setting = {
    			check : {
    				enable : true
    			},
    			data : {
    				simpleData : {
    					enable : true
    				}
    			}
    		};
    	$.ajax({
    		url : path+"/role/jsonlist?uid="+uid,
    		method : "post",
    		dataType : "json",
    		success : function(result) {
    			var zNodes = result;
    			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
    			$("#myModal").modal('show');//显示模态框
    		}
    	})
    	
    	id=uid;
    }
    
    //为用户添加角色
    function addRole(){
		var treeObj=$.fn.zTree.getZTreeObj("treeDemo");
		var nodes=treeObj.getCheckedNodes(true);
		var rids="";
		
		for(var i in nodes){
			rids+=nodes[i].id+",";
		}
		//所选中的角色id
		rids=rids.substring(0,rids.length-1);
		//用户id
		var uid=id;
		$.ajax({
    		url : path+"/user/addRole?uid="+uid+"&rids="+rids,
    		method : "post",
    		dataType : "json",
    		success : function(result) {
    			$("#myModal").modal('hide');//隐藏模态框
    		}
    	})
	}
    

    //搜索
    function serachUser() {
        $("#userListTable").bootstrapTable('refresh');
    }