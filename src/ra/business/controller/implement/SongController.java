package ra.business.controller.implement;

import ra.business.controller.ISong;
import ra.business.entity.Song;

public class SongController implements ISong {
    @Override
    public Song[] findAll() {
        return new Song[0];
    }

    @Override
    public Song findById(String id) {
        return null;
    }

    @Override
    public void add(Song song) {

    }

    @Override
    public void update(Song song) {

    }

    @Override
    public void delete(String id) {

    }
}
