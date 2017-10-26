
//chat page settings
(function () {
    'use strict'
    var chat = {
        messageToSend: '',
        messageResponses: [
            'Why did the web developer leave the restaurant? Because of the table layout.',
            'How do you comfort a JavaScript bug? You console it.',
            'An SQL query enters a bar, approaches two tables and asks: "May I join you?"',
            'What is the most used language in programming? Profanity.',
            'What is the object-oriented way to become wealthy? Inheritance.',
            'An SEO expert walks into a bar, bars, pub, tavern, public house, Irish pub, drinks, beer, alcohol'
        ],
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
                    messageOutput: this.messageToSend,
                    time: this.getCurrentTime()
                };
                this.$chatHistoryList.append(template(context));
                this.scrollToBottom();
                this.$textarea.val('');
                var templateResponse = Handlebars.compile($('#message-response-template').html());
                var contextResponse = {
                    response: this.getRandomItem(this.messageResponses),
                    time: this.getCurrentTime()
                };
                setTimeout(function () {
                    this.$chatHistoryList.append(templateResponse(contextResponse));
                    this.scrollToBottom();
                }.bind(this), 1500);
            }
        },
        addMessage: function () {
            this.messageToSend = this.$textarea.val();

            if (websocketTool && websocketTool.onlineStatus == 1) {
                var tp =  0;
                var sendName = 'ITBC';
                var message = {
                    userId: websocketTool.user.userId,
                    userName: websocketTool.user.username,
                    type: tp,
                    content: this.messageToSend,
                    sendId: '1',
                    sendName: sendName
                };
                websocketTool.sendMessage(message);
                this.render();
            } else {
                $("#text" + type + sendId).val(content);
                layer.msg("已离线，发送失败！");
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
        }
    };
    chat.init();
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
    searchFilter.init();
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
            // var sendCheckMessage = function () {
            //     that.friends.forEach(function (friend) {
            //         if (that.checkSocket.readyState == 1) {
            //             that.checkSocket.send(friend.id);
            //         } else {
            //             if (that.onlineStatus == 1) {
            //                 that.checkAndSetStatus();
            //             }
            //         }
            //     });
            //     setTimeout(sendCheckMessage, 2000);
            // };
            //setTimeout(sendCheckMessage, 2000);
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
                    var mes = {
                        name: message.userName
                        , id: message.userId
                        , type: 'friend'
                        , content: message.content
                        , timestamp: message.timeStamp
                    };
                    if (message.type == 'GROUP') {
                        mes.type = 'group';
                        mes.groupname = message.sendName;
                        mes.id = message.sendId;
                        var group = that.groupMap[message.sendId];
                        if (group && typeof group.getMessage == "function") {
                            group.getMessage(mes);
                        }
                    } else {
                        var userInfo = that.userInfoMap[message.userId];
                        if (userInfo && typeof userInfo.getMessage == "function") {
                            userInfo.getMessage(mes);
                        }
                    }
                }
            };
        },
        sendMessage: function (message) {
            var data = {
                user: this.user,
                message: message
            };
            if (message.type == 1) {
                data.groupIds = this.groupMap[message.sendId].list;
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
    websocketTool.init(user);
}());