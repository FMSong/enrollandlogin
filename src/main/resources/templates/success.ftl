<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>成功页面</title>
</head>
<body>
<table>
<#list list as ls>
    <tr>
        <td>账号：${ls.acc}</td>
        <td>密码：${ls.pwd}</td>
    </tr>
</#list>
</table>
</body>
</html>