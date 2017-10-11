<#include "../../header.ftl">
<div class="mainWrap navslide">
    <div class="ui equal width left aligned padded grid stackable">
        <div class="row">
            <div class="column">
                <div class="ui segments">
                    <div class="ui segment inverted redli">
                        <h3 class="ui header">
                            系统状态
                        </h3>
                    </div>
                    <div class="ui segment">
                        <div class="ui grey icon fluid big label">
                            <i class="yellow info icon"></i>状态 :
                            <div class="detail" id="status">

                            </div>
                        </div>
                        <div class="ui grey icon fluid big label">
                            <i class="yellow info icon"></i>描述 :
                            <div class="detail" id="desc">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="sixteen wide tablet sixteen wide computer column">
                <div class="ui segments">
                    <div class="ui segment inverted redli">
                        <h3 class="ui header">
                            磁盘状态
                        </h3>
                    </div>
                    <div class="ui segment">
                        <div class="ui grid">
                            <div class="stretched row">
                                <div class="sixteen wide tablet eight wide computer column">
                                    <#--<div class="ui segment">-->
                                        <div class="ui grey icon fluid big label">
                                            <i class="yellow info icon"></i>状态 :
                                            <div class="detail" id="status_disk">

                                            </div>
                                        </div>
                                        <div class="ui grey icon fluid big label">
                                            <i class="yellow info icon"></i>总容量 :
                                            <div class="detail" id="disk_total">

                                            </div>
                                        </div>
                                    <#--</div>-->
                                </div>
                                <div class="sixteen wide tablet eight wide computer column">
                                    <#--<div class="ui segment">-->
                                        <div class="ui grey icon fluid big label">
                                            <i class="yellow info icon"></i>未用 :
                                            <div class="detail" id="disk_free">

                                            </div>
                                        </div>
                                        <div class="ui grey icon fluid big label">
                                            <i class="yellow info icon"></i>已用 :
                                            <div class="detail" id="disk_threshold">

                                            </div>
                                        </div>
                                    <#--</div>-->
                                </div>
                            </div>
                        </div>
                    </div>
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
                //alert(JSON.stringify(result));
                $('#status').html(result.status.code=='UP'?'正在运行':'已关闭');
                $('#desc').html(result.status.description);
                $('#status_disk').html(result.details.diskSpace.status.code == 'UP'?'空间充足':'空间不足');
                $('#disk_total').html(Math.ceil(result.details.diskSpace.details.total/1073741824)+" M");
                $('#disk_free').html(Math.ceil(result.details.diskSpace.details.free/1073741824)+" M");
                $('#disk_threshold').html(Math.ceil(result.details.diskSpace.details.threshold/1073741824)+" M");
            }
        });
    }
</script>