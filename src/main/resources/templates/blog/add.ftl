<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/index_v5.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:51 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>技术记录</title>

    <link href="${contextPath}/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="${contextPath}/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${contextPath}/css/animate.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/plugins/simditor/simditor.css" />
    <link href="${contextPath}/css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg top-navigation">

    <div id="wrapper">
        <div id="page-wrapper" class="gray-bg">
            <div class="row border-bottom white-bg">
                <nav class="navbar navbar-static-top" role="navigation">
                    <div class="navbar-header">
                        <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
                            <i class="fa fa-reorder"></i>
                        </button>
                        <a href="#" class="navbar-brand">dc</a>
                    </div>
                    <div class="navbar-collapse collapse" id="navbar">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a aria-expanded="false" role="button" href="${contextPath}/home"> 返回首页</a>
                            </li>
                            <li class="dropdown">
                                <a aria-expanded="false" role="button" target="_blank" href="${contextPath}/swagger-ui.html"> Swagger</a>
                            </li>
                            <li class="dropdown">
                                <a aria-expanded="false" role="button" target="_blank" href="${contextPath}/druid/login.html"> 数据监控</a>
                            </li>

                            <li class="dropdown">
                                <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> 日志记录 <span class="caret"></span></a>
                                <ul role="menu" class="dropdown-menu">
                                    <li>
                                        <a href="${contextPath}/blog/toadd"> 日志录入</a>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                        <ul class="nav navbar-top-links navbar-right">
                            <li>
                                <a href="${contextPath}/logout">
                                    <i class="fa fa-sign-out"></i> 退出
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>

            <div class="wrapper wrapper-content animated fadeInRight">
                <div class="row">
                    <form class="form-horizontal">

                        <div class="form-group">
                            <label class="col-sm-1 control-label">日志名称：</label>
                            <div class="col-sm-11">
                                <input type="text" class="form-control" name="name" id="name">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-1 control-label">简易描述：</label>
                            <div class="col-sm-11">
                                <input type="text" class="form-control" id="description" name="description"> <span class="help-block m-b-none">用于标题展示</span>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-1 control-label">所属技术：</label>
                            <div class="col-sm-11">
                                <select class="form-control m-b" name="account" id="skill">
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>国产simditor富文本编辑器</h5>
                                    </div>
                                    <div class="ibox-content">
                                        <textarea id="content" name="content" placeholder="这里输入内容" autofocus>

                                        </textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-6 col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit" id="sub">保存内容</button>
                                <button class="btn btn-white" type="button">取消</button>
                            </div>
                        </div>

                    </form>

                </div>
            </div>

            <div class="footer">
                <div class="pull-right">
                    By：<a href="http://www.zi-han.net/" target="_blank">zyf's blog</a>
                </div>
                <div>
                    <strong>Copyright</strong> &copy; 2018
                </div>
            </div>
        </div>
    </div>

    <script src="${contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${contextPath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${contextPath}/js/content.min.js?v=1.0.0"></script>
    <script type="text/javascript" src="${contextPath}/js/asstes/common.ajax.js"></script>
    <script type="text/javascript" src="${contextPath}/js/asstes/dictionary/dictionary.js"></script>


    <script type="text/javascript" src="${contextPath}/js/plugins/simditor/module.js"></script>
    <script type="text/javascript" src="${contextPath}/js/plugins/simditor/uploader.js"></script>
    <script type="text/javascript" src="${contextPath}/js/plugins/simditor/hotkeys.js"></script>
    <script type="text/javascript" src="${contextPath}/js/plugins/simditor/simditor.js"></script>
    <script>
        $(document).ready(function(){var content=new Simditor({textarea:$("#content"),defaultImage:"img/a9.jpg"})});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>


</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/index_v5.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:52 GMT -->
</html>
