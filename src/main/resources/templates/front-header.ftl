<!--navbar-->
<div class="navwrap" style="width: 100%;">
    <div class="ui menu icon borderless grid" data-color="inverted white">
        <img src="/static/logo.svg" alt="stagblogo">
        <div class="ui secondary stackable right menu fourteen column">
            <a class="active item icon">
                <i class="home icon"></i>
                &nbsp;首 页
            </a>
            <a class="item">
                News
            </a>
            <a class="item">
                About
            </a>
            <a class="item">
                Portfolio
            </a>
            <a class="item">
                Portfolio
            </a>
        </div>

        <div class="right menu colhidden">
            <div class="ui right aligned category search item">
                <div class="ui icon input">
                    <input type="text" placeholder="Search...">
                    <i class="search link icon"></i>
                </div>
            </div>
        <#if isLogin>
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
            <a class="ui item" href="/login">
                <label style="font-weight: bold;font-size: larger;">登 录</label>
            </a>
            <a class="ui item" href="/register">
                <label style="font-weight: bold;font-size: larger;">注 册</label>
            </a>
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