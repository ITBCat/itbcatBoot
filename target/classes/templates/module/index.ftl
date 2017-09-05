<div class="ui equal width left aligned padded grid stackable">
    <div class="row">
        <div class="column">
            <div class="ui segments no-padding">
                <div class="ui segment basic no-padding-bottom">
                    <h5 class="ui left floated header">
                        Sales Statistics
                    </h5>
                    <h5 class="ui right floated header">
                        <i class="ion-ios-arrow-up icon link"></i>
                        <i class="ion-ios-refresh-empty refreshing icon link"></i>
                        <i class="ion-ios-close-empty icon link"></i>
                    </h5>
                    <div class="clearfix"></div>
                </div>
                <div class="ui basic segment no-padding">
                    <div id="chart-curved-line" class="flot-chart" style="width:100%;height:200px">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="sixteen wide tablet four wide computer column">

            <div class="ui segment left aligned">

                <div class="ui  statistic">
                    <div class="value counter">
                        3,952
                    </div>
                    <div class="label">
                        Orders
                    </div>
                    <i class="icon ion-ios-cart teal statisticIcon"></i>
                </div>
                <div id="flot-order" class="flotchart"></div>
            </div>
        </div>

        <div class="sixteen wide tablet four wide computer column">

            <div class="ui segment left aligned">

                <div class="ui  statistic">
                    <div class="value">
                        <span class="counter">57.6</span> %
                    </div>
                    <div class="label">
                        Average Time
                    </div>
                    <i class="icon ion-ios-timer blue statisticIcon"></i>
                </div>
                <div id="flot-avarage" class="flotchart"></div>
            </div>
        </div>
        <div class="sixteen wide tablet four wide computer column">

            <div class="ui segment left aligned">

                <div class="ui  statistic">
                    <div class="value counter">
                        3,112
                    </div>
                    <div class="label">
                        Saves
                    </div>
                    <i class="icon ion-magnet purple statisticIcon"></i>
                </div>
                <div id="flot-saves" class="flotchart"></div>
            </div>
        </div>
        <div class="sixteen wide tablet four wide computer column">

            <div class="ui segment left aligned">

                <div class="ui  statistic">

                    <div class="value counter">
                        9,582
                    </div>
                    <div class="label">
                        Page Views
                    </div>
                    <i class="icon ion-trophy red statisticIcon"></i>
                </div>
                <div id="flot-view" class="flotchart"></div>
            </div>
        </div>
    </div>

    <div class="stretched row">

        <div class="sixteen wide tablet ten wide computer column">
            <div class="ui segments">
                <div class="ui segment no-padding-bottom">
                    <h5 class="ui left floated header">
                        Populer Browsers
                    </h5>
                    <h5 class="ui right floated header">
                        <i class="ion-ios-arrow-up icon link"></i>
                        <i class="ion-ios-refresh-empty refreshing icon link"></i>
                        <i class="ion-ios-close-empty icon link"></i>
                    </h5>
                    <div class="clearfix"></div>
                </div>
                <div class="ui segment left aligned">

                    <table class="ui very basic center aligned  celled table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Project Name</th>
                            <th>Date</th>
                            <th>Accept</th>
                            <th>Status</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>Chrome</td>
                            <td>10 July 2014</td>
                            <td><i class="green check icon"></i></td>
                            <td><a class="ui blue mini basic label">Update</a></td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Mozilla</td>
                            <td>2 Feb 2010</td>
                            <td><i class="red close icon"></i></td>
                            <td><a class="ui green mini basic label">Upgrade</a></td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>Yandex</td>
                            <td>29 Aug 2012</td>
                            <td><i class="green check icon"></i></td>
                            <td><a class="ui purple mini basic label">Coming Soon</a></td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td>Internet Explorer</td>
                            <td>5 Sep 2005</td>
                            <td><i class="red close icon"></i></td>
                            <td><a class="ui red mini basic label">Released</a></td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td>Safari</td>
                            <td>1 Jan 2002</td>
                            <td><i class="red close icon"></i></td>
                            <td><a class="ui yellow mini basic label">Upgrade</a></td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="ui inverted dimmer">
                        <div class="ui text loader">Loading</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="sixteen wide tablet six wide computer column">

            <div class="ui segment">
                <h2 class="ui   center aligned header">

                    <div class="content">
                        Melbourne
                        <div class="sub header">Thursday, 29 November</div>
                    </div>
                </h2>
                <h3 class="ui center aligned header">14 &deg;</h3>
                <div class="ui divider"></div>
                <div class="ui five column centered grid">

                    <div class="column center aligned">
                        <p>Wed</p>
                        <p><i class="wi wi-day-cloudy"></i></p>
                        <p>12&deg;</p>
                    </div>
                    <div class="column center aligned">
                        <p>Thu</p>
                        <p><i class="wi wi-day-sleet"></i></p>
                        <p>10&deg;</p>
                    </div>
                    <div class="column center aligned">
                        <p>Fri</p>
                        <p><i class="wi wi-day-cloudy-gusts"></i></p>
                        <p>8&deg;</p>
                    </div>
                    <div class="column center aligned">
                        <p>Sat</p>
                        <p><i class="wi wi-day-sprinkle"></i></p>
                        <p>-5&deg;</p>
                    </div>
                    <div class="column center aligned">
                        <p>Sun</p>
                        <p><i class="wi wi-day-lightning"></i></p>
                        <p>14&deg;</p>
                    </div>
                </div>
                <div id="flot-weather" class="flotchart"></div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="sixteen wide tablet sixteen wide computer column">
            <div class="ui segments">
                <div class="ui segment no-padding-bottom">
                    <h5 class="ui left floated header">
                        Browser Usage Statistics
                    </h5>
                    <h5 class="ui right floated header">
                        <i class="ion-ios-arrow-up icon link"></i>
                        <i class="ion-ios-refresh-empty refreshing icon link"></i>
                        <i class="ion-ios-close-empty icon link"></i>
                    </h5>
                    <div class="clearfix"></div>
                </div>
                <div class="ui segment">
                    <div class="ui grid">
                        <div class="stretched row">
                            <div class="sixteen wide tablet ten wide computer column">
                                <canvas id="chart_1" width="400" height="400"></canvas>
                            </div>
                            <div class="sixteen wide tablet six wide computer column">
                                <div class="ui horizontal large statistic">
                                    <div class="value counter">
                                        16,482
                                    </div>
                                    <div class="label">
                                        Your Profile Views
                                    </div>
                                </div>
                                <div id="flot-profile" class="flotchart"></div>
                                <table class="ui celled striped table">
                                    <thead>
                                    <tr>
                                        <th style="width:10%">#</th>
                                        <th style="width:40%">Browser</th>
                                        <th style="width:25%">Sessions</th>
                                        <th style="width:25%">Up/Down</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>Chrome</td>
                                        <td>4325</td>
                                        <td class="text-success">+3.26%</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Firefox</td>
                                        <td>3257</td>
                                        <td class="text-danger">-2.14%</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>Edge</td>
                                        <td>2314</td>
                                        <td class="text-success">+2.92%</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="stretched row">
        <div class="sixteen wide tablet five wide computer column">
            <div class="ui segment">
                <h5 class="ui dividing header">
                    Recent Activities
                </h5>
                <div class="ui feed timeline">
                    <div class="event">
                        <div class="label">
                            <img src="/static/img/avatar/people/Abraham.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a class="user">
                                    Francis	Baldwin
                                </a> added you as a friend
                                <div class="date">
                                    1 Hour Ago
                                </div>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 4 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label">
                            <img src="/static/img/avatar/people/carol.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a>Lindsey Daniels</a> added <a>2 new illustrations</a>
                                <div class="date">
                                    4 days ago
                                </div>
                            </div>
                            <div class="extra images">
                                <a><img src="/static/img/bg/1.png" alt="bg-image" /></a>
                                <a><img src="/static/img/bg/3.png" alt="bg-image" /></a>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 1 Like
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label">
                            <img src="/static/img/avatar/people/Daryl.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a class="user">
                                    Walter	Stewart
                                </a> added you as a friend
                                <div class="date">
                                    2 Days Ago
                                </div>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 8 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label">
                            <img src="/static/img/avatar/people/deana.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a>Loretta	Burke</a> posted on his page
                                <div class="date">
                                    3 days ago
                                </div>
                            </div>
                            <div class="extra text">
                                Ours is a life of constant reruns. We're always circling back to where we'd we started, then starting all over again. Even if we don't run extra laps that day, we surely will come back for more of the same another day soon.
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 5 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="event">
                        <div class="label">
                            <img src="/static/img/avatar/people/enid.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a>Meredith	Barnes</a> added <a>2 new photos</a> of you
                                <div class="date">
                                    4 days ago
                                </div>
                            </div>
                            <div class="extra images">
                                <a><img src="/static/img/bg/5.png" alt="bg-image" /></a>
                                <a><img src="/static/img/bg/6.png" alt="bg-image" /></a>
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 41 Likes
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="event">
                        <div class="label">
                            <img src="/static/avatar/people/Meggie.png" alt="label-image" />
                        </div>
                        <div class="content">
                            <div class="summary">
                                <a>Jennifer	Clarke</a> posted on his page
                                <div class="date">
                                    3 days ago
                                </div>
                            </div>
                            <div class="extra text">
                                Ours is a life of constant reruns. We're always circling back to where we'd we started, then starting all over again.
                            </div>
                            <div class="meta">
                                <a class="like">
                                    <i class="like icon"></i> 5 Likes
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="sixteen wide tablet five wide computer column">

            <div class="ui segment">
                <div class="ui middle aligned relaxed list">
                    <div class="item">
                        <div class="right floated content">
                            <a class="ui red basic label">Just Now</a>
                        </div>
                        <i class="icon large ion-pizza circular red"></i>
                        <div class="content">
                            You have 4 pending tasks.
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a class="ui teal basic label">2 Hours ago</a>
                        </div>
                        <i class="icon large ion-lock-combination circular teal"></i>

                        <div class="content">
                            Server #1 overloaded.
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a class="ui blue basic label">31 May</a>
                        </div>
                        <i class="icon large ion-bowtie circular blue"></i>

                        <div class="content">
                            New order received.
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a class="ui purple basic label">30 May</a>
                        </div>
                        <i class="icon large ion-bonfire circular purple"></i>

                        <div class="content">
                            New user registered.
                        </div>
                    </div>
                    <div class="item">
                        <div class="right floated content">
                            <a class="ui brown basic label">27 May</a>
                        </div>
                        <i class="icon large ion-scissors circular brown"></i>

                        <div class="content">
                            New Version just arrived.
                        </div>
                    </div>
                </div>
            </div>
            <div class="ui basic segment no-padding">
                <div class="ui fluid one cards special">
                    <div class="card fluid">
                        <div class="blurring dimmable image">
                            <div class="ui dimmer">
                                <div class="content">
                                    <div class="center">
                                        <div class="ui inverted button">Add Friend</div>
                                    </div>
                                </div>
                            </div>
                            <img src="/static/img/gallery/images5.jpg">
                        </div>
                        <div class="content">
                            <a class="header">Samantha Green</a>
                            <div class="meta">
                                <span class="date">Melbourne</span>
                            </div>
                        </div>
                        <div class="extra content">
                            <a>
                                <i class="like icon"></i> 214 Likes
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="sixteen wide tablet six wide computer column">

            <div class="ui segment">

                <div class="chat">
                    <div class="chat-header clearfix">
                        <img class="ui circular image" src="/static/img/avatar/people/Meggie.png" alt="avatar" />

                        <div class="chat-about">
                            <div class="chat-with">Chat with Vincent Porter</div>
                            <div class="chat-num-messages">Already 14 messages</div>
                        </div>
                        <i class="fa fa-star"></i>
                    </div>
                    <!-- end chat-header -->

                    <div class="chat-history" style="overflow:hidden">
                        <ul>
                            <li class="clearfix">
                                <div class="message-data align-right">
                                    <span class="message-data-time">10:10 AM, Today</span> &nbsp; &nbsp;
                                    <span class="message-data-name">Olia</span> <i class="icon circle me"></i>
                                </div>
                                <div class="message other-message float-right">
                                    Hi Vincent
                                </div>
                            </li>

                            <li>
                                <div class="message-data">
                                    <span class="message-data-name"><i class="icon circle online"></i> Vincent</span>
                                    <span class="message-data-time">10:12 AM, Today</span>
                                </div>
                                <div class="message my-message">
                                    Are we meeting today?
                                </div>
                            </li>

                            <li class="clearfix">
                                <div class="message-data align-right">
                                    <span class="message-data-time">10:14 AM, Today</span> &nbsp; &nbsp;
                                    <span class="message-data-name">Olia</span> <i class="icon circle me"></i>
                                </div>
                                <div class="message other-message float-right">
                                    Well I am not sure.
                                </div>
                            </li>

                            <li>
                                <div class="message-data">
                                    <span class="message-data-name"><i class="icon circle online"></i> Vincent</span>
                                    <span class="message-data-time">10:20 AM, Today</span>
                                </div>
                                <div class="message my-message">
                                    Actually everything was fine
                                </div>
                            </li>
                        </ul>
                    </div>
                    <!-- end chat-history -->
                </div>
            </div>
        </div>
    </div>
</div>