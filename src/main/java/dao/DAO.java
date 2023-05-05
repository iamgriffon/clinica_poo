package dao;

public interface DAO<T, I> {

    Boolean insert(T data);

    Boolean update(T data);

    T select(I id);

    Boolean delete(I id);

}
