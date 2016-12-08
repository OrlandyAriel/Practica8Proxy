package ull.patrones.paradas.lecturadatos;

import java.util.List;

import javax.json.JsonObject;

import ull.patrones.paradas.datos.Geometry;
import ull.patrones.paradas.datos.ParadaTaxi;

public class ProxyTaxi extends LeerJSON
{

	private LeerJSONTaxis m_taxi;

	public ProxyTaxi()
	{
	}

	@Override
	public String getURL()
	{
		return m_taxi.getURL();
	}

	@Override
	public Boolean getTermino()
	{
		return m_taxi.getTermino();
	}

	@Override
	public void leerDatos()
	{
		checkNull();
		m_taxi.leerDatos();
	}

	@Override
	public void paradasConfig()
	{
		m_taxi.paradasConfig();
		;
	}

	@Override
	public List<String> getListaZona()
	{
		return super.getListaZona();
	}

	private void checkNull()
	{
		if (m_taxi == null)
		{
			System.out.println("Creando conexión...");
			m_taxi = new LeerJSONTaxis();
		}
	}

	private void checkListaVacia()
	{
		checkNull();
		if (m_taxi.getParadas() == null || m_taxi.getParadas().isEmpty())
		{
			System.out.println("Obteniendo paradas...");
			m_taxi.paradasConfig();
		}
	}

	@Override
	public void paradaConcreta(JsonObject jsonValue)
	{
		checkListaVacia();
		m_taxi.paradaConcreta(jsonValue);
	}

	@Override
	public void addZona(String a_zona)
	{
		checkNull();
		m_taxi.addZona(a_zona);
	}

	@Override
	public List<Geometry> getGeometrys(String a_barrio)
	{
		checkListaVacia();
		return m_taxi.getGeometrys(a_barrio);
	}

	@Override
	public void mostrarParadas()
	{
		checkListaVacia();
		System.out.println("Mostrando paradas");
		for (ParadaTaxi parada : m_taxi.getParadas())
		{
			System.out.println(parada);
		}
	}

}
