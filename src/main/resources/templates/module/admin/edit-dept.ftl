<#include "../../header.ftl">
<link rel="stylesheet" href="/static/ztree/css/bootstrapStyle/bootstrapStyle.css" type="text/css">
<script type="text/javascript" src="/static/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/static/ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="/static/ztree/js/jquery.ztree.exedit.js"></script>
<!--maincontent-->
<div class="mainWrap navslide">
    <div class="ui equal width left aligned padded grid stackable">
        <div class="row">
            <div class="sixteen wide tablet sixteen wide computer column">
                <#if msg??>
                    <div class="ui error message">
                        <i class="close icon" onclick="hideMsg()"></i>
                        <div class="header">
                            错误信息
                        </div>
                        ${msg}
                    </div>
                </#if>
                <div class="ui segments">
                    <div class="ui segment">
                        <h5 class="ui header">
                            修改部门
                        </h5>
                    </div>
                    <form  class="ui form segment form4" action="${ITBCAdmin}/dept/edit" method="post">
                        <input value="${dept.deptId}" name="deptId" hidden="hidden" type="text">
                        <div class="field">
                            <label>部门名称</label>
                            <input name="name" value="${dept.name}" type="text" placeholder="请填写部门名称...">
                        </div>
                        <div class="field">
                            <label>上级部门</label>
                            <div class="ui fluid action input">
                                <input name="parentId" hidden="hidden" type="text" id="parentId" value="${dept.parentId}">
                                <input type="text" id="parentName" name="parentName" value="${dept.parentName}">
                                <button type="button" onclick="showDept()" class="ui teal right labeled icon button">
                                    <i class="rocket icon"></i>
                                    浏览
                                </button>
                            </div>
                        </div>
                        <div class="field">
                            <label>排序</label>
                            <input name="orderNum"  value="${dept.orderNum}" type="number">
                        </div>

                        <input type="submit" class="ui green submit right large button"/>
                        <button type="button" class="ui right orange labeled icon large button" onclick="history.go(-1);"><i class="left arrow icon"></i> 返回 </button>
                        <div class="ui error message"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--maincontent-->
<div class="ui modal">
    <i class="close icon"></i>
    <div class="header">
        选择部门
    </div>
    <div class="content">
        <div class="ui equal width left aligned padded grid stackable">
            <div class="row">
                <div class="sixteen wide column">
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    /*
    * 显示图标
    * */
    function showDept () {
        $('.ui.modal').modal('show');
    }

    /**
     * 隐藏消息tree.js
     */
    function hideMsg() {
        $('.message').hide();
    }

    var setting = {
        view: {
            addHoverDom: false,
            removeHoverDom: false,
            selectedMulti: false,
            showLine : false
        },
        check: {
            enable: true,
            chkStyle:"radio",
            radioType: "all"
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        edit: {
            enable: false
        },
        callback:{
            onCheck:onCheck
        }
    };

    $(document).ready(function(){
        getTree();

    });

    var newCount = 1;
    function addHoverDom(treeId, treeNode) {
        var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='add node' onfocus='this.blur();'></span>";
        sObj.after(addStr);
        var btn = $("#addBtn_"+treeNode.tId);
        if (btn) btn.bind("click", function(){
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
            return false;
        });
    };
    function removeHoverDom(treeId, treeNode) {
        $("#addBtn_"+treeNode.tId).unbind().remove();
    };

    function onCheck(e,treeId,treeNode){
        /*var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
                nodes=treeObj.getCheckedNodes(true),
                v="";*/
        /*for(var i=0;i<nodes.length;i++){
            v+=nodes[i].name + ",";
            alert(treeNode.name); //获取选中节点的值*/
            $("#parentName").val(treeNode.name);
            $("#parentId").val(treeNode.id);
        /*}*/


    }

    function getTree() {
        $.ajax({
            type : "GET",  //提交方式
            url : "${ITBCAdmin}/dept/tree",//路径
            dataType : 'json',
            async: false,
            data : {},
            success : function(result) {//返回数据根据结果进行相应的处理
                //alert(JSON.stringify(result));
                var zTreeObj =$.fn.zTree.init($("#treeDemo"), setting, result);
                //全部展开
                zTreeObj.expandAll(true);
            }
        });
    }

</script>