<%--
  Created by IntelliJ IDEA.
  User: bliu
  Date: 2019年5月10日23点12分
  To change this template use File | Settings | File Templates.
  增加教师姓名
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程管理</title>
    <link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
</head>
<body>
<div style="margin: 0 10px">
    <h2>待审核课程</h2>
    <table id="dg" class="easyui-datagrid" title="All of course"
           style="margin: 10px 10px"
           data-options="url:'course/getUnPassedCourse',fitColumns:true,singleSelect:true,method:'get'"
           rownumbers="true" fitColumns="true" pagination="true">
        <thead>
        <tr>


            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'cid',width:100"> Code                  </th>
            <th data-options="field:'coursename',width:100"> 课程名         </th>
            <th data-options="field:'message',width:100">课程信息           </th>
            <th data-options="field:'begintime',width:100">开始时间         </th>
            <th data-options="field:'endtime',width:100">结束时间           </th>
            <th data-options="field:'category',width:100">课程分类          </th>
            <th data-options="field:'departmentid',width:100">开设院系      </th>
            <th data-options="field:'credit',width:100">学分                </th>
            <a id="btn-save" href="javascript:(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'">通过审核</a>

        </tr>
        </thead>

    </table>

    <script type="text/javascript">

        var select;
        $("#dg").datagrid({
            onClickRow:function (rowIndex, rowData) {
                select = rowData.cid;
            }
        });

        $("#btn-save").click(function () {
            $.ajax({
                type:'post',
                async:true,
                data:{'cid':select},
                url:'course/updateCourseStatus',
                dataType:'text',//服务器返回类型，如果是json，则直接返回为一个对象，不用再转换
                success(data){
                    var data1 = eval('(' + data + ')');
                    $.messager.show({
                        title:'提示',
                        msg:'message:'+data1.res,
                        timeout:3000,
                        showType:'slide'
                    });
                }
            });
        });
    </script>
</div>
</body>
</html>
