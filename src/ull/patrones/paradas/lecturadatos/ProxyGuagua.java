package ull.patrones.paradas.lecturadatos;

import java.util.List;

import javax.json.JsonObject;

import ull.patrones.paradas.datos.Geometry;
import ull.patrones.paradas.datos.ParadaGuagua;

public class ProxyGuagua extends LeerJSON
{
	private LeerJSONGuagua m_guagua;
	public ProxyGuagua()
	{
	}
	@Override
	public String getURL()
	{
		return m_guagua.getURL();
	}
	@Override
	public Boolean getTermino()
	{
		return m_guagua.getTermino();
	}
	@Override
	public void leerDatos()
	{
		checkNull();
		m_guagua.leerDatos();
	}
	@Override
	public void paradasConfig()
	{
		m_guagua.paradasConfig();;
	}
	@Override
	public List<String> getListaZona()
	{
		return super.getListaZona();
	}
	private void checkNull()
	{
		if(m_guagua == null)
		{
			System.out.println("Creando conexión...");
			m_guagua = new LeerJSONGuagua();
		}
	}
	private void checkListaVacia()
	{
		checkNull();
		if(m_guagua.getParadas() == null || m_guagua.getParadas().isEmpty())
		{
			System.out.println("Obteniendo paradas...");
			m_guagua.paradasConfig();
		}
	}
	@Override
	public void paradaConcreta(JsonObject jsonValue)
	{
		checkListaVacia();
		m_guagua.paradaConcreta(jsonValue);
	}
	@Override
	public void addZona(String a_zona)
	{
		checkNull();
		m_guagua.addZona(a_zona);
	}
	@Override
	public List<Geometry> getGeometrys(String a_barrio)
	{
		checkListaVacia();
		return m_guagua.getGeometrys(a_barrio);
	}

	@Override
	public void mostrarParadas()
	{
		checkListaVacia();
		System.out.println("Mostrando paradas");
		for (ParadaGuagua parada : m_guagua.getParadas())
		{
			System.out.println(parada);
		}
	}

}
