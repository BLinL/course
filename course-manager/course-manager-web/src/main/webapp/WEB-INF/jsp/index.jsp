<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: bliu
  Date: 2019/3/17
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上选课系统</title>
    <link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
</head>

<body class="easyui-layout">



        <div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
            <%--学生菜单--%>
            <shiro:hasRole name="student">
                <ul id="tt" class="easyui-tree">
                    <li>
                        <span>选课管理</span>
                        <ul>
                            <li data-options="attributes:{'url':'course_list'}"><span>所有课程</span></li>
                            <li data-options="attributes:{'url':'select_course'}"><span>我的课程</span></li>
                        </ul>
                    </li>
                </ul>
            </shiro:hasRole>


            <%--教师菜单--%>
            <shiro:hasRole name="teacher">
                <ul id="tch" class="easyui-tree">
                    <li>
                        <span>课程管理</span>
                        <ul>
                            <li data-options="attributes:{'url':'course_add'}"><span>课程添加</span></li>
                            <li data-options="attributes:{'url':'course_add'}"><span>成绩管理</span></li>
                        </ul>
                    </li>
                </ul>
            </shiro:hasRole>

            <shiro:hasRole name="admin">
                <ul id="adm" class="easyui-tree">
                    <li>
                        <span>课程管理</span>
                        <ul>
                            <li data-options="attributes:{'url':'course_list'}"><span>课程审核</span></li>
                            <li data-options="attributes:{'url':'select_course'}"><span>学生管理</span></li>
                        </ul>
                    </li>
                </ul>
            </shiro:hasRole>
        </div>

        <div data-options="region:'center'" style="padding:5px;background:#eee">
            <div id="tb" class="easyui-tabs" style="height: 520px">
                <div title="Tab1" style="padding:20px;display:none;">
                    首页
                </div>
            </div>

        </div>

        <div data-options="region:'south',title:'South Title',split:true" style="height:100px;">

        </div>


        <script type="text/javascript">

            $('#tt').tree({
                onClick: function(node){
                    var node_text = node.text;

                    if(node_text ==="选课管理"){

                    }else{
                        var tabs = $("#tb");
                        var tab = tabs.tabs("getTab",node_text);

                        if(tab){
                            tabs.tabs("select",node_text);
                        }else{
                            // 添加一个新的标签页面板（tab panel）
                            tabs.tabs('add',{

                                fit:true,
                                border:false,
                                title:node_text,
                                content:'Tab Body',
                                closable:true,
                                href:node.attributes.url

                            });
                        }
                    }
                }
            });

            $("#tch").tree({
                onClick:function (node) {
                   var node_text = node.text;

                   if(node_text === "课程管理") {

                   } else {
                       var tabs = $("#tb");
                       var tab = tabs.tabs("getTab",node_text);
                       if(tab){
                           tabs.tabs("select",node_text)
                       }else{
                           // 添加一个新的标签页面板（tab panel）
                           tabs.tabs('add',{
                               title:node_text,
                               content:'Tab Body',
                               closable:true,
                               href:node.attributes.url
                           });
                       }
                   }
                }



            })

        </script>
</body>
</html>
