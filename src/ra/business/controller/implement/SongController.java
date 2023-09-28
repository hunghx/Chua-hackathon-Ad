package ra.business.controller.implement;

import ra.business.controller.ISong;
import ra.business.entity.Song;
import ra.business.service.implement.SongService;

public class SongController implements ISong {
    private SongService songService =new SongService();
    @Override
    public Song[] findAll() {
        return songService.findAll();
    }

    @Override
    public Song findById(String id) {
        return songService.findById(id);
    }

    @Override
    public void add(Song song) {
        songService.add(song);
    }

    @Override
    public void update(Song song) {
        songService.update(song);
    }

    @Override
    public void delete(String id) {
        songService.delete(id);
    }

    @Override
    public int getSize() {
        return songService.getSize();
    }

    @Override
    public boolean existsBySongId(String id) {
        return songService.existsBySongId(id);
    }
    @Override
    public  boolean existsSongBySingerId(int singerId){
        return songService.existsSongBySingerId(singerId);
    }

    @Override
    public Song[] sortByName() {
        return songService.sortByName();
    }

    @Override
    public Song[] findSongBySingerNameOrGenre(String name) {
        return songService.findSongBySingerNameOrGenre(name);

    }
}
