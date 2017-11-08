<div class="ui equal width left aligned padded grid stackable">
    <!--Site Content-->
    <div class="sixteen wide tablet two wide computer column">
        <div class="ui vertical secondary pointing fluid tabular menu">
            <a class="item active" data-tab="profile">
                基本信息
            </a>
            <a class="item" data-tab="avatar">
                头像
            </a>
            <a class="item" data-tab="settings">
                Account Settings
            </a>
            <a class="item" data-tab="emails">
                Emails
            </a>
            <a class="item" data-tab="notifications">
                Notifications
            </a>
            <a class="item" data-tab="security">
                Security
            </a>
        </div>
    </div>
    <div class="sixteen wide tablet fourteen wide computer column">
        <div class="ui segment" style="height: 80%;">
            <div class="ui tab active" data-tab="profile">
                <form class="ui form" action="${ITBCFront}/settings/${_user.userId}" method="post">
                    <h3 class="ui header">
                        基本信息
                    </h3>
                    <div class="ui hidden divider"></div>
                    <div class="two fields">
                        <div class="field">
                            <label>昵称</label>
                            <input placeholder="填写你的昵称" <#if _user.username??>value="${_user.username}"</#if> name="username" type="text">
                        </div>
                        <div class="field">
                            <label>性别</label>
                            <div class="ui selection dropdown" tabindex="0">
                                <input name="gender" <#if _user.gender??>value="${_user.gender}"</#if> type="hidden">
                                <div class="default text">选择你的性别</div>
                                <i class="dropdown icon"></i>
                                <div class="menu" tabindex="-1">
                                    <div class="item" data-value="0">帅哥</div>
                                    <div class="item" data-value="1">美女</div>
                                    <div class="item" data-value="2">保密</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="two fields">
                        <div class="field">
                            <label>个人简介</label>
                            <input placeholder="填写你的个人简介" <#if _user.profiles??>value="${_user.profiles}"</#if> name="profiles" type="text">
                        </div>
                        <div class="field">
                            <label>个人网站</label>
                            <div class="ui labeled input fluid">
                                <div class="ui label">
                                    http://
                                </div>
                                <input type="text" <#if _user.website??>value="${_user.website}"</#if> name="website" placeholder="你的网址">
                            </div>
                        </div>
                    </div>
                    <div class="field">
                        <label>自我标签</label>
                        <div class="ui dropdown fluid selection multiple" tabindex="0">
                            <select name="自我标签" multiple="">
                            <option value=""></option>
                            <option value="1">宅男腐女</option>
                            <option value="2">程序猿</option>
                            <option value="3">艺术家</option>
                            <option value="4">运动员</option>
                            <option value="5">设计师</option>
                            <option value="6">作家</option>
                            <option value="7">其他</option>
                        </select>
                            <i class="dropdown icon"></i>
                            <input name="tags" <#if _user.tags??>value="${_user.tags}"</#if> type="hidden">
                            <div class="default text">选择自我标签</div>
                            <div class="menu" tabindex="-1">
                                <div class="item" data-value="1">宅男腐女</div>
                                <div class="item" data-value="2">程序猿</div>
                                <div class="item" data-value="3">艺术家</div>
                                <div class="item" data-value="4">运动员</div>
                                <div class="item" data-value="5">设计师</div>
                                <div class="item" data-value="6">作家</div>
                                <div class="item" data-value="7">其他</div>
                            </div>
                        </div>
                    </div>
                    <button class="ui green submit button" type="submit" style="float: right;">保存</button>
                    <div class="ui error message"></div>
                </form>
            </div>
            <div class="ui tab" data-tab="avatar" style="margin-top: 12%;">
                <div class="ui tow column middle aligned stackable grid">
                    <div class="row">
                        <div class="fourteen wide column">
                            <div class="ui images">
                                <#if _user?? && _user.avatar??>
                                    <img id="_mini" class="ui mini rounded image" src="${ITBCNginx}/${_user.avatar}" onerror="this.src='/static/i.png'" style="margin-left: 15em;width: 35px;height: 35px;">
                                    <img id="_small" class="ui small rounded image" src="${ITBCNginx}/${_user.avatar}" onerror="this.src='/static/i.png'" style="margin-left: 15em;width: 150px;height: 150px;">
                                    <img id="_medium" class="ui medium rounded image" src="${ITBCNginx}/${_user.avatar}" onerror="this.src='/static/i.png'" style="margin-left: 15em;width: 300px;height: 300px;">
                                <#else >
                                    <img id="_mini" class="ui mini rounded image" src=""  style="margin-left: 15em;width: 35px;height: 35px;">
                                    <img id="_small" class="ui small rounded image" src="" style="margin-left: 15em;width: 150px;height: 150px;">
                                    <img id="_medium" class="ui medium rounded image" src="" style="margin-left: 15em;width: 300px;height: 300px;">
                                </#if>
                            </div>
                        </div>
                        <div class="two wide column">
                            <div class="center aligned column">
                                <span class="ui green large button btn-file">
                                    <span id="buttonLabel">上传头像</span>
                                    <input id="_avatar" type="file" accept="image/*" name="avatar" onchange="changeImg(event)" class="ui green large button"/>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui tab" data-tab="settings">
                <form class="ui form">
                    <h3 class="ui header">
                        Account Settings
                    </h3>
                    <div class="ui hidden divider"></div>
                    <div class="field">
                        <label>Client ID</label>
                        <input placeholder="Client ID" value="567yznQZng9BMtmb3S0A9LAQN6IT9Dug" name="name" type="text">
                    </div>
                    <div class="field">
                        <label>Secret ID</label>
                        <input placeholder="Secret ID" value="x978LzQBmN2qt4AO6TjS84HO0ohdzP1x" name="name" type="text">
                    </div>
                    <div class="field">
                        <label>App Name</label>
                        <input placeholder="App Name" name="name" type="text">
                    </div>
                    <div class="field">
                        <label>App URL</label>
                        <input placeholder="http://example.com" name="name" type="text">
                    </div>

                    <div class="ui blue submit button">Update</div>
                    <div class="ui error message"></div>
                </form>
            </div>
            <div class="ui tab" data-tab="emails">
                <div class="ui form">
                    <div class="field">
                        <div class="ui toggle button">Toggle</div>
                        <div class="ui positive check button">Check</div>
                        <div class="ui negative uncheck button">Uncheck</div>
                    </div>

                    <div class="field">
                        <div class="ui test toggle checkbox">
                            <input type="checkbox" checked="checked">
                            <label>Anyone invite me to group</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui test toggle checkbox">
                            <input type="checkbox">
                            <label>Anyone send me a message</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui test toggle checkbox">
                            <input type="checkbox" checked="checked">
                            <label>Anyone follow me</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui test toggle checkbox">
                            <input type="checkbox" checked="checked">
                            <label>Anyone posts a comment</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui test toggle checkbox">
                            <input type="checkbox">
                            <label>Anyone send me a comment</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui test toggle checkbox">
                            <input type="checkbox" checked="checked">
                            <label>Anyone send me an email</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui tab" data-tab="notifications">
                <div class="ui form">
                    <div class="field">
                        <div class="ui toggle button">Toggle</div>
                        <div class="ui positive check button">Check</div>
                        <div class="ui negative uncheck button">Uncheck</div>
                    </div>

                    <div class="field">
                        <div class="ui test slider checkbox">
                            <input type="checkbox">
                            <label>Automatically watch repositories </label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui test slider checkbox">
                            <input type="checkbox" checked="checked">
                            <label>Participating</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui test slider checkbox">
                            <input type="checkbox">
                            <label>Watching</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui test slider checkbox">
                            <input type="checkbox" checked="checked">
                            <label>Notification email</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui test slider checkbox">
                            <input type="checkbox">
                            <label>Custom routing</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui tab" data-tab="security">
                <form class="ui form">
                    <h3 class="ui header">
                        Security Settings
                    </h3>
                    <div class="ui hidden divider"></div>
                    <div class="field">
                        <label>Old Password</label>
                        <input placeholder="Old Password" value="" name="name" type="text">
                    </div>
                    <div class="field">
                        <label>New Password</label>
                        <input placeholder="New Password" value="" name="name" type="text">
                    </div>
                    <div class="field">
                        <label>New Password Repeat</label>
                        <input placeholder="New Password Repeat" name="name" type="text">
                    </div>

                    <div class="ui blue submit button">Update</div>
                    <div class="ui red submit button">Delete Account</div>
                    <div class="ui error message"></div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        <#if msg??>
            var type = '${msg.type}';
            var msg = '${msg.message}';
        notify(type,'基本信息',msg,'/static/img/message/'+type+'.png');
        </#if>

    })
    function changeImg(e){
        upload();
        /*for (var i = 0; i < e.target.files.length; i++) {
            var file = e.target.files.item(i);
            if (!(/^image\/.*$/i.test(file.type))) {
                continue; //不是图片 就跳出这一次循环
            }
            //实例化FileReader API
            var freader = new FileReader();
            freader.readAsDataURL(file);
            freader.onload = function(e) {
                $('#_mini').attr("src",e.target.result);
                $('#_small').attr("src",e.target.result);
                $('#_medium').attr("src",e.target.result);
            }
        }*/
    }
    function upload(){
        var formData = new FormData();
        var inputs = $('#_avatar');
        for (var i = 0; i < inputs.length; i++) {
            var file = inputs[i];
            if (inputs[i].files[0]) {
                formData.append("avatar", file.files[0], file.files[0].name);
            }
        }
        $.ajax({
            type: 'POST',
            url: '${ITBCFront}/settings/avatar',
            dataType: "json",
            data: formData,
            processData: false,
            contentType: false,
            success: function(data) {
                if(data.code == 0){
                    $('#_mini').attr("src",'${ITBCNginx}/'+data.data);
                    $('#_small').attr("src",'${ITBCNginx}/'+data.data);
                    $('#_medium').attr("src",'${ITBCNginx}/'+data.data);
                    $('#_avatar_heard').attr("src",'${ITBCNginx}/'+data.data);
                }else{
                    alert(data.message);
                }
            }
        });
    }
</script>