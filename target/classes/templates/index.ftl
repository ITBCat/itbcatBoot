<#include "macro-head.ftl">

<!DOCTYPE html>
<html lang="zh-CN">


<!-- Mirrored from telatkaya.com/stagb/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 15:51:53 GMT -->

<head>
    <#if template == 'index'>
        <@head title="后台管理 - ITBC"></@head>
    </#if>
    <#if template == 'user' >
        <@head title='用户管理 - ITBC'></@head>
    </#if>
    <#if template == 'add-user' >
        <@head title='添加用户 - ITBC'></@head>
    </#if>
    <#if template == 'edit-user' >
        <@head title='修改用户 - ITBC'></@head>
    </#if>
    <#if template == 'menu'>
        <@head title="菜单管理 - ITBC"></@head>
    </#if>
    <#if template == 'add-menu' >
        <@head title='添加菜单 - ITBC'></@head>
    </#if>
    <#if template == 'edit-menu' >
        <@head title='修改菜单 - ITBC'></@head>
    </#if>
    <#if template == 'dept' >
        <@head title='部门管理 - ITBC'></@head>
    </#if>
    <#if template == 'role' >
        <@head title='角色管理 - ITBC'></@head>
    </#if>
    <#if template == 'add-dept' >
        <@head title='添加部门 - ITBC'></@head>
    </#if>
    <#if template == 'edit-dept' >
        <@head title='修改部门 - ITBC'></@head>
    </#if>
    <#if template == 'add-role' >
        <@head title='添加角色 - ITBC'></@head>
    </#if>
    <#if template == 'edit-role' >
        <@head title='修改角色 - ITBC'></@head>
    </#if>

</head>

