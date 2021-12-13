<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pers.Donovan.hr.service.DeptService" %>
<%@ page import="pers.Donovan.hr.entity.Dept" %>
<%@ page import="pers.Donovan.hr.service.DeptServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="pers.Donovan.hr.dao.DeptDao" %>
<%@ page import="pers.Donovan.hr.dao.Impl.DeptDaoImpl" %>
<%@ page import="pers.Donovan.hr.entity.Staff" %><%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2021/6/26
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        div{
            width:100%;
            text-align: center;
        }
        table{
            text-align: center;
            margin: 0px auto;
        }
        input[type=button]{
            margin-top: 20px;
            background: darkblue;
            color: #fff;
            border: 0px none;
        }
        input[type=submit]{
            margin-top: 20px;
            background: darkblue;
            color: #fff;
            border: 0px none;
        }
    </style>
    <style>
        .table11_7 table {
            width:100%;
            margin:15px 0;
            border:0;
        }
        .table11_7 th {
            background-color:#00A5FF;
            color:#FFFFFF
        }
        .table11_7,.table11_7 th,.table11_7 td {
            font-size:0.95em;
            text-align:center;
            padding:4px;
            border-collapse:collapse;
        }
        .table11_7 th,.table11_7 td {
            border: 1px solid #2087fe;
            border-width:1px 0 1px 0;
            border:2px inset #ffffff;
        }
        .table11_7 tr {
            border: 1px solid #ffffff;
        }
        .table11_7 tr:nth-child(odd){
            background-color:#aae1fe;
        }
        .table11_7 tr:nth-child(even){
            background-color:#ffffff;
        }
    </style>
</head>
<body style="background-color: aliceblue">
<div class="top" style="color:#DDA0DD">
    人力资源管理系统
</div>
<div>
    <%Staff Staff = (Staff) session.getAttribute("currentStaff");%>
    <%String src = "./img/"+Staff.getStaffHeadPic();%>
    <img style="width:30px;height:30px" src="<%=src%>" alt="头像">
    <%--    <c:set var="img" value="./img/"/>--%>
    <%--    <c:set var="pic" value="${sessionScope.currentStaff.staffHeadPic}"/>--%>
    <%--    <img src="${img.concat(pic)}" alt="用户头像"/>--%>
</div>
<%Staff currentStaff = (Staff) session.getAttribute("currentStaff");%>
<div class="top" style="color:red">
    当前用户
</div>
<table class=table11_7>
    <tr>
        <td>用户名</td>
        <td>姓名</td>
        <td>电话</td>
        <td>QQ</td>
        <td>所在部门</td>
    </tr>
    <tr>
        <td><%=currentStaff.getStaffUserName()%></td>
        <td><%=currentStaff.getStaffName()%></td>
        <td><%=currentStaff.getStaffTel()%></td>
        <td><%=currentStaff.getStaffQQ()%></td>
        <td><%=currentStaff.getDeptName()%></td>
    </tr>
</table>
<div class="main">
    <p style="color: #DDA0DD">当前位置：员工主页/所有部门</p>
    <%--    <iframe name="mainFrame" src="" width="100%" height="100%" scrolling="auto"></iframe>--%>

    <table class=table11_7>
        <tr>
            <td>部门名</td>
            <td>部门所在地</td>
            <td>部门电话</td>
        </tr>
        <%
            DeptService deptService = new DeptService() {
                private final DeptDao deptDao = new DeptDaoImpl();

                @Override
                public List<Dept> showForOthers() {
                    return deptDao.selectByOrders();
                }

                @Override
                public List<Dept> showForAdmin() {
                    return deptDao.selectByAdmin();
                }

                @Override
                public List<Dept> searchForOthers(String DeptName) {
                    return deptDao.selectAllByName(DeptName);
                }

                @Override
                public List<Dept> searchForAdmin(String DeptName) {
                    return deptDao.selectAllForAdminByName(DeptName);
                }

                @Override
                public int insertDept(Dept dept) {
                    return deptDao.insertDept(dept);
                }

                @Override
                public int deleteDept(String DeptName) {
                    return deptDao.deleteDeptByDeptName(DeptName);
                }

                @Override
                public int updateDept(Dept dept) {
                    return deptDao.updateDept(dept);
                }
            };
            List<Dept> list = deptService.showForOthers();
            for(Dept dept:list){%>
        <tr>
            <td><%=dept.getDeptName()%></td>
            <td><%=dept.getDeptLoc()%></td>
            <td><%=dept.getDeptTel()%></td>
        </tr>
        <%}%>
    </table>
</div>

<div style="text-align:center">
    <input type="button" value="返回" onclick="window.location.href='All.jsp'"><br>
</div>
<form name="formForSearchStaff" action="searchDept.jsp">
    <div style="text-align:center">
        <input name="DeptNameForSearch" type="text" value="<%=request.getParameter("DeptNameForSearch")==null?"":request.getParameter("DeptNameForSearch")%>">
        <input type="submit" value="搜索">
    </div>
</form>

</body>
</html>
