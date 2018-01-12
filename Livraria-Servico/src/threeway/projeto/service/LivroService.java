package threeway.projeto.service;

import java.util.Collection;

import threeway.projeto.modelo.Livro;
import threeway.projeto.service.dao.LivroDao;

public class LivroService {
	
	private LivroDao dao = new LivroDao();
	
	public Collection<Livro> listar() {
		return dao.listar();
	}
}