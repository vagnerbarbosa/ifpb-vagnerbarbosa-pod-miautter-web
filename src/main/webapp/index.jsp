<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1" />
        <title>Miautter.com</title>
        
        <link href="estilos/principal.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
       <div id="container">
        <div id="menu"><span>Bem Vindo ao Miautter! Novo por aqui? <a href="cadastro.html">Cadastre-se já!</a></span></div>               
            
            <div id="form" class="principal">
                <div id="formlogin">
                    <form id="form1" method="post" action="LoginUsuario">
                        </br>
                        </br>
                        
                        <div id="login">
                        </br>
                            <input name="login" type="text" id="login" placeholder="Login" required/>
                        </div>
                        
                        <div id="senha">
                            <input name="senha" type="password" id="senha" placeholder="Senha" required/>
                        </div>
                        <div id="botao">
                            <input type="submit" name="button" id="button" value="ENTRAR" />
                        </div>
                        
                    </form>
                </div>

                <div id="conta"><a href="cadastro.html">Cadastre-se</a></div>
            </div>
        </div>

    </body>
</html>