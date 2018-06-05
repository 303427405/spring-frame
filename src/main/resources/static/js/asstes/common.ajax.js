/**
 * 公共js
 *
 * **/
var JQ_COM_API = jQuery;

$(function() {

    JQ_COM_API.pageSize = 10;

    /**
     * ajax json 请求
     * */
    JQ_COM_API.requestByJson = function(req,fun){
        fun.success = fun.success ||  function(req){console.log('获取成功')};
        fun.cancel  = fun.cancel  ||  function(req){console.log('操作取消')};
        fun.fail    = fun.fail    ||  function(req){console.log('操作失败')};
        $.ajax({
            url:         req.url ,
            type:        req.method      || "POST",
            // contentType: req.contentType || 'application/json',
            dataType:    req.dataType    || "json",
            async:       req.async == null ? false : req.async,
            timeout:     req.timeout     || 60000,
            data:        req.data        || {},
            /*beforeSend: function(xhr) {
                 xhr.setRequestHeader("X-CSRF-TOKEN",$('meta[name="csrf-token"]').attr('content'));
            },*/
            success: function (data) {
                var code  = data.code || data.status;
                if(code == 404){
                    window.location.href = "/error";
                }else if( code == 1 || code == null){
                    fun.success(req,data);
                } else{
                    fun.fail(req,data);
                }
            },
            error: function(xhr, type){

                if (xhr.status == 401) {
                    try {
                        var jsonObj = xhr.responseText;
                        if (typeof jsonObj === 'string') {
                            jsonObj = JSON.parse(jsonObj);
                        }
                        if (jsonObj.status == 401) {
                            // 弹出登录框
                            // loginPop();
                        }

                    } catch (err) {

                    }
                } else {
                    layer.alert('错误信息提醒！！！', {title: '提示', icon: 5});
                }
                fun.fail(req,null);
            }
        })
    }


    /**获取请求参数*/
    JQ_COM_API.getQueryParam = function () {
        /**获取url中"?"符后的字串*/
        var url = location.search;
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(1);
            var arr = str.split("&");
            for(var i = 0; i < arr.length; i ++) {
                var obj = arr[i].split("=");
                theRequest[obj[0]] = decodeURIComponent(obj[1]);
            }
        }
        return theRequest;
    }
})
