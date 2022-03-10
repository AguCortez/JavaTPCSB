<%@ include file="menu-header.jsp"%>
<% 
	HttpSession sesion= request.getSession();
	String user, lvl;	
if(sesion.getAttribute("usuario")!=null && sesion.getAttribute("nivel")!=null)
	{
	user=sesion.getAttribute("usuario").toString();
	lvl=sesion.getAttribute("nivel").toString();

	}
else{
	out.print("<script>location.replace('index.jsp');</script>"); 
}
%>
<div class="card">
  <div class="card-header">
  </div>
  <div class="card-body">
    <h5 class="card-title">Aca pueden ir imagenes random</h5>
    <p class="card-text">Clases random?</p>
    <a href="#" class="btn btn-primary">Ver Clases</a>
  </div>
</div>
<%@ include file="menu-foot.jsp" %>