<!DOCTYPE html>
<html lang="zh">

<head>
    <title>ITBC - Front</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link href="/static/dist/semantic.min.css" rel="stylesheet" />
    <link rel="icon" type="image/png" href="/static/b.png" />
    <link href="/static/plugins/ionicons/css/ionicons.min.css" rel="stylesheet" />
    <link href="/static/css/main.css" rel="stylesheet" />
    <link href="/static/plugins/pacejs/pace.css" rel="stylesheet" />
    <link rel="stylesheet" href="/static/plugins/editor.md/css/editormd.css" />
</head>

<body>
    <div class="ui fluid container">
        <div id="editormd">
            <textarea id="my-editormd-markdown-doc" name="my-editormd-markdown-doc" style="display:none;"></textarea>
            <!-- 注意：name属性的值-->
            <textarea id="my-editormd-html-code" name="my-editormd-html-code" style="display:none;"></textarea>
        </div>
    </div>


    <script src="/static/js/jquery-2.1.4.min.js"></script>
    <script src="/static/plugins/editor.md/editormd.js"></script>
    <!--semantic-->
    <script src="/static/dist/semantic.min.js"></script>
    <!--semantic-->
    <script src="/static/plugins/cookie/js.cookie.js"></script>
    <script src="/static/plugins/nicescrool/jquery.nicescroll.min.js"></script>

    <script data-pace-options='{ "ajax": false }' src="/static/plugins/pacejs/pace.js"></script>

    <script src="/static/js/main.js"></script>
    <script type="text/javascript">
        var Editor;

        $(function() {
            Editor = editormd("editormd", {
                width: "100%",
                height: 740,
                path: '/static/plugins/editor.md/lib/',
                codeFold: true,
                //syncScrolling : false,
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
                imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                onload: function() {
                    console.log('onload', this);
                }
            });
        });
    </script>
</body>

</html>