<%--
  Created by IntelliJ IDEA.
  User: bliu
  Date: 2019/4/19
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>可选课程</title>
    <link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
</head>
<body>
    <h2>Context Menu on DataGrid</h2>
    <table class="easyui-datagrid"
           data-options="url:'getdata',fitColumns:true,singleSelect:true">

        <thead>
            <tr>
                <th data-options="field:'cid'"> Code                  </th>
                <th data-options="field:'coursename'"> 课程名         </th>
                <th data-options="field:'message'">课程信息           </th>
                <th data-options="field:'begintime'">开始时间         </th>
                <th data-options="field:'endtime'">结束时间           </th>
                <th data-options="field:'category'">课程分类          </th>
                <th data-options="field:'departmentid'">开设院系      </th>
                <th data-options="field:'credit'">学分                </th>
            </tr>
        </thead>

    </table>
</body>
</html>
