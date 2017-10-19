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
    },
    add: function(articleId){
        $('#_commentId').prepend(
            '<div class="comment" style="width: 1100px;">'
            +'<a class="avatar" style="height: 38.56px;">'
            +'<img src="/static/img/avatar/people/Abraham.png">'
            +'</a>'
            +'<div class="ui fluid content">'
            +'<a class="author">Yin Hightower</a>'
            +'<div class="metadata">'
            +'<span class="date">Today at 5:42PM</span>'
            +'</div>'
            +'<div class="description" style="font-size: 14px;color: #C1C1C1;">'
            +'签名：一生放荡不羁爱自由。'
            +'</div>'
            +'<div id="1234567890" class="editormd-preview-theme-dark" style="margin: 0;padding: 0;overflow:visible;">'
            +'<textarea style="display:none;" class="fullheight">fff</textarea>'
            +'</div>'
            +'<div class="actions" style="margin-top: 1em;">'
            +'<a data-content="赞" data-variation="inverted">'
            +'<i class="heart icon"></i>'
            +'</a>'
            +'<a data-content="收藏" data-variation="inverted">'
            +'<i class="star icon"></i>'
            +'</a>'
            +'<a data-content="转发" data-variation="inverted">'
            +'<i class="retweet icon"></i>'
            +'</a>'
            +'<a href="#comment" onclick="replyAuthor()" data-content="回复" data-variation="inverted">'
            +'<i class="reply icon"></i>'
            +'</a>'
            +'</div>'
            +'</div>'
            +'</div>'
        );
        drawcommet('1234567890')
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
            timeout:15000,    //超时时间
            dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
            beforeSend:function(xhr){
                console.log(xhr)
                console.log('发送前')
            },
            success:function(data,textStatus,jqXHR){
                console.log(data)
                console.log(textStatus)
                console.log(jqXHR)
                if(data.code == 0){
                    $('#_commentId').prepend(
                        '<div class="comment" style="width: 1100px;">'
                        +'<a class="avatar" style="height: 38.56px;">'
                        +'<img src="/static/img/avatar/people/Abraham.png">'
                        +'</a>'
                        +'<div class="ui fluid content">'
                        +'<a class="author">Yin Hightower</a>'
                        +'<div class="metadata">'
                        +'<span class="date">Today at 5:42PM</span>'
                        +'</div>'
                        +'<div class="description" style="font-size: 14px;color: #C1C1C1;">'
                        +'签名：一生放荡不羁爱自由。'
                        +'</div>'
                        +'<div id="editormd-view${item_index}" class="editormd-preview-theme-dark" style="margin: 0;padding: 0;overflow:visible;">'
                        +'<textarea style="display:none;" class="fullheight">fff</textarea>'
                        +'</div>'
                        +'<div class="actions" style="margin-top: 1em;">'
                        +'<a data-content="赞" data-variation="inverted">'
                        +'<i class="heart icon"></i>'
                        +'</a>'
                        +'<a data-content="收藏" data-variation="inverted">'
                        +'<i class="star icon"></i>'
                        +'</a>'
                        +'<a data-content="转发" data-variation="inverted">'
                        +'<i class="retweet icon"></i>'
                        +'</a>'
                        +'<a href="#comment" onclick="replyAuthor()" data-content="回复" data-variation="inverted">'
                        +'<i class="reply icon"></i>'
                        +'</a>'
                        +'</div>'
                        +'</div>'
                        +'</div>'
                    );
                }
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

function drawcommet(_id) {
    editormd.markdownToHTML(_id, {
        htmlDecode      : "style,script,iframe",  // you can filter tags decode
        emoji           : true,
        taskList        : true,
        tex             : true,  // 默认不解析
        flowChart       : true,  // 默认不解析
        sequenceDiagram : true,  // 默认不解析
    });
}
