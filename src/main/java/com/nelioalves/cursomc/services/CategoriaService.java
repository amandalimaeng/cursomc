package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;


@Service
public class CategoriaService {

	@Autowired // Instancia automaticamente a dependência abaixo
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) throws Exception {

		// Retorna null se não encontrar um objeto do tipo categoria

		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new Exception("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));

	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) throws Exception {
		
		buscar(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) throws Exception {
		buscar(id);
		try {
		repo.deleteById(id);}
		catch (DataIntegrityViolationException e) {
			throw new Exception("Não é possível excluir uma categoria com produtos associados à ela.");
		}
		
	}
}
