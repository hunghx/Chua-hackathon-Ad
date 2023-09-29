package ra.business.controller;

import java.util.List;

public interface IGeneric<T,E>{
    List<T> findAll();
    T findById(E id);

    void add(T t);
    void update(T t);

    void delete(E id);
}
