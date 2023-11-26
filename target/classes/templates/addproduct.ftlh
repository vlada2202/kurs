<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/2.css">
    <title>Название парикмахерской</title>
</head>
<body>
<h1>Добавить новую услугу</h1>
<div class="add">
    <form action="/product/create" method="post" enctype="multipart/form-data">
        <div class="form-group ">
            <label for="title">Название услуги:</label>
            <input type="text" class="form-control" required id="title" name="title">
        </div>
        <div class="form-group">
            <label for="description"> Описание услуги: </label>
            <input type="text" class="form-control" id="description" required name="description">
        </div>
        <div class="form-group">
            <label for="price">Цена услуги: </label>
            <input type="number" class="form-control" id="price" required name="price">
        </div>
        <div class="form-group">
            <label for="master">Мастер услуги:</label>
            <input type="text" class="form-control" id="master" required name="master">
        </div>
        <div class="form-group">
            <label for="file1">Первая фотография:</label>
            <input type="file" class="form-control" id="file1" required name="file1">
        </div>
        <div class="form-group">
            <label for="file2">Вторая фотография:</label>
            <input type="file" class="form-control" id="file2" required name="file2">
        </div>
        <div class="form-group">
            <label for="file3"> Третья фотография:</label>
            <input type="file" class="form-control" id="file3" required name="file3">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" style="width: 100%" class="btn btn-dark">Добавить</button>
    </form>
</div>
</body>
</html>
