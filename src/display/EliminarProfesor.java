package display;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.ProfesorRepository;
import domain.Profesor;

public class EliminarProfesor extends PageController
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ProfesorRepository profesores = (ProfesorRepository) context.getBean("profesorRepository");
		try
		{
			Profesor profesor = new Profesor();
			int id = Integer.parseInt(request.getParameter("id"));
			profesor.setId(id);
			if (profesores.deleteProfesor(profesor))
			{
				response.sendRedirect("listaProfesores");
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