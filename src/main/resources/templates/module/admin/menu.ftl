<#include "../../header.ftl">
<div class="mainWrap navslide">
    <div class="ui equal width left aligned padded grid stackable">
        <div class="row">
            <div class="sixteen wide column">
                <@shiro.hasPermission name="admin:menu:add">
                    <a class="ui left aligned green icon button" href="/menu/add-menu" style="margin-left: 10px;"><i class="write icon"></i> 添加菜单 </a>
                </@shiro.hasPermission>
                <div class="ui segments">
                    <div class="ui segment">
                        <h5 class="ui header greenli ribbon big label">
                            ${parentName}
                        </h5>
                    </div>
                    <div class="ui segment">
                        <table id="data_table" class="ui compact selectable striped celled table tablet stackable" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>菜单名称</th>
                                <th>父级菜单名称</th>
                                <th>菜单路径</th>
                                <th>权限</th>
                                <th>类型</th>
                                <th>操作</th>
                            </tr>
                            </thead>

                            <tbody>
                            <#list menus as item>
                                <tr>
                                    <td>
                                        <#if item.parentId == "0">
                                        <a class="ui right greenli icon label" href="/menu/menu?parentId=${item.menuId}"> ${item.name}
                                            <i class="right arrow icon"></i>
                                        </a>
                                        <#else >
                                        ${item.name}
                                        </#if>
                                    </td>
                                    <td>${item.parentName}</td>
                                    <td>${item.url}</td>
                                    <td>${item.perms}</td>
                                    <td>
                                        <#if item.type == 0>
                                            <div class="ui blueli horizontal label">目录</div>
                                        <#elseif item.type == 1>
                                            <div class="ui redli horizontal label">菜单</div>
                                        <#else>
                                            <div class="ui greenli2 horizontal label">按钮</div>
                                        </#if>
                                    </td>
                                    <td class="center aligned" width="130px;">
                                        <div class="ui buttons clearfix" style="margin-top: 10px;">
                                            <a class="ui teal mini button" href="/menu/edit/edit-menu?menuId=${item.menuId}">修改</a>
                                            <div class="or"></div>
                                            <a class="ui orange mini button" href="/menu/delete/${item.menuId}">删除</a>
                                        </div>
                                    </td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    <#if parentName != '一级菜单'>
                        <button type="button" class="ui right orange labeled icon large button" onclick="history.go(-1);"><i class="left arrow icon"></i> 返回 </button>
                    </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>