<%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2021/6/25
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title></title>
    <style type="text/css">
      .container{
        position: absolute;
        width: 600px;
        height: 400px;
        left: 50%;
        top: 50%;
        margin-left: -300px;
        margin-top: -240px;
      }
      .container h1,.container>p{
        text-align: center;
        margin: 0px;
        font-family: "楷体";
      }
      .container .main{
        width: 600px;
        height: 240px;
        background: #eee;
        margin: 50px 0px;
      }
      .container .main img,.container .main .login{
        width: 300px;
        height: 240px;
        float: left;
      }
      .container .main .login p{
        margin: 10px 20px;
      }
      .container .main .login span{
        float:left;
        clear: left;
        font-size: 16px;
        line-height: 24px;
        width: auto;
        height: 24px;
        margin-bottom: 5px;
      }
      .container .main .login input{
        width: 260px;
        height: 30px;
        border: 1px solid #666;
        outline: none;
        padding: 0px 2em;
        box-sizing: border-box;
      }.container .main .login input[type=button]{
         margin-top: 20px;
         background: darkblue;
         color: #fff;
         border: 0px none;
       }
    </style>
  </head>
  <body>
  <%
    if(request.getAttribute("isOK") != null){
  %>
  <div style="color:red">账号或者密码错误</div>
  <%
    }
  %>
  <div class="container">
    <h1>人力资源管理系统</h1>
    <div class="main">
      <img src="./img/NEU.jpg">
      <div class="login">

        <form name="formLogin" action="LoginServlet" method="get">
        <p>
          <span>账号：</span>
          <input type="text" name="StaffUserName" value="<%=request.getParameter("StaffUserName")==null?"":request.getParameter("StaffUserName")%>" />
        </p>
        <p>
          <span>密码：</span>
          <input type="password" name="StaffPwd" value="<%=request.getParameter("StaffPwd")==null?"":request.getParameter("StaffPwd")%>" />
        </p>
        <p>
          <input type="submit" value="登录" /><br>
          <input type="button" value="注册" onclick="window.location.href='reg.jsp'" />
        </p>
        </form>
      </div>
    </div>
  </div>

<%--  <form name="formLogin" action="LoginServlet" method="get">--%>
<%--    用户名：<input name="StaffUserName" type="text" value="<%=request.getParameter("StaffUserName")==null?"":request.getParameter("StaffUserName")%>"><br>--%>
<%--    密  码：<input name="StaffPwd" type="password" value="<%=request.getParameter("StaffPwd")==null?"":request.getParameter("StaffPwd")%>"><br>--%>
<%--    <input type="submit" value="登录">--%>
<%--    <input type="button" value="注册" onclick="window.location.href='reg.jsp'">--%>

<%--  </form>--%>
  </body>
</html>
