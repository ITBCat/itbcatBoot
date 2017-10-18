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
                        <a>
                            <i class="reply icon"></i>
                        </a>
                        <a>
                            <i class="star icon"></i>
                        </a>
                        <a>
                            <i class="retweet icon"></i>
                        </a>
                        <a>
                            <i class="heart icon"></i>
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
                                <a>
                                    <i class="reply icon"></i>
                                </a>
                                <a>
                                    <i class="star icon"></i>
                                </a>
                                <a>
                                    <i class="retweet icon"></i>
                                </a>
                                <a>
                                    <i class="heart icon"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
<script type="text/javascript">
    $(function() {

        var comments = '${length}';
        for (var i = 0;i<comments;i++){
            editormd.markdownToHTML("editormd-view"+i, {
                htmlDecode      : "style,script,iframe",  // you can filter tags decode
                emoji           : true,
                taskList        : true,
                tex             : true,  // 默认不解析
                flowChart       : true,  // 默认不解析
                sequenceDiagram : true,  // 默认不解析
            });
        }
        editormd.markdownToHTML("editormd-view7", {
            htmlDecode      : "style,script,iframe",  // you can filter tags decode
            emoji           : true,
            taskList        : true,
            tex             : true,  // 默认不解析
            flowChart       : true,  // 默认不解析
            sequenceDiagram : true,  // 默认不解析
        });
    });
</script>