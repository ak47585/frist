<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加客户</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/add_customer.css">
</head>
<body>
<div class="box">
    <div class="box-title">新建学生信息</div>
    <div style="color: red;">${error}</div>
    <form class="form-horizontal" action="/customer/add" method="post" onsubmit="return true;">
        <div class="form-group">
            <label class="col-sm-3 control-label" for="customer_name">学生姓名</label>
            <div class="col-sm-8">
                <input value="${customer.name}" class="form-control" name="name" id="customer_name" placeholder="学生姓名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="user_id">教师</label>
            <div class="col-sm-8">
                <select class="form-control" name="userId" id="user_id">
                    <c:forEach items="${userList}" var="user">
                        <c:choose>
                            <c:when test="${user.id == customer.userId}">
                                <option value="${user.id}" selected>${user.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${user.id}">${user.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="customer_source">学生系别</label>
            <div class="col-sm-8">
                <select class="form-control" name="dictSource" id="customer_source">
                    <c:forEach items="${customerSources}" var="dict">
                        <c:choose>
                            <c:when test="${dict.id == customer.dictSource}">
                                <option value="${dict.id}" selected>${dict.itemName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${dict.id}">${dict.itemName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="customer_industry">学生班级</label>
            <div class="col-sm-8">

                <select class="form-control" name="dictIndustry" id="customer_industry">
                    <c:forEach items="${customerIndustry}" var="dict">
                        <c:choose>
                            <c:when test="${dict.id == customer.dictIndustry}">
                                <option value="${dict.id}" selected>${dict.itemName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${dict.id}">${dict.itemName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="customer_level">学生性别</label>
            <div class="col-sm-8">
                <select class="form-control" name="dictLevel" id="customer_level">
                    <c:forEach items="${customerLevel}" var="dict">
                        <c:choose>
                            <c:when test="${dict.id == customer.dictLevel}">
                                <option value="${dict.id}" selected>${dict.itemName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${dict.id}">${dict.itemName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="customer_linkman">教师</label>
            <div class="col-sm-8">
                <input value="${customer.linkman}" class="form-control" name="linkman" id="customer_linkman" placeholder="教师名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="customer_phone">学号</label>
            <div class="col-sm-8">
                <input value="${customer.phone}" type="tel" class="form-control" name="phone" id="customer_phone" placeholder="学号">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="customer_address">学生地址</label>
            <div class="col-sm-8">
                <input value="${customer.address}" class="form-control" name="address" id="customer_address" placeholder="学生地址">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-3"></div>
            <div class="col-sm-3">
                <input onclick="location.href='/customer/select/1'" class="form-control" type="button" value="关闭">
            </div>
            <div class="col-sm-3">
                <input class="form-control btn-info" type="submit" value="创建学生">
            </div>
            <div class="col-sm-3"></div>
        </div>
    </form>
</div>
</body>
</html>
