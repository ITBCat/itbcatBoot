<#include "../../header.ftl">
<div class="mainWrap navslide">
    <div class="ui equal width left aligned padded grid stackable">
        <div class="row">
            <div class="sixteen wide column">
                <@shiro.hasPermission name="admin:role:add">
                    <a class="ui left aligned green icon button" href="/menu/add-role" style="margin-left: 10px;"><i class="write icon"></i> 添加角色 </a>
                </@shiro.hasPermission>
                <div class="ui segments">
                    <div class="ui segment">
                        <h5 class="ui header greenli ribbon big label">
                            角色列表
                        </h5>
                    </div>
                    <div class="ui segment">
                        <table id="data_table" class="ui compact selectable striped celled table tablet stackable" cellspacing="0" width="100%">
                            <thead>
                            <tr>
                                <th>角色名称</th>
                                <th>所属部门</th>
                                <th>备注</th>
                                <th>创建时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                                <#list roles as item>
                                    <tr>
                                        <td>${item.name}</td>
                                        <td>${item.deptName}</td>
                                        <td>${item.remarks}</td>
                                        <td>${item.createTime}</td>
                                        <td class="center aligned" width="130px;">
                                            <div class="ui buttons clearfix" style="margin-top: 10px;">
                                                <a class="ui teal mini button" href="/role/edit/edit-role?roleId=${item.roleId}">修改</a>
                                                <div class="or"></div>
                                                <a class="ui orange mini button" href="/role/delete/${item.roleId}">删除</a>
                                            </div>
                                        </td>
                                    </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>