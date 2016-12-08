package ull.patrones.paradas;

import ull.patrones.paradas.lecturadatos.LeerJSON;
import ull.patrones.paradas.lecturadatos.ProxyGuagua;
import ull.patrones.paradas.lecturadatos.ProxyTaxi;

public class Practica8DAP
{
	public static void main(String[] args)
	{
		ProxyGuagua guaguas = new ProxyGuagua();
		guaguas.mostrarParadas();
		
		LeerJSON taxi = new ProxyTaxi();
		taxi.mostrarParadas();
	}
}
