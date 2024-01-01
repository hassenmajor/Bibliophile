package projet.liu.dao;

import java.util.List;

public interface Dao<T> {

	public T get(String id);
	public List<T> getAll();
	public void save(T element);
	public void update(String id, T newElement);
	public void delete(String id);

}
