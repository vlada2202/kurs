<!DOCTYPE html>
<html>
<head>
    <title>Beauty</title>
</head>
<body>
<h1 style="text-align: center">Информация о пользователе</h1>
<hr>
<div style="text-align: center">
    <h2>${user.name}</h2>
    <br>
    Номер телефона: <b>${user.phoneNumber}</b>
    <br>
    Почта:<b>${user.email}</b>
</div>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
<br>
<hr>
</body>
</html>


