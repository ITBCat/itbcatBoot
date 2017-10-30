<#macro pagination url>
<#if paginationPageCount?? && paginationPageCount!=0 && paginationPageCount!=1>
    <ul class="pagination">
        <#if (cur > 1)>
            <li><a href="/course/list?c=${c!"all"}&page=${cur - 1}"><i class="fa fa-angle-left"></i></a></li>
        <#else>
            <li class="disabled"><a href="/course/list&c=${c!"all"}?page=${cur - 1}"><i class="fa fa-angle-left"></i></a></li>
        </#if>
        <#list 1..count as t>
            <#if cur == t>
                <li class="active"><a href="/course/list?c=${c!"all"}&page=${t - 1}">${t}</a></li>
            <#else>
                <li><a href="/course/list?c=${c!"all"}&page=${t - 1}"></a></li>
            </#if>
        </#list>
        <#if (cur < count)>
            <li><a href="/course/list?c=${c!"all"}&page=${cur + 1}"><i class="fa fa-angle-right"></i></a></li>
        <#else>
            <li class="disabled"><a href="/course/list?c=${c!"all"}&page=${cur + 1}"><i class="fa fa-angle-right"></i></a></li>
        </#if>
    </ul>
</#if>
</#macro>