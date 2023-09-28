package ra.business.service;

public interface IGeneric <T,E>{
    T[] findAll();
    T findById(E id);

    void add(T t);
    void update(T t);

    void delete(E id);
}
