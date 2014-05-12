<html>
<body>
<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript">
  var clear = function(){
	  var e = document.getElementById("textId")
	  e.value = "";
  }
  var store = function(){
	  //objeto localStorage - responsável por armazenar os dados localmente no browser
	  //metodos: setItem(key, value) (ex. key = 'store-temp' e value = 'Mensagem de Texto para este input')
	  var e = document.getElementById("textId")
	  localStorage.setItem("store-temp", e.value);
	  clear();
  }
  var get = function(){
	  //elemento do tipo input
	  var e = document.getElementById("textId")
	  //objeto de armazenamento: localStorage
	  //método de recuperação de dados offline é getItem(key)
	  e.value = localStorage.getItem("store-temp");
  }
  var ping = function(){
	  jQuery.get("ping.lulu", function(response){
		  jQuery("div").html(response)
		})
  }
  setTimeout(ping, 2000);//uma vez
  setInterval(ping, 5000)//sempre a cada dois segundos
</script>
<textarea id="textId"></textarea>
<button onclick="javascript: store();">Enviar</button>
<button onclick="javascript: get();">Recuperar</button>
<button onclick="javascript: ping();">Ping</button>
<div></div>
</body>
</html>
