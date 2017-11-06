<!--navbar-->
<div class="navwrap" style="width: 100%;">
    <div class="ui menu icon borderless four column grid" style="width: 100%;height: 54px;" data-color="inverted white">
        <div class="three wide column" style="margin-top: -1em;">
            <a href="/"><img src="/static/i.svg" alt=""></a>
        </div>
        <div class="ui secondary stackable menu eight wide column" style="font-size: larger;font-weight: bold;" >
            <a class="active item icon" href="/">
                <i class="home icon"></i>
                &nbsp;首页
            </a>
            <a class="item">
                <i class="coffee icon"></i>
                &nbsp;JAVA
            </a>
            <a class="item">
                <i class="Record icon"></i>
                &nbsp;VIDEO
            </a>
            <a class="item">
                <i class="Music icon"></i>
                &nbsp;MUSIC
            </a>
            <a class="item">
                <i class="sound icon"></i>
                &nbsp;ABOUT
            </a>

            <div class="ui right aligned category search item">
                <div class="ui icon input" id="_search_result">
                    <input id="_search_input" name="q" autocomplete="off" type="text" placeholder="Search...">
                    <i class="search icon input"></i>
                </div>
                <div class="searchresult" style="display: none;overflow-x:hidden;">
                </div>
            </div>
        </div>

        <div class="right menu colhidden four wide column">
        <#if isLogin>
            <div class="ui dropdown item" style="height: 54px;margin-top: -14px;">
                <i class="bell big icon"></i>
                <div class="menu">
                    <div class="header">
                        People You Might Know
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/enid.png" alt="label-image" /> Janice Robinson
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/Hershell.png" alt="label-image" /> Cynthia May
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/Rick.png" alt="label-image" /> Hugh Carter
                    </div>
                    <div class="header">
                        Your Friends' Friends
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/Meggie.png" alt="label-image" /> Pauline Cain
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/Glenn.png" alt="label-image" /> Marco Beck
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/Daryl.png" alt="label-image" /> Sue Quinn
                    </div>
                </div>
            </div>
            <div class="ui dropdown item" tabindex="0">
                语言 <i class="dropdown icon"></i>
                <div class="menu transition hidden" tabindex="-1">
                    <a class="item" href="/changeSessionLanauage?lang=en"><i class="united kingdom flag"></i>English</a>
                    <a class="item" href="/changeSessionLanauage?lang=zh"><i class="china flag"></i>简体中文</a>
                </div>
            </div>
            <@shiro.hasPermission name="admin:admin:view">
                <a class="item labeled rightsidebar computer only" href="${ITBCAdmin}/admin">
                    <i class="ion-wrench large icon"></i>
                </a>
            </@shiro.hasPermission>
            <a class="ui item" href="${ITBCFront}/put">
                <button class="ui active redli button">
                    <i class="paint brush icon"></i>
                    发 布
                </button>
            </a>
            <div class="ui dropdown item" style="height: 54px;margin-top: -14px;">
                <#if _user?? && _user.avatar??>
                    <img id="_avatar_heard" class="ui mini rounded image" style="height: 35px;width: 35px;" src="${ITBCNginx}/${_user.avatar}" onerror="this.src='/static/i.png'   " alt="label-image" />
                <#else >
                    <img id="_avatar_heard" class="ui mini rounded image" style="height: 35px;width: 35px;" src="/static/i.png" alt="label-image" />
                </#if>
                <div class="menu">
                    <a class="item" href="mail.html">Inbox</a>
                    <a class="item" href="${ITBCFront}/chat">IChat</a>
                    <a class="item" href="${ITBCFront}/settings">个人信息</a>
                    <div class="ui divider"></div>
                    <a class="item">Need Help?</a>
                    <a class="item" href="/logout">注销</a>
                </div>
            </div>
        <#else>
            <a class="ui item" href="/login">
                <label style="font-weight: bold;font-size: larger;">登 录</label>
            </a>
            <a class="ui item" href="/register">
                <label style="font-weight: bold;font-size: larger;">注 册</label>
            </a>
        </#if>
        </div>
    </div>
</div>
<script type="text/javascript">
    $('input').bind('input propertychange', function() {
        $('.searchresult').html('');
        $('.searchresult').hide();
        var q = $('#_search_input').val();
        if(q==''){
            $(".searchresult").hide();
        }else{
            search(q);
        }
    });
    $(document).click(function () {
        $(".searchresult").hide();
    });
    function search(q) {
        var search = {
            'q':q
        }
        $.ajax({
            type : "POST",  //提交方式
            url : "${ITBCFront}/search",//路径
            dataType : 'json',
            async: false,
            data : search,
            success : function(result) {//返回数据根据结果进行相应的处理
                var html = '<table class="ui celled table"><tbody>';
                if(result.data.search.length <= 0){
                    return;
                }
                if(result.data.search.length>=25){
                    $(".searchresult").css({height:"50em",overflow:"auto"});
                }
                for (var i = 0;i<result.data.search.length;i++){
                    var src=ITBC.ITBCNginx+'/'+result.data.search[i].avatar;
                    html +='<tr>'
                              +'<td>'
                                  +'<a class="ui image header" href="">'
                                      +'<img src="'+src+'" class="ui mini rounded image">'
                                      +'<div class="content">'
                                          +'<h4 style="margin: 0;">'+result.data.search[i].title+'</h4>'
                                          +'<div class="sub header">'+result.data.search[i].md+'</div>'
                                      +'</div>'
                                  +'</a>'
                              +'</td>'
                            +'</tr>';
                }
                html+='</tbody></table>';
                $('.searchresult').html(html);
                $('.searchresult').show();
            }
        });
    }
</script>
<!--navbar-->