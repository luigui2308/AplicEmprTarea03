<%@ page import="java.util.*" %>
<%@ page import="display.*" %>
<html>
  <head>
    <title>Sistema Universitario</title>
  </head>
  <!--
  <h1>Sistema Universitario</h1>
  <h2>Listado de profesores</h2>
  -->
  <% List profs = (List)request.getAttribute("profesores"); %>
  <table>
    <tr><th>Nombre</th><th>T&iacute;tulo</th><th>Area</th><th>Acciones</th></tr>
    <% for(int i = 0, n = profs.size(); i < n; i++) {
         ProfesorDTO prof = (ProfesorDTO) profs.get(i); %>
        <tr><td><%= prof.nombre %></td>
        <td><%= prof.titulo %></td>
        <td><%= prof.area %></td>
        <td><a href='/universidad/detalleProfesor?id=<%= prof.id %>'>
              <input type="submit" value="Detalle"/></a>
            <a href='/universidad/eliminarProfesor?id=<%= prof.id %>'>
              <input type="submit" value="Eliminar"/></a></td></tr>
    <% } %>
  </table>
    <table>
      <tr><td><a href='../agregarProfesor.jsp'>
        <input type="submit" name="action" value="Agregar"/></a>
      </td></tr>
    </table>
	<a href="/universidad/listaGrupos">Administracion de grupos</a>
</html>