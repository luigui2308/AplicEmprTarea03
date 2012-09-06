package domain;

public class Grupo
{
	private int id;
	private int numero;
	private String sigla;
	private String nombre;
	private String horario;
	private String aula;
	private int id_profesor;
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setNumero(int numero)
	{
		this.numero = numero;
	}
	
	public int getNumero()
	{
		return numero;
	}
	
	public void setSigla(String sigla)
	{
		this.sigla = sigla;
	}
	
	public String getSigla()
	{
		return sigla;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setHorario(String horario)
	{
		this.horario = horario;
	}
	
	public String getHorario()
	{
		return horario;
	}
	
	public void setAula(String aula)
	{
		this.aula = aula;
	}
	
	public String getAula()
	{
		return aula;
	}
	
	public void setIdProfesor(int id_profesor)
	{
		this.id_profesor = id_profesor;
	}
	
	public int getIdProfesor()
	{
		return id_profesor;
	}
}