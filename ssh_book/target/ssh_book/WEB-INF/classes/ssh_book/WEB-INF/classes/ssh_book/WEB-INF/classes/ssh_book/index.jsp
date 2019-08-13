
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
</head>
<body>


<!--datagrid 开始  -->
<table id="data"></table>
<!--datagrid 结束 -->




</body>
<script type="text/javascript">
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
