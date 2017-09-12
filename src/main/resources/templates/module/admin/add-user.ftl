<#include "../../header.ftl">
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
                            添加用户
                        </h5>
                    </div>
                    <form  class="ui form segment form14" action="/user/save" method="post">
                        <div class="two fields">
                            <div class="field">
                                <label>用户名</label>
                                <input placeholder="请输入用户名..." name="username" type="text">
                            </div>
                            <div class="field">
                                <label>密码</label>
                                <input placeholder="请输入密码..." name="password" type="text">
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>邮箱</label>
                                <input placeholder="请输入邮箱..." name="email" type="email">
                            </div>
                            <div class="field">
                                <label>用户类型</label>
                                <div class="ui selection dropdown" tabindex="0">
                                    <input name="type" type="hidden">
                                    <div class="default text"> </div>
                                    <i class="dropdown icon"></i>
                                    <div class="menu" tabindex="-1">
                                        <div class="item" data-value="">--空--</div>
                                        <div class="item" data-value="1">系统管理</div>
                                        <div class="item" data-value="2">其他管理</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="two fields">
                            <div class="field">
                                <label>所属部门</label>
                                <div class="ui selection dropdown" tabindex="0">
                                    <input name="deptId" type="hidden">
                                    <div class="default text"> </div>
                                    <i class="dropdown icon"></i>
                                    <div class="menu" tabindex="-1">
                                        <div class="item" data-value="">--空--</div>
                                        <div class="item" data-value="1">系统管理</div>
                                        <div class="item" data-value="2">其他管理</div>
                                    </div>
                                </div>
                            </div>
                            <div class="field">
                                <label>备注</label>
                                <input name="remarks" type="text">
                            </div>
                        </div>
                        <input type="submit" class="ui green submit right button"/>
                        <div class="ui error message"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--maincontent-->


<script type="text/javascript">
    /**
     * 隐藏消息
     */
    function hideMsg() {
        $('.message').hide();
    }

</script>