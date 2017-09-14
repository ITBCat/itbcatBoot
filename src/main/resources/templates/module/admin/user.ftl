<#include "../../header.ftl">
<div class="mainWrap navslide">
    <div class="ui equal width left aligned padded grid stackable">
        <div class="row">
            <div class="sixteen wide column">
                <@shiro.hasPermission name="admin:user:add">
                    <a class="ui left aligned green icon button" href="/menu/add-user" style="margin-left: 10px;"><i class="write icon"></i> 添加用户 </a>
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

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>