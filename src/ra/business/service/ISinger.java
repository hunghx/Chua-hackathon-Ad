package ra.business.service;

import ra.business.entity.Singer;

public interface ISinger extends IGeneric<Singer,Integer>{
    Singer[] findAllByNameOrGenre(String name);
}
