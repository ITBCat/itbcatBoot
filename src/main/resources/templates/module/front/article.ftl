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
</div>
<div class="ui main container" style="padding-top: 20px;">
    <h1 class="ui fluid header" style="text-align: center;">
        ${article.title}
    </h1>
    <div class="ui two column fluid grid">
        <div class="twelve wide column">
            <div id="editormd-view" class="editormd-preview-theme-dark">
                <textarea style="display:none;">${article.md}</textarea>
            </div>
        </div>
        <div class="four wide column">
            <div class="content">
                <div class="ui header">
                    TOC
                </div>
                <div class="markdown-body editormd-preview-container" id="custom-toc-container" style="padding: 0;"></div>
            </div>
        </div>
    </div>
    <div class="ui middle aligned stackable grid container">
        <div class="row">
            <div class="center aligned column" style="font-size: large;font-weight: bold;color: grey;">
                如果觉得我的文章对您有用，请随意赞赏。您的支持将鼓励我继续创作！
            </div>
        </div>
        <div class="row">
            <div class="center aligned column">
                <button class="ui orange button big reward">打 赏</button>
            </div>
        </div>
    </div>
    <div class="ui container" style="margin-top: 20px;">
        <div id="editormd" style="border-radius: 8px;">
            <textarea class="editormd-markdown-textarea" name="md" hidden="hidden"></textarea>
            <textarea class="editormd-html-textarea" name="html" hidden="hidden"></textarea>
        </div>
        <div class="ui fluid content">
            <button class="ui right floated greenli labeled submit icon button">
                <i class="icon edit"></i> 评论
            </button>
        </div>
    </div>
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

        var Editor = editormd("editormd", {
            width: "100%",
            height: 200,
            path: '/static/plugins/editor.md/lib/',
            codeFold: true,
            toolbarIcons : function() {
                return ["undo", "redo", "|", "bold", "del", "italic", "quote", "|", "list-ul", "list-ol", "hr", "|", "image", "emoji", "table", "datetime",
                    "|", "watch", "search", "fullscreen", "|", "help"]
            },
            saveHTMLToTextarea: true, // 保存 HTML 到 Textarea
            searchReplace: true,
            //watch : false,                // 关闭实时预览
            htmlDecode: "style,script,iframe|on*", // 开启 HTML 标签解析，为了安全性，默认不开启
            emoji: true,
            taskList: true,
            tocm: true, // Using [TOCM]
            tex: true, // 开启科学公式TeX语言支持，默认关闭
            flowChart: true, // 开启流程图支持，默认关闭
            sequenceDiagram: true, // 开启时序/序列图支持，默认关闭
            imageUpload: true,
            placeholder:'写一下你的评论吧...',
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            onload: function() {
                console.log('onload', this);
            },
            previewTheme : "dark"
        });
    });
    window.onload=function () {
        $('#loading').hide();
    }
</script>
