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
                            修改角色
                        </h5>
                    </div>
                    <form  id="formid" class="ui form segment form14" action="${ITBCAdmin}/role/edit" method="post">
                        <input type="text" name="roleId" value="${role.roleId}" hidden="hidden">
                        <div class="field">
                            <label>角色名称</label>
                            <input name="roleName" value="${role.roleName}" type="text" placeholder="请填写部门名称...">
                        </div>
                        <div class="field">
                            <label>所属部门</label>
                            <div class="ui fluid action input">
                                <input name="deptId" hidden="hidden" type="text" id="deptId" value="${role.deptId}">
                                <input type="text" id="deptName" name="deptName" value="${role.deptName}">
                                <button type="button" onclick="showDept()" class="ui teal right labeled icon button">
                                    <i class="rocket icon"></i>
                                    浏览
                                </button>
                            </div>
                        </div>
                        <div class="field">
                            <label>备注</label>
                            <input name="remark" value="${role.remark}" type="number">
                        </div>

                        <input name="menuList" value="" id="menuList" hidden="hidden"/>
                        <input name="deptList" value="" id="deptList" hidden="hidden"/>

                        <div class="ui error message"></div>
                    </form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="eight wide column">
                <div class="ui segments">
                    <div class="ui segment">
                        <h5 class="ui header">
                            功能权限
                        </h5>
                    </div>
                    <div class="ui segment">
                        <ul id="menuTree" class="ztree"></ul>
                    </div>
                </div>
            </div>
            <div class="eight wide column">
                <div class="ui segments">
                    <div class="ui segment">
                        <h5 class="ui header">
                            数据权限
                        </h5>
                    </div>
                    <div class="ui segment">
                        <ul id="deptTree" class="ztree"></ul>
                    </div>
                </div>
            </div>
        </div>
        <input type="submit" onclick="goSubmit()" class="ui green submit right large button" style="margin-left: 13px;"/>
        <button type="button" class="ui right orange labeled icon large button" onclick="history.go(-1);"><i class="left arrow icon"></i> 返回 </button>
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
                    <ul id="tree" class="ztree"></ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">



    /*
    * 显示部门
    * */
    function showDept () {
        $('.ui.modal').modal('show');
    }

    function goSubmit() {
        document.getElementById("formid").submit()
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

    var settingDept = {
        view: {
            addHoverDom: false,
            removeHoverDom: false,
            selectedMulti: false,
            showLine : false
        },
        check: {
            enable: true
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
            onCheck:onDeptCheck
        }
    };
    var settingMenu = {
        view: {
            addHoverDom: false,
            removeHoverDom: false,
            selectedMulti: false,
            showLine : false
        },
        check: {
            enable: true
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
            onCheck:onMenuCheck
        }
    };
    $(document).ready(function(){
        getTree();getMenuTree();
    });



    function onCheck(e,treeId,treeNode){
        $("#deptName").val(treeNode.name);
        $("#deptId").val(treeNode.id);
    }

    function onDeptCheck(e,treeId,treeNode){
        var treeObj=$.fn.zTree.getZTreeObj("deptTree"),
                nodes=treeObj.getCheckedNodes(true),
                v="";
        for(var i=0;i<nodes.length;i++){
            v+=nodes[i].id + ",";
        }
        $("#deptList").val(v);
    }

    function onMenuCheck(e,treeId,treeNode){
        var treeObj=$.fn.zTree.getZTreeObj("menuTree"),
                nodes=treeObj.getCheckedNodes(true),
                v="";
        for(var i=0;i<nodes.length;i++){
            v+=nodes[i].id + ",";
        }
        $("#menuList").val(v);
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
                var zTreeObj =$.fn.zTree.init($("#tree"), setting, result);
                var deptTree =$.fn.zTree.init($("#deptTree"), settingDept, result);
                //全部展开
                zTreeObj.expandAll(true);
                var list = JSON.parse('${deptIds}');
                for(var i = 0 ;i < list.length ;i++){
                    //根据后台选中的id获取node对象
                    var node = deptTree.getNodeByParam("id",list[i].id);
                    //展开父节点
                    deptTree.selectNode(node.getParentNode());
                    //展开子节点
                    deptTree.selectNode(node);
                    //选中节点
                    deptTree.checkNode(node, true, true);
                }
            }
        });
    }

    function getMenuTree() {
        $.ajax({
            type : "POST",  //提交方式
            url : "${ITBCAdmin}/menu/tree",//路径
            dataType : 'json',
            async: false,
            data : {},
            success : function(result) {//返回数据根据结果进行相应的处理
                var menuTree =$.fn.zTree.init($("#menuTree"), settingMenu, result);
                var list = JSON.parse('${menuIds}');
                for(var i = 0 ;i < list.length ;i++){
                    //根据后台选中的id获取node对象
                    var node = menuTree.getNodeByParam("id",list[i].id);
                    //展开父节点
                    menuTree.selectNode(node.getParentNode());
                    //展开子节点
                    menuTree.selectNode(node);
                    //选中节点
                    menuTree.checkNode(node, true, true);
                }
            }
        });
    }



</script>