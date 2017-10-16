<!DOCTYPE html>
<html lang="zh">

<head>
    <title>ITBC - 文章发布</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link href="/static/dist/semantic.min.css" rel="stylesheet" />
    <link rel="icon" type="image/png" href="/static/i.png" />
    <link href="/static/plugins/ionicons/css/ionicons.min.css" rel="stylesheet" />
    <link href="/static/css/main.css" rel="stylesheet" />
    <link href="/static/plugins/pacejs/pace.css" rel="stylesheet" />
    <link rel="stylesheet" href="/static/plugins/editor.md/css/editormd.min.css" />
    <link rel="stylesheet" href="/static/plugins/tageditor/fm.tagator.jquery.css" />
</head>
<body>
    <div class="ui fluid whiteli container">
        <form class="ui form" action="/f/put" method="post" id="formid">
            <div class="ui left fluid massive input" style="margin: 0 ;">
                <input type="text" placeholder="标题" name="title">
            </div>
            <div id="editormd" style="border: none;margin: 0 ;">
                <textarea class="editormd-markdown-textarea" name="md"></textarea>
                <textarea class="editormd-html-textarea" name="html"></textarea>
            </div>
            <div class="ui left fluid input" >
                <input type="text" id="inputTagator" placeholder="标签" style="padding: 0;">
            </div>
            <input type="text" name="tags" id="tags" hidden="hidden">
        </form>

        <div class="ui fluid content">
            <div class="ui right floated big buttons" style="margin-right: 50px;">
                <button class="ui yellowli labeled icon button" onclick="history.go(-1)">
                    <i class="left chevron icon"></i>
                    首页
                </button>
                <button class="ui green labeled icon button" onclick="goSubmit()">
                    <i class="save icon"></i>
                    保存
                </button>
                <button class="ui brown labeled icon button">
                    <i class="cloud icon"></i>
                    草稿
                </button>
            </div>
        </div>
    </div>


    <script src="/static/plugins/editor.md/plugins/jquery.min.js"></script>
    <script src="/static/plugins/editor.md/editormd.js"></script>
    <!--semantic-->
    <script src="/static/dist/semantic.min.js"></script>
    <!--semantic-->
    <script src="/static/plugins/cookie/js.cookie.js"></script>
    <script src="/static/plugins/nicescrool/jquery.nicescroll.min.js"></script>
    <script src="/static/plugins/tageditor/fm.tagator.jquery.js"></script>

    <script data-pace-options='{ "ajax": false }' src="/static/plugins/pacejs/pace.js"></script>

    <script src="/static/js/main.js"></script>
    <script type="text/javascript">
        var Editor;

        function goSubmit() {
            document.getElementById("formid").submit();
        }
        
        $(function() {
            $('#inputTagator').tagator({
                autocomplete: ['first', 'second', 'third', 'fourth', 'fifth', 'sixth', 'seventh', 'eighth', 'ninth', 'tenth', '��ǩ']
            });
            Editor = editormd("editormd", {
                width: "100%",
                height: 740,
                path: '/static/plugins/editor.md/lib/',
                codeFold: true,
                toolbarIcons : function() {
                    return ["undo", "redo", "|", "bold", "del", "italic", "quote", "|", "list-ul", "list-ol", "hr", "|", "image", "emoji", "table", "datetime",
                        "|", "watch", "search", "fullscreen", "|", "help"]
                },
                saveHTMLToTextarea: true, // 保存 HTML 到 Textarea
                placeholder: '遨遊在文字的海洋中吧~',
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
                imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                onload: function() {
                    console.log('onload', this);
                },
                previewTheme : "dark"
            });
        });
    </script>
</body>

</html>