<div class="ui equal width left aligned padded grid stackable" style="background-color: #F1F4F5;">
    <div class="sixteen wide tablet sixteen wide computer column profileheader row no-padding">
        <div class="column  left floated">
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
                        <div class="meta">
                        <a href="http://${profiler.website}" target="_blank">http://${profiler.website}</a>
                        </div>
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
                <button class="ui circular facebook icon button">
                    <i class="facebook icon"></i>
                </button>
                <button class="ui circular twitter icon button">
                    <i class="twitter icon"></i>
                </button>
                <button class="ui circular linkedin icon button">
                    <i class="linkedin icon"></i>
                </button>
                <button class="ui circular google plus icon button">
                    <i class="google plus icon"></i>
                </button>
                <button class="ui circular instagram icon button">
                    <i class="instagram icon"></i>
                </button>
                <div class="ui divider"></div>
                <button class="ui inverted black button follow" id="_follow" onclick="Follow.follow('${profiler.userId}')">关注</button>
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
                        1.6k
                    </div>
                    <div class="label">
                        Followers
                    </div>
                </div>
            </a>
            <a class="item">
                <div class="ui mini statistic">
                    <div class="value">
                        102
                    </div>
                    <div class="label">
                        Following
                    </div>
                </div>
            </a>
            <a class="item">
                <div class="ui mini statistic">
                    <div class="value">
                        206
                    </div>
                    <div class="label">
                        Activities
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
                    <h3 class="ui header">Follow Suggestions</h3>
                </div>
                <div class="ui segment">
                    <div class="ui items">

                        <div class="item">
                            <div class="ui tiny rounded image">
                                <img src="/static/img/avatar/people/Abraham.png" alt="label-image" />
                                <i class="circle mini green icon avt" data-content="Online" data-variation="inverted greenli"></i>
                            </div>
                            <div class="content">
                                <a class="header" href="#">Gwen Randolph</a>
                                <div class="meta">
                                    <span class="cinema">Irure ex aute dolor minim sit. Enim eiusmod cillum incididunt fugiat</span>
                                </div>
                                <div class="description">
                                    <p></p>
                                </div>
                                <div class="extra">
                                    <button class="ui greenli inverted tiny button follow">Follow</button>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="ui rounded tiny image">
                                <img src="/static/img/avatar/people/carol.png" alt="label-image" />
                                <i class="circle mini green icon avt" data-content="Online" data-variation="inverted greenli"></i>
                            </div>
                            <div class="content">
                                <a class="header">Ashley Ross</a>
                                <div class="meta">
                                    <span class="cinema">Ea nostrud adipisicing ut et sint culpa et ut esse minim Lorem ex voluptate ex</span>
                                </div>
                                <div class="description">
                                    <p></p>
                                </div>
                                <div class="extra">
                                    <button class="ui greenli inverted tiny button follow">Follow</button>
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <div class="ui rounded tiny image">
                                <img src="/static/img/avatar/people/Daryl.png" alt="label-image" />
                                <i class="circle mini red icon avt" data-content="Offline" data-variation="inverted redli"></i>
                            </div>
                            <div class="content">
                                <a class="header">Trina Marquez</a>
                                <div class="meta">
                                    <span class="cinema">Excepteur ut elit dolor officia consequat do duis cillum culpa pariatur</span>
                                </div>
                                <div class="description">
                                    <p></p>
                                </div>
                                <div class="extra">
                                    <button class="ui greenli inverted tiny button follow">Follow</button>
                                </div>
                            </div>
                        </div>
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
            axios.post(ITBC.serverName+'/follow', {
                followerId: followerId
            }).then(function (response) {
                console.log(response)
                if(response.data.code == 0){
                    $('#_follow').attr('class','ui green button follow');
                    $('#_follow').html('<i class="checkmark icon"></i> 已关注');
                    console.log("关注成功")
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