<%-- 
    Document   : cadastro
    Created on : 12/04/2020, 18:30:23
    Author     : iohan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="w3-container" id="contact" style="margin-top:75px">
    <h1 class="w3-xxxlarge w3-text-green"><b>Entrar</b></h1>
    <hr style="width:50px;border:5px green;" class="w3-round">
    <p>Cadastre-se</p>
    <form action="index.jsp?page=campeonato" method="post">
        <div class="w3-section">
        <label>E-mail</label>
        <input class="w3-input w3-border" type="email" name="email" required>
      </div>
      <div class="w3-section">
        <label>Login</label>
        <input class="w3-input w3-border" type="text" name="login" required>
      </div>
      <div class="w3-section">
        <label>Senha</label>
        <input class="w3-input w3-border" type="password" name="senha" required>
      </div>
        <div class="w3-section">
        <label>Escolha o seu time</label>
        <select name="escolhaTime">
            <option value="barcelona">Barcelona</option>
        </select>
      </div>
      
      <button type="submit" class="w3-button w3-block w3-padding-large w3-green w3-margin-bottom">Cadastrar-se</button>
      
    </form>