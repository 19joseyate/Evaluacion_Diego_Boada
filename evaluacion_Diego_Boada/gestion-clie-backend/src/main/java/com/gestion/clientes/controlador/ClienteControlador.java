package com.gestion.clientes.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.clientes.excepciones.ResourceNotFoundException;
import com.gestion.clientes.modelo.Cliente;
import com.gestion.clientes.repositorio.ClienteRepositorio;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class ClienteControlador {

	@Autowired
	private ClienteRepositorio repositorio;

	//este metodo sirve para listar todos los clientes
	@GetMapping("/clientes")
	public List<Cliente> listarTodosLosCliente() {
		return repositorio.findAll();
	}
	

	//este metodo sirve para guardar el cliente
	@PostMapping("/clientes")
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return repositorio.save(cliente);
	}
    
	//este metodo sirve para buscar un cliente
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id){
			Cliente cliente = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
			return ResponseEntity.ok(cliente);
	}
	
	//este metodo sirve para actualizar cliente
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id,@RequestBody Cliente detallesCliente){
		Cliente cliente = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
		
		
		cliente.setCedula(detallesCliente.getCedula());
		cliente.setNombre(detallesCliente.getNombre());
		cliente.setApellido(detallesCliente.getApellido());
		cliente.setFecha_nacimiento(detallesCliente.getFecha_nacimiento());
		cliente.setCiudad(detallesCliente.getCiudad());
		cliente.setEmail(detallesCliente.getEmail());
		cliente.setTelefono(detallesCliente.getTelefono());
		cliente.setOcupacion(detallesCliente.getOcupacion());
		
		
		Cliente clienteActualizado = repositorio.save(cliente);
		return ResponseEntity.ok(clienteActualizado);
    }
	
	//este metodo sirve para eliminar un cliente
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarCliente(@PathVariable Long id){
		Cliente cliente = repositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID : " + id));
		
		repositorio.delete(cliente);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}














