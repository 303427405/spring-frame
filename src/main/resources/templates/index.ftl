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
                            <li class="active">
                                <a aria-expanded="false" role="button" href="index-2.html"> 返回首页</a>
                            </li>
                            <li class="dropdown">
                                <a aria-expanded="false" role="button" target="_blank" href="${contextPath}/swagger-ui.html"> Swagger</a>
                            </li>
                            <li class="dropdown">
                                <a aria-expanded="false" role="button" target="_blank" href="${contextPath}/druid/login.html"> 数据监控</a>
                            </li>

                            <li class="dropdown">
                                <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> 菜单 <span class="caret"></span></a>
                                <ul role="menu" class="dropdown-menu">
                                    <li><a href="#">菜单列表</a>
                                    </li>
                                    <li><a href="#">菜单列表</a>
                                    </li>
                                    <li><a href="#">菜单列表</a>
                                    </li>
                                    <li><a href="#">菜单列表</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a aria-expanded="false" role="button" href="#" class="dropdown-toggle" data-toggle="dropdown"> 菜单 <span class="caret"></span></a>
                                <ul role="menu" class="dropdown-menu">
                                    <li><a href="#">菜单列表</a>
                                    </li>
                                    <li><a href="#">菜单列表</a>
                                    </li>
                                    <li><a href="#">菜单列表</a>
                                    </li>
                                    <li><a href="#">菜单列表</a>
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
                    <#list dictionarys as dictionary>
                        <div class="col-sm-4">
                            <div class="contact-box">
                                <a href="${contextPath}/blog/view?dicId=${dictionary.id}">
                                    <div class="col-sm-4">
                                        <div class="text-center">
                                            <img alt="image" class="img-circle m-t-xs img-responsive" src="${contextPath}/${dictionary.head}">
                                            <div class="m-t-xs font-bold">${dictionary.type}</div>
                                        </div>
                                    </div>
                                    <div class="col-sm-8">
                                        <h3><strong>${dictionary.name}</strong></h3>
                                        <p><i class="fa fa-map-marker"></i> ${dictionary.type}</p>
                                        <address>
                                            <strong>${dictionary.application!}</strong><br>
                                            描述:${dictionary.description!}<br>
                                        </address>

                                    </div>
                                    <div class="clearfix"></div>
                                </a>
                            </div>
                        </div>
                    </#list>
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
    <script src="${contextPath}/js/plugins/flot/jquery.flot.js"></script>
    <script src="${contextPath}/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="${contextPath}/js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="${contextPath}/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="${contextPath}/js/demo/peity-demo.min.js"></script>
    <script>
        $(document).ready(function(){var d1=[[1262304000000,6],[1264982400000,3057],[1267401600000,20434],[1270080000000,31982],[1272672000000,26602],[1275350400000,27826],[1277942400000,24302],[1280620800000,24237],[1283299200000,21004],[1285891200000,12144],[1288569600000,10577],[1291161600000,10295]];var d2=[[1262304000000,5],[1264982400000,200],[1267401600000,1605],[1270080000000,6129],[1272672000000,11643],[1275350400000,19055],[1277942400000,30062],[1280620800000,39197],[1283299200000,37000],[1285891200000,27000],[1288569600000,21000],[1291161600000,17000]];var data1=[{label:"数据1",data:d1,color:"#17a084"},{label:"数据2",data:d2,color:"#127e68"}];$.plot($("#flot-chart1"),data1,{xaxis:{tickDecimals:0},series:{lines:{show:true,fill:true,fillColor:{colors:[{opacity:1},{opacity:1}]},},points:{width:0.1,show:false},},grid:{show:false,borderWidth:0},legend:{show:false,}});var lineData={labels:["一月","二月","三月","四月","五月","六月","七月"],datasets:[{label:"示例数据",fillColor:"rgba(220,220,220,0.5)",strokeColor:"rgba(220,220,220,1)",pointColor:"rgba(220,220,220,1)",pointStrokeColor:"#fff",pointHighlightFill:"#fff",pointHighlightStroke:"rgba(220,220,220,1)",data:[65,59,40,51,36,25,40]},{label:"示例数据",fillColor:"rgba(26,179,148,0.5)",strokeColor:"rgba(26,179,148,0.7)",pointColor:"rgba(26,179,148,1)",pointStrokeColor:"#fff",pointHighlightFill:"#fff",pointHighlightStroke:"rgba(26,179,148,1)",data:[48,48,60,39,56,37,30]}]};var lineOptions={scaleShowGridLines:true,scaleGridLineColor:"rgba(0,0,0,.05)",scaleGridLineWidth:1,bezierCurve:true,bezierCurveTension:0.4,pointDot:true,pointDotRadius:4,pointDotStrokeWidth:1,pointHitDetectionRadius:20,datasetStroke:true,datasetStrokeWidth:2,datasetFill:true,responsive:true,};var ctx=document.getElementById("lineChart").getContext("2d");var myNewChart=new Chart(ctx).Line(lineData,lineOptions)});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/index_v5.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:52 GMT -->
</html>
