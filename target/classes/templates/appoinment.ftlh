<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/5.css">
    <title>Название парикмахерской</title>
</head>
<body>
<h1>Оформление записи</h1>
<div class="zapis">
    <form action="/add" method="post">
        <div class="form-group ">
            <label for="name">Имя</label>
            <input type="text" class="form-control" required id="name" name="name">
        </div>
        <div class="form-group">
            <label for="nomertel">Номер телефона</label>
            <input type="number" class="form-control" id="nomertel" required name="nomertel">
        </div>
        <div class="form-group">
            <label for="date">Дата</label>
            <input type="date" class="form-control" id="date" required name="date">
        </div>
        <div class="form-group">
            <label for="time">Время</label>
            <input type="time" class="form-control" id="time" required name="time">
        </div>
        <div class="form-group">
            <label for="ysluga">Услуга:</label>
            <input type="text" class="form-control" id="ysluga" required name="ysluga">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" name="name" style="width: 100%" class="btn btn-dark">Оформить запись</button>
    </form>
    <div class="ss">
        <#if errorMessage??>
            <h2 style="color: black">${errorMessage}</h2>
        </#if>
    </div>
</div>
</body>
</html>