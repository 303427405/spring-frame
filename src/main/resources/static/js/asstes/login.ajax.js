/**
 * ajax login js
 *
 * **/

$(function() {

    $(document).on('click' , '#loginAjax',function(){
        var $u = $("body #loginForm").find("#uajax");
        var $p = $("body #loginForm").find("#pajax");
        var username = $u.val();
        var password = $p.val();
        if (!username) {
            $u.focus();
            addError('Please fill in the name of the username');
            return
        }
        if (!password) {
            $p.focus();
            addError('Please fill in the password');
            return;
        }


        $.ajax({
            type: "POST",
            url: "/u/signin_check",
            data: {
                "u": username,
                "p": CryptoJS.MD5(password).toString()
            },
            async: false,
            success: function(data) {
                if (data.status != 1) {
                    addError(data.msg);
                }
                else {
                    // document.location.reload();
                    layer.closeAll();
                }
            }
        });
    })

    function addError(text) {
        $('.errror').find('em').text(text);
    }


    $(document).keydown(function(event) {
        if (event.keyCode == 13) {
            $("#loginForm").click();
        }
    });

    /**验证登录用户是否激活*/
    $(document).on('blur' , '#uajax',function(){
        JQ_COM_API.requestByJson({
            url: "/u/validate",
            method: "POST",
            data:{
                userName : $("body #loginForm").find("#uajax").val()
    },
        }, {
            success : function(req,result){
            },
            fail : function(req , result){
                console.log(result)
                if(result.details.indexOf("activated") > 0){
                    $('.errror').find('em').html("<a href='/u/activation.html'>Please click here to activate the account</a>");
                }
                if(result.details.indexOf("information") > 0){
                    addError(result.details);
                }
            }
        });
    })

    $("#signOut").click(function () {
        /**提交数据*/
        JQ_COM_API.requestByJson({
            url: "/u/logout",
            method: "POST",
        }, {
            success : function(req,result){
                window.location.href = "/";
            },
            fail : function(req , result){
                window.location.href = "/u/signin.html";

            }
        });
    })
})
