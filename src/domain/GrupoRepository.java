package domain;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class GrupoRepository
{
	private Map<String,Grupo> grupos;

	GrupoRepository()
	{
		grupos = new HashMap<String, Grupo>();
	}
	public boolean insertGrupo(Grupo grupo)
	{
		if (grupos.containsKey(grupo.getId() + ""))
			return false;
		else
			grupos.put(grupo.getId()+"", grupo);
		return true;
	}
	public boolean deleteGrupo(Grupo grupo)
	{
		if (!grupos.containsKey(grupo.getId() + ""))
			return false;
		else
			grupos.remove(grupo.getId() + "");
		return true;
	}
	public Profesor findGrupo(int id) {
		if (!grupos.containsKey(id + ""))
			return null;
		else
			return grupos.get(id);
	}
	public boolean updateGrupo(Grupo grupo) {
		if (!grupos.containsKey(grupo.getId() + ""))
			return false;
		else
			grupos.put(grupo.getId() + "", grupo);
		return true;
	}
	public Collection findByProfesor(int id_profesor)
	{
		Map<String,Grupo> PGrupos = new HashMap<String, Grupo>();
		for (Grupo grupo : grupos.values())
		{
			if (grupo.getIdProfesor() == id_profesor)
			{
				PGrupos.put(grupo.getId() + "", grupo);
			}
		}
		return PGrupos.values();
	}
	public Collection findAllGrupo()
	{
		return grupos.values();
	}
	public void setGrupos(Map grupos)
	{
		this.grupos = grupos;
	}
}