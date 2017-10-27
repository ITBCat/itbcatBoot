<link href="/static/css/chat-page.css" rel="stylesheet" />
<div class="ui equal width left aligned padded grid stackable">
    <!--Site Content-->
    <div class="stretched row">
        <div class="sixteen wide tablet three wide computer column">
            <div class="ui segments">
                <div class="ui segment" style="height: 40px;">
                    <h5 class="ui left floated header">
                        好友列表
                    </h5>
                    <a style="float: right;" data-content="添加好友" data-variation="inverted"><i style="font-size: large;" class="add user icon"></i></a>
                </div>
                <div class="ui segment no-padding">
                    <div class="people-list" id="people-list">
                        <div class="search">
                            <input type="text" placeholder="搜索...">
                        </div>
                        <ul class="list">
                            <#list friends as item>
                                <li class="clearfix" onclick="chat.choseFriend('${item.friend.userId}','${item.friend.username}'<#if item.friend.avatar??>,'${item.friend.avatar}'</#if>)" style="cursor:pointer;">
                                    <#if item.friend.avatar??>
                                        <img class="ui circular image" src="${ITBCNginx}/${item.friend.avatar}" onerror="this.src='/static/i.png'   " alt="label-image" />
                                    <#else >
                                        <img class="ui circular image" src="/static/i.png" alt="label-image" />
                                    </#if>
                                    <div class="about">
                                        <div class="name">${item.friend.username}</div>
                                        <div class="status">
                                            <i class="icon circle online"></i> online
                                        </div>
                                    </div>
                                </li>
                            </#list>
                        </ul>
                        <div class="clearfix"></div>
                    </div>

                    <!-- end chat -->
                </div>
            </div>
        </div>
        <div class="sixteen wide tablet thirteen wide computer column">
            <div class="ui segments">
                <div class="ui segment">
                    <h5 class="ui header">
                        聊天室
                    </h5>
                </div>
                <div class="ui segment">

                    <div class="chat">
                        <div id="_chat_header" class="chat-header clearfix" style="display: none;background:#444753;border-radius: 4px 4px 0 0; ">
                            <img id="_chat_from_avatar" class="ui circular image" src="" alt="avatar"/>
                            <div class="chat-about">
                                <div class="chat-with" style="color: white;">Chat with . . .</div>
                                <div class="chat-num-messages">already 1 902 messages</div>
                            </div>
                            <i class="fa fa-star"></i>
                        </div> <!-- end chat-header -->

                        <div class="chat-history">
                            <ul>

                            </ul>
                        </div> <!-- end chat-history -->

                        <div class="chat-message clearfix" style="background-color: #EEEEEE;">
                            <textarea name="message-to-send" id="message-to-send" placeholder="Type your message" rows="3" style="border: 2px solid #94C2ED;"></textarea>

                            <i class="fa fa-file-o"></i> &nbsp;&nbsp;&nbsp;
                            <i class="fa fa-file-image-o"></i>

                            <button id="send"><i class="send icon"></i>发送</button>
                        </div> <!-- end chat-message -->
                    </div> <!-- end chat -->
                </div>
            </div>
        </div>
    </div>
<!--Site Content-->
</div>
<script src='/static/js/handlebars.min.js'></script>
<script src='/static/js/list.min.js'></script>
<script src="/static/js/customjs/custom-chat.js"></script>
<script id="message-template" type="text/x-handlebars-template">
    <li class="clearfix">
        <div class="message-data align-right">
            <span class="message-data-time">{{time}}</span> &nbsp; &nbsp;
            <span class="message-data-name">{{name}}</span> <i class="icon circle me"></i>
        </div>
        <div class="message other-message float-right" style="white-space: normal;word-break: break-all;word-wrap: break-word;">
            {{messageOutput}}
        </div>
    </li>
</script>

<script id="message-response-template" type="text/x-handlebars-template">
    <li>
        <div class="message-data">
            <span class="message-data-name"><i class="icon circle online"></i> {{name}}</span>
            <span class="message-data-time">{{time}}</span>
        </div>
        <div class="message my-message" style="white-space: normal;word-break: break-all;word-wrap: break-word;">
            {{response}}
        </div>
    </li>
</script>
<script type="text/javascript">
    var ITBC = {
        ITBCNginx:'${ITBCNginx}'
    }
    $(function () {
        chat.init();
        searchFilter.init();
        websocketTool.init(user);
    });
</script>