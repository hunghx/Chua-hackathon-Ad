package ra.business.service;

import ra.business.entity.Song;

public interface ISong extends IGeneric<Song,String>{
    Song[] findBySongName(String name);
}
