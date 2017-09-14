<#include "../../header.ftl">
<div class="mainWrap navslide">
    <div class="ui equal width left aligned padded grid stackable">
        <div class="row">
            <div class="sixteen wide column">
                <@shiro.hasPermission name="admin:dept:add">
                    <a class="ui left aligned green icon button" href="/dept/add-dept" style="margin-left: 10px;"><i class="write icon"></i> 添加部门 </a>
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
                                <th>部门名称</th>
                                <th>上级部门</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list depts as item>
                            <tr>
                                <td>
                                    <a class="ui right greenli icon label" href="/dept/dept?parentId=${item.deptId}"> ${item.name}
                                        <i class="right arrow icon"></i>
                                    </a>
                                </td>
                                <td>${item.parentName}</td>
                                <td class="center aligned" width="130px;">
                                    <div class="ui buttons clearfix" style="margin-top: 10px;">
                                        <a class="ui teal mini button" href="/dept/edit/edit-dept?menuId=${item.deptId}">修改</a>
                                        <div class="or"></div>
                                        <a class="ui orange mini button" href="/dept/delete/${item.deptId}">删除</a>
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