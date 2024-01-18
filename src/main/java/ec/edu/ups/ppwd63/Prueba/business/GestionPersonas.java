package ec.edu.ups.ppwd63.Prueba.business;

import java.util.List;

import ec.edu.ups.ppwd63.Prueba.dao.PersonaDao;
import ec.edu.ups.ppwd63.Prueba.model.Persona;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionPersonas {
	@Inject
	private PersonaDao daoCliente;

	public void guardarClientes(Persona persona) {
		Persona per = daoCliente.read(persona.getCodigo());
		if (per != null){
			daoCliente.update(persona);;
		}else {
			daoCliente.insert(persona);;
		}
	}
	
	public void actualizarCliente(Persona persona) throws Exception {
		Persona cli = daoCliente.read(persona.getCodigo());
		if (cli != null){
			daoCliente.update(persona);
		}else {
			throw new Exception("Cliente no existe");
		}
	}
	
	public Persona getClientePorCedula(String cedula) throws Exception{
		
		if(cedula.length()!=10)
			throw new Exception("Cedula incorrecta");
			
		return daoCliente.getClientePorCedula(cedula);
	}
	
	public void borrarCliente(int codigo){
		
		daoCliente.remove(codigo);
	}
	
	public List<Persona> getClientes(){
		return daoCliente.getAll();
	}

}
