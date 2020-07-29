<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: kgc
  Date: 2020/5/18
  Time: 下午4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Bug管理系统</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/res/bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/res/bootstrap-3.4.1-dist/css/bootstrap-theme.min.css">
    <script src="${pageContext.request.contextPath}/statics/res/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/res/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function query() {
            var projectId = $.trim($("#name").val());
            window.location.href = "${pageContext.request.contextPath}/getBugList?projectId=" + projectId;
        }
        function add() {
            window.location.href = "${pageContext.request.contextPath}/add.html";
        }

    </script>
</head>
<body>
<c:import url="header.jsp" charEncoding="utf-8"/>
<div class="form-inline" style="text-align: center">
    <div>
        <label for="name">所属项目：</label>
        <select name="projectId" class="form-control" id="name">
            <option value="">全部</option>
            <c:forEach items="${projectList}" var="project" varStatus="status">
                <option value="${project.id}"
                        <c:if test="${project.id == projectId}">selected</c:if>>${project.name}</option>
            </c:forEach>
        </select>
        <button onclick="query()" type="button" class="btn btn-default">搜索</button>
        <button onclick="add()" type="button" class="btn btn-default">添加BUG</button>
    </div>
</div>
<br>
<div style="text-align: center">
    <div style="text-align: center">
        <h1>BUG管理列表</h1>
    </div>
    <br>
    <table class="table  table-bordered table-hover" style="text-align: center">
        <thead>
        <tr>
            <th style="text-align: center">BUG编号</th>
            <th style="text-align: center">严重性</th>
            <th style="text-align: center">标题</th>
            <th style="text-align: center">报告人</th>
            <th style="text-align: center">报告时间</th>


        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bugList}" var="detail" varStatus="status">
            <tr>
                <td>${detail.id}</td>
                <td>
                    <c:if test="${detail.severity == 10}">
                        文字错误
                    </c:if>
                    <c:if test="${detail.severity == 20}">
                        次要错误
                    </c:if>
                    <c:if test="${detail.severity == 30}">
                        严重错误
                    </c:if>
                </td>
                <td>${detail.title}</td>
                <td>${detail.reportUser}</td>
                <td>
                    <fmt:formatDate value="${detail.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>


</div>
</body>
</html>