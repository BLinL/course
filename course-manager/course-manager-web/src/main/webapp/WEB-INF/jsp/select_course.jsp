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
<div style="margin: 10px;">
<h2>学生选课</h2>
<%--不同页面id 不要取相同--%>
<table id="dg1" class="easyui-datagrid" title="我的课程"
       data-options="url:'course/getSelectedCourse',fitColumns:true,singleSelect:true,method:'get'">

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
        <a id="btn-cancle" href="javascript:(0)" class="easyui-linkbutton" data-options="iconCls:'icon-no'">退选课程</a>
    </tr>
    </thead>


</table>


<script type="text/javascript">
    var select;
    $("#dg1").datagrid({
        onClickRow:function (rowIndex, rowData) {
            select = rowData.cid;
            // alert(select);
        }
    });

    $("#btn-cancle").click(function () {
        $.ajax({
            type:'post',
            async:true,
            data:{'cid':select},
            url:'student/removeCourse',
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
