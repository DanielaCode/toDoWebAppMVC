<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="webjars/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Welcome</title>
</head>
<body>
    <%@ include file="common/navigation.jspf" %>
    <div class="container">
        <h1>Welcome dear ${name}!</h2>
        <a href="list-todos">ToDos</a>
    </div>
    <script src="webjars/bootstrap/5.3.0/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.4/jquery.min.js"></script>
</body>
</html>