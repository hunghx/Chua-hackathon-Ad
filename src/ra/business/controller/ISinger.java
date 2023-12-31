package ra.business.controller;

import ra.business.entity.Singer;

public interface ISinger extends IGeneric<Singer,Integer> {
    int getIdMax();
    Singer[] findAllByNameOrGenre(String name);

}
