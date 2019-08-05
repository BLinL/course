<%--
  Created by IntelliJ IDEA.
  User: bliu
  Date: 2019/5/12
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布公告</title>
    <link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
</head>
<body>
<h2 style="margin: 10px">公告发布：</h2>
<form id="ff" method="post" style="margin: 10px">
    <div style="margin: 20px">
        <label for="tittle">标题:</label>
        <input class="easyui-textbox" type="text" name="tittle" data-options="required:true" />
    </div>
    <div style="margin: 20px">
        <label for="content">内容:</label>
        <input class="easyui-textbox" type="text" name="content" data-options="required:true"
            style="width: 700px;height: 300px;"
        />
    </div>
    <div style="text-align:left;padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
           onclick="submit()">提交</a>
    </div>
</form>

<script>
    function submit(){
        $('#ff').form({
            url:'<%=request.getContextPath()%>/notice/addNotice',
            onSubmit: function(){
                return $(this).form('validate');
            },
            success:function(data){
                var data1 = eval('(' + data + ')'); // change the JSON string to javascript object
                if (data1){
                    $.messager.show({
                        title:'提示',
                        msg:'message:'+data1.res,
                        timeout:3000,
                        showType:'slide'
                    });
                }
            }
        });
        // submit the form
        $('#ff').submit();
    }

</script>
</body>
</html>
