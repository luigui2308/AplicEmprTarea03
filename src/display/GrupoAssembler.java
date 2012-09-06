package display;

import domain.Grupo;

public class GrupoAssembler
{
	public static GrupoDTO Create(Grupo grupo)
	{
		GrupoDTO dto = new GrupoDTO();
		dto.id = grupo.getID();
		dto.numero = grupo.getNumero();
		dto.sigla = grupo.getSigla();
		dto.nombre = grupo.getNombre();
		dto.horario = grupo.getHorario();
		dto.aula = grupo.getAula();
		dto.id_profesor = grupo.getIdProfesor();
		return dto;
	}
}