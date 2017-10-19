<div class="ui container" style="margin-top: 20px;" >
    <div class="content" style="margin-bottom: 1em;" hidden="hidden" id="replyAuthor"></div>
    <div id="editormd" style="border-radius: 8px;">
        <textarea class="editormd-markdown-textarea" name="commentMd" hidden="hidden"></textarea>
        <textarea class="editormd-html-textarea" name="html" hidden="hidden"></textarea>
    </div>
    <div class="ui fluid content">
        <button class="ui right floated greenli labeled submit icon button" onclick="Comment.add('${article.id}')">
            <i class="icon edit"></i> 评论
        </button>
    </div>
</div>
<div class="ui container" style="padding-top: 50px;">
    <div class="ui right floated basic buttons" style="border: none;">
        <button class="ui labeled icon button" style="border: none;"><i class="red fire icon" style="background-color: #ffffff"></i>按热度排序</button>
        <button class="ui labeled icon button" style="border: none;"><i class="orange long arrow up icon" style="background-color: #ffffff"></i>按时间正序</button>
        <button class="ui labeled icon button" style="border: none;"><i class="yellow long arrow down icon" style="background-color: #ffffff"></i>按时间倒序</button>
    </div>
    <h2 class="ui horizontal divider header">6条 评论 </h2>
    <div class="ui fluid threaded big comments" >
        <#list data as item>
            <div class="comment" style="width: 1100px;">
                <a class="avatar" style="height: 38.56px;">
                    <img src="/static/img/avatar/people/Abraham.png">
                </a>
                <div class="ui fluid content">
                    <a class="author">Yin Hightower</a>
                    <div class="metadata">
                        <span class="date">Today at 5:42PM</span>
                    </div>
                    <div class="description" style="font-size: 14px;color: #C1C1C1;">
                        签名：一生放荡不羁爱自由。
                    </div>
                    <div class="text">
                        <div id="editormd-view${item_index}" class="editormd-preview-theme-dark" style="margin: 0;padding: 0;">
                            <textarea style="display:none;">
##### 代码块里包含的过滤标签及属性不会被过滤

```html
&lt;style type="text/style"&gt;
body{background:red;}
&lt;/style&gt;

&lt;script type="text/javscript"&gt;
alert("script");
&lt;/script&gt;

&lt;iframe height=498 width=510 src="http://player.youku.com/embed/XMzA0MzIwMDgw" frameborder=0 allowfullscreen&gt;&lt;/iframe&gt;
```
                            </textarea>
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
                        <a href="#comment" onclick="replyAuthor()" data-content="回复" data-variation="inverted">
                            <i class="reply icon"></i>
                        </a>
                    </div>
                </div>
                <div class="comments">
                    <div class="comment">
                        <a class="avatar" style="height: 38.56px;">
                            <img src="/static/img/avatar/people/Michonne.png" alt="label-image">
                        </a>
                        <div class="content">
                            <a class="author">Ufuoma Tómasson</a>
                            <div class="metadata">
                                <span class="date">Just now</span>
                            </div>
                            <div class="description" style="font-size: 14px;color: #C1C1C1;">
                                签名：一生放荡不羁爱自由。
                            </div>
                            <div class="text">
                                <div id="editormd-view7" class="editormd-preview-theme-dark" style="margin: 0;padding: 0;">
                                    <textarea style="display:none;">
##### 代码块里包含的过滤标签及属性不会被过滤

```html
&lt;style type="text/style"&gt;
body{background:red;}
&lt;/style&gt;

&lt;script type="text/javscript"&gt;
alert("script");
&lt;/script&gt;

&lt;iframe height=498 width=510 src="http://player.youku.com/embed/XMzA0MzIwMDgw" frameborder=0 allowfullscreen&gt;&lt;/iframe&gt;
```</textarea>
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
                </div>
            </div>
        </#list>
    </div>
    <div class="ui fluid content">
        <div class="ui two attached big buttons">
            <button class="ui labeled icon button" style="border-radius: 2px 0 0 2px;"><i class="left arrow icon"></i> 上一页 </button>
            <button class="ui right labeled icon button" style="border-radius: 0 2px 2px; 0;">下一页 <i class="right arrow icon"></i> </button>
        </div>
    </div>
</div>
<script type="text/javascript" src="/static/js/common/comment.js"></script>
<script type="text/javascript">
    $(function () {
        Comment.init('${parents}','${comments}');
    });

    function replyAuthor() {
        $('#replyAuthor').html('<i class="share icon"></i>'
                +'<a class="ui big image label" style="height: 33.42px;">'
                +'<img src="/static/img/avatar/people/Glenn.png" alt="label-image">'
                +'Glenn'
                +'</a>');
        $('#replyAuthor').show();
    }
</script>