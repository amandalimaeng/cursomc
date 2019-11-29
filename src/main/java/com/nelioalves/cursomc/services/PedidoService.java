package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired // Instancia automaticamente a dependência abaixo
	private PedidoRepository repo;

	public Pedido buscar(Integer id) throws Exception {

		// Retorna null se não encontrar um objeto do tipo categoria

		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new Exception("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));

	}

}
