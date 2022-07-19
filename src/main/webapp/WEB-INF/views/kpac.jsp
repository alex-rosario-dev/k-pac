<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <title>K-Pac</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<c:url value="/static/js/grid.min.js?v=7.3.3"/>"></script>
    <link rel="stylesheet" href="<c:url value="/static/css/grid.min.css?v=7.3.3"/>"/>
    <link rel="stylesheet" href="<c:url value="/static/css/app.css?v=1.20"/>"/>
</head>

<body onload="kPacs()">
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">K-Pac</a></li>
                <li><a href="${pageContext.request.contextPath}/app/sets">Set</a></li>
            </ul>
        </div>
    </div>
</nav>

<main role="main">
    <div class="jumbotron">
        <div class="container">
            <h3>Add K-Pac</h3>
            <form class="form-inline" action="#" onsubmit="return false">
                <div class="form-group mb-2">
                    <label for="title" class="sr-only">Title</label>
                    <input type="text" class="form-control" id="title" placeholder="Enter Title" required>
                </div>
                <div class="form-group mb-2">
                    <label for="description" class="sr-only">Description</label>
                    <input type="text" class="form-control" id="description" placeholder="Description" required>
                </div>
                <button type="submit" class="btn btn-primary mb-2" onclick="addKPac()">Add</button>
            </form>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3>K-Pacs</h3>
                <section class="dhx_sample-container" style="min-height: 400px; height: 400px">
                    <div class="grid" id="kpac-grid"></div>
                </section>
            </div>
        </div>
    </div>

</main>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<script type="text/javascript" src="<c:url value="/static/js/app-kpac.js?ver=1.31"/>"></script>
</body>
</html>