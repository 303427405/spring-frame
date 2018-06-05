$(function() {
    var param = JQ_COM_API.getQueryParam();

    /**获取字典项*/
    JQ_COM_API.requestByJson({
        url: "/dict/list",
        method: "POST",
    }, {
        success : function(req,result){
            $("#skill").empty();
            result.forEach(function (v) {
                $("#skill").append("<option value='"+v.id+"'>"+v.name+"</option>")
            })

        },
        fail : function(req , result){

        }
    });
    
    
    $("#sub").click(function () {
        JQ_COM_API.requestByJson({
            url: "/blog/add",
            method: "POST",
            async:true,
            data:{
                name:$("#name").val(),
                description:$("#description").val(),
                skill:$("#skill").val(),
                content:$("#content").val()
            }
        }, {
            success : function(req,result){
               window.location.href = "/home";

            },
            fail : function(req , result){

            }
        });
    })
})
