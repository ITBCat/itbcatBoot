<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from telatkaya.com/stagb/blank.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 16:00:22 GMT -->
<head>
    <title>ITBC - Front</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
    <link href="/static/dist/semantic.min.css" rel="stylesheet" />
    <link href="/static/plugins/ionicons/css/ionicons.min.css" rel="stylesheet" />
    <link href="/static/css/main.css" rel="stylesheet" />
    <link href="/static/plugins/pacejs/pace.css" rel="stylesheet" />
    
</head>
<body>
    <div id="contextWrap" style="height: 100%;">
        <div class="pusher">
            <!--navbar-->
            <div class="navwrap">
                <div class="ui menu icon borderless grid" data-color="inverted white">
                    <div class="item ui colhidden">

                    </div>
                    <div class="right menu colhidden">
                        <div class="right item ui colhidden">
                            <div class="ui icon input">
                                <input type="text" placeholder="Search...">
                                <i class="search icon"></i>
                            </div>
                        </div>
                        <div class="ui dropdown item">
                            <i class="bell big icon"></i>
                            <div class="menu">
                                <div class="header">
                                    People You Might Know
                                </div>
                                <div class="item">
                                    <img class="ui avatar image" src="img/avatar/people/enid.png" alt="label-image" /> Janice Robinson
                                </div>
                                <div class="item">
                                    <img class="ui avatar image" src="img/avatar/people/Hershell.png" alt="label-image" /> Cynthia May
                                </div>
                                <div class="item">
                                    <img class="ui avatar image" src="img/avatar/people/Rick.png" alt="label-image" /> Hugh Carter
                                </div>
                                <div class="header">
                                    Your Friends' Friends
                                </div>
                                <div class="item">
                                    <img class="ui avatar image" src="img/avatar/people/Meggie.png" alt="label-image" /> Pauline Cain
                                </div>
                                <div class="item">
                                    <img class="ui avatar image" src="img/avatar/people/Glenn.png" alt="label-image" /> Marco Beck
                                </div>
                                <div class="item">
                                    <img class="ui avatar image" src="img/avatar/people/Daryl.png" alt="label-image" /> Sue Quinn
                                </div>
                            </div>
                        </div>
                        <#if isLogin>
                        <div class="ui dropdown item">
                            <img class="ui mini circular image" src="/static/img/avatar/people/enid.png" alt="label-image" />
                            <div class="menu">
                                <a class="item" href="mail.html">Inbox</a>
                                <a class="item" href="profile.html">Profile</a>
                                <a class="item" href="settings.html">Settings</a>
                                <div class="ui divider"></div>
                                <a class="item">Need Help?</a>
                                <a class="item" href="/logout">注销</a>
                            </div>
                        </div>
                        <#else>

                        </#if>
                        <@shiro.hasPermission name="admin:admin:view">
                        <a class="item labeled rightsidebar computer only" href="/admin">
                            <i class="ion-wrench large icon"></i>
                        </a>
                        </@shiro.hasPermission>
                    </div>
                </div>
            </div>
            <!--navbar-->
            <!--maincontent-->
        <div class="mainWrap">
            <div class="ui equal width left aligned padded grid stackable">

            </div>
        </div>
        <!--maincontent-->
    </div>
    </div>
    <!--jquery-->
    <script src="/static/js/jquery-2.1.4.min.js"></script>
    <!--jquery-->
    <!--semantic-->
    <script src="/static/dist/semantic.min.js"></script>
    <!--semantic-->
    <script src="/static/plugins/cookie/js.cookie.js"></script>
    <script src="/static/plugins/nicescrool/jquery.nicescroll.min.js"></script>

    <script data-pace-options='{ "ajax": false }' src="/static/plugins/pacejs/pace.js"></script>

    <script src="/static/js/main.js"></script>
</body>

<!-- Mirrored from telatkaya.com/stagb/blank.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 16:00:22 GMT -->
</html>