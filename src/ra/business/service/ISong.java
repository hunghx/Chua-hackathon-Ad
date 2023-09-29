package ra.business.service;

import ra.business.entity.Song;

import java.util.List;

public interface ISong extends IGeneric<Song,String>{
    List<Song> findBySongName(String name);
     boolean existsSongBySingerId(int singerId);
    List<Song> findSongBySingerNameOrGenre(String name);
    List<Song> sortByName();
}
