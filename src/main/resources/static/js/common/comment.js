/**
 * brickcat
 * @type {{}}
 */
var Editor;
var Comment = {
    init:function (parents,comments) {
        var comments = '${length}';
        Editor = editormd("editormd", {
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
        for (var i = 0;i < parents;i++){
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
    },
    add: function(articleId){
        if(!Editor.getMarkdown()){
            return;
        }
        var comment = {
            "articleId":articleId,
            "content":Editor.getMarkdown().toString()
        }

        $.ajax({
            url:ITBC.serverName+'/comment/add',
            type:'POST', //GET
            async:true,    //或false,是否异步
            data:comment,
            timeout:5000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            beforeSend:function(xhr){
                console.log(xhr)
                console.log('发送前')
            },
            success:function(data,textStatus,jqXHR){
                console.log(data)
                console.log(textStatus)
                console.log(jqXHR)
            },
            error:function(xhr,textStatus){
                console.log('错误')
                console.log(xhr)
                console.log(textStatus)
            },
            complete:function(){
                console.log('结束')
            }
        })

    }
}

