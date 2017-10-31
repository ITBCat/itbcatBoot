<#macro pagination url>
<#if PageCount?? && PageCount!=0 && PageCount!=1>
    <ul class="pagination">
        <#if (curNum > 1)>
            <li><a href="${url}?page=${curNum - 1}"><i class="fa fa-angle-left"></i></a></li>
        <#else>
            <li class="disabled"><a href="${url}?page=${curNum - 1}"><i class="fa fa-angle-left"></i></a></li>
        </#if>
        <#list 1..PageCount as t>
            <#if curNum == t>
                <li class="active"><a href="${url}?page=${t - 1}">${t}</a></li>
            <#else>
                <li><a href="${url}?page=${t - 1}"></a></li>
            </#if>
        </#list>
        <#if (curNum < PageCount)>
            <li><a href="${url}?page=${curNum + 1}"><i class="fa fa-angle-right"></i></a></li>
        <#else>
            <li class="disabled"><a href="${url}?page=${curNum + 1}"><i class="fa fa-angle-right"></i></a></li>
        </#if>
    </ul>
</#if>
</#macro>