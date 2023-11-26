<!DOCTYPE html>
<html lang=en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/7.css">
    <title> Услуги </title>
</head>
<body>
<header class="p-3 mb-3 border-bottom">
    <div class="container">
        <div class="d-flex flex-wrap align-items-left justify-content-left justify-content-lg-start">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <h2>Beauty</h2>
                <li><a href="#" class="nav-link px-2 link-secondary">Главная</a></li>
                <li><a href="/" class="nav-link px-2 link-secondary">Услуги</a></li>
                <li><a href="/infomasters" class="nav-link px-2 link-secondary">Мастера</a></li>
                <li><a href="#" class="nav-link px-2 link-secondary">Корзина</a></li>
            </ul>
            <div class="asa">
            <#if user.email??>
                <form action="/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Выйти"/>
                </form>
            <#else>
                <form action="/autorisation" method="post">
                    <input type="submit" value="Войти"/>
                </form>
            </#if>
            </div>
            <div class="poisk">
            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" action="/" method="get">
                Поиск по названию услуги:
                <input type="text" name="title">
                <input type="submit" value="Поиск">
            </form>
            </div>
        </div>
    </div>
</header>
<#if user.isAdmin()>
    <a href="/admin">Панель администратора</a>
</#if>
<div class="colp">
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <#list products as product>
            <div class="col col-2">
                    <div class="card shadow-sm">
                        <img src="/images/${product.previewImageId}" alt="">
                        <div class="card-body">
                            <a href="/product/${product.id}" class="product-link">
                            <h3>${product.title}</h3>
                            </a>
                            <p class="card-text">${product.description}</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn btn-sm btn-outline-secondary">
                                    <form action="/view" method="get">
                                        <input type="submit" value="Оформить запись"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
<#else>
    <h1 style="text-align: center">Не найдено</h1>
</#list>
</div>
</div>
</body>
</html>