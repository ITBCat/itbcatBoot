
var Common = {
    /**
     * 通知
     * @param type
     * @param title
     * @param msg
     * @param img
     */
    notify:function notify(type,title,msg,img) {
        Lobibox.notify(type, {
            size: 'normal',
            rounded: false,
            delayIndicator: true,
            msg: msg,
            icon: true,
            title: title,
            showClass: 'fadeInDown',
            hideClass: 'zoomOut',
            sound: false,
            img: img,
            delay: 5000
        });
    },
    addFriend:function (frendId) {
        if (!user){
            window.location.href='/login';
            return;
        }
        if(user.userId == frendId){
            this.notify('warning','这是一个小小的警告哦','自己不能添加自己为好友，默认自己已经可以和自己聊天啦 └(^o^)┘ 。','/static/img/message/warning.png')
            return;
        }
        axios.post(ITBC.serverName+'/friend/'+frendId)
            .then(function (response) {
            console.log(response)
            if(response.data.code == 0){
                $('#_addFriend').attr('class','ui inverted greenli tiny  button follow');
                $('#_follow').html('已添加');
                console.log(response);
            }else{
                if(response.data.message.message=='not login'){
                    window.location.href='/login';
                }
            }
        }).catch(function (error) {
            console.log(error);
        });
    }
}