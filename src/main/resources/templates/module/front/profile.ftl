<div class="ui equal width left aligned padded grid stackable" style="background-color: #F1F4F5;">
    <div class="sixteen wide tablet sixteen wide computer column profileheader row no-padding">
        <div class="column left floated" style="margin-left: 23%;">
            <div class="ui items">
                <div class="item">
                    <a class="ui small circular image">
                        <img src="${ITBCNginx}/${profiler.avatar}" alt="label-image" />
                        <i class="circle mini red icon avt" data-content="Offline" data-variation="inverted redli"></i>
                    </a>
                    <div class="middle aligned content hiddenui">
                        <div class="header">
                            <i class="like icon"></i>
                            ${profiler.username}
                        </div>
                    <#if profiler.website??>
                        <#if profiler.website != 'http://'>
                            <div class="meta">
                            <a href="http://${profiler.website}" target="_blank">http://${profiler.website}</a>
                            </div>
                        </#if>
                    </#if>
                    <#if profiler.profiles??>
                         <div class="meta">
                             ${profiler.profiles}
                         </div>
                    </#if>
                    </div>
                </div>
            </div>
        </div>
        <div class="column hiddenui">
            <div class="description right aligned">
                <a class="ui circular facebook icon button" data-content="facebook" data-variation="inverted">
                    <i class="facebook icon"></i>
                </a>
                <a class="ui circular twitter icon button" data-content="twitter" data-variation="inverted">
                    <i class="twitter icon"></i>
                </a>
                <a class="ui circular linkedin icon button" data-content="linkedin" data-variation="inverted">
                    <i class="linkedin icon"></i>
                </a>
                <a class="ui circular google plus icon button" data-content="google" data-variation="inverted">
                    <i class="google plus icon"></i>
                </a>
                <a class="ui circular instagram icon button" data-content="instagram" data-variation="inverted">
                    <i class="instagram icon"></i>
                </a>
                <div class="ui divider"></div>
            <#if isFollowing>
                <button class="ui green right labeled icon button follow" id="_unfollow" onclick="Follow.unfollow('${profiler.userId}')">已关注 <i class="checkmark icon"></i></button>
            <#else>
                <button class="ui inverted black button follow" id="_follow" onclick="Follow.follow('${profiler.userId}')">关注</button>
            </#if>
                <button class="ui inverted black button follow" id="" onclick="Common.addFriend('${profiler.userId}')">添加好友</button>
            </div>
        </div>
    </div>
    <div class="ui menu fluid no-radius borderless stackable" style="margin-top:0">
        <a class="item active red">Timeline</a>
        <a class="item">About</a>
        <a class="item">Friends</a>
        <a class="item">Profile</a>
        <div class="right menu">
            <a class="item">
                <div class="ui mini statistic">
                    <div class="value">
                        <#if profiler.articleCnt lt 1000>
                            ${profiler.articleCnt}
                        <#else >
                            ${profile.article / 1000} k
                        </#if>
                    </div>
                    <div class="label">
                        篇文章
                    </div>
                </div>
            </a>
            <a class="item">
                <div class="ui mini statistic">
                    <div class="value">
                        <#if profiler.followCnt lt 1000>
                            ${profiler.followCnt}
                        <#else >
                            ${profile.followCnt / 1000} k
                        </#if>
                    </div>
                    <div class="label">
                        关注
                    </div>
                </div>
            </a>
            <a class="item">
                <div class="ui mini statistic">
                    <div class="value">
                    1.3 k
                    </div>
                    <div class="label">
                        个赞
                    </div>
                </div>
            </a>
            <a class="item">
                <div class="ui mini statistic">
                    <div class="value">
                    690
                    </div>
                    <div class="label">
                        条评论
                    </div>
                </div>
            </a>
            <a class="item">
                <div class="ui  mini statistic">
                    <div class="value">
                    150
                    </div>
                    <div class="label">
                        收藏
                    </div>
                </div>
            </a>
            <a class="item">
                <div class="ui mini statistic">
                    <div class="value">
                    <#if profiler.fansCnt lt 1000>
                    ${profiler.fansCnt}
                    <#else >
                    ${profile.fansCnt / 1000} k
                    </#if>
                    </div>
                    <div class="label">
                        粉丝
                    </div>
                </div>
            </a>
        </div>
    </div>

    <div class="row">
        <div class="sixteen wide tablet ten wide computer column">
            <div class="ui segment">
                <div class="ui feed timeline" >
                    <div class="event">
                        <div class="label" style="margin-left: 2px;">
                            <img src="/static/img/avatar/people/Abraham.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a class="user">
                                    Francis	Baldwin
                                </a> added you as a friend
                                <div class="date">
                                    1 Hour Ago
                                </div>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 4 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label" style="margin-left: 2px;">
                            <img src="/static/img/avatar/people/carol.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a>Lindsey Daniels</a> added <a>2 new illustrations</a>
                                <div class="date">
                                    4 days ago
                                </div>
                            </div>
                            <div class="extra images">
                                <a><img src="/static/img/bg/1.png" alt="bg-image" /></a>
                                <a><img src="/static/img/bg/3.png" alt="bg-image" /></a>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 1 Like
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label" style="margin-left: 2px;">
                            <img src="/static/img/avatar/people/Daryl.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a class="user">
                                    Walter	Stewart
                                </a> added you as a friend
                                <div class="date">
                                    2 Days Ago
                                </div>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 8 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label" style="margin-left: 2px;">
                            <img src="/static/img/avatar/people/deana.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a>Loretta	Burke</a> posted on his page
                                <div class="date">
                                    3 days ago
                                </div>
                            </div>
                            <div class="extra text">
                                Ours is a life of constant reruns. We're always circling back to where we'd we started, then starting all over again. Even if we don't run extra laps that day, we surely will come back for more of the same another day soon.
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 5 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label" style="margin-left: 2px;">
                            <img src="/static/img/avatar/people/enid.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a>Meredith	Barnes</a> added <a>2 new photos</a> of you
                                <div class="date">
                                    4 days ago
                                </div>
                            </div>
                            <div class="extra images">
                                <a><img src="/static/img/bg/5.png" alt="bg-image" /></a>
                                <a><img src="/static/img/bg/6.png" alt="bg-image" /></a>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 41 Likes
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="event">
                        <div class="label" style="margin-left: 2px;">
                            <img src="/static/img/avatar/people/Glenn.png"  alt="label-image"/>
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a class="user">
                                    Tami Maxwell
                                </a> added you as a friend
                                <div class="date">
                                    1 Hour Ago
                                </div>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 4 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label" style="margin-left: 2px;">
                            <img src="/static/img/avatar/people/Hershell.png" alt="label-image" >
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a>Doris Grant</a> added <a>2 new illustrations</a>
                                <div class="date">
                                    4 days ago
                                </div>
                            </div>
                            <div class="extra images">
                                <a><img src="/static/img/bg/2.png"></a>
                                <a><img src="/static/img/bg/4.png"></a>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 1 Like
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label" style="margin-left: 2px;">
                            <img src="/static/img/avatar/people/Hershell.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a class="user">
                                    Julia Anderson
                                </a> added you as a friend
                                <div class="date">
                                    2 Days Ago
                                </div>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 8 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label" style="margin-left: 2px;">
                            <img src="/static/img/avatar/people/Meggie.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a>Jennifer	Clarke</a> posted on his page
                                <div class="date">
                                    3 days ago
                                </div>
                            </div>
                            <div class="extra text">
                                Ours is a life of constant reruns. We're always circling back to where we'd we started, then starting all over again. Even if we don't run extra laps that day, we surely will come back for more of the same another day soon.
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 5 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label" style="margin-left: 2px;">
                            <img src="/static/img/avatar/people/Michonne.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a>Elizabeth Weaver</a> added <a>2 new photos</a> of you
                                <div class="date">
                                    4 days ago
                                </div>
                            </div>
                            <div class="extra images">
                                <a><img src="/static/img/bg/7.png"></a>
                                <a><img src="/static/img/bg/1.png" alt="bg-image" /></a>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 41 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="sixteen wide tablet six wide computer column">
            <div class="ui segments">
                <div class="ui segment">
                    <h3 class="ui header">${profiler.username}&nbsp;关注的人</h3>
                </div>
                <div class="ui segment">
                    <div class="ui items">
                        <#list profiler.follows as item>
                            <div class="item">
                                <div class="ui tiny rounded image">
                                    <#if item.avatar??>
                                        <img src="${ITBCNginx}/${item.avatar}" onerror="this.src='/static/img/avatar/animals/beer_128.png'" alt="label-image" />
                                    <#else >
                                        <img src="/static/img/avatar/animals/bat_128px.png" alt="label-image" />
                                    </#if>
                                    <#if item.chatStatus == 'NotOnline'>
                                        <i class="circle mini red icon avt" data-content="offline" data-variation="inverted redli"></i>
                                    <#elseif item.chatStatus == 'Online'>
                                        <i class="circle mini green icon avt" data-content="Online" data-variation="inverted greenli"></i>
                                    <#else >
                                        <i class="circle mini yellow icon avt" data-content="hide" data-variation="inverted yellowli"></i>
                                    </#if>
                                </div>
                                <div class="content">
                                    <a class="header" href="#">${item.username}</a>
                                    <div class="meta">
                                        <span class="cinema">${item.profiles}</span>
                                    </div>
                                    <div class="extra">
                                        <button class="ui inverted greenli tiny button follow" onclick="Follow.follow('${item.userId}')">关注</button>
                                        <button id="_addFriend" class="ui inverted yellowli tiny button follow" onclick="Common.addFriend('${item.userId}')">添加好友</button>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    var Follow = {
        /**
         * 关注
         * @param userId 关注人
         * @param followerId 被关注人
         */
        follow:function (followerId) {
            if(!user){
                window.location.href='/login';
                return;
            }
            if(user.userId == followerId){
                Common.notify('warning','这是一个小小的警告哦','自己不可以Follow自己[允悲][允悲][允悲]','/static/img/message/warning.png');
                return;
            }
            var params = new URLSearchParams();
            params.append('followerId',followerId);
            axios.post(ITBC.serverName+'/follow',params).then(function (response) {
                console.log(response)
                if(response.data.code == 0){
                    $('#_follow').attr('class','ui green right labeled icon button follow');
                    $('#_follow').html('已关注 <i class="checkmark icon"></i>');
                    console.log("关注成功")
                }else{
                    if(response.data.message.message=='not login'){
                        window.location.href='/login';
                    }
                }
            }).catch(function (error) {
                console.log(error);
            });
        },
        unfollow:function (followerId) {
            if(!user){
                window.location.href='/login';
                return;
            }
            var params = new URLSearchParams();
            params.append('followerId',followerId);
            axios.post(ITBC.serverName+'/unfollow',params).then(function (response) {
                console.log(response)
                if(response.data.code == 0){
                    $('#_unfollow').attr('class','ui inverted black button follow');
                    $('#_unfollow').html('关注');
                    console.log("取关成功")
                }else{
                    if(response.data.message.message=='not login'){
                        window.location.href='/login';
                    }
                }
            }).catch(function (error) {
                console.log(error);
            });
        }
    }

</script>