<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Error</title>
  </head>
  <body>
  <h1>Error</h1>
  <% String mensaje = (String)request.getAttribute("mensaje"); %>
  
  <span><%= mensaje %></span>
  </body>
</html>