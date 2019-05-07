<%--
  Created by IntelliJ IDEA.
  User: bliu
  Date: 2019/5/6
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add course</title>
    <link rel="stylesheet" type="text/css" href="../css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../css/themes/icon.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
</head>
<body>
<div style="margin: 0 10px">
<h2>课程管理</h2>
<p>您可进行课程的增加、修改、删除操作</p>
<div>

    <table id="dg" class="easyui-datagrid" title="课程管理" style="height:390px"
           data-options="singleSelect:true,collapsible:true,url:'course/getdata',method:'get',toolbar:toolbar" rownumbers="true" fitColumns="true" pagination="true">
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
        </tr>
        </thead>
    </table>

</div>


<%--模态框--%>
<div id="dlg" class="easyui-dialog" title="添加课程" style="width:500px;height:400px;"
     data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="ff" method="post" style="margin:0;padding:20px 50px">
        <div style="margin-bottom: 10px">
            <input class="easyui-textbox" type="text" name="coursename" data-options="required:true" label="课程名：" style="width: 100%"/>
        </div>
        <div style="margin-bottom: 10px">
            <input class="easyui-textbox" type="text" name="message" data-options="required:true" label="课程信息:" style="width: 100%"/>
        </div>
        <div style="margin-bottom: 10px">
            <input id="dt1" class="easyui-datebox" type="text" name="begintime" data-options="required:true,formatter:myformatter,parser:myparser" label="开始时间:" style="width: 100%"/>
        </div>
        <div style="margin-bottom: 10px">
            <input id="dt2" class="easyui-datebox" type="text" name="endtime" data-options="required:true,formatter:myformatter,parser:myparser" label="结束时间:" style="width: 100%"/>
        </div>

        <div style="margin-bottom: 10px">
            <input class="easyui-textbox" type="text" name="category" data-options="required:true" label="课程分类:" style="width: 100%"/>
        </div>
        <div style="margin-bottom: 10px">
            <input class="easyui-textbox" type="text" name="departmentid" data-options="required:true" label="开设院系:" style="width: 100%"/>
        </div>



    </form>
</div>

<script>


    /**
    *
    *日期格式化
    */
    function myformatter(date){
        var y = date.getFullYear();
        var m = date.getMonth()+1;
        var d = date.getDate();
        return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
    }
    function myparser(s){
        if (!s) return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0],10);
        var m = parseInt(ss[1],10);
        var d = parseInt(ss[2],10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
            return new Date(y,m-1,d);
        } else {
            return new Date();
        }
    }



</script>

<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>


<script type="text/javascript">


    function saveUser() {
        $('#ff').form({
            url:'course/addCourse',
            onSubmit: function(){
                return $(this).form('validate');
                // do some check
                // return false to prevent submit;
            },
            success:function(data){
                alert(data)
                var data1 = eval('(' + data + ')');
                $.messager.show({
                    title:'添加成功',
                    msg:'message:'+data1.res,
                    timeout:5000,
                    showType:'slide'
                });
                $("#dlg").dialog('close')
            }
        });
        // submit the form
        $('#ff').submit();

    }


    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
            $("#dlg").dialog('open')

        }
    },{
        text:'修改',
        iconCls:'icon-edit',
        handler:function(){alert('edit')}
    }, {
        text:'删除',
        iconCls:'icon-remove',
        handler:function(){alert('remove')}
        },'-',{
        text:'Save',
        iconCls:'icon-save',
        handler:function(){alert('save')}
    }];
</script>
</div>
</body>
</html>
