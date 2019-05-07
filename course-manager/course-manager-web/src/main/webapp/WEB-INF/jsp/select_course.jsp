<%--
  Created by IntelliJ IDEA.
  User: XingKe
  Date: 2019/4/24
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>已选课程</title>
</head>
<body>
<h2>Context Menu on DataGrid</h2>
<table class="easyui-datagrid" title="All of course"
       style="width: 80%"
       data-options="url:'course/getSelectedCourse',fitColumns:true,singleSelect:true,method:'get'">

    <thead>
    <tr>
        <th data-options="field:'cid'"> Code                 </th>
        <th data-options="field:'coursename'"> 课程名         </th>
        <th data-options="field:'message'">课程信息           </th>
        <th data-options="field:'begintime'">开始时间         </th>
        <th data-options="field:'endtime'">结束时间           </th>
        <th data-options="field:'category'">课程分类          </th>
        <th data-options="field:'departmentid'">开设院系      </th>
        <th data-options="field:'credit'">学分               </th>

    </tr>
    </thead>

</table>
</body>
</html>
