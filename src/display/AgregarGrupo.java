package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GrupoRepository;
import domain.Grupo;

public class AgregarGrupo extends PageController
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		GrupoRepository grupos = (GrupoRepository)context.getBean("grupoRepository");
		try
		{
			Random Generator = new Random();
			int id = Generator.nextInt();
			int numero = Integer.parseInt(request.getParameter("numero"));
			String sigla = request.getParameter("sigla");
			String nombre = request.getParameter("nombre");
			String horario = request.getParameter("horario");
			String aula = request.getParameter("aula");
			int id_profesor = Integer.parseInt(request.getParameter("id_profesor"));
			Grupo grupo = new Grupo();
			grupo.setId(id);
			grupo.setNumero(numero);
			grupo.setSigla(sigla);
			grupo.setNombre(nombre);
			grupo.setHorario(horario);
			grupo.setAula(aula);
			grupo.setIdProfesor(id_profesor);
			grupo.insertProfesor(grupo);
			response.sendRedirect("listaGrupos");
		}
		catch (Exception e)
		{
			request.setAttribute("mensaje",e.getMessage());
			forward("/paginaError.jsp",request,response);
		}
	}
}
