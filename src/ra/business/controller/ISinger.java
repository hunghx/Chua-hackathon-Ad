package ra.business.controller;

import ra.business.entity.Singer;

import java.util.List;

public interface ISinger extends IGeneric<Singer,Integer> {
    int getIdMax();
    List<Singer> findAllByNameOrGenre(String name);

}
