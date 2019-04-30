
<#include "../layout/main.ftl" >
<@header title="技术记录">
</@header>

<@body>
<body class="gray-bg top-navigation">

<div id="wrapper">
    <div id="page-wrapper" class="gray-bg">
        <@top/>

        <div class="wrapper wrapper-content  animated fadeInRight blog">
            <div class="row">


                <#list blogs as blog>
                    <div class="col-lg-12">
                        <div class="ibox">
                            <div class="ibox-content">
                                <a href="${contextPath}/blog/todetail?id=${blog.id!}" class="btn-link">
                                    <h2>
                                    ${blog.name!}
                                    </h2>
                                </a>
                                <div class="small m-b-xs">
                                    <span class="text-muted"><i class="fa fa-clock-o"></i> ${blog.createTime!}</span>
                                </div>
                                <p>
                                ${blog.description!}
                                </p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <h5>标签：</h5>
                                        <button class="btn btn-primary btn-xs" type="button">Apple Watch</button>
                                        <button class="btn btn-white btn-xs" type="button">速比涛</button>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="small text-right">
                                            <h5>状态：</h5>
                                            <i class="fa fa-eye"> </i> 144 浏览
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </#list>



            </div>
        </div>
        <@bottom/>
    </div>
</div>
</body>
</@body>

<@footer>
</@footer>
<!-- Mirrored from www.zi-han.net/theme/hplus/index_v5.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:52 GMT -->
</html>