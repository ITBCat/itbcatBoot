/**
 * brickcat
 * @type {{}}
 */
var Editor;
var Comment = {
    init:function (commentIds) {
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
        var ids = JSON.parse(commentIds);
        if(ids.length == 0){
            $('#_commentContent').hide();
            $('#loading').hide();
            return;
        }
        for (var i = 0;i < ids.length;i++){
            editormd.markdownToHTML("editormd-view"+ids[i], {
                htmlDecode      : "style,script,iframe",  // you can filter tags decode
                emoji           : true,
                taskList        : true,
                tex             : true,  // 默认不解析
                flowChart       : true,  // 默认不解析
                sequenceDiagram : true,  // 默认不解析
            });
        }
        window.onload=function () {
            $('#loading').hide();
        }
    },
    add: function(articleId,commentId){
        /**
         * 根据评论id判断是新增还是回复
         */
        if(!commentId){
            if(!Editor.getMarkdown()){
                return;
            }
            commentId = $('#_replyId').val();
            //新增
            var comment = {
                "articleId":articleId,
                "parentId":commentId,
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
                    if(data.code == 0){
                        if(!data.data.parentId){
                            $('#_commentId').prepend(
                                '<div class="comment" style="width: 1100px;">'
                                +'<a class="avatar" style="height: 38.56px;">'
                                +'<img src="'+ITBC.ITBCNginx +'/'+ data.data.anthro.avatar +'" style="height: 35px;width: 35px;">'
                                +'</a>'
                                +'<div class="ui fluid content">'
                                +'<a class="author">'+data.data.anthro.username+'</a>'
                                +'<div class="metadata">'
                                +'<span class="date">刚刚</span>'
                                +'</div>'
                                +'<div class="description" style="font-size: 14px;color: #C1C1C1;">'
                                +'签名：一生放荡不羁爱自由。'
                                +'</div>'
                                +'<div id="editormd-view'+ data.data.id +'" class="editormd-preview-theme-dark" style="margin: 0;padding: 0;overflow:visible;">'
                                +'<textarea style="display:none;" class="fullheight">'+data.data.content+'</textarea>'
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
                                /*+'<a href="#comment" onclick="Comment.add('+data.data.articleId+','+data.data.id+')" data-content="回复" data-variation="inverted">'
                                +'<i class="reply icon"></i>'
                                +'</a>'*/
                                +'</div>'
                                +'</div>'
                                +'<div class="comments" id="'+data.data.id+'" style="display: none;">'
                                +'</div>'
                                +'</div>'
                            );
                        }else {
                            $('#'+data.data.parentId).show();
                            $('#'+data.data.parentId).prepend(
                                '<div class="comment">'
                                +'<a class="avatar" style="height: 38.56px;">'
                                +'<img src="'+ITBC.ITBCNginx +'/'+ data.data.anthro.avatar +'" style="height: 35px;width: 35px;" alt="label-image">'
                                +'</a>'
                                +'<div class="content">'
                                +'<a class="author">'+data.data.anthro.username+'</a>'
                                +'<div class="metadata">'
                                +'<span class="date">刚刚</span>'
                                +'</div>'
                                +'<div class="description" style="font-size: 14px;color: #C1C1C1;">'
                                +'签名：一生放荡不羁爱自由。'
                                +'</div>'
                                +'<div class="text">'
                                +'<div id="editormd-view'+data.data.id+'" class="editormd-preview-theme-dark" style="margin: 0;padding: 0;overflow:visible;">'
                                +'<textarea style="display:none;">'+data.data.content+'</textarea>'
                                +'</div>'
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
                                +'</div>'
                                +'</div>'
                                +'</div>'
                            );
                            $('#_reply').hide();
                            $('#_reply').html('');

                        }
                        $('#_commentContent').show();
                        Editor.clear();
                        drawcommet(data.data.id);
                        $('#_length_header').html((parseInt($('#_length').val())+1)+'条评论');
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
        }else{
            if(!ITBC.isLogin){
                window.location.href="/login";
                return;
            }
            $.ajax({
                url:ITBC.serverName+'/comment/user?commentId='+commentId,
                type:'POST', //GET
                async:true,    //或false,是否异步
                data:{},
                timeout:15000,    //超时时间
                dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
                beforeSend:function(xhr){
                    console.log(xhr)
                    console.log('发送前')
                },
                success:function(data,textStatus,jqXHR){
                    if(data.code==0){
                        //回复
                        $('#_reply').html('<i class="share icon"></i>'
                            +'<a class="ui big image label" style="height: 33.42px;width: 33.42px;">'
                            +'<img src="'+ITBC.ITBCNginx+'/'+data.data.avatar+'" style="height: 33.42px;width: 33.42px;" alt="label-image">'
                            +data.data.username
                            +'</a>'
                            + '<input type="text" value="'+commentId+'" id="_replyId" hidden="hidden"/>');
                        $('#_reply').show();
                        location.href='#comment';
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
            });
        }
    }
}

function drawcommet(_id) {
    editormd.markdownToHTML("editormd-view"+_id, {
        htmlDecode      : "style,script,iframe",  // you can filter tags decode
        emoji           : true,
        taskList        : true,
        tex             : true,  // 默认不解析
        flowChart       : true,  // 默认不解析
        sequenceDiagram : true,  // 默认不解析
    });
}
