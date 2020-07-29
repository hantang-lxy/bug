<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>添加BUG</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/res/bootstrap-3.4.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/statics/res/bootstrap-3.4.1-dist/css/bootstrap-theme.min.css">
    <script src="${pageContext.request.contextPath}/statics/res/js/jquery-3.5.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/res/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/res/js/studentlist.js"></script>
    <script type="text/javascript">
        function submitBtn() {
            $.ajax({
                type: "POST",
                data: $("#myForm").serialize(),
                url: "${pageContext.request.contextPath}/add.html",
                dataType: "json",
                success: function (result) {
                    if (result == "ok") {
                        alert("添加成功！");
                        window.location.href = "${pageContext.request.contextPath}/getBugList"
                    }

                },
                error: function () {
                    alert("添加失败！");
                }
            })
        }
    </script>
</head>
<body>

<c:import url="header.jsp" charEncoding="utf-8"/>

<div style="text-align: center;margin: 2% 25%">
    <div>
        <h1>增加BUG</h1>
    </div>
    <br> <br>
    <form role="form" id="myForm">
        <div class="form-inline">
            <div>
                <label for="projectId">所属项目</label>
                <select name="projectId" class="form-control" id="projectId">
                    <c:forEach items="${projectList}" var="project" varStatus="status">
                        <option value="${project.id}">${project.name}</option>
                    </c:forEach>
                </select>
            </div>
            <br>
            <div>
                <label for="severity">严重性</label>
                <select name="severity" class="form-control" id="severity">
                    <option value="10">文字错误</option>
                    <option value="20">次要错误</option>
                    <option value="30">严重错误</option>
                </select>
            </div>
            <br>

            <div>
                <label for="title">BUG标题</label>
                <input type="text" class="form-control" name="title" id="title"
                       placeholder="请输入BUG标题">
            </div>
            <br>

            <div>
                <label for="reportUser">报告人</label>
                <input type="text" class="form-control" name="reportUser" id="reportUser"
                       placeholder="请输入报告人">
            </div>
        </div>
        <br>
        <button onclick="submitBtn()" type="button" class="btn btn-default">添加</button>
        <button type="reset" class="btn btn-default">重置</button>
    </form>

</div>
<div style="text-align: center;margin: 2% 30%">

</div>

</body>
</html>