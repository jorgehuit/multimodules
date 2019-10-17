package businessLayer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;


public class BusinessTest {
	
	@Test
	public void generarIdCondicion() {
		
		List<Condiciones> listCondiciones = new ArrayList<>();
		listCondiciones.add(new Condiciones("nombre0", "app0", "COBE00010000"));
		listCondiciones.add(new Condiciones("nombre2", "app2", "COBE00010200"));
		listCondiciones.add(new Condiciones("nombre1", "app1", "COBE00010100"));
//		listCondiciones.add(new Condiciones("nombre1Ser", "app1Ser", "SERV00010000"));
		
		listCondiciones.sort(Comparator.comparing(Condiciones::getIdGenerado));
		
		listCondiciones.stream().forEach(a -> System.out.println(a.getIdGenerado()));
		
		Condiciones condiciones = listCondiciones.get(listCondiciones.size() - 1);
		System.out.println("condiciones elegida: " + condiciones.getIdGenerado());
		
		
		StringBuilder builder = new StringBuilder();
		String string = builder.toString();
		System.out.println(string);
		
		String idGenerado = "COBE00010008";
		String tipoEntity = idGenerado.substring(0, 4);
		Integer conNvo = Integer.parseInt(idGenerado.substring(4, 8));
		Integer clon = Integer.parseInt(idGenerado.substring(8, 10));
		Integer version = Integer.parseInt(idGenerado.substring(10, 12));
		
		
		System.out.println("nvo : " + String.format("%04d", conNvo + 1));
        System.out.println("clon : " + String.format("%02d",  clon +1 ));
        System.out.println("version : " + String.format("%02d",  version +1 ));
	}
	
	private class Condiciones {
		
		String nombre;
		String app;
		public Condiciones() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Condiciones(String nombre, String app, String idGenerado) {
			super();
			this.nombre = nombre;
			this.app = app;
			this.idGenerado = idGenerado;
		}
		String idGenerado;
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApp() {
			return app;
		}
		public void setApp(String app) {
			this.app = app;
		}
		public String getIdGenerado() {
			return idGenerado;
		}
		public void setIdGenerado(String idGenerado) {
			this.idGenerado = idGenerado;
		}
		
		
	}

}
