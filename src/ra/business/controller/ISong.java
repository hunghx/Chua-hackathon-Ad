package ra.business.controller;

import ra.business.entity.Song;

public interface ISong extends IGeneric<Song,String> {
   boolean existsBySongId(String id);
   boolean existsSongBySingerId(int singerId);
   Song[] findSongBySingerNameOrGenre(String name);
   Song[] sortByName();
}
