<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <title>客户列表</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/customer_list.css">
</head>
<body>
<div class="head">
    <div class="head-left">
        教务管理系统
    </div>
    <div class="head-right">
        <span class="glyphicon glyphicon-user"></span>
        ${sessionScope.user.name}
        &nbsp;&nbsp;
        <a href="/user/logout" class="btn btn-xs btn-danger">退出登录</a>
    </div>
</div>
<div class="body">
    <div class="body-title">
        学生管理
    </div>
    <div class="body-search">
        <form action="/customer/select/1" method="post" class="form-inline">
            <div class="form-group">
                <label for="customerName">学生名称</label>
                <input class="form-control" name="name" id="customerName">
            </div>
            <div class="form-group">
                <label for="customerSource">学生系别</label>
                <select class="form-control" name="dictSource" id="customerSource">
                    <option value="-1">--请选择--</option>
                    <c:forEach items="${customerSources}" var="dict">
                        <option value="${dict.id}">${dict.itemName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="customerIndustry">学生班级</label>
                <select class="form-control" name="dictIndustry" id="customerIndustry">
                    <option value="-1">--请选择--</option>
                    <c:forEach items="${customerIndustry}" var="dict">
                        <option value="${dict.id}">${dict.itemName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="customerLevel">学生性别</label>
                <select class="form-control" name="dictLevel" id="customerLevel">
                    <option value="-1">--请选择--</option>
                    <c:forEach items="${customerLevel}" var="dict">
                        <option value="${dict.id}">${dict.itemName}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="查找" class="form-control btn-info">
        </form>
    </div>
    <div class="body-table">
        <a href="/customer/addCustomerPage" class="btn btn-info">新建</a>
        <div class="body-table-title">
            学生信息列表
        </div>
        <table class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <td>编号</td>
                    <td>学生姓名</td>
                    <td>学生系别</td>
                    <td>学生班级</td>
                    <td>学生性别</td>
                    <td>学号</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${customerList}" var="customer" varStatus="statu">
                    <c:choose>
                        <c:when test="${statu.index % 4 == 0}">
                            <tr class="success">
                        </c:when>
                        <c:when test="${statu.index % 4 == 1}">
                            <tr class="danger">
                        </c:when>
                        <c:when test="${statu.index % 4 == 2}">
                            <tr class="info">
                        </c:when>
                        <c:otherwise>
                            <tr class="warning">
                        </c:otherwise>
                    </c:choose>
                        <td>${statu.count}</td>
                        <td>${customer.name}</td>
                        <td>
                            <c:forEach items="${customerSources}" var="dict">
                                <c:choose>
                                    <c:when test="${dict.id == customer.dictSource}">
                                        ${dict.itemName}
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${customerIndustry}" var="dict">
                                <c:choose>
                                    <c:when test="${dict.id == customer.dictIndustry}">
                                        ${dict.itemName}
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach items="${customerLevel}" var="dict">
                                <c:choose>
                                    <c:when test="${dict.id == customer.dictLevel}">
                                        ${dict.itemName}
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </td>
                        <td>${customer.phone}</td>
                        <td>
                            <a href="/customer/updatePage/${customer.id}" class="btn btn-sm btn-warning">修改</a>
                            <a href="/customer/delete/${customer.id}" class="btn btn-sm btn-danger">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
            <ul class="pagination">
                <c:forEach items="${pageNav}" var="item">
                    ${item}
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
