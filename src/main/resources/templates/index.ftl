<#include "layout/main.ftl" >
<@header title="技术记录">
</@header>

<@body>
<body class="gray-bg top-navigation">

    <div id="wrapper">
        <div id="page-wrapper" class="gray-bg">
            <@top/>

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
            <@bottom/>
        </div>
    </div>
</body>
</@body>

<@footer>
</@footer>
<!-- Mirrored from www.zi-han.net/theme/hplus/index_v5.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:52 GMT -->
</html>
