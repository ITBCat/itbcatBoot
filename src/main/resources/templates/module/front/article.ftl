<link rel="stylesheet" href="/static/plugins/editor.md/css/editormd.preview.css" />
<link rel="stylesheet" href="/static/plugins/editor.md/css/editormd.min.css" />
<#--<div class="ui right floated" style="width: 30%; ">
    <div class="markdown-body editormd-preview-container" id="custom-toc-container"></div>
</div>-->
<div class="ui main container left floated" style="padding-top: 20px; ">
    <h1 class="ui header">
        ${article.title}
    </h1>

    <div id="editormd-view" class="editormd-preview-theme-dark">
        <textarea style="display:none;">${article.md}</textarea>
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
    });
</script>
</body>
</html>