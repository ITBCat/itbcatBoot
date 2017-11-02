<title>ITBC - Front</title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<link href="/static/dist/semantic.min.css" rel="stylesheet" />
<link rel="icon" type="image/png" href="/static/favicon.png" />
<link href="/static/plugins/ionicons/css/ionicons.min.css" rel="stylesheet" />
<link href="/static/css/main.css" rel="stylesheet" />
<link href="/static/plugins/pacejs/pace.css" rel="stylesheet" />

<link href="/static/plugins/lobibox/css/lobibox.css" rel="stylesheet" />
<!--jquery-->
<script src="/static/js/jquery-2.1.4.min.js"></script>
<!--jquery-->
<style>
    .ui.footer.segment {
        margin: 1em 0em 0em;
        padding: 5em 0em;
    }
</style>
<script type="text/javascript" src="/static/plugins/jquerygroup/jquery.goup.js"></script>

<script type="text/javascript">
    var user;
    <#if _J_user??>
     user= JSON.parse('${_J_user}');
    </#if>

    $(document).ready(function () {

        $.goup({

            trigger: 100,

            bottomOffset: 150,

            locationOffset: 100,

            containerColor:'#fff',

            arrowColor:'#6E6E6E',

            borderClass: '2px solid #C0C0C0',

            titleAsText: true

        });
    });
    var ITBC={
        serverName:'${ITBCFront}',
        ITBCNginx:'${ITBCNginx}',
    <#if isLogin>
        isLogin:true,
    <#else >
        isLogin:false,
    </#if>
    };
</script>