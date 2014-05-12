<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos/home.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery.js"></script> 
        <title>Bem vindo ${usuario.nome} - Home</title>
    </head>
    <body>
        <div id="menu"><span><a id="miauter" href="home.jsp">Miautter.com</span></a></div>              
        <div id="container">
            <div id="perfil">
                <h3>PERFIL</h3>
                <h1>Bem vindo ${usuario.nome}</h1>
<div class="panel">
   <textarea id="textId" style="display:block"></textarea>
   <button onclick="javascript: postMessage()">enviar</button>
</div>
                
            </div>
            <div id="feed">
                
                <!-- painel de escrita -->
<!-- painel de resposta -->
<div id="messages"></div>
<!--  comportamento da página -->
<script type="text/javascript">
  //
  var initialIndex = -1;
  var maxRows = 10;
  //
  var postMessage = function(){
	  //recuperar o valor da mensagem
	  //# <-- representa o id de uma tag
	  //. <-- representa uma class de uma tag	
        var msg = jQuery("#textId").val();
	  //enviar os dados para o servidor
	  jQuery.post("message.ajax", {"message": msg}, function(result){
		  if ("OK" == result){
			  //certo: continuar e atualizar a tela
			  jQuery("#textId").val("");
		    jQuery("#messages").prepend("<div>" + msg + "</div>");
		  }
		  else {
			  //errado: estocar para tentar novamente
			  console.info("Error: " + msg);
		  }
	  })
  };
  //
  var updateMessages = function(){
	  //recuperar o ínidice das últimas dez mensagens 
	  jQuery.get("messages.ajax", {"offset": initialIndex}).done(function(result){
		  //formato javascript "['b', 'a', 'c', 'd']"
		  var json = result;
		  if (json && json.length > 0){
			  jQuery("#messages").html("");
			  for (var ix = 0; ix < json.length; ix++){
				  jQuery("#messages").prepend("<div>" + json[ix] + "</div>");
			  }
		  }
		  //atualizar o index
		  initialIndex = initialIndex + json.length;
	  })
  }
  //
  var getIndexLatest = function(){
	  //recuperar o ínidice das últimas dez mensagens 
	  jQuery.get("index.ajax", function(result){
		  if (initialIndex != result){
		    initialIndex = result;
		    updateMessages();//<-- atualiza as message
	    }
	  })
  }
  //
  var ping = function(){
	  getIndexLatest();//<-- atualizando o índice
  }
  setInterval(ping, 2000);
  //inicialização
  getIndexLatest();//<-- atualizando o índice
  //
</script>
            
            </div>
            <div id="rodape"></div>
        </div>
        
        <form method="link" action="LogoutUsuario">
        <input type="submit" value="Logout"/>
        </form>       
    </body>
</html>
