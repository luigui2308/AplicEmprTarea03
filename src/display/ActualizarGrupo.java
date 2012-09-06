package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GrupoRepository;
import domain.Grupo;

public class ActualizarGrupo extends PageController
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		GrupoRepository grupos = (GrupoRepository) context.getBean("grupoRepository");
		try
		{
            int id = Integer.parseInt(request.getParameter("id"));
            int numero = Integer.parseInt(request.getParameter("numero"));
			String sigla = request.getParameter("sigla");
            String nombre = request.getParameter("nombre");
            String horario = request.getParameter("horario");
            String aula = request.getParameter("aula");
            int id_profesor = request.getParameter("id_profesor");
            Grupo grupo = grupos.findGrupo(id);
            try
			{
                if (cedula!=null) grupo.setNumero(numero);
				if (titulo!=null) grupo.setSigla(sigla);
                if (nombre!=null) grupo.setNombre(nombre);
                if (titulo!=null) grupo.setHorario(horario);
                if (area!=null) grupo.setAula(aula);
				if (area!=null) grupo.setIdProfesor(id_profesor);
            }
			catch (Exception e)
			{
			}
			response.sendRedirect("listaGrupos");
        }
		catch (Exception e)
		{
            request.setAttribute("mensaje",e.getMessage());
            forward("/paginaError.jsp",request,response);
        }
	}
}