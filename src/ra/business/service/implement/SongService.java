package ra.business.service.implement;

import ra.business.entity.Singer;
import ra.business.entity.Song;
import ra.business.service.ISong;

public class SongService implements ISong {
    private Song[] songs;
    private int size;

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

    @Override
    public Song[] findBySongName(String name) {
        Song[] searchList  = new Song[size];
        int index= 0;
        for (int i = 0; i < size; i++) {
            if(songs[i].getSongName().contains(name)){
                searchList[index] = songs[i];
                index++;
            }
        }
        if (index ==0){
            return new Song[0];
        }
        return searchList;
    }
}
