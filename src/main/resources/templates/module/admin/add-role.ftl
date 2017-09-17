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
                            添加角色
                        </h5>
                    </div>
                    <form  id="formid" class="ui form segment form14" action="/role/save" method="post">
                        <div class="field">
                            <label>角色名称</label>
                            <input name="roleName" type="text" placeholder="请填写部门名称...">
                        </div>
                        <div class="field">
                            <label>所属部门</label>
                            <div class="ui fluid action input">
                                <input name="deptId" hidden="hidden" type="text" id="deptId" value="">
                                <input type="text" id="deptName" name="deptName" value="">
                                <button type="button" onclick="showDept()" class="ui teal right labeled icon button">
                                    <i class="rocket icon"></i>
                                    浏览
                                </button>
                            </div>
                        </div>
                        <div class="field">
                            <label>备注</label>
                            <input name="remark"  type="number">
                        </div>

                        <input name="menuList" id="menuList" hidden="hidden"/>
                        <input name="deptList" id="deptList" hidden="hidden"/>

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
    * 显示图标
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

    var zNodes =[
        {id:1, pId:0, name:"[core] 基本功能 演示", open:false},
        {id:101, pId:1, name:"最简单的树 --  标准 JSON 数据"},
        {id:102, pId:1, name:"最简单的树 --  简单 JSON 数据"},
        {id:103, pId:1, name:"不显示 连接线"},
        {id:104, pId:1, name:"不显示 节点 图标"},
        {id:108, pId:1, name:"异步加载 节点数据"},
        {id:109, pId:1, name:"用 zTree 方法 异步加载 节点数据"},
        {id:110, pId:1, name:"用 zTree 方法 更新 节点数据"},
        {id:111, pId:1, name:"单击 节点 控制"},
        {id:112, pId:1, name:"展开 / 折叠 父节点 控制"},
        {id:113, pId:1, name:"根据 参数 查找 节点"},
        {id:114, pId:1, name:"其他 鼠标 事件监听"},

        {id:2, pId:0, name:"[excheck] 复/单选框功能 演示", open:false},
        {id:201, pId:2, name:"Checkbox 勾选操作"},
        {id:206, pId:2, name:"Checkbox nocheck 演示"},
        {id:207, pId:2, name:"Checkbox chkDisabled 演示"},
        {id:208, pId:2, name:"Checkbox halfCheck 演示"},
        {id:202, pId:2, name:"Checkbox 勾选统计"},
        {id:203, pId:2, name:"用 zTree 方法 勾选 Checkbox"},
        {id:204, pId:2, name:"Radio 勾选操作"},
        {id:209, pId:2, name:"Radio nocheck 演示"},
        {id:210, pId:2, name:"Radio chkDisabled 演示"},
        {id:211, pId:2, name:"Radio halfCheck 演示"},
        {id:205, pId:2, name:"用 zTree 方法 勾选 Radio"},

        {id:3, pId:0, name:"[exedit] 编辑功能 演示", open:false},
        {id:301, pId:3, name:"拖拽 节点 基本控制"},
        {id:302, pId:3, name:"拖拽 节点 高级控制"},
        {id:303, pId:3, name:"用 zTree 方法 移动 / 复制 节点"},
        {id:304, pId:3, name:"基本 增 / 删 / 改 节点"},
        {id:305, pId:3, name:"高级 增 / 删 / 改 节点"},
        {id:306, pId:3, name:"用 zTree 方法 增 / 删 / 改 节点"},
        {id:307, pId:3, name:"异步加载 & 编辑功能 共存"},
        {id:308, pId:3, name:"多棵树之间 的 数据交互"},

        {id:4, pId:0, name:"大数据量 演示", open:false},
        {id:401, pId:4, name:"一次性加载大数据量"},
        {id:402, pId:4, name:"分批异步加载大数据量"},
        {id:403, pId:4, name:"分批异步加载大数据量"},

        {id:5, pId:0, name:"组合功能 演示", open:false},
        {id:501, pId:5, name:"冻结根节点"},
        {id:502, pId:5, name:"单击展开/折叠节点"},
        {id:503, pId:5, name:"保持展开单一路径"},
        {id:504, pId:5, name:"添加 自定义控件"},
        {id:505, pId:5, name:"checkbox / radio 共存"},
        {id:506, pId:5, name:"左侧菜单"},
        {id:507, pId:5, name:"下拉菜单"},
        {id:509, pId:5, name:"带 checkbox 的多选下拉菜单"},
        {id:510, pId:5, name:"带 radio 的单选下拉菜单"},
        {id:508, pId:5, name:"右键菜单 的 实现"},
        {id:511, pId:5, name:"与其他 DOM 拖拽互动"},
        {id:512, pId:5, name:"异步加载模式下全部展开"},

        {id:6, pId:0, name:"其他扩展功能 演示", open:false},
        {id:601, pId:6, name:"隐藏普通节点"},
        {id:602, pId:6, name:"配合 checkbox 的隐藏"},
        {id:603, pId:6, name:"配合 radio 的隐藏"}
    ];

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
            url : "/dept/tree",//路径
            dataType : 'json',
            async: false,
            data : {},
            success : function(result) {//返回数据根据结果进行相应的处理
                //alert(JSON.stringify(result));
                var zTreeObj =$.fn.zTree.init($("#tree"), setting, result);
                var deptTree =$.fn.zTree.init($("#deptTree"), settingDept, result);
                //全部展开
                zTreeObj.expandAll(true);
            }
        });
    }

    function getMenuTree() {
        $.ajax({
            type : "POST",  //提交方式
            url : "/menu/tree",//路径
            dataType : 'json',
            async: false,
            data : {},
            success : function(result) {//返回数据根据结果进行相应的处理
                var menuTree =$.fn.zTree.init($("#menuTree"), settingMenu, result);
            }
        });
    }



</script>