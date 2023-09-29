package ra.business.controller;

import ra.business.entity.Song;

import java.util.List;

public interface ISong extends IGeneric<Song,String> {
   boolean existsBySongId(String id);
   boolean existsSongBySingerId(int singerId);
   List<Song> findSongBySingerNameOrGenre(String name);
   List<Song> sortByName();
}
