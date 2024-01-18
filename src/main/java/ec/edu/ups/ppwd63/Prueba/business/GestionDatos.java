package ec.edu.ups.ppwd63.Prueba.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppwd63.Prueba.dao.PersonaDao;
import ec.edu.ups.ppwd63.Prueba.model.Persona;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	@Inject
	private PersonaDao daoCliente;
	
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Persona cliente = new Persona();
		cliente.setCodigo(1);
		cliente.setCedula("1150704672");
		cliente.setMesesdeuda("1 mes");
		cliente.setNombre("Jairo Salazar");
		cliente.setVdeuda(25);
		
		daoCliente.insert(cliente);
		
		System.out.println("\n------------- Clientes");
		List<Persona> list = daoCliente.getAll();
		for (Persona per: list) {
			System.out.println(per.getCodigo() + "\t" + per.getNombre());
		
		
		
		
		
		
		
	}

}
