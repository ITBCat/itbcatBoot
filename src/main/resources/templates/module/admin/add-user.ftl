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
                    <form  class="ui form segment form4" action="/menu/save" method="post">
                        <div class="field">
                            <label>菜单名称</label>
                            <input placeholder="请填写菜单名称..." name="name" type="text">
                        </div>
                        <div class="field">
                            <label>上级菜单</label>
                            <div class="ui selection dropdown" tabindex="0">
                                <input name="parentId" type="hidden">
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
                            <label>菜单路径</label>
                            <input placeholder="请填写菜单路径..." name="url" type="text">
                        </div>
                        <div class="field">
                            <label>授权标识</label>
                            <input name="perms" placeholder="请填写授权标识,多个请用逗号隔开..." type="text">
                        </div>
                        <div class="field">
                            <label>排序</label>
                            <input name="sort"  type="number">
                        </div>
                        <div class="field">
                            <label>图标</label>
                            <div class="ui fluid action input">
                                <input name="icon" type="text" value="">
                                <button type="button" onclick="showIcon()" class="ui teal right labeled icon button">
                                    <i class="rocket icon"></i>
                                    浏览
                                </button>
                            </div>
                        </div>
                        <div class="field">
                            <label>是否隐藏</label>
                            <div class="ui selection dropdown" tabindex="0">
                                <input name="isShow" type="hidden" value="1">
                                <div class="default text">否</div>
                                <i class="dropdown icon"></i>
                                <div class="menu" tabindex="-1">
                                    <div class="item" data-value="0">是</div>
                                    <div class="item" data-value="1">否</div>
                                </div>
                            </div>
                        </div>
                        <div class="field">
                            <label>目标</label>
                            <input type="text" name="target" placeholder="请输入_blank、_self、_top">
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