<%--
  Created by IntelliJ IDEA.
  User: bliu
  Date: 2019/5/11
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>学生成绩</h2>
    <table id="dgg" class="easyui-datagrid" title="All of course"
           style="margin: 10px 10px"
           data-options="url:'<%=request.getContextPath()%>/score/getScore',fitColumns:true,singleSelect:true,method:'get'"
           rownumbers="true" fitColumns="true">
        <thead>
        <tr>

            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'username',width:100">学生         </th>
            <th data-options="field:'studentId',width:100,hidden:true">        </th>
            <th data-options="field:'courseId',width:100,hidden:true">        </th>
            <th data-options="field:'theClass',width:100">班级         </th>
            <th data-options="field:'courseName',width:100">课程       </th>
            <th data-options="field:'score',width:100">分数        </th>
            <a id="btn-edit" href="javascript:(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改分数</a>

        </tr>
        </thead>
        <script>
            var studentId;
            var courseId;
            var score;
            $("#dgg").datagrid({
                onClickRow:function (rowIndex, rowData) {
                    studentId = rowData.studentId;
                    courseId = rowData.courseId;
                    score = rowData.score;
                    // var select = {"studentId":studentId,"courseId":courseId}
                    // alert(score);
                }
            });

            $("#btn-edit").click(function () {
                $("#dlgg").dialog('open');
                $("#score").attr(score);
            });

        </script>
    </table>


<%--模态框--%>
<div id="dlgg" class="easyui-dialog" title="修改分数" style="width:300px;height:230px;"
     data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="ff" method="post" style="margin:0;padding:20px 50px">
        <div style="margin-bottom: 10px">
            <input id = "score" class="easyui-textbox" type="text" name="score" data-options="required:true" label="分数：" style="width: 100%"/>
        </div>
    </form>
</div>


<div id="dlg-buttons">
    <a id="btn-yes" href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveScore()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgg').dialog('close')" style="width:90px">Cancel</a>
</div>

<script>
    function saveScore() {
        $("#btn-yes").click(function () {
            var score = $("#score").val();
            // alert(score);
            $.ajax({
                type: 'post',
                async: true,
                data: {'studentid': studentId,'courseid':courseId,'score':score},
                url: '<%=request.getContextPath()%>/score/updateScore',
                dataType: 'text',//服务器返回类型，如果是json，则直接返回为一个对象，不用再转换
                success(data) {
                    $("#score").val("");
                    $("#dlgg").dialog('close');
                    var data1 = eval('(' + data + ')');
                    $.messager.show({
                        title: '提示',
                        msg: 'message:' + data1.res,
                        timeout: 3000,
                        showType: 'slide'
                    });
                }
            });
        })
    }

</script>
</body>
</html>
