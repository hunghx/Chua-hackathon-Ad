package ra.business.service;

import ra.business.entity.Singer;

import java.util.List;

public interface ISinger extends IGeneric<Singer,Integer>{
    List<Singer> findAllByNameOrGenre(String name);
}
