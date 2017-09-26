<#include "../../header.ftl">
<div class="mainWrap navslide">
    <div class="ui equal width left aligned padded grid stackable">
        <div class="row">
            <div class="sixteen wide column">
                <@shiro.hasPermission name="admin:user:add">
                    <a class="ui left aligned green icon button" href="/user/add-user" style="margin-left: 10px;"><i class="write icon"></i> 添加用户 </a>
                </@shiro.hasPermission>
                <div class="ui segments">
                    <div class="ui segment">
                        <h5 class="ui header greenli ribbon big label">
                            用户列表
                        </h5>
                    </div>
                    <div class="ui segment">
                        <table id="data_table" class="ui compact selectable striped celled table tablet stackable" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>用户名</th>
                                <th>所属部门</th>
                                <th>邮箱</th>
                                <th>手机号</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <#list users as item>
                                    <#if item.userId != "1">
                                        <tr>
                                            <td>${item.username}</td>
                                            <td>${item.deptName}</td>
                                            <td>${item.email}</td>
                                            <td>${item.mobile}</td>
                                            <td>${(item.status == 0)?string('正常','禁用')}</td>
                                            <td class="center aligned" width="130px;">
                                                <div class="ui buttons clearfix" style="margin-top: 10px;">
                                                    <a class="ui teal mini button" href="/user/edit/edit-user?userId=${item.userId}">修改</a>
                                                    <div class="or"></div>
                                                    <a class="ui orange mini button" href="/user/delete/${item.userId}">删除</a>
                                                </div>
                                            </td>
                                        </tr>
                                    </#if>
                                </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>