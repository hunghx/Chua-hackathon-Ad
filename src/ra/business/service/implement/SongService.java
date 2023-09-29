package ra.business.service.implement;

import ra.business.entity.Singer;
import ra.business.entity.Song;
import ra.business.entity.SongComparator;
import ra.business.service.ISong;
import ra.run.SingerManager;

import java.util.*;

public class SongService implements ISong {
    private List<Song> songs;

    public SongService() {
        songs = new ArrayList<>();
        Singer s1 =new Singer(1,"Hùng",19,"VN",true,"Pop");
        Singer s2 =new Singer(2,"Nam",22,"LAO",true,"Pop");
        SingerManager.singerController.findAll().add(s1);
        SingerManager.singerController.findAll().add(s2);

        Song y1 = new Song("S001","BH1",null,"HXH",s1,new Date(),true);
        Song y2 = new Song("S002","BH2",null,"HXH",s1,new Date(),true);
        Song y3 = new Song("S003","BH3",null,"HXH",s2,new Date(),true);
        Song y4 = new Song("S004","BH4",null,"HXH",s2,new Date(),true);
        Song y5 = new Song("S005","BH5",null,"HXH",s1,new Date(),true);
        Song y6 = new Song("S006","BH6",null,"HXH",s1,new Date(),true);
        Song y7 = new Song("S007","BH7",null,"HXH",s2,new Date(),true);
        Song y8 = new Song("S008","BH8",null,"HXH",s1,new Date(),true);
        Song y9 = new Song("S009","BH9",null,"HXH",s2,new Date(),true);
        Song y10 = new Song("S010","BH10",null,"HXH",s2,new Date(),true);
        Song y11 = new Song("S011","BH11",null,"HXH",s1,new Date(),true);
        songs.add(y1);
        songs.add(y2);
        songs.add(y3);
        songs.add(y4);
        songs.add(y5);
        songs.add(y6);
        songs.add(y7);
        songs.add(y8);
        songs.add(y9);
        songs.add(y10);
        songs.add(y11);
    }

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public Song findById(String id) {
        for (Song s:songs
             ) {
            if (s.getSongId().equals(id)){
                return s;
            }
        }
        return null;
    }

    @Override
    public void add(Song song) {
        songs.add(song);
    }

    @Override
    public void update(Song song) {
        songs.set(songs.indexOf(findById(song.getSongId())),song);
    }



    @Override
    public void delete(String id) {
       songs.remove(findById(id));
    }

    @Override
    public List<Song> findBySongName(String name) {
        List<Song> searchList  = new ArrayList<>();
        for (Song s:songs
             ) {
            if(s.getSongName().contains(name)){
                searchList.add(s);
            }
        }
        return searchList;
    }
    public  boolean existsBySongId(String songId){
        return findById(songId)!=null;
    }
    @Override
    public  boolean existsSongBySingerId(int singerId){
        for (Song s:songs) {
            if(s.getSinger().getSingerId()==singerId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Song> findSongBySingerNameOrGenre(String name) {
        List<Song> searchList  = new ArrayList<>();
        for (Song s:songs
             ) {
            if (s.getSinger().getSingerName().contains(name)||s.getSinger().getGenre().contains(name)){
                searchList.add(s);
            }
        }
        return searchList;
    }
    @Override
    public List<Song> sortByName() {
        List<Song> sortSong = new ArrayList<>(songs);
//        sortSong.sort((a,b)->a.getSinger().getAge()-b.getSinger().getAge());
        Collections.sort(sortSong, Comparator.comparing(Song::getSongName)); // Comparator
//       Collections.sort(sortSong); // Comparable
        return sortSong;
    }
}
