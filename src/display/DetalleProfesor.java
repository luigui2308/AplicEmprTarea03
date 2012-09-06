package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ProfesorRepository;
import domain.Profesor;

import domain.GrupoRepository;
import domain.Grupo;

public class DetalleProfesor extends PageController
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ProfesorRepository profesores = (ProfesorRepository) context.getBean("profesorRepository");
		try
		{
			String id = request.getParameter("id");
            int idProf = Integer.parseInt(id);
            Profesor prof = profesores.findProfesor(idProf+"");
            ProfesorDTO dto = ProfesorAssembler.Create(prof);
			request.setAttribute("profesor",dto);
			request.setAttribute("grupos", getGruposByProfesor(idProf));
			forward("/detalleProfesor.jsp",request,response);
        }
		catch (Exception e)
		{
            request.setAttribute("mensaje",e.getMessage());
            forward("/paginaError.jsp",request,response);
        }
	}
	
	public List getGruposByProfesor(int id_profesor)
	{
		GrupoRepository grupos = (GrupoRepository)context.getBean("grupoRepository");
		List Grupos = new ArrayList();
		for (Grupo grupo : grupos.findByProfesor(id_profesor))
		{
			Grupos.add(GrupoAssembler.Create(grupo))
		}
		return Grupos;
	}
}