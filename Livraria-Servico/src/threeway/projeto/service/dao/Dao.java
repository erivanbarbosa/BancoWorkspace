package threeway.projeto.service.dao;

import java.util.Collection;

import threeway.projeto.modelo.Entidade;

public interface Dao<E extends Entidade> {

	Collection<E> listar();
}
