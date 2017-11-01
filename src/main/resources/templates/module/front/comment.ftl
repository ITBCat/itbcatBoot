<div class="ui container" style="margin-top: 20px;" >
    <div class="content" style="margin-bottom: 1em;" hidden="hidden" id="_reply"></div>
    <div id="editormd" style="border-radius: 8px;z-index: 0;">
        <textarea class="editormd-markdown-textarea" name="commentMd" hidden="hidden"></textarea>
        <textarea class="editormd-html-textarea" name="html" hidden="hidden"></textarea>
    </div>
    <div class="ui fluid content" style="padding-bottom: 50px;">
        <button class="ui right floated greenli labeled submit icon button" onclick="Comment.add('${article.id}')">
            <i class="icon edit"></i> 评论
        </button>
    </div>
</div>

<div class="ui container" id="_commentContent">
    <div class="ui right floated basic buttons" style="border: none;">
        <button class="ui labeled icon button" style="border: none;"><i class="red fire icon" style="background-color: #ffffff"></i>按热度排序</button>
        <button class="ui labeled icon button" style="border: none;"><i class="orange long arrow up icon" style="background-color: #ffffff"></i>按时间正序</button>
        <button class="ui labeled icon button" style="border: none;"><i class="yellow long arrow down icon" style="background-color: #ffffff"></i>按时间倒序</button>
    </div>
    <h2 class="ui horizontal divider header" id="_length_header">${length}条评论</h2>
    <input id="_length" type="text" value="${length}" hidden="hidden"/>
    <div class="ui fluid threaded big comments" id="_commentId">
        <#list article.comments as item>
            <div class="comment" style="width: 1100px;">
                <a class="avatar" style="height: 38.56px;">
                    <img style="height: 35px;width: 35px;" src="${ITBCNginx}/${item.anthro.avatar}" onerror="this.src='/static/i.png'">
                </a>
                <div class="ui fluid content">
                    <a class="author">${item.anthro.username}</a>
                    <div class="metadata">
                        <span class="date">${item.ago}</span>
                    </div>
                    <div class="description" style="font-size: 14px;color: #C1C1C1;">
                        签名：一生放荡不羁爱自由。
                    </div>
                    <div id="editormd-view${item.id}" class="editormd-preview-theme-dark" style="margin: 0;padding: 0;overflow:visible;">
                        <textarea style="display:none;" class="fullheight">${item.content}</textarea>
                    </div>
                    <div class="actions" style="margin-top: 1em;">
                        <a data-content="赞" data-variation="inverted">
                            <i class="heart icon"></i>
                        </a>
                        <a data-content="收藏" data-variation="inverted">
                            <i class="star icon"></i>
                        </a>
                        <a data-content="转发" data-variation="inverted">
                            <i class="retweet icon"></i>
                        </a>
                        <#if item.isMine != isLogin>
                            <a onclick="Comment.add('${article.id}','${item.id}')" data-content="回复" data-variation="inverted">
                                <i class="reply icon"></i>
                            </a>
                        </#if>
                    </div>
                </div>
                <div class="comments" id="${item.id}">
                    <#if item.comments??>
                        <#list item.comments as child>
                            <div class="comment">
                                <a class="avatar" style="height: 38.56px;">
                                    <img style="height: 35px;width: 35px;" src="${ITBCNginx}/${child.anthro.avatar}" onerror="this.src='/static/i.png'" alt="label-image">
                                </a>
                                <div class="content">
                                    <a class="author">${child.anthro.username}</a>
                                    <div class="metadata">
                                        <span class="date">${child.ago}</span>
                                    </div>
                                    <div class="description" style="font-size: 14px;color: #C1C1C1;">
                                        签名：一生放荡不羁爱自由。
                                    </div>
                                    <div class="text">
                                        <div id="editormd-view${child.id}" class="editormd-preview-theme-dark" style="margin: 0;padding: 0;overflow:visible;">
                                            <textarea style="display:none;">${child.content}</textarea>
                                        </div>
                                    </div>
                                    <div class="actions" style="margin-top: 1em;">
                                        <a data-content="赞" data-variation="inverted">
                                            <i class="heart icon"></i>
                                        </a>
                                        <a data-content="收藏" data-variation="inverted">
                                            <i class="star icon"></i>
                                        </a>
                                        <a data-content="转发" data-variation="inverted">
                                            <i class="retweet icon"></i>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </#list>
                    </#if>
                </div>
            </div>
        </#list>
    </div>
    <div class="ui fluid content" style="z-index: 0;">
        <div class="ui two attached big buttons">
            <button class="ui labeled icon button" style="border-radius: 2px 0 0 2px;"><i class="left arrow icon"></i> 上一页 </button>
            <button class="ui right labeled icon button" style="border-radius: 0 2px 2px; 0;">下一页 <i class="right arrow icon"></i> </button>
        </div>
    </div>
</div>

<script type="text/javascript" src="/static/js/common/comment.js"></script>
<script type="text/javascript">
    $(function () {
        Comment.init('${commentIds}');
    });
</script>
