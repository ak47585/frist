<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %><html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/login.css">
    <script>
        // 判断是登录账号和密码是否为空
        function check(){
            var usercode = $("#usercode").val();
            var password = $("#password").val();
            if(usercode=="" || password==""){
                $("#message").text("账号或密码不能为空！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="main-box">
    <div class="box">
        <h2 class="box-title">教师登录</h2>
        <form action="/user/login" method="post">
            <div class="form-group">
                <div style="color: red;">${codeError}</div>
                <input class="form-control" name="code" placeholder="用户名" value="${user.code}">
            </div>
            <div class="form-group">
                <div style="color: red;">${passwordError}</div>
                <input class="form-control" name="password" placeholder="密码" type="password">
            </div>
            <div class="form-group">
                <input class="form-control btn-info" type="submit" value="登录">
            </div>
        </form>
    </div>
</div>
</body>
</html>

