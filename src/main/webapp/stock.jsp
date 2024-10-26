<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name='csrf-token' content='UWQIA4t3AJuFYxz2pLVRwsrZo1D3NQwXIDgzwdaL5M2eJPPjK+jWB+iPjb8mZM8XyzoAw2Fp8RXRE8IF3YN57g==' charset='UTF-8'>
<title>Ristorante da Luigi</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-animate.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-cookies.js"></script>
<script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin="anonymous"></script>
<script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin="anonymous"></script>
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<link rel="stylesheet" href="index.min.css">
<script src="/pietro/js/ajax.js" defer></script>
<script src="/pietro/js/index.min.js" defer></script>

</head>
<body>
<header id="header">
<h1>Ristorante da Luigi</h1>
</header>

<div id="link">
<div title="Home page"><a href="/pietro">Home</a></div>
<div title="Prenotazione dal tavolo"><a href="/pietro/page.jsp">Ordina</a></div>
<div title="Giacenza frigorifero"><a href="/pietro/stock.jsp">Giacenza</a></div>
<div title="Tavoli disponibili"><a href="/pietro/table.jsp">Tavoli</a></div>
<div title="Prenota un tavolo"  data-bs-toggle='modal' data-bs-target='#prenota_tavolo' data-bs-whatever='@mdo'>Prenota</div>     
</div>

<div class="modal fade" id="prenota_tavolo" tabindex="-1" aria-labelledby="chat" aria-hidden="true">
<div class="modal-dialog">

<form action="/pietro/prenota" method="post">

<div class="modal-content">
<div class="modal-header">
<h1 class="modal-title fs-5">Inserisci le informazione</h1>
<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
</div>
<div class="modal-body">
<div>
<div class="mb-3">
    
<div class="form-floating mb-3">
<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" required>
<label for="nome">Nome</label>
</div>
    
<div class="form-floating mb-3">
<input type="text" class="form-control" id="cogn" name="cogn"  placeholder="Cognome" required>
<label for="cogn">Cognome</label>
</div>
    
<div class="form-floating mb-3">    
<input type="tel" class="form-control" id="tel" name="tel" placeholder="Recapito telefonico" required>
<label for="tel">Recapito telefonico</label>
</div>
    
<div class="form-floating mb-3">
<input type="date" class="form-control" id="data" name="data" required>
<label for="data">Scelgi il giorno</label>
</div>

<div class="form-floating mb-3">
<select class="form-control" id="ora" name="ora" required>
<option value="12:00">12:00</option>
<option value="13:00">13:00</option>
<option value="14:00">14:00</option>
<option value="15:00">15:00</option>
<option value="16:00">16:00</option>
<option value="17:00">17:00</option>
<option value="18:00">19:00</option>
<option value="19:00">19:00</option>
<option value="20:00">20:00</option>
<option value="21:00">21:00</option>
<option value="22:00">22:00</option>
<option value="23:00">23:00</option>
</select>
<label for="ora">Scelgi l'orario</label>
</div>

<div class="form-floating mb-3">
<select class="form-control" id="num" name="num" required>
<option value="4">Tavolo da 4 posti</option>
<option value="6">Tavolo da 6 posti</option>
<option value="12">Tavolo da 12 posti</option>
</select>
<label for="num">Scelgi Tavolo</label>
</div>

</div>
</div>
</div>
<div class="modal-footer">
<button class="btn btn-outline-success" id="btn" data-bs-dismiss="modal" aria-label="Close"><i class="bi bi-arrow-up-circle"> </i>Invia</button>
<button type="reset" class="btn btn-outline-danger"><i class="bi bi-x-octagon-fill"> </i>Reset</button>
</div>
</div>
</form>
</div>
</div>

<nav id="giacenza">
<table>
<thead>    
<tr>
<th colspan="3">Giacenza in frigorifero</th>
</tr>
<tr>
<th>Ingredienti</th>
<th>Quantità (Kg)</th>
<th>Giacenza</th>
</tr>
</thead>

<tbody id="tbody"></tbody>
</table>

</nav>

<footer>
<div>
<h4>Informazioni:</h4>
<ol>
<li>
<li>Via Roma 001, CAP 20100 Milano</li>
<li>Lunedì - Venerdì: 12:00 - 23:00</li>
<li>Sabato: 13:00 - 00:00</li>
<li>Domenica: Chiuso</li>
</ol>
</div>

<div>
<h4>Contatti:</h4>
<ol>
<li><a href="#"><i class="bi bi-telephone"></i> +39 0123456789</a></li>
<li><a href="#"><i class="bi bi-whatsapp"></i> +39 0987654321</a></li> 
<li><a href="#"><i class="bi bi-envelope-at"></i> luigi@food.it</a></li>   
</ol>
</div>

<div>
<h4>Social:</h4>
<ol>
<li><a href="#"><i class="bi bi-facebook"></i> Facebook</a></li>
<li><a href="#"><i class="bi bi-instagram"></i> Instagram</a></li>
<li><a href="#"><i class="bi bi-linkedin"></i> Linkedin</a></li>
<li><a href="#"><i class="bi bi-tiktok"></i> Tiktok</a></li>
</ol>
</div>
</footer>

</body>
</html>