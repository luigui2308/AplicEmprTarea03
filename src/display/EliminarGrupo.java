package display;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GrupoRepository;
import domain.Grupo;

public class EliminarGrupo extends PageController
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		GrupoRepository grupo = (GrupoRepository) context.getBean("grupoRepository");
		try
		{
			Grupo grupo = new Grupo();
			int id = Integer.parseInt(request.getParameter("id"));
			grupo.setId(id);
			if (grupos.deleteGrupo(grupo))
			{
				response.sendRedirect("listaGrupos");
			}
			else
			{
				throw new ServletException(Integer.toString(id));
			}
        }
		catch (Exception e)
		{
            request.setAttribute("mensaje",e.getMessage());
            forward("/paginaError.jsp",request,response);
        }
	}
}