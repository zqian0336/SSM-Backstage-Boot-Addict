<%--
  Created by IntelliJ IDEA.
  User: zhichengqian
  Date: 9/20/20
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>产品管理</title>

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                数据管理 <small>产品列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">基础数据</a></li>
                <li><a href="${pageContext.request.contextPath}/product/findAllProductByMsg">产品管理</a></li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>
                <div class="box-body">
                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建"
                                            onclick="location.href='${pageContext.request.contextPath}/forward/forwardProductAdd'">
                                        <i class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="button" id="delBtn" class="btn btn-default" title="删除">
                                        <i class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" id="open" title="开启">
                                        <i class="fa fa-check"></i> 开启
                                    </button>
                                    <button type="button" class="btn btn-default" id="close" title="关闭">
                                        <i class="fa fa-ban"></i> 关闭
                                    </button>
                                    <button type="button" class="btn btn-default" id="refresh" title="刷新">
                                        <i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm"
                                       placeholder="搜索"> <span
                                    class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <table id="dataList"
                               class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right: 0px;"><input
                                        id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="sorting_asc">ID</th>
                                <th class="sorting_desc">编号</th>
                                <th class="sorting_asc sorting_asc_disabled">产品名称</th>
                                <th class="sorting_desc sorting_desc_disabled">出发城市</th>
                                <th class="sorting">出发时间</th>
                                <th class="text-center sorting">产品价格</th>
                                <th class="sorting">产品描述</th>
                                <th class="text-center sorting">状态</th>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>

                            <tbody id="productLists">
                            <c:forEach items="${pageInfo.list}" var="product">
                                <tr>
                                    <td><input name="ids" type="checkbox" id="productList"></td>
                                    <td id="ID">${product.id }</td>
                                    <td>${product.productNum }</td>
                                    <td>${product.productName }</td>
                                    <td>${product.cityName }</td>
                                    <td>${product.departureTimeStr }</td>
                                    <td class="text-center">${product.productPrice}</td>
                                    <td>${product.productDesc }</td>
                                    <td class="text-center">${product.productStatusStr}</td>
                                    <td class="text-center">
                                        <button type="button" class="btn bg-olive btn-xs">订单</button>
                                        <button type="button" class="btn bg-olive btn-xs"
                                                onclick="location.href='${pageContext.request.contextPath}/product/findProductById?id=${product.id}'">
                                            详情
                                        </button>
                                        <button type="button" class="btn bg-olive btn-xs"
                                                onclick="location.href='${pageContext.request.contextPath}/product/findProductById2?id=${product.id}'">
                                            编辑
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <!--数据列表/-->
                    </div>
                    <!-- 数据表格 /-->
                </div>

                <div class="box-footer bg-light-blue" style="height: 50px;padding: 8px;line-height: 36px">
                    <div class="pull-left">
                        <div class="form-group form-inline" style="margin: 0;font-size: 16px">
                            总共${pageInfo.pages}页，共${pageInfo.total}条数据。 每页
                            <select style="color: #0c0c0c;outline: none" id="changePageSize"
                                    onchange="changePageSize()">
                                <option>${pageInfo.pageSize}</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select> 条
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination" style="height: 30px;margin: 0;padding: 0">
                            <li>
                                <a href="${pageContext.request.contextPath}/product/findAllProductByMsg?page=1&pageSize=${pageInfo.pageSize}&searchMsg=${searchMsg}"
                                   aria-label="Previous">首页</a></li>
                            <li>
                                <a href="${pageContext.request.contextPath}/product/findAllProductByMsg?page=${pageInfo.prePage}&pageSize=${pageInfo.pageSize}&searchMsg=${searchMsg}">上一页</a>
                            </li>

                            <%--1、一共要显示10个页码--%>
                            <c:if test="${pageInfo.pages<=10}">
                                <%--总页码不够10页--%>
                                <c:forEach begin="1" end="${pageInfo.pages}" var="pageNum">
                                    <c:if test="${pageInfo.pageNum != pageNum}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/product/findAllProductByMsg?page=${pageNum}&pageSize=${pageInfo.pageSize}&searchMsg=${searchMsg}">${pageNum}</a>
                                        </li>
                                    </c:if>

                                    <c:if test="${pageInfo.pageNum == pageNum}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/product/findAllProductByMsg?page=${pageNum}&pageSize=${pageInfo.pageSize}&searchMsg=${searchMsg}"
                                               style="background-color: #3498db;color: #FFFFFF;border-bottom: 1px solid #3498db;border-top: 1px solid #3498db">${pageNum}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </c:if>

                            <%--总页码超过10页--%>
                            <c:if test="${pageInfo.pages>10}">
                                <%--前5后4--%>
                                <c:set var="begin" value="${pageInfo.pageNum-5}"></c:set>
                                <c:set var="end" value="${pageInfo.pageNum+4}"></c:set>
                                <%--如果前边不够5个，后边补齐10个--%>
                                <c:if test="${begin<1}">
                                    <c:set var="begin" value="1"></c:set>
                                    <c:set var="end" value="${begin+9}"></c:set>
                                </c:if>
                                <%--如果后边不足4个，前边补齐10个--%>
                                <c:if test="${end>pageInfo.pages}">
                                    <c:set var="end" value="${pageInfo.pages}"></c:set>
                                    <c:set var="begin" value="${end-9}"></c:set>
                                </c:if>
                                <c:forEach begin="${begin}" end="${end}" var="pageNum">
                                    <c:if test="${pageInfo.pageNum != pageNum}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/product/findAllProductByMsg?page=${pageNum}&pageSize=${pageInfo.pageSize}&searchMsg=${searchMsg}">${pageNum}</a>
                                        </li>
                                    </c:if>

                                    <c:if test="${pageInfo.pageNum == pageNum}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/product/findAllProductByMsg?page=${pageNum}&pageSize=${pageInfo.pageSize}&searchMsg=${searchMsg}"
                                               style="background-color: #3498db;color: #FFFFFF;border-bottom: 1px solid #3498db;border-top: 1px solid #3498db">${pageNum}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </c:if>

                            <li>
                                <a href="${pageContext.request.contextPath}/product/findAllProductByMsg?page=${pageInfo.nextPage}&pageSize=${pageInfo.pageSize}&searchMsg=${searchMsg}">下一页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/product/findAllProductByMsg?page=${pageInfo.pages}&pageSize=${pageInfo.pageSize}&searchMsg=${searchMsg}"
                                   aria-label="Next">尾页</a></li>
                        </ul>
                    </div>
                </div>
                <!-- /.box-footer-->
            </div>
        </section>
        <!-- 正文区域 /-->
    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2020-2021 <a
                href="http://www.huaxin.press">孙启新</a>
        </strong>&nbsp;版权所有&nbsp;&nbsp;&nbsp;鲁ICP备20005824号
    </footer>
    <!-- 底部导航 /-->
</div>


<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    /*每页显示条数选项*/
    function changePageSize() {
        //获取下拉框的值
        let pageSize = $("#changePageSize").val();
        //向服务器发送请求，改变没页显示条数
        location.href = "${pageContext.request.contextPath}/product/findAllProductByMsg?page=1&pageSize="
            + pageSize+"&searchMsg=${searchMsg}";
    }
    $(document).ready(function () {
        // 选择框
        $(".select2").select2();
        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });
    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }
    $(document).ready(function () {
        // 激活导航位置
        setSidebarActive("admin-datalist");
        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function () {
            let clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
    $(function () {
        //删除操作
        $("#delBtn").click(function () {
            let dataList = $("#productLists tr");
            $.each(dataList, function () {
                //获取被选中的行
                let flag = $(this).find("input").is(':checked');
                if (flag) {
                    //获取选中行的id值
                    let id = $(this).find("#ID").html();
                    $.get("${pageContext.request.contextPath}/product/deleteProduct", {"id": id}, function () {
                    })
                }
            });
            $.get("${pageContext.request.contextPath}/product/findAllProductByMsg", {}, function () {
                location.reload();
            })
        });
        //刷新操作
        $("#refresh").click(function () {
            location.reload();
        })
        //点击开启按钮操作
        $("#open").click(function () {
            let dataList = $("#productLists tr");
            $.each(dataList, function () {
                //获取被选中的行
                let flag = $(this).find("input").is(':checked');
                if (flag) {
                    //获取选中行的id值
                    let id = $(this).find("#ID").html();
                    $.get("${pageContext.request.contextPath}/product/updateProduct", {
                        "id": id,
                        "productStatus": 1
                    }, function () {
                    })
                }
            });
            $.get("${pageContext.request.contextPath}/product/findAllProductByMsg", {}, function () {
                location.reload();
            });
        });
        //点击关闭按钮操作
        $("#close").click(function () {
            let dataList = $("#productLists tr");
            $.each(dataList, function () {
                //获取被选中的行
                let flag = $(this).find("input").is(':checked');
                if (flag) {
                    //获取选中行的id值
                    let id = $(this).find("#ID").html();
                    $.get("${pageContext.request.contextPath}/product/updateProduct", {
                        "id": id,
                        "productStatus": 0
                    }, function () {
                    })
                }
            });
            $.get("${pageContext.request.contextPath}/product/findAllProductByMsg", {}, function () {
                location.reload();
            });
        });
    });
</script>
</body>

</html>
