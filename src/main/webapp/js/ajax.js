const time = new Date();
const threeDays = 3*24*60*60*1000;
time.setTime(time.getTime() + (threeDays));
let expires = "expires="+time.toUTCString();
document.cookie = "XSRF-TOKEN="+$('meta[name="csrf-token"]').attr('content')+";"+expires+";path=/;";

$(function() {
	$.ajaxSetup({
	  headers: {
		'X-CSRF-TOKEN' : $('meta[name="csrf-token"]').attr('content')
	  }
	});
});

$(function(){
	$("#piatti").fadeIn(()=>{
		$.ajax({
			type:"GET",
			method:"GET",
			dataType:"json",
			url:"/pietro/json/piatti.json",
			data:{
				token:$('meta[name="csrf-token"]').attr('content')
			},
			error:(error)=>{
				console.log("Errore : "+error);
			},
			success:(data)=>{
				let tag = "<h4>Seleziona i piatti che preferisci,"
				+" puoi fare massimo 10 ordini alla volta. </h4>";
				var word = "";
				$.each(data,(item,i)=>{
					word = "'"+i.pasto+"'";
					tag +=
					'<div class="box" onclick="object.carrello('+word+');">' +
					'<div class="img">' +
					'<img src="/pietro/img/pasta.webp">' +
					'</div>' +
					'<div>' +
					i.pasto +
					'</div>' +
					'</div>';
				});

				$("#piatti").html(tag);
			}
		});
	});
});

$(function(){
	$("#giacenza").fadeIn(()=>{
		$.ajax({
			type:"GET",
			method:"GET",
			dataType:"json",
			url:"/pietro/rest/file/giacenza",
			data:{
				token:$('meta[name="csrf-token"]').attr('content')
			},
			error:(error)=>{
				console.log("Errore : "+error);
			},
			success:(data)=>{
				let tag = "";
				$.each(data,(item,i)=>{;
					tag += 
					"<tr>" +
					"<td>" + i.ingrediente + "</td>" +
					"<td>" + i.quantita + "</td>" +
					"<td>" + i.giacenza + "</td>" +
					"</tr>";
				});
				
				$("#tbody").html(tag);
			}
		});
	});
});

$(function(){
	$("#disponibile-button").on("click",()=>{
		$.ajax({
			type:"GET",
			method:"GET",
			dataType:"json",
			url:"/pietro/rest/file/tavolo",
			data:{
				token:$('meta[name="csrf-token"]').attr('content')
			},
			error:(error)=>{
				console.log("Errore : "+error);
			},
			success:(data)=>{
				let tavolo = $("#tab").val();
				let giorno =  $("#giorno").val();
				let orario = $("#orario").val();
				let liberi = 3;

				$.each(data,(item,i)=>{
					if(parseInt(tavolo)===parseInt(i.tavolo) && giorno===i.giorno && orario===i.orario) {
						liberi = liberi - parseInt(i.occupati);
					}
				});

				tag = "Tavoli da " + tavolo +" posti sono disponibili " + liberi + " tavoli per il giorno " + giorno + " e per l'orario " + orario;
				$("#messaggio").append("<h4>"+tag+"</h4>");
				liberi = 3;
			}
		});
	});
});