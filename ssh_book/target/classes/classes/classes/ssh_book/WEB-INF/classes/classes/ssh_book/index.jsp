
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>标题</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script src="js/jquery-1.8.0.js"></script>
    <link rel="stylesheet" type="text/css" href="js/easyui-1.7.0/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="js/easyui-1.7.0/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="js/easyui-1.7.0/demo.css">
    <script type="text/javascript" src="js/easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript" src="js/easyui-1.7.0/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/easyui-1.7.0/plugins/jquery.datagrid.js"></script>
    <script type="text/javascript" src="<%=path%>/js/myEsyui.js"></script>
    <script type="text/javascript" src="<%=path%>/js/my97/WdatePicker.js"></script>
</head>
<body>

<div>
    <a id="btn" href="javaScript:openDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
    <a id="btn1" href="javaScript:editDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
    <a id="btn2" href="javaScript:delDialog()" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</a>
</div>

<!--datagrid 开始  -->
<table id="data"></table>
<!--datagrid 结束 -->

    <div id="myDialog" class="easyui-dialog" title="新增" style="width: 400px; height: 300px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true"
     buttons="#add2DialogButtons" closed="true">
    <form id="addForm">
        <input name="id" type="hidden">
        客户名称:<input type="text" name="cust.name"><br>
        所属地区:<select name="cust.location_id">
        <option value="1">中国
        <option value="2">洛阳
        <option value="3">偃师
    </select><br>
        录入时间:<input class="Wdate" name="cust.create_time" onClick="WdatePicker()"><br>
        电话:<input type="text" name="cust.phone"><br>
        部门:<select name="cust.department_id">
        <option value="1">java
        <option value="2">测试
        <option value="3">UI
    </select><br>
        备注:<input type="text" name="cust.description"><br>
    </form>
</div>
<div id="add2DialogButtons">
    <a href="javascript:addBook()" class="easyui-linkbutton" iconCls="icon-ok">确认</a>
    <a href="javascript:guanbi()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>



</body>
<script type="text/javascript">

    function openDialog(){
        $("#myDialog").dialog("open");
    }
    function guanbi(){
        $("#myDialog").dialog("close");
    }
    function addBook(){
        $("#addForm").form("submit",{
            url:"<%=path%>/customer!addCust.action",
            success:function(){

                $("#myDialog").dialog("close");

                $("#data").datagrid('reload');
            }
        })
    }


    $(function(){
        queryData();
    });

    //查询
    function queryData(){

        $('#data').datagrid({
            url:'<%=path%>/customer!queryCust.action',
            fitColumns:true,
            columns: [[
                {field: 'checkbox', checkbox: true},  //开启复选框
                {field: 'id', title: '序号', width: 300},      //  列    field   代表是 后台  传过来的值
                {field: 'name', title: '公司名称', width: 300},
                {field: 'lname', title: '所属省市', width: 300},
                {field: 'create_time', title: '录入时间', width: 300},
                {field: 'gj_time', title: '跟进时间', width: 300},
                {field: 'phone', title: '电话', width: 300},
                {field: 'dname', title: '部门', width: 300},
                {field: 'description', title: '备注', width: 300},
                {field: 'xxx', title: '操作', width: 300,
                    formatter:function(value,row,index){
                        return "<a href='JavaScript:genjin()'>跟进</a>"
                    }}
            ]],
            pagination:true,
            pageList:[2,5,10],
            rownumbers:true,
            //fit:true,
            fitColumns:true
        });

    }


    function searchSer(){
        $.ajax({
            url:"<%=path%>/jie/add.do",
            type:"post",
            data:$("#tc").serialize(),
            success:function(){
                alert("新增成功");

                location.href=location;

            }

        })

    }









</script>

</html>
