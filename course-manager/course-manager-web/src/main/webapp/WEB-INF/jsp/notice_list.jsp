<%--
  Created by IntelliJ IDEA.
  User: bliu
  Date: 2019/5/12
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告管理</title>
</head>
<body>
<h2>所有公告</h2>
<table id="not" class="easyui-datagrid" title="公告"
       style="margin: 10px 10px"
       data-options="url:'notice/getAllNotice',fitColumns:true,singleSelect:true,method:'get'"
       rownumbers="true" fitColumns="true">
    <thead>
    <tr>

        <th data-options="field:'tittle'">标题         </th>
        <th data-options="field:'content'">内容       </th>
        <th data-options="field:'status'">状态       </th>
    </tr>
    </thead>
</table>
</body>
</html>