<body>
<div id="contextWrap">
    <!--sidebar-->
    <div class="ui sidebar vertical left menu overlay  borderless visible sidemenu inverted  grey" style="-webkit-transition-duration: 0.1s; transition-duration: 0.1s;" data-color="grey">
        <a class="item logo" href="/admin">
            <img src="/static/logo.png" alt="ITBC Admin" /><img src="/static/thumblogo.png" alt="ITBC Admin" class="displaynone" />
        </a>
        <div class="ui accordion inverted">

            <a class="title item <#if template == 'menu' || template == 'add-menu' || template == 'edit-menu' || template == 'user' || template=='add-user'|| template == 'role' || template == 'dept'|| template == 'add-dept'|| template == 'add-role'||template == 'edit-dept'||template == 'edit-role'||template == 'edit-user'>active</#if>">
                <i class="ion-speedometer titleIcon icon"></i> 系统管理 <i class="dropdown icon"></i>
            </a>
            <div class="content <#if template == 'menu' || template == 'add-menu' || template == 'edit-menu' || template == 'user' || template=='add-user'|| template == 'role' || template == 'dept'|| template == 'add-dept'|| template == 'add-role'||template == 'edit-dept'||template == 'edit-role'||template == 'edit-user'>active</#if>">
                <@shiro.hasPermission name="admin:user:view">
                    <a class="item <#if template == 'menu' || template == 'add-menu' || template == 'edit-menu' ||template == 'user' || template=='add-user'|| template == 'role' || template == 'dept'|| template == 'add-dept'|| template == 'add-role'||template == 'edit-dept'||template == 'edit-role'||template == 'edit-user'>transition visible</#if>" href="/user/user">
                        用户管理
                    </a>
                </@shiro.hasPermission>
                <@shiro.hasPermission name="admin:menu:view">
                    <a class="item <#if template == 'menu' || template == 'add-menu' || template == 'edit-menu' ||template == 'user' || template=='add-user'|| template == 'role' || template == 'dept'|| template == 'add-dept'|| template == 'add-role'||template == 'edit-dept'||template == 'edit-role'||template == 'edit-user'>transition visible</#if>" href="/menu/menu">
                        菜单管理
                    </a>
                </@shiro.hasPermission>
                    <@shiro.hasPermission name="admin:dept:view">
                    <a class="item <#if template == 'menu' || template == 'add-menu' || template == 'edit-menu' ||template == 'user' || template=='add-user' || template == 'role'|| template == 'dept'|| template == 'add-dept'|| template == 'add-role'||template == 'edit-dept'||template == 'edit-role'||template == 'edit-user'>transition visible</#if>" href="/dept/dept">
                        部门管理
                    </a>
                </@shiro.hasPermission>
                <@shiro.hasPermission name="admin:role:view">
                    <a class="item <#if template == 'menu' || template == 'add-menu' || template == 'edit-menu' ||template == 'user' || template=='add-user' || template == 'role' || template == 'dept'|| template == 'add-dept'|| template == 'add-role'||template == 'edit-dept'||template == 'edit-role' ||template == 'edit-user'>transition visible</#if>" href="/role/role">
                        角色管理
                    </a>
                </@shiro.hasPermission>
            </div>

            <div class="title item">
                <i class="ion-ios-lightbulb titleIcon icon"></i>

                <i class="dropdown icon"></i> Apps
            </div>
            <div class="content">
                <a class="item" href="inbox.html">
                    Inbox
                </a>

                <a class="item" href="chat.html">
                    Chat
                </a>

                <a class="item" href="filter.html">
                    Filter
                </a>
                <a class="item" href="todo.html">
                    Todo
                </a>
            </div>
            <div class="title item">
                <i class="ion-ios-world titleIcon  icon"></i>

                <i class="dropdown icon"></i> Layouts
            </div>
            <div class="content">
                <a class="item" href="sidebar.html">
                    Sidebar
                </a>
                <a class="item" href="menu.html">
                    Nav
                </a>

                <a class="item" href="box.html">
                    Box
                </a>
                <a class="item" href="cards.html">
                    Cards
                </a>
                <a class="item" href="color.html">
                    Colors
                </a>
                <a class="item" href="comment.html">
                    Comment
                </a>
                <a class="item" href="embed.html">
                    Embed
                </a>
                <a class="item" href="faq.html">
                    Faq
                </a>
                <a class="item" href="feed.html">
                    Feed
                </a>
                <a class="item" href="gallery.html">
                    Gallery
                </a>
                <a class="item" href="grid.html">
                    Grid
                </a>
                <a class="item" href="header.html">
                    Header
                </a>
                <a class="item" href="timeline.html">
                    Timeline
                </a>
                <a class="item" href="message.html">
                    Message
                </a>
                <a class="item" href="price.html">
                    Price
                </a>
            </div>



            <div class="title item">
                <i class="ion-briefcase titleIcon icon"></i>

                <i class="dropdown icon"></i> UI-Kit
            </div>
            <div class="content">

                <a class="item" href="breadcrumb.html">
                    Breadcrumb
                </a>
                <a class="item" href="button.html">
                    Button
                </a>
                <a class="item" href="divider.html">
                    Divider
                </a>

                <a class="item" href="flag.html">
                    Flag
                </a>
                <a class="item" href="icon.html">
                    Icon
                </a>
                <a class="item" href="image.html">
                    Image
                </a>
                <a class="item" href="label.html">
                    Label
                </a>
                <a class="item" href="list.html">
                    List
                </a>
            </div>
            <div class="title item">
                <i class="ion-mouse titleIcon icon"></i>

                <i class="dropdown icon"></i> Script
            </div>
            <div class="content">
                <a class="item" href="accordion.html">
                    Accordion
                </a>

                <a class="item" href="dropdown.html">
                    Dropdown
                </a>

                <a class="item" href="modal.html">
                    Modal
                </a>
                <a class="item" href="notification.html">
                    Notification
                </a>
                <a class="item" href="alert.html">
                    Alert
                </a>

                <a class="item" href="progress.html">
                    Progress
                </a>
                <a class="item" href="range-v1.html">
                    Range Semantic
                </a>
                <a class="item" href="range-v2.html">
                    Range Material
                </a>
                <a class="item" href="rating.html">
                    Rating
                </a>
                <a class="item" href="tab.html">
                    Tab
                </a>
                <a class="item" href="tooltip.html">
                    Tooltip
                </a>
                <a class="item" href="transition.html">
                    Transition
                </a>
            </div>
            <div class="title item">
                <i class="ion-bowtie titleIcon icon"></i>

                <i class="dropdown icon"></i> Pages
            </div>
            <div class="content">
                <a class="item" href="profile.html">
                    Profile
                </a>

                <a class="item" href="settings.html">
                    Settings
                </a>

                <a class="item" href="blank.html">
                    Blank
                </a>
                <a class="item" href="login.html">
                    Sign In
                </a>
                <a class="item" href="login.html">
                    Sign Up
                </a>
                <a class="item" href="forgotpassword.html">
                    Forgot Password
                </a>
                <a class="item" href="lockme.html">
                    Lock Me Screen
                </a>
                <a class="item" href="404.html">
                    Error 404
                </a>
                <a class="item" href="comingsoon.html">
                    Coming Soon
                </a>
            </div>

            <div class="title item">
                <i class="ion-paintbrush titleIcon icon"></i>

                <i class="dropdown icon"></i> Form
            </div>
            <div class="content">
                <a class="item" href="formelements.html">
                    Form Element
                </a>
                <a class="item" href="input.html">
                    Input
                </a>
                <a class="item" href="formvalidation.html">
                    Form Validation
                </a>

                <a class="item" href="editor.html">
                    Html Editor
                </a>
            </div>

            <div class="title item">
                <i class="ion-flame titleIcon icon"></i>

                <i class="dropdown icon"></i> Tables
            </div>
            <div class="content">
                <a class="item" href="table.html">
                    Static Table
                </a>
                <a class="item" href="datatable.html">
                    Datatable
                </a>
                <a class="item" href="editable.html">
                    Editable
                </a>
            </div>
            <div class="title item">
                <i class="ion-arrow-graph-up-right titleIcon icon"></i>

                <i class="dropdown icon"></i> Chart
            </div>
            <div class="content">
                <a class="item" href="chart.html">
                    Charts 1
                </a>
                <a class="item" href="chart-2.html">
                    Charts 2
                </a>

            </div>

        </div>

        <div class="ui dropdown item displaynone scrolling">
            <span>Dashboard</span>
            <i class="ion-speedometer icon"></i>

            <div class="menu">
                <div class="header">
                    Dashboard
                </div>
                <div class="ui divider"></div>
                <a class="item" href="index-2.html">
                    Dashboard v1
                </a>
            </div>
        </div>


        <div class="ui dropdown item displaynone scrolling">
            <span>Apps</span>
            <i class="ion-ios-lightbulb icon"></i>
            <div class="menu">
                <div class="header">
                    Apps
                </div>
                <div class="ui divider"></div>
                <a class="item" href="inbox.html">
                    Inbox
                </a>
                <a class="item" href="filter.html">
                    Filter
                </a>
                <a class="item" href="todo.html">
                    Todo
                </a>
            </div>
        </div>
        <div class="ui dropdown item displaynone scrolling">
            <span>Layouts</span>
            <i class="ion-ios-world icon"></i>
            <div class="menu">
                <div class="header">
                    Layouts
                </div>
                <div class="ui divider"></div>
                <a class="item" href="sidebar.html">
                    Sidebar
                </a>
                <a class="item" href="menu.html">
                    Nav
                </a>

                <a class="item" href="box.html">
                    Box
                </a>
                <a class="item" href="cards.html">
                    Cards
                </a>
                <a class="item" href="color.html">
                    Colors
                </a>
                <a class="item" href="comment.html">
                    Comment
                </a>
                <a class="item" href="embed.html">
                    Embed
                </a>
                <a class="item" href="faq.html">
                    Faq
                </a>
                <a class="item" href="feed.html">
                    Feed
                </a>
                <a class="item" href="gallery.html">
                    Gallery
                </a>
                <a class="item" href="grid.html">
                    Grid
                </a>
                <a class="item" href="header.html">
                    Header
                </a>
                <a class="item" href="timeline.html">
                    Timeline
                </a>
                <a class="item" href="message.html">
                    Message
                </a>
                <a class="item" href="price.html">
                    Price
                </a>
            </div>
        </div>
        <div class="ui dropdown item displaynone scrolling">
            <span>UI-Kit</span>
            <i class="ion-briefcase icon"></i>
            <div class="menu">
                <div class="header">
                    UI-Kit
                </div>
                <div class="ui divider"></div>
                <a class="item" href="breadcrumb.html">
                    Breadcrumb
                </a>
                <a class="item" href="button.html">
                    Button
                </a>
                <a class="item" href="divider.html">
                    Divider
                </a>

                <a class="item" href="flag.html">
                    Flag
                </a>
                <a class="item" href="icon.html">
                    Icon
                </a>
                <a class="item" href="image.html">
                    Image
                </a>
                <a class="item" href="label.html">
                    Label
                </a>
                <a class="item" href="list.html">
                    List
                </a>
            </div>
        </div>
        <div class="ui dropdown item displaynone scrolling">
            <span>Script</span>
            <i class="ion-mouse icon"></i>
            <div class="menu">
                <div class="header">
                    UI-Kit
                </div>
                <div class="ui divider"></div>
                <a class="item" href="accordion.html">
                    Accordion
                </a>

                <a class="item" href="dropdown.html">
                    Dropdown
                </a>

                <a class="item" href="modal.html">
                    Modal
                </a>
                <a class="item" href="notification.html">
                    Notification
                </a>
                <a class="item" href="alert.html">
                    Alert
                </a>

                <a class="item" href="progress.html">
                    Progress
                </a>
                <a class="item" href="range-v1.html">
                    Range Semantic
                </a>
                <a class="item" href="range-v2.html">
                    Range Material
                </a>
                <a class="item" href="rating.html">
                    Rating
                </a>
                <a class="item" href="tab.html">
                    Tab
                </a>
                <a class="item" href="tooltip.html">
                    Tooltip
                </a>
                <a class="item" href="transition.html">
                    Transition
                </a>
            </div>
        </div>
        <div class="ui dropdown item displaynone scrolling">
            <span>Pages</span>
            <i class="ion-bowtie icon"></i>

            <div class="menu">
                <div class="header">
                    Pages
                </div>
                <div class="ui divider"></div>
                <a class="item" href="profile.html">
                    Profile
                </a>

                <a class="item" href="settings.html">
                    Settings
                </a>

                <a class="item" href="blank.html">
                    Blank
                </a>
                <a class="item" href="login.html">
                    Sign In
                </a>
                <a class="item" href="login.html">
                    Sign Up
                </a>
                <a class="item" href="forgotpassword.html">
                    Forgot Password
                </a>
                <a class="item" href="lockme.html">
                    Lock Me Screen
                </a>
                <a class="item" href="404.html">
                    Error 404
                </a>
                <a class="item" href="comingsoon.html">
                    Coming Soon
                </a>
            </div>
        </div>
        <div class="ui dropdown item displaynone scrolling">
            <span>Form</span>
            <i class="ion-paintbrush  icon"></i>

            <div class="menu">
                <div class="header">
                    Form
                </div>
                <div class="ui divider"></div>
                <a class="item" href="formelements.html">
                    Form Element
                </a>
                <a class="item" href="input.html">
                    Input
                </a>
                <a class="item" href="formvalidation.html">
                    Form Validation
                </a>

                <a class="item" href="editor.html">
                    Html Editor
                </a>
            </div>
        </div>
        <div class="ui dropdown item displaynone scrolling">
            <span>Table</span>
            <i class="ion-flame icon"></i>

            <div class="menu">
                <div class="header">
                    Table
                </div>
                <div class="ui divider"></div>
                <a class="item" href="table.html">
                    Static Table
                </a>
                <a class="item" href="datatable.html">
                    Datatable
                </a>
                <a class="item" href="editable.html">
                    Editable
                </a>
            </div>
        </div>
        <div class="ui dropdown item displaynone scrolling">
            <span>Charts</span>
            <i class="ion-arrow-graph-up-right icon"></i>

            <div class="menu">
                <div class="header">
                    Charts
                </div>
                <div class="ui divider"></div>
                <a class="item" href="chart.html">
                    Charts 1
                </a>
                <a class="item" href="chart-2.html">
                    Charts 2
                </a>

            </div>
        </div>
        <div class="ui divider"></div>
        <a class="item" href="typography.html">
            <i class="ion-printer icon"></i> <span class="colhidden">Typography</span>
        </a>
        <a class="item" href="document.html">
            <i class="ion-code icon"></i> <span class="colhidden">Document</span>
        </a>
        <div class="ui divider"></div>
        <a class="item">
            <div class="ui inverted progress tiny yellow" id="sidebar_progress1">
                <div class="bar">

                </div>
                <div class="label colhidden" style="margin-top: 10px"><span class="colhidden">Monthly Bandwidth Transfer</span></div>
            </div>

        </a>

        <a class="item">
            <div class="ui inverted progress tiny teal" id="sidebar_progress2">
                <div class="bar">

                </div>
                <div class="label colhidden" style="margin-top: 10px"><span class="colhidden">Disk Space Usage</span></div>
            </div>

        </a>
        <a class="item">
            <div class="ui inverted progress tiny blue" id="sidebar_progress3">
                <div class="bar">

                </div>
                <div class="label colhidden" style="margin-top: 10px"><span class="colhidden">Earn money</span></div>
            </div>

        </a>
        <div class="ui divider"></div>

        <a class="item hiddenCollapse">
            <div class="ui one tiny inverted statistics">
                <div class="statistic">
                    <div class="value counter">
                        3654
                    </div>
                    <div class="label">
                        Downloads
                    </div>
                </div>
                <div class="statistic">
                    <div class="text value">
                        Three<br> Thousand
                    </div>
                    <div class="label">
                        Views
                    </div>
                </div>
                <div class="statistic">
                    <div class="value">
                        <i class="ion-paperclip icon"></i><span class="counter">19</span>
                    </div>
                    <div class="label">
                        Attached File
                    </div>
                </div>
                <div class="statistic">
                    <div class="value">
                        <img src="/static/img/avatar/people/carol.png" class="ui circular inline  top aligned image"><span class="counter">212</span>
                    </div>
                    <div class="label">
                        Team Members
                    </div>
                </div>
            </div>
        </a>
    </div>

    <!--sidebar-->
    <div class="ui right sidebar">
        <div class="ui pointing secondary two item tabular menu">
            <a class="item active" data-tab="first"><i class="red icon ion-chatbox-working icon"></i></a>

            <a class="item" data-tab="fourth"><i class="blue icon ion-gear-a"></i></a>
        </div>
        <div class="ui tab active" data-tab="first">
            <div class="ui small feed">
                <h4 class="ui header">Followers Activity</h4>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/Abraham.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="date">
                            3 days ago
                        </div>
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/carol.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                            <div class="date">
                                3 days ago
                            </div>
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/Daryl.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="date">
                            3 days ago
                        </div>
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/deana.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                            <div class="date">
                                3 days ago
                            </div>
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/enid.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="date">
                            3 days ago
                        </div>
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/Glenn.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                            <div class="date">
                                3 days ago
                            </div>
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/Hershell.png" alt="label-image">
                    </div>
                    <div class="content">
                        <div class="date">
                            3 days ago
                        </div>
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/Hershell.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                            <div class="date">
                                3 days ago
                            </div>
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/Meggie.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="date">
                            3 days ago
                        </div>
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/Michonne.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                            <div class="date">
                                3 days ago
                            </div>
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/Rick.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="date">
                            3 days ago
                        </div>
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                        </div>
                    </div>
                </div>
                <div class="event">
                    <div class="label">
                        <img src="/static/img/avatar/people/Tara.png" alt="label-image" />
                    </div>
                    <div class="content">
                        <div class="summary">
                            You added <a>Jenny Hess</a> to your <a>coworker</a> group.
                            <div class="date">
                                3 days ago
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="ui tab" data-tab="fourth">
            <div class="ui form fluid">
                <div class="grouped fields">
                    <label>Connection Limited</label>
                    <div class="field">
                        <div class="ui slider checkbox">
                            <input type="radio" name="throughput" checked="checked">
                            <label>20 mbps max</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui slider checkbox">
                            <input type="radio" name="throughput">
                            <label>10mbps max</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui slider checkbox">
                            <input type="radio" name="throughput">
                            <label>5mbps max</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui slider checkbox checked">
                            <input type="radio" name="throughput">
                            <label>Unmetered</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui divider"></div>
            <div class="ui form fluid">
                <div class="grouped fields">
                    <label>Notifications</label>
                    <div class="field">
                        <div class="ui toggle checkbox">
                            <input type="checkbox" checked name="public">
                            <label class="coloring red">Enabled</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui toggle checkbox">
                            <input type="checkbox" name="public">
                            <label class="coloring green">Updates</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui toggle checkbox">
                            <input type="checkbox" name="public">
                            <label>Comments</label>
                        </div>
                    </div>
                    <div class="field">
                        <div class="ui toggle checkbox">
                            <input type="checkbox" name="public">
                            <label>Chat</label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui divider"></div>

            <h4 class="ui header">Navbar Color</h4>
            <div class="ui basic segment">

                <ul class="colorlist">
                    <li>
                        <a class="ui segment yellow inverted" data-addClass="inverted yellow">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment red inverted" data-addClass="inverted red">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment blue inverted" data-addClass="inverted blue">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment black inverted" data-addClass="inverted black">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment orange inverted" data-addClass="inverted orange">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment pink inverted" data-addClass="inverted pink">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment green inverted" data-addClass="inverted green">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment purple inverted" data-addClass="inverted purple">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment violet inverted" data-addClass="inverted violet">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment brown inverted" data-addClass="inverted brown">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment teal inverted" data-addClass="inverted teal">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment greenli inverted" data-addClass="inverted greenli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment grey inverted" data-addClass="inverted grey">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment redli inverted" data-addClass="inverted redli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment yellowli inverted" data-addClass="inverted yellowli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment blueli inverted" data-addClass="inverted blueli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment darkpurpleli inverted" data-addClass="inverted darkpurpleli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment darkorangeli inverted" data-addClass="inverted darkorangeli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment greenli2 inverted" data-addClass="inverted greenli2">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment pinkli inverted" data-addClass="inverted pinkli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment lightyellowli inverted" data-addClass="inverted lightyellowli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment darkli inverted" data-addClass="inverted darkli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment lightbrownli inverted" data-addClass="inverted lightbrownli">
                        </a>
                    </li>
                </ul>
            </div>
            <h4 class="ui header">Sidebar Color</h4>
            <div class="ui basic segment">

                <ul class="sidecolor">
                    <li>
                        <a class="ui segment yellow inverted" data-addClass="inverted yellow">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment red inverted" data-addClass="inverted red">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment blue inverted" data-addClass="inverted blue">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment black inverted" data-addClass="inverted black">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment orange inverted" data-addClass="inverted orange">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment pink inverted" data-addClass="inverted pink">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment green inverted" data-addClass="inverted green">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment purple inverted" data-addClass="inverted purple">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment violet inverted" data-addClass="inverted violet">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment brown inverted" data-addClass="inverted brown">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment teal inverted" data-addClass="inverted teal">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment greenli inverted" data-addClass="inverted greenli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment grey inverted" data-addClass="inverted grey">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment redli inverted" data-addClass="inverted redli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment yellowli inverted" data-addClass="inverted yellowli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment blueli inverted" data-addClass="inverted blueli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment darkpurpleli inverted" data-addClass="inverted darkpurpleli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment darkorangeli inverted" data-addClass="inverted darkorangeli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment greenli2 inverted" data-addClass="inverted greenli2">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment pinkli inverted" data-addClass="inverted pinkli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment lightyellowli inverted" data-addClass="inverted lightyellowli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment darkli inverted" data-addClass="inverted darkli">
                        </a>
                    </li>
                    <li>
                        <a class="ui segment lightbrownli inverted" data-addClass="inverted lightbrownli">
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="pusher">
    <#include "module/admin/${template}.ftl">
    </div>
</div>
<#include "macro-foot.ftl">

</body>


<!-- Mirrored from telatkaya.com/stagb/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Apr 2017 15:53:37 GMT -->

</html>