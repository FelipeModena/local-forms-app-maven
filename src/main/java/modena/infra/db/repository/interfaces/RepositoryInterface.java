package modena.infra.db.repository.interfaces;

import java.util.ArrayList;

public interface RepositoryInterface <T> {
    public T create(T object);

    public T read(T object);

    public int update(T object);

    public int delete(T object);

    public void put (String key, String value);

    public ArrayList<T> list(T object);
}
