
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.sociosUtil"%>
<%@ include file="menu-header.jsp"%>s
<body>	
<%	LinkedList<Ejercicio> ejers=new LinkedList<Ejercicio>();
 %>

<h1>Agregar Ejercicios a Rutina</h1>
</head>
<body>

<div class="mb-3">
  <label for="repeticiones" class="form-label">REPETICIONES</label>
  <textarea class="form-control" id="repeticiones" rows="3"></textarea>
</div>


<div class="mb-3">
  <label for="series" class="form-label">SERIES</label>
  <textarea class="form-control" id="series" rows="3"></textarea>
</div>


<div class="mb-3">
  <label for="peso" class="form-label">PESO</label>
  <textarea class="form-control" id="peso" rows="3"></textarea>
</div>


<div class="mb-3">
  <label for="descripcion" class="form-label">DESCRIPCION</label>
  <textarea class="form-control" id="descripcion" rows="3"></textarea>
</div>



<div class="mb-3">
  <label for="nombre_maq" class="form-label">NOMBRE DE LA MAQUINA</label>
  <textarea class="form-control" id="nombre_maq" rows="3"></textarea>
</div>

<div class="mb-3">
  <label for="id_ejer" class="form-label">ID EJERCICIO </label>
  <textarea class="form-control" id="id_ejer" rows="3"></textarea>
</div>
<a href="ejercicio-agrega-varios.jsp"class="btn btn-warning btn-sm">Agregar otro</a>
<a href="rutina-tabla.jsp"class="btn btn-warning btn-sm">Terminar y volver a ver lista de rutinas</a>

<% for(Ejercicio e:ejers) %>


