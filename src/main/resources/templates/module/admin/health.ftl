<#include "../../header.ftl">
<div class="mainWrap navslide">
    <div class="ui equal width left aligned padded grid stackable">
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
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        getHealth();
    });
    
    function getHealth() {
        $.ajax({
            type : "GET",  //提交方式
            url : "/health",//路径
            dataType : 'json',
            async: false,
            data : {},
            success : function(result) {//返回数据根据结果进行相应的处理
                alert(JSON.stringify(result))
            }
        });
    }
</script>