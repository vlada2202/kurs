<!DOCTYPE html>
<html>
<head>
    <title> Beauty </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/10.css">
</head>
<body>
<div class="logo">
<img src="/static/img/2.png" alt=" ">
</div>
<h4>Панель администратора</h4>
<table class="table table-hover" border="1">
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>Бан</th>
        <th>Редактирование</th>
        <th>Подробная информация</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th><#if user.active>true<#else>false</#if></th>
            <th><#list user.roles as role><{${role}</#list> </th>
            <th>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" >
                    <input type="submit" value="Бан">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id}">Редактирование</a> </th>
            <th><a href="/user/${user.id}">Подробная информация</a></th>
        </tr>
        <#else >
        <h3>Пользователей нет</h3>
    </#list>
</table>
<hr>
<form action="/product/create" method="get">
    <input type="submit" value="Добавить новую услугу"/>
</form>
<form action="/addmaster" method="get">
    <input type="submit" value="Добавить нового мастера"/>
</form>
</body>
</html>
