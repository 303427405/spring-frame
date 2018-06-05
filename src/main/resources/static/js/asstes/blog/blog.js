$(function() {
    var param = JQ_COM_API.getQueryParam();

    function htmlEscape(text){
        return text.replace(/[<>"&]/g, function(match, pos, originalText){
            switch(match){
                case "<": return "&lt;";
                case ">":return "&gt;";
                case "&":return "&amp;";
                case "\"":return "&quot;";
            }
        });
    }

    /**获取字典项*/
    JQ_COM_API.requestByJson({
        url: "/blog/detail",
        method: "GET",
        data:{
            id:param.id
        }
    }, {
        success : function(req,result){
           $("#content").html(result.description);
           $("#name").text(result.name)
        },
        fail : function(req , result){

        }
    });



    function HTMLDecode(text) {
        var temp = document.createElement("div");
        temp.innerHTML = text;
        var output = temp.innerText || temp.textContent;
        temp = null;
        return output;
    }
})
