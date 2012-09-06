package display;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.web.context.*;

import domain.GrupoRepository;
import domain.Grupo;

public class ListaGrupo extends PageController
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		GrupoRepository grupos = (GrupoRepository)context.getBean("grupoRepository");
		try
		{
			for (Grupo grupo : grupos.findAllGrupo())
			{
				Grupos.add(GrupoAssembler.Create(grupo))
			}
			return Grupos;
        }
		catch (Exception e)
		{
            request.setAttribute("mensaje",e.getMessage());
            forward("/paginaError.jsp",request,response);
        }
  }
}