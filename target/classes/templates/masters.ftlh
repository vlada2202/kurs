<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/6.css">
    <title>Добавление мастера</title>
</head>
<body>
<h1>Добавить мастера</h1>
<div class="masters">
    <form action="/addmasters" method="post" enctype="multipart/form-data">
        <div class="form-group ">
            <label for="fullname">Фамилия и имя:</label>
            <input type="text" class="form-control" required id="fullname" name="fullname">
        </div>
        <div class="form-group ">
            <label for="description">Описание:</label>
            <input type="text" class="form-control" required id="description" name="description">
        </div>
        <div class="form-group">
            <label for="photo">Фотография</label>
            <input type="file" class="form-control" id="photo" required name="photo">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить мастера</button>
    </form>
    <div class="ss">
        <#if errorMessage??>
            <h2 style="color: black">${errorMessage}</h2>
        </#if>
    </div>
</div>
</body>
</html>