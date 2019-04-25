<%--
  Created by IntelliJ IDEA.
  User: bliu
  Date: 2019/4/6
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生学科系统 注册</title>

    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../css/themes/icon.css">

</head>
<body style="margin: 0;border: 0;background-color: #20366b">
<%--<%@include file="head.jsp"%>--%>
<div id="header" class="group wrap header">

    <div style="margin:70px auto;width: 40%;">
        <div class="easyui-tabs" style="height:550px">
            <div title="登陆" style="padding:10px">
                <div class="easyui-panel" style="padding:30px 60px;width:80%;border: 0;">
                    <form id="logn" method="post">
                        <div style="margin-bottom:20px">
                            <div>用户名:</div>
                            <input class="easyui-textbox" data-options="required:true,missingMessage:'用户名必填'"
                                   name="username" iconWidth="28" style="width:100%;height:32px">
                        </div>
                        <div style="margin-bottom:20px">
                            <div>密码:</div>
                            <input class="easyui-passwordbox" data-options="required:true,missingMessage:'密码必填'"
                                   name="password" iconWidth="28" style="width:100%;height:32px">
                        </div>

                    </form>
                    <div style="text-align:left;padding:5px">
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok"
                           onclick="loding()">登陆</a>

                    </div>

                </div>

            </div>

            <script type="text/javascript">
                function loding() {
                    $('#logn').form({
                        url: '/logon',
                        onSubmit: function () {

                            return $(this).form('validate');	// return false will stop the form submission
                        },
                        success: function (data) {
                            var data = eval('(' + data + ')');//转化为js 对象
                            var url = data.url;
                            if (data.errorInfo == null) {
                                //跳转
                                window.location.href = "${pageContext.request.contextPath}" + url;
                            }else{
                                alert(data.errorInfo);
                            }
                        }
                    });
                    // submit the form
                    $('#logn').submit();

                }


            </script>


            <div title="注册" style="padding:10px">
                <div class="easyui-panel" style="padding:30px 60px;width:80%;border: 0">
                    <form id="ff" method="post">
                        <div style="margin-bottom:20px">
                            <div>学号:</div>
                            <input class="easyui-textbox" name="sid" iconWidth="28" style="width:100%;height:32px">
                        </div>
                        <div style="margin-bottom:20px">
                            <div>用户名:</div>
                            <input class="easyui-textbox" name="username" data-options="required:true" iconWidth="28"
                                   style="width:100%;height:32px">
                        </div>
                        <div style="margin-bottom:20px">
                            <div>密码:</div>
                            <input class="easyui-passwordbox" name="password" data-options="required:true"
                                   iconWidth="28" style="width:100%;height:32px">
                        </div>
                        <div style="margin-bottom:20px">
                            <div>性别：</div>
                            <input class="easyui-radiobutton" name="sex" value="man" label="男">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input class="easyui-radiobutton" name="sex" value="woman" label="女">
                        </div>

                        <div style="margin-bottom:20px">
                            <div>班级:</div>
                            <input class="easyui-textbox" name="theClass" style="width:100%;height:32px">
                        </div>

                        <div style="margin-bottom:20px">
                            <div>学院:</div>
                            <input class="easyui-textbox" name="college" style="width:100%;height:32px">
                        </div>

                    </form>

                    <div style="text-align:center;padding:5px">
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitForm()">注册</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
                    </div>


                    <script type="text/javascript">
                        function submitForm() {

                            $('#ff').form({

                                url: 'student/addStudent',
                                onSubmit: function () {

                                    return $(this).form('validate');
                                    // do some check
                                    // return false to prevent submit;
                                },
                                success: function (data) {
                                    alert(data);
                                }
                            });

                            $('#ff').submit();
                        }


                        function clearForm() {
                            $('#ff').form('clear');
                        }
                    </script>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
