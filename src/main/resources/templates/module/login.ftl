﻿<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from telatkaya.com/stagb/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 16:00:22 GMT -->
<head>
    <!-- Standard Meta -->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta content="initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" name="viewport" />
    <title>登录 - ITBC</title>
    <!-- Site Properities -->
    <meta name="generator" content="Visual Studio 2015" />
    <title>Stagb Admin Template</title>
    <meta name="description" content="Stagb Admin Template" />
    <meta name="keywords" content="html5, ,semantic,ui, library, framework, javascript,jquery,template,blog,stagb,template" />
    <link href="/static/dist/semantic.min.css" rel="stylesheet" />
    <link href="/static/css/main.css" rel="stylesheet" />
</head>
<body>
    <div class="ui container" style="padding-top:10%">
        <div class="ui grid center aligned">
            <div class="row">
                <div class="sixteen wide tablet six wide computer column">
                    <div class="ui left aligned segment">

                        <div id="form1" class="ui form">

                            <h1 class="ui header center aligned">
                                <img src="/static/logo.png" alt="stagblogo" class="ui small image">

                                <div class="content">
                               
                                </div>
                            </h1>

                            <div class="field">
                                <label>
                                    Email or Username:
                                </label>
                                <div class="ui fluid icon input">
                                    <input name="user_name" id="u_name" type="email" autocomplete="off" style="width:100%!important;min-width:100%;width:100%;">
                                    <i class="icon mail outline"></i>
                                </div>
                            </div>
                            <div class="field">
                                <label>
                                    Password:
                                </label>
                                <div class="ui fluid icon input">
                                    <input name="password" id="u_pass" type="password" autocomplete="off" style="width:100%!important;min-width:100%;width:100%;">
                                    <i class="icon key"></i>
                                </div>
                            </div>
                            <div class="field">

                                <a class="ui teal right labeled icon button fluid" href="index-2.html">
                                    Login
                                    <i class="icon sign in"></i>
                                </a>

                                <a class="ui blue right labeled icon button fluid" href="index-2.html">
                                    Sign Up
                                    <i class="icon spy"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/static/js/jquery-2.1.4.min.js"></script>

    <script>
        var colors = ["#F25F5C", "#247BA0", "#8e44ad", "#ED6A5A", "#32936F", "#2c3e50", "#E83F6F", "#32936F", "#2E294E"];
        var rand = Math.floor(Math.random() * colors.length);
        $('body').css("background-color", colors[rand]);
    </script>
</body>

<!-- Mirrored from telatkaya.com/stagb/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 16:00:22 GMT -->
</html>