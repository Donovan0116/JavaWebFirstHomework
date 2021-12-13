<%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2021/6/25
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>login</title>
    <style>
        body {
            font-family: "楷体";
            font-size: 15px;
        }

        #sectionOne {
            width: 300px;
            height: 500px;
            margin: 0 auto;
            background-color: aliceblue;
            border: solid 1px cadetblue;
            padding: 20px;
        }

        .loginMain {
            width: 70px;
            height: 20px;
            display: inline-block;
            text-align: justify;
            text-justify: inter-ideograph;
            float: left;
        }

        div.loginMain > span {
            padding-left: 100%;
            display: inline-block;
        }

        input[type=submit] {
            margin-top: 20px;
            background: darkblue;
            color: #fff;
            border: 0px none;
        }
    </style>
</head>
<body>
<%
    if (request.getAttribute("isOKForReg") != null) {
%>
<div style="color:red">这个用户名被占用，请换一个！</div>
<%
    }
%>
<form name="formReg" action="RegServlet" method="post">
    <section id="sectionOne">
        <div class="loginMain">用户名：<span></span></div>
        <input name="StaffUserNameForReg" type="text"
               value="<%=request.getParameter("StaffUserNameForReg")==null?"":request.getParameter("StaffUserNameForReg")%>"
               placeholder="请输入用户名"><br>
        <br/>
        <br/>
        <div class="loginMain">姓名：<span></span></div>
        <input name="StaffNameForReg" type="text"
               value="<%=request.getParameter("StaffNameForReg")==null?"":request.getParameter("StaffNameForReg")%>"
               placeholder="请输入姓名"><br>
        <br/>
        <br/>
        <div class="loginMain">电话：<span></span></div>
        <input name="StaffTelForReg" type="text"
               value="<%=request.getParameter("StaffTelForReg")==null?"":request.getParameter("StaffTelForReg")%>"
               placeholder="请输入11位手机号"><br>
        <br/>
        <br/>
        <div class="loginMain">QQ：<span></span></div>
        <input name="StaffQQForReg" type="text"
               value="<%=request.getParameter("StaffQQForReg")==null?"":request.getParameter("StaffQQForReg")%>"
               placeholder="请输入QQ"><br>
        <br/>
        <br/>
        <div class="loginMain">工资：<span></span></div>
        <input name="StaffWageForReg" type="text"
               value="<%=request.getParameter("StaffWageForReg")==null?"":request.getParameter("StaffWageForReg")%>"
               placeholder="请输入工资"><br>
        <br/>
        <br/>
        <div class="loginMain">密码：<span></span></div>
        <input name="StaffPwdForReg" type="password"
               value="<%=request.getParameter("StaffPwdForReg")==null?"":request.getParameter("StaffPwdForReg")%>"
               placeholder="请输入密码"><br>
        <br/>
        <br/>
        <div class="loginMain">部门：<span></span></div>
        <input name="StaffDeptNameForReg" type="text"
               value="<%=request.getParameter("StaffDeptNameForReg")==null?"":request.getParameter("StaffDeptNameForReg")%>"><br>
        <br/>
        <br/>
        <div class="loginMain">头像：<span></span></div>
        <input name="StaffHeadPicForReg" type="file" value="<%=request.getParameter("StaffHeadPicForReg")==null?"":request.getParameter("StaffHeadPicForReg")%>"><br>
<%--        <button type="button" id="upBtn">开始上传</button>--%>
        <br/>
        <br/>
        <div class="loginMain">管理员：<span></span></div>
        <input name="isAdminForReg" type="radio" value="true" checked="checked">是<br>
        <input name="isAdminForReg" type="radio" value="false">否<br>
        <input type="submit" value="注册">
    </section>
</form>
<script type="text/javascript">
    document.getElementById("upBtn").onclick = function () {
        let xhr = new XMLHttpRequest();
        let fd = new FormData(document.getElementById("formReg"));
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    alert("上传成功");
                }
            }
        }
        xhr.upload.onprogress = function (e) {
            // prog.innerHTML = Math.round(e.loaded/e.total)+'%';
        }
        xhr.onload = function () {

        }
        xhr.open('POST', 'http://localhost:8080/hr/RegServlet', true);
        xhr.send(fd);
    }

</script>

</body>
</html>
