<!--semantic-->
<script src="/static/dist/semantic.min.js"></script>
<!--semantic-->
<#--首页的JS-->
<#if template=='index'>
<!--counter number-->
<script src="/static/plugins/counterup/jquery.counterup.min.js"></script>
<script src="/static/plugins/counterup/waypoints.min.js"></script>
<!--counter number-->
<!--flot chart-->
<script src="/static/plugins/flot/jquery.flot.js"></script>
<script src="/static/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="/static/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="/static/plugins/flot/curvedLines.js"></script>
<!--flot chart-->
<!--chartjs chart-->
<script src="/static/plugins/chartjs/chart.min.js"></script>
<!--chartjs chart-->

<script src="/static/plugins/chartist/chartist.min.js"></script>

<script src="/static/js/dashboard2.js"></script>
</#if>

<#--菜单的Js-->
<#if template=='add-menu' || template=='add-user'||template=='add-dept'||template=='add-role'>
<script src="/static/js/customjs/custom-validation.js"></script>
</#if>
<#if template=='menu'|| template == 'user'|| template == 'dept'|| template == 'role'>
<script src="/static/plugins/datatable/jquery.dataTables.js"></script>
<script src="/static/js/customjs/custom-datatable.js"></script>
</#if>
<script src="/static/plugins/cookie/js.cookie.js"></script>
<script src="/static/plugins/nicescrool/jquery.nicescroll.min.js"></script>

<script data-pace-options='{ "ajax": false }' src="/static/plugins/pacejs/pace.js"></script>

<script src="/static/js/main.js"></script>