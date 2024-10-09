<!DOCTYPE html>
<html>
<head>
    <title>ByteOJ</title>
</head>
<body>
<h1>Welcome to ByteOJ</h1>
<ul>
    <#list Items as item>
    <li><a href="${item.地址}">${item.用户名}</a></li>
</#list>
</ul>
<#-- 底部版权信息-->
<footer>
    ${currentYear?c} https://www.byteoj.com.
</footer>
</body>
</html>