<div class="ui container">
    <#if spanner>
        <link rel="stylesheet" type="text/css" href="/static/plugins/jquerySFQ/index.css"/>
        <div class="pic" style="width: 100%;">
            <ul>
                <li class="pic1" style="background-image: url('/static/img/bg/1.png');border-bottom-left-radius: 4px;">
                    <a href="javascript:;">
                        <div class="txt" style="border-bottom-left-radius: 4px;">
                            <p class="p1">雨红了枫叶 ，枫叶红了山头 ，山头红了整个秋</p>
                        </div>
                    </a>
                </li>

                <li class="pic2" style="background-image: url('/static/img/bg/2.png')">
                    <a href="javascript:;">
                        <div class="txt">
                            <p class="p1">莫愁前路无知己 ,天下谁人不识君 。</p>
                        </div>
                    </a>
                </li>

                <li class="pic3" style="background-image: url('/static/img/bg/3.png');">
                    <a href="javascript:;">
                        <div class="txt">
                            <p class="p1">你能看到多远的过去 ，就能看到多远的未来。</p>
                        </div>
                    </a>
                </li>

                <li class="pic4" style="background-image: url('/static/img/bg/4.png')">
                    <a href="javascript:;">
                        <div class="txt" style="border-radius: 0 0 4px 0;">
                            <p class="p1">编不下去了 。 。 。 。  。</p>
                        </div>
                    </a>
                </li>

            </ul>
        </div>
        <script>
            $(".pic ul li").hover(function(){
                $(this).stop(true).animate({width:"825px"},1000).siblings().stop(true).animate({width:"100px"},1000);
            });
        </script>
    <#else >
        <link rel="stylesheet" type="text/css" href="/static/plugins/spanner/jPicture.min.css">
        <style>
            #imgBox{  height: 300px; margin-left: auto; margin-right: auto;border-radius: 0 0 5px 5px;}
        </style>
        <div id="imgBox">
            <div>
                <div><a href="#1"><img src="/static/img/bg/1.png"></a></div>
                <div><a href="#2"><img src="/static/img/bg/2.png"></a></div>
                <div><a href="#3"><img src="/static/img/bg/3.png"></a></div>
                <div><a href="#4"><img src="/static/img/bg/4.png"></a></div>
                <div><a href="#5"><img src="/static/img/bg/5.png"></a></div>
                <div><a href="#6"><img src="/static/img/bg/6.png"></a></div>
            </div>
        </div>
        <script src="/static/plugins/spanner/jPicture.min.js"></script>
        <script>

            // Javascript 代码
            jPicture("#imgBox", {
                type: "fade",
                autoplay: 5000
            });

        </script>
    </#if>
    <div class="ui two column grid" style="margin-top: 3em;">
        <div class="eleven wide column">
            <div class="ui items">
                <div class="ui huge breadcrumb">
                    <div class="section" style="color: #315CA0;">最新</div>
                    <div class="divider" > / </div>
                    <div class="section" style="color: #676767;">最热</div>
                    <div class="divider"> / </div>
                    <div class="section" style="color: #676767;">最新回复</div>
                </div>
                ${page.}
                <#list articles as item>
                    <div class="ui divider"></div>
                    <div class="item">
                        <a class="ui mini avatar image">
                            <#if item.anthor.avatar??>
                                <img style="35px;height: 35px;" src="${ITBCNginx}/${item.anthor.avatar}">
                            <#else >
                                <img  src="/static/img/avatar/people/Abraham.png">
                            </#if>

                        </a>
                        <div class="content">
                            <a class="header">${item.anthor.username}</a>
                            <div class="meta">
                                <a>${item.ago}</a>
                            </div>
                            <a class="title" style="font-size: 22px;color: black;" target="_blank" href="${ITBCFront}/article/${item.id}">
                                ${item.title}
                            </a>
                            <div class="ui grid" style="padding-top: 1em;">
                                <div class="stretched row">
                                    <#if true>
                                        <div class="sixteen wide tablet twelve wide computer column">
                                            <div class="description" style="font-size: 16px;">
                                                ${item.desc}
                                            </div>
                                        </div>
                                        <div class="sixteen wide tablet four wide computer column">
                                            <div class="ui small image">
                                                <img  src="/static/img/avatar/people/Glenn.png" style="border-radius: 4px;" class="transition visible">
                                            </div>
                                        </div>
                                    <#else >
                                        <div class="sixteen wide tablet sixteen wide computer column">
                                            <div class="description" style="font-size: 16px;">
                                                A description which may flow for several lines and give context to the content.A description which may flow for several lines and give context to the content.A description which may flow for several lines and give context to the content.A description which may flow for several lines and give context to the content.A description which may flow for several lines and give context to the content.
                                            </div>
                                        </div>
                                    </#if>
                                </div>
                            </div>
                            <div class="meta" style="padding-top: 1em;">
                                <a class="ui yellow basic label">feed</a>
                                <a class="like" data-content="赞" data-variation="inverted">
                                    <i class="heart red icon"></i> 8 Likes
                                </a>
                                <a class="like"  data-content="评论" data-variation="inverted">
                                    <i class="comment red icon"></i> 8 comments
                                </a>
                                <a class="like"  data-content="收藏" data-variation="inverted">
                                    <i class="star red icon"></i> 8 stars
                                </a>
                            </div>
                        </div>
                    </div>
                </#list>
                <div class="ui divider"></div>
            </div>
        </div>
        <div class="five wide column" >
            <div class="ui clearing segment">
                <h5 class="ui right floated header" style="color: #c0c0c0;cursor:pointer;"><a>我要投放</a></h5>
                <h3 class="ui left floated meta header" style="color: #676767">广告栏</h3>
                <div class="ui medium rectangle ad">
                    <img src="/static/ad.png" border="0" width="300" alt="" class="img_ad">
                </div>
            </div>
            <h3 class="ui dividing header" style="color: #676767">近期热议</h3>
            <div class="ui items">
                <div class="ui floating dropdown basic labeled icon button">
                    <i class="filter icon"></i>
                    <span class="text">分类查询</span>
                    <div class="menu" tabindex="-1">
                        <div class="ui icon search input">
                            <i class="search icon"></i>
                            <input type="text" placeholder="Search category..." tabindex="0">
                        </div>
                        <div class="divider"></div>
                        <div class="header">
                            <i class="tags icon"></i>
                            Tag Label
                        </div>
                        <div class="scrolling menu">
                            <div class="item">
                                Video
                            </div>
                            <div class="item">
                                Article
                            </div>
                            <div class="item">
                                Feed
                            </div>
                        </div>
                    </div>
                </div>
                <div class="ui icon right floated basic button" style="height: 30px;">
                    <i class="refresh small icon"></i>
                </div>
                <div class="ui right floated basic buttons">
                    <button class="ui button"><i class="chevron left icon"></i></button>
                    <button class="ui button"><i class="chevron right icon"></i></button>
                </div>
                <div class="item">
                    <a class="ui mini avatar image"">
                    <img src="/static/img/avatar/people/Abraham.png" alt="label-image">
                    </a>
                    <div class="content">
                        <div class="summary">
                            <div class="meta">
                                <a>No mapping found for HTTP request with URI</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <a class="ui mini avatar image"">
                    <img src="/static/img/avatar/people/Rick.png" alt="label-image">
                    </a>
                    <div class="content">
                        <div class="summary">
                            <div class="meta">
                                <a>No mapping found for HTTP request with URI</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <a class="ui mini avatar image"">
                    <img src="/static/img/avatar/people/enid.png" alt="label-image">
                    </a>
                    <div class="content">
                        <div class="summary">
                            <div class="meta">
                                <a>No mapping found for HTTP request with URI</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <h3 class="ui dividing header" style="color: #676767">推荐作家</h3>
            <div class="ui items">
                <div class="item">
                    <a class="ui mini avatar image"">
                        <img src="/static/img/avatar/people/carol.png" alt="label-image">
                    </a>
                    <div class="content">
                        <a class="user">Shannon Garcia</a>
                        <div class="meta">
                            <p>共500篇文章、200个粉丝</p>
                        </div>
                    </div>
                    <div class="ui right floated">
                        <a class="ui greenli label" style="margin-top: 10px;">关注</a>
                    </div>
                </div>
                <div class="item">
                    <a class="ui mini avatar image"">
                    <img src="/static/img/avatar/people/carol.png" alt="label-image">
                    </a>
                    <div class="content">
                        <a class="user">Shannon Garcia</a>
                        <div class="meta">
                            <p>共500篇文章、200个粉丝</p>
                        </div>

                    </div>
                    <div class="ui right floated">
                        <a class="ui greenli label" style="margin-top: 10px;">关注</a>
                    </div>
                </div>
                <div class="item">
                    <a class="ui mini avatar image"">
                    <img src="/static/img/avatar/people/carol.png" alt="label-image">
                    </a>
                    <div class="content">
                        <a class="user">Shannon Garcia</a>
                        <div class="meta">
                            <p>共500篇文章、200个粉丝</p>
                        </div>
                    </div>
                    <div class="ui right floated">
                        <a class="ui greenli label" style="margin-top: 10px;">关注</a>
                    </div>
                </div>
                <button class="fluid ui basic button">查看全部</button>
            </div>
            <h3 class="ui dividing header" style="color: #676767">热门专题</h3>
            <a class="ui basic image label" style="margin-top: 8px;">
                <img src="/static/img/avatar/people/Abraham.png" alt="label-image">
                Elliot3434343
            </a>
            <a class="ui basic image label" style="margin-top: 8px;">
                <img src="/static/img/avatar/people/Michonne.png" alt="label-image">
                Elliot4
            </a>
            <a class="ui basic image label" style="margin-top: 8px;">
                <img src="/static/img/avatar/people/Meggie.png" alt="label-image">
                Elliot4
            </a>
            <a class="ui basic image label" style="margin-top: 8px;">
                <img src="/static/img/avatar/people/deana.png" alt="label-image">
                Elliot33434
            </a>
            <a class="ui basic image label" style="margin-top: 8px;">
                <img src="/static/img/avatar/people/Hershell.png" alt="label-image">
                Elliot4
            </a>
            <a class="ui basic image label" style="margin-top: 8px;">
                <img src="/static/img/avatar/people/Daryl.png" alt="label-image">
                Elliot3333
            </a>
            <a class="ui basic image label" style="margin-top: 8px;">
                <img src="/static/img/avatar/people/Tara.png" alt="label-image">
                Elliot444
            </a>
            <a class="ui basic image label" style="margin-top: 8px;">
                <img src="/static/img/avatar/people/Rick.png" alt="label-image">
                Elliot22
            </a>
        </div>
    </div>
</div>