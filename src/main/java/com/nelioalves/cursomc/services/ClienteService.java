package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired // Instancia automaticamente a dependência abaixo
	private ClienteRepository repo;

	public Cliente buscar(Integer id) throws Exception {

		// Retorna null se não encontrar um objeto do tipo categoria

		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new Exception("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

	}

}
