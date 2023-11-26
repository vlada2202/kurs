<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
</head>
<body>
<h1>SHOP</h1><hr>
<h4>Подробная информация об услуге</h4>
<#list images as img>
    <img src="/images/${img.id}" height= "150px"/><br><br>
</#list>
<b>Название услуги:</b>${product.title}<br>
<b>Описание:</b>${product.description}<br>
<b>Цена:</b>${product.price}<br>
<b>Мастер:</b>${product.master}<br>
    <form action="/product/delete/${product.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-danger m-3">
            Удалить
        </button>
    </form>
</body>
</html>
