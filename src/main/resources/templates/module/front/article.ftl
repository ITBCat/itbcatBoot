<link rel="stylesheet" href="/static/plugins/editor.md/css/editormd.preview.css" />
<link rel="stylesheet" href="/static/plugins/editor.md/css/editormd.min.css" />
<div class="ui text container" id="loading">
    <img class="wireframe" src="/static/img/wireframe/media-paragraph.png">
    <img class="wireframe" style="margin-top: 1em;" src="/static/img/wireframe/paragraph.png">
    <img class="wireframe" style="margin-top: 1em;" src="/static/img/wireframe/paragraph.png">
    <img class="wireframe" style="margin-top: 1em;" src="/static/img/wireframe/paragraph.png">
    <img class="wireframe" style="margin-top: 1em;" src="/static/img/wireframe/paragraph.png">
    <img class="wireframe" style="margin-top: 1em;" src="/static/img/wireframe/paragraph.png">
    <img class="wireframe" style="margin-top: 1em;" src="/static/img/wireframe/paragraph.png">
    <img class="wireframe" style="margin-top: 1em;" src="/static/img/wireframe/paragraph.png">
    <img class="wireframe" style="margin-top: 1em;" src="/static/img/wireframe/paragraph.png">
    <img class="wireframe" style="margin-top: 1em;" src="/static/img/wireframe/paragraph.png">
</div>
<div class="ui main container" style="padding-top: 20px;" id="loaded">
    <div class="ui items">
        <div class="item" style="border-left: 5px solid #BABABA;padding-top: 5px;padding-bottom: 5px;">
            <div class="ui two column middle aligned stackable grid" style="width: 100%;">
                <div class="eleven wide column">
                    <a class="ui avatar image" style="height: 65px;width: 65px; float: left;margin-left: 1em;margin-top: 10px;">
                    <#if article.anthor.avatar??>
                        <img style="height: 60px;width: 60px;" src="${ITBCNginx}/${article.anthor.avatar}" onerror="this.src='/static/img/avatar/people/Abraham.png'">
                    <#else >
                        <img  style="height: 60px;width: 60px;" src="/static/img/avatar/people/Abraham.png">
                    </#if>
                    </a>
                    <div class="content" style="float: left;margin-left: 1em;">
                        <a class="header">
                        ${article.anthor.username}
                        </a>
                        <div class="meta">
                            <a>Feed</a> ·
                            <a>${length} 评论</a> ·
                            <a>78 浏览</a> ·
                            <a>${article.ago}</a>

                        </div>
                        <div class="meta">
                            真理惟一可靠的标准就是永远自相符合。
                        </div>
                    </div>
                </div>
                <div class="five wide column">
                    <div class="center aligned column">
                        <div class="meta">
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
            </div>
        </div>
    </div>
    <h1 class="ui fluid header" style="text-align: center;">
        ${article.title}
    </h1>
    <div class="ui two column fluid grid">
        <div class="twelve wide column">
            <div id="editormd-view" class="editormd-preview-theme-dark">
                <textarea style="display:none;">${article.md}</textarea>
            </div>
        </div>
        <div class="four wide column" style="margin-top: 2em;">
            <div class="content" id="_toc">
                <div class="ui header">
                    TOC
                </div>
                <div class="markdown-body editormd-preview-container" id="custom-toc-container" style="padding: 0;"></div>
            </div>
        </div>
    </div>
    <div class="ui middle aligned stackable grid container" >
        <div class="row">
            <div class="center aligned column" style="font-size: large;font-weight: bold;color: grey;" id="comment">
                如果觉得我的文章对您有用，请随意赞赏。您的支持将鼓励我继续创作！
            </div>
        </div>
        <div class="row" >
            <div class="center aligned column">
                <button class="ui orange button big reward">打 赏</button>
            </div>
        </div>
    </div>
    <#--评论-->
    <#include "comment.ftl"/>
</div>

<div class="ui small modal">
    <div class="ui header" style="text-align: center;">
        <img class="ui mini circular image" src="/static/img/avatar/people/enid.png" alt="label-image"> 打赏
    </div>
    <div class="content">
        <div class="ui two column doubling grid container">
            <div class="column">
                <div class="ui horizontal center aligned big segment">
                    <i class="like red icon"></i>
                    2 元
                </div>
            </div>
            <div class="column">
                <div class="ui horizontal center aligned big segment">
                    <i class="like red icon"></i>
                    3 元
                </div>
            </div>
            <div class="column">
                <div class="ui horizontal center aligned big segment">
                    <i class="like red icon"></i>
                    5 元
                </div>
            </div>
            <div class="column">
                <div class="ui horizontal center aligned big segment">
                    <i class="like red icon"></i>
                    8 元
                </div>
            </div>
            <div class="column">
                <div class="ui horizontal center aligned big segment">
                    <i class="like red icon"></i>
                    10 元
                </div>
            </div>
            <div class="column">
                <div class="ui horizontal center aligned big segment" style="padding: 0;">
                    <i class="like red icon"></i>
                    <div class="ui right labeled mini input" style="width: 20%;padding-top: 10px;">
                        <input type="text" placeholder="自定义">
                        <div class="ui basic label" >元 </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="ui divider"></div>
        <div class="ui middle aligned stackable grid container">
            <div class="row">
                <div class="center aligned column">
                    <button class="ui orange button big reward">支 付</button>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- <script src="js/zepto.min.js"></script>
<script>
    var jQuery = Zepto;  // 为了避免修改flowChart.js和sequence-diagram.js的源码，所以使用Zepto.js时想支持flowChart/sequenceDiagram就得加上这一句
</script> -->
<script src="/static/plugins/editor.md/lib/marked.min.js"></script>
<script src="/static/plugins/editor.md/lib/prettify.min.js"></script>
<script src="/static/plugins/editor.md/lib/raphael.min.js"></script>
<script src="/static/plugins/editor.md/lib/underscore.min.js"></script>
<script src="/static/plugins/editor.md/lib/sequence-diagram.min.js"></script>
<script src="/static/plugins/editor.md/lib/flowchart.min.js"></script>
<script src="/static/plugins/editor.md/lib/jquery.flowchart.min.js"></script>

<script src="/static/plugins/editor.md/editormd.js"></script>
<script type="text/javascript">

    $(function() {
        $(".modalactionone").on("click", function () {
            $(".ui.actionmodal").modal({
                closable: false,
                onDeny: function () {
                    window.alert("OOooopps! You must read this..");
                    return false;
                },
                onApprove: function () {
                    window.alert("Yess He is a Best Footballer in Holland now!");
                }
            }).modal("show");
        });
        var Editormd = editormd.markdownToHTML("editormd-view", {
            htmlDecode      : "style,script,iframe",  // you can filter tags decode
            //toc             : false,
            tocm: true, // Using [TOCM]
            tocContainer: "#custom-toc-container", // 自定义 ToC 容器层
            emoji           : true,
            taskList        : true,
            tex             : true,  // 默认不解析
            flowChart       : true,  // 默认不解析
            sequenceDiagram : true,  // 默认不解析
        });

        var toc = $('#custom-toc-container').html();
        var f = '<div class="markdown-toc editormd-markdown-toc"><ul class="markdown-toc-list"></ul></div>';
        if(toc==f){
            $('#_toc').hide();
        }else {
            $('#_toc').show();
        }
    });
    var ITBC={
        serverName:'${ITBCFront}',
        ITBCNginx:'${ITBCNginx}',
        <#if isLogin>
        isLogin:true,
        <#else >
        isLogin:false,
        </#if>

    };

</script>
