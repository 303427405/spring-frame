<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>登录</title>
    <link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${contextPath}/css/animate.min.css" rel="stylesheet">
    <link href="${contextPath}/css/style.min.css" rel="stylesheet">
    <link href="${contextPath}/css/login.min.css" rel="stylesheet">

</head>

<body class="signin">

    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <!--<h1>[ H+ ]</h1>-->
                    </div>
                    <div class="m-b"></div>
                </div>
            </div>
            <div class="col-sm-5">
                <form method="post" action="/login">
                    <!--<p class="m-t-md">登录到H+后台主题UI框架</p>-->
                    <input type="text" class="form-control uname" name="username" placeholder="用户名" />
                    <input type="password" class="form-control pword m-b" name="password" placeholder="密码" />
                    <input type="submit" class="btn btn-success btn-block" value="登陆"/>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
