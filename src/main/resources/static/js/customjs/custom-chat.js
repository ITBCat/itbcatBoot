

var chat = {
    messageToSend: '',
    messageResponses: '',
    receiveId:'',
    receiveName:'',
    init: function () {
        this.cacheDOM();
        this.bindEvents();
        this.render();
    },
    cacheDOM: function () {
        this.$chatHistory = $('.chat-history');
        this.$button = $('button');
        this.$textarea = $('#message-to-send');
        this.$chatHistoryList = this.$chatHistory.find('ul');
    },
    bindEvents: function () {
        this.$button.on('click', this.addMessage.bind(this));
        this.$textarea.on('keyup', this.addMessageEnter.bind(this));
    },
    render: function () {
        this.scrollToBottom();
        if (this.messageToSend.trim() !== '') {
            var template = Handlebars.compile($('#message-template').html());
            var context = {
                name:user.username,
                messageOutput: this.messageToSend,
                time: timestampFormat(Date.parse(new Date()))
            };
            this.$chatHistoryList.append(template(context));
            this.scrollToBottom();

        }
    },
    addMessage: function () {
        if(chat.receiveId != ''){
            this.messageToSend = this.$textarea.val();
            if (this.messageToSend.trim() !== '') {
                if (websocketTool && websocketTool.onlineStatus == 1) {
                    var tp = 0;
                    var sendName = 'ITBC';
                    var message = {
                        userId: websocketTool.user.userId,
                        userName: websocketTool.user.username,
                        type: tp,
                        content: this.messageToSend,
                        receiveId: chat.receiveId,
                        receiveName: chat.receiveName
                    };
                    websocketTool.sendMessage(message);
                    this.$textarea.val('');
                    this.render();
                } else {
                    console.log("lixian")
                }
            }
        }else{

        }
    },
    addMessageEnter: function (event) {
        if (event.keyCode === 13) {
            this.addMessage();
        }
    },
    scrollToBottom: function () {
        this.$chatHistory.scrollTop(this.$chatHistory[0].scrollHeight);
    },
    getCurrentTime: function () {
        return new Date().toLocaleTimeString().replace(/([\d]+:[\d]{2})(:[\d]{2})(.*)/, '$1$3');
    },
    getRandomItem: function (arr) {
        return arr[Math.floor(Math.random() * arr.length)];
    },
    choseFriend:function (receiveId,receiveName,avatar) {
        chat.receiveId = receiveId;
        chat.receiveName = receiveName;
        $('.chat-with').html(' '+receiveName);
        if(avatar){
            $('#_chat_from_avatar').attr('src',ITBC.ITBCNginx+'/'+avatar);
        }else {
            $('#_chat_from_avatar').attr('src','/static/i.png');
        }
        $('#_chat_header').show();
    }
};

var searchFilter = {
    options: { valueNames: ['name'] },
    init: function () {
        var userList = new List('people-list', this.options);
        var noItems = $('<li id="no-items-found">No items found</li>');
        userList.on('updated', function (list) {
            if (list.matchingItems.length === 0) {
                $(list.list).append(noItems);
            } else {
                noItems.detach();
            }
        });
    }
};

var websocketRoot = "ws://" + window.location.host;
console.log("websocketRoot:", websocketRoot);
var websocketTool = {
    chatUri: websocketRoot + "/im/",
    assistUri: websocketRoot + "/imAssist",
    user: {},
    friends: [],
    groups: [],
    onlineStatus: 1,
    socket: {},
    checkSocket: {},
    userInfoMap: {},
    groupMap: {},
    init: function (user) {
        var that = this;
        // this.friends = friends;
        // this.friends.forEach(function (fr) {
        //     that.userInfoMap[fr.id] = fr;
        // });
        this.user = user;
        // this.groups = groups;
        // this.groups.forEach(function (group) {
        //     that.groupMap[group.id] = group;
        // });
        this.chatUri += user.userId;
        this.resetSocket();
        var sendCheckMessage = function () {
            // that.friends.forEach(function (friend) {
            //     if (that.checkSocket.readyState == 1) {
            //         that.checkSocket.send(friend.id);
            //     } else {
            //         if (that.onlineStatus == 1) {
            //             that.checkAndSetStatus();
            //         }
            //     }
            // });
            setTimeout(sendCheckMessage, 2000);
        };
        setTimeout(sendCheckMessage, 2000);
    },
    resetSocket: function () {
        var that = this;
        this.checkSocket = new WebSocket(this.assistUri);
        this.socket = new WebSocket(this.chatUri);
        this.socket.onopen = function (event) {
            that.sendMessage({});
            that.checkAndSetStatus();
        };
        this.socket.onerror = function (e) {
            console.error('websocket is error:', e, socket);
            that.checkAndSetStatus();
        };
        this.checkSocket.onopen = function (event) {
            console.log('the checkSocket is open..............')
        };
        this.checkSocket.onmessage = function (event) {
            var message = JSON.parse(event.data);
            var userInfo = that.userInfoMap[message.id];
            if (userInfo && typeof userInfo.setFriendStatus == "function") {
                userInfo.setFriendStatus(message.id, message.online);
            }
        };
        this.socket.onmessage = function (event) {
            var message = JSON.parse(event.data);
            if (message.sendType == "LEAVE") {
                that.socket.close();
                that.checkSocket.close();
                alert("被他人挤下线！！");
                that.onlineStatus = 0;
                that.notOnlineEvent();
            } else {
                console.log('onmessage.message:', message);
                $('.chat-with').html(' '+message.username);
                if(message.userAvatar){
                    $("#_chat_from_avatar").attr("src", ITBC.ITBCNginx+'/'+message.userAvatar);
                }else{
                    $("#_chat_from_avatar").attr("src", "/static/i.png");
                }
                $('#_chat_header').show();
                chat.receiveId=message.userId;
                chat.receiveName=message.userName;
                var templateResponse = Handlebars.compile($('#message-response-template').html());
                var contextResponse = {
                    name: message.username,
                    response: message.content,
                    time: timestampFormat(message.timeStamp)
                };

                setTimeout(function () {
                    chat.$chatHistoryList.append(templateResponse(contextResponse));
                    chat.scrollToBottom();
                }.bind(chat), 1500);
            }
        };
    },
    sendMessage: function (message) {
        var data = {
            user: this.user,
            message: message
        };
        if (message.type == 1) {
            data.groupIds = this.groupMap[message.receiveId].list;
        }
        this.socket.send(JSON.stringify(data));
    },
    checkAndSetStatus: function () {
        if (this.socket.readyState == 1) {
            this.onlineStatus = 1;
            this.onlineEvent();
        } else {
            this.onlineStatus = 0;
            this.notOnlineEvent();
        }
    },
    setOnlineStatus: function (status) {
        if (status != this.user.onlineStatus) {
            this.user.status = parseInt(status);
            if (status == 1 && this.user.status == 0) {
                this.resetSocket();
            } else if (status == 0) {
                this.socket.close();
                this.checkSocket.close();
            } else {
                this.sendMessage({});
            }
        }
    },
    onlineEvent: function () {

    },
    notOnlineEvent: function () {

    }
};
function timestampFormat( timestamp ) {
    function zeroize( num ) {
        return (String(num).length == 1 ? '0' : '') + num;
    }

    var curTimestamp = parseInt(new Date().getTime() / 1000); //当前时间戳
    var timestampDiff = curTimestamp - timestamp; // 参数时间戳与当前时间戳相差秒数

    var curDate = new Date( curTimestamp * 1000 ); // 当前时间日期对象
    var tmDate = new Date( timestamp * 1000 );  // 参数时间戳转换成的日期对象

    var Y = tmDate.getFullYear(), m = tmDate.getMonth() + 1, d = tmDate.getDate();
    var H = tmDate.getHours(), i = tmDate.getMinutes(), s = tmDate.getSeconds();

    if ( timestampDiff < 60 ) { // 一分钟以内
        return "刚刚";
    } else if( timestampDiff < 3600 ) { // 一小时前之内
        return Math.floor( timestampDiff / 60 ) + "分钟前";
    } else if ( curDate.getFullYear() == Y && curDate.getMonth()+1 == m && curDate.getDate() == d ) {
        return '今天' + zeroize(H) + ':' + zeroize(i);
    } else {
        var newDate = new Date( (curTimestamp - 86400) * 1000 ); // 参数中的时间戳加一天转换成的日期对象
        if ( newDate.getFullYear() == Y && newDate.getMonth()+1 == m && newDate.getDate() == d ) {
            return '昨天' + zeroize(H) + ':' + zeroize(i);
        } else if ( curDate.getFullYear() == Y ) {
            return  zeroize(m) + '月' + zeroize(d) + '日 ' + zeroize(H) + ':' + zeroize(i);
        } else {
            return  Y + '年' + zeroize(m) + '月' + zeroize(d) + '日 ' + zeroize(H) + ':' + zeroize(i);
        }
    }
}
