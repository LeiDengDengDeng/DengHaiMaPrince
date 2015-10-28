var item_amount = 0;

function init()
{
	$.ajax({
		url:"./AddImportList",
		type:"POST",
		data:{method:"init"},
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		success:function(data){
			initSelector(data);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
             alert(XMLHttpRequest.status);
             alert(XMLHttpRequest.readyState);
             alert(textStatus);
        }
	});
}

function initSelector(data){
	for(var i in data){
		$("#supplier").append("<option value="+data[i].id+">"+data[i].name+"</option>")
	};
}

function addItem(){
	var no = $("#comm_no").val();
	var amount = $("#amount").val();
	if(amount <1){
		alert("请输入正确数量");
		return;
	}
	var note = $("#note").val();
	
	$.ajax({
		url:"./AddImportList",
		type:"POST",
		data:{method:"addItem", no:no,amount:amount,note:note},
		dataType:"json",
		contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		success:function(data){
			if(data.status!=0){
				addItemToTable(data);
			}
			else{
				alert("查无此商品");
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
             alert(XMLHttpRequest.status);
             alert(XMLHttpRequest.readyState);
             alert(textStatus);
        }
	});
}

function addItemToTable(data){
	var string = "";
	string += "<tr id="+ item_amount +">";
	string += "<td>"+data.no+"</td>";
	string += "<td>"+data.name+"</td>";
	string += "<td>"+data.type+"</td>";
	string += "<td>"+data.amount+"</td>";
	string += "<td>"+data.price+"</td>";
	string += "<td>"+data.totalPrice+"</td>";
	string += "<td>"+data.note+"</td>";
	string += "<td><input type=\"radio\" name=\"itemRadio\" value="+ item_amount +"></td>"
	string += "</tr>";
	$("#itemTable").append(string);
	item_amount ++;
	
	$("#totalPrice").html("总价："+data.total);
	
	$("#comm_no").val("");
	$("#amount").val(0);
	$("#note").val("");
}

function deleteItem(){
    var selected_radio = $("input[name='itemRadio']:checked").val();
    if(selected_radio == null){
    	alert("请选中一个进货项");
    	return;
    }
    
    if(confirm("确定要删除吗？")){   
        $.ajax({  
            url:"./AddImportList",  
            type:"post",   
            dataType:"json",
            data:{method:"deleteItem", index:selected_radio},  
            success:function(data){
    			if(data.status!=0){
    				deleteItemFromTable(data);
    			}
    			else{
    				alert("删除失败！");
    			}
            },
    		error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
           }
        });  
    } 
}

function deleteItemFromTable(data){
	$("tr[id="+data.index+"]").remove();
	$("#totalPrice").html("总价："+data.total);
	item_amount --;
}

function submit(){
	var supplier = $("#supplier").val();
    $.ajax({  
        url:"./AddImportList",  
        type:"post",   
        dataType:"json",
        data:{method:"submit", "supplier":supplier},  
        success:function(data){
			if(data.status!=0){
				alert("提交进货单成功!");
				location.reload() 
			}
			else{
				alert("提交失败！");
			}
        },
		error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
       }
    });
}