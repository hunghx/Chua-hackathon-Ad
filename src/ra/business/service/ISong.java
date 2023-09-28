package ra.business.service;

import ra.business.entity.Song;

public interface ISong extends IGeneric<Song,String>{
    Song[] findBySongName(String name);
     boolean existsSongBySingerId(int singerId);
     Song[] findSongBySingerNameOrGenre(String name);
    Song[] sortByName();
}
