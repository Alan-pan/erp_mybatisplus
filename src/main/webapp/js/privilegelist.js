		var setting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true,
				editNameSelectAll: true,
				showRemoveBtn: showRemoveBtn,
				showRenameBtn: showRenameBtn
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeEditName: beforeEditName,
				beforeRemove: beforeRemove
			}
		};

		var log, className = "dark";
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		//编辑
		function beforeEditName(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			setTimeout(function() {
				console.log(treeNode);
				$("#ppid").empty();
				if(treeNode.pId!=null){//子节点
					var parentNode=treeNode.getParentNode();
					$("#ppid").append("<option value='"+parentNode.id+"'>"+parentNode.name+"</option>");
					$("#name").val(treeNode.name);
					$("#url").val(treeNode.url);
					$("#pid").val(treeNode.id);
				}else{//父节点
					$("#ppid").append("<option value='0'></option>");
					$("#name").val(treeNode.name);
					$("#url").val(treeNode.url);
					$("#pid").val(treeNode.id);
				}
			}, 0);
			return false;
		}
		//删除
		function beforeRemove(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			alert("删除节点");
			return false;
		}

		function showRemoveBtn(treeId, treeNode) {
			return true;
		}
		function showRenameBtn(treeId, treeNode) {
//			return !treeNode.isLastNode;
			return true;
		}

		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			var btn = $("#addBtn_"+treeNode.tId);
			//添加
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				$("#ppid").empty();
				$("#ppid").append("<option value='"+treeNode.id+"'>"+treeNode.name+"</option>");
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.tId).unbind().remove();
		};
		function selectAll() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
		}
		
		$(document).ready(function(){
			$.ajax({
	    		url : "/ssh/privilege/jsonlist",
	    		method : "post",
	    		dataType : "json",
	    		success : function(result) {
	    			var zNodes = result;
	    			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	    		}
	    	})
		});
