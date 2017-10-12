<!--navbar-->
<div class="navwrap" style="width: 100%;">
    <div class="ui menu icon borderless four column grid" style="width: 100%;height: 54px;" data-color="inverted white">
        <div class="three wide column" style="margin-top: -1em;">
            <img src="/static/logo.svg" alt="">
        </div>
        <div class="ui secondary stackable menu eight wide column" style="font-size: larger;font-weight: bold;" >
            <a class="active item icon">
                <i class="home icon"></i>
                &nbsp;首 页
            </a>
            <a class="item">
                <i class="coffee icon"></i>
                &nbsp;JAVA
            </a>
            <a class="item">
                <i class="Record icon"></i>
                &nbsp;VIDEO
            </a>
            <a class="item">
                <i class="Music icon"></i>
                &nbsp;MUSIC
            </a>
            <a class="item">
                <i class="sound icon"></i>
                &nbsp;ABOUT
            </a>
            <div class="ui right aligned category search item">
                <div class="ui icon input">
                    <input type="text" placeholder="Search...">
                    <i class="search link icon"></i>
                </div>
            </div>
        </div>

        <div class="right menu colhidden four wide column">
        <#if isLogin>
            <div class="ui dropdown item" style="height: 54px;margin-top: -14px;">
                <i class="bell big icon"></i>
                <div class="menu">
                    <div class="header">
                        People You Might Know
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/enid.png" alt="label-image" /> Janice Robinson
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/Hershell.png" alt="label-image" /> Cynthia May
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/Rick.png" alt="label-image" /> Hugh Carter
                    </div>
                    <div class="header">
                        Your Friends' Friends
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/Meggie.png" alt="label-image" /> Pauline Cain
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/Glenn.png" alt="label-image" /> Marco Beck
                    </div>
                    <div class="item">
                        <img class="ui avatar image" src="/static/img/avatar/people/Daryl.png" alt="label-image" /> Sue Quinn
                    </div>
                </div>
            </div>
            <div class="ui dropdown item" style="height: 54px;margin-top: -14px;">
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
            <@shiro.hasPermission name="admin:admin:view">
                <a class="item labeled rightsidebar computer only" href="/admin">
                    <i class="ion-wrench large icon"></i>
                </a>
            </@shiro.hasPermission>
            <a class="ui item" href="/f/put">
                <button class="ui active redli button">
                    <i class="paint brush icon"></i>
                    发 布
                </button>
            </a>
        <#else>
            <a class="ui item" href="/login">
                <label style="font-weight: bold;font-size: larger;">登 录</label>
            </a>
            <a class="ui item" href="/register">
                <label style="font-weight: bold;font-size: larger;">注 册</label>
            </a>
        </#if>
        </div>
    </div>
</div>
<!--navbar-->