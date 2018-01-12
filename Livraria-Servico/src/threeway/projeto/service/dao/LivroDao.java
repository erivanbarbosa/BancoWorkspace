package threeway.projeto.service.dao;

import java.util.ArrayList;
import java.util.Collection;

import threeway.projeto.modelo.Livro;

public class LivroDao implements Dao<Livro>{

	@Override
	public Collection<Livro> listar() {
		ArrayList<Livro> livros = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			Livro livro = new Livro();
			livro.setTitulo("Livro " + i);
			livro.setAutor("Autor " + i );
			livro.setPreco(0.0 + i);	
			
			livros.add(livro);
		}
		
		return livros;
	}

}
