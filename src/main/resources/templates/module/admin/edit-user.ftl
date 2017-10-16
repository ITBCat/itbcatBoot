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
                            修改用户
                        </h5>
                    </div>
                    <form  class="ui form segment form14" action="/user/edit" method="post">
                        <input type="text" hidden="hidden" name="userId" value="${user.userId}">
                        <div class="field">
                            <label>邮箱</label>
                            <input placeholder="请输入邮箱(登录账户)..." value="${user.email}" name="email" type="email">
                        </div>
                        <div class="field">
                            <label>用户名</label>
                            <input placeholder="请输入用户名(昵称)..." value="${user.username}" name="username" type="text">
                        </div>
                        <input value="${user.password}" hidden="hidden" name="password" type="text">
                        <div class="field">
                            <label>所属部门</label>
                            <div class="ui fluid action input">
                                <input value="${user.deptId}" name="deptId" hidden="hidden" type="text" id="deptId">
                                <input value="${user.deptName}" name="deptName" type="text" id="deptName">
                                <button type="button" onclick="showDept()" class="ui teal right labeled icon button">
                                    <i class="rocket icon"></i>
                                    浏览
                                </button>
                            </div>
                        </div>
                        <div class="field">
                            <label>选择角色</label>
                            <div class="ui selection dropdown" tabindex="0">
                                <input name="roleId"  type="hidden" value="${roleId}">
                                <div class="default text"></div>
                                <i class="dropdown icon"></i>
                                <div class="menu" tabindex="-1">
                                    <div class="item" data-value="admin">超级管理员</div>
                                <#list roles as item>
                                    <div class="item" data-value="${item.roleId}">${item.roleName}</div>
                                </#list>
                                </div>
                            </div>
                        </div>
                        <div class="field">
                            <label>手机号</label>
                            <input type="text" name="mobile" value="${user.mobile}" placeholder="请输入手机号...">
                        </div>
                        <div class="field">
                            <label>状态</label>
                            <div class="ui form">
                                <div class="inline fields">
                                    <div class="field">
                                        <div class="ui radio checkbox">
                                            <input type="radio" name="status" value="0" <#if user.status == 0>checked="checked"</#if>>
                                            <label>正常</label>
                                        </div>
                                    </div>
                                    <div class="field">
                                        <div class="ui radio checkbox">
                                            <input type="radio" value="1" name="status" <#if user.status == 1>checked="checked"</#if>>
                                            <label>禁用</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="submit" class="ui green submit right button"/>
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
                    <ul id="tree" class="ztree"></ul>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    /**
     * 隐藏消息
     */
    function hideMsg() {
        $('.message').hide();
    }

    /*
    * 显示部门
    * */
    function showDept () {
        $('.ui.modal').modal('show');
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
                //全部展开
                zTreeObj.expandAll(true);
            }
        });
    }
    function onCheck(e,treeId,treeNode){
        $("#deptName").val(treeNode.name);
        $("#deptId").val(treeNode.id);
        $('.ui.modal').modal('hide');
    }
</script>