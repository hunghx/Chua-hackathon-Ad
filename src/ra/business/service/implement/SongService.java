package ra.business.service.implement;

import ra.business.entity.Singer;
import ra.business.entity.Song;
import ra.business.service.ISong;
import ra.run.SingerManager;

import java.util.Date;

public class SongService implements ISong {
    private Song[] songs;
    private int size;

    public SongService() {
        songs = new Song[100];
        Singer s1 =new Singer(1,"Hùng",19,"VN",true,"Pop");
        Singer s2 =new Singer(2,"Nam",22,"LAO",true,"Pop");
        SingerManager.singerController.findAll()[0]=s1;
        SingerManager.singerController.findAll()[1]=s2;

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
        songs[0]=y1;
        songs[1]=y2;
        songs[2]=y3;
        songs[3]=y4;
        songs[4]=y5;
        songs[5]=y6;
        songs[6]=y7;
        songs[7]=y8;
        songs[8]=y9;
        songs[9]=y10;
        songs[10]=y11;
        size=11;
    }

    @Override
    public Song[] findAll() {
        return songs;
    }

    @Override
    public Song findById(String id) {
        for (int i = 0; i < size; i++) {
            if(songs[i].getSongId().equals(id)){
                return songs[i];
            }
        }
        return null;
    }

    @Override
    public void add(Song song) {
        songs[size] = song;
        size++;
    }

    @Override
    public void update(Song song) {
        for (int i = 0; i < size; i++) {
            if (songs[i].getSongId().equals(song.getSongId())){
                // cập nhật
                songs[i] = song;
                break;
            }
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public void delete(String id) {
        int indexDel = -1;
        // tìm ra vị trí cần xóa
        for (int i = 0; i < size; i++) {
            if (songs[i].getSongId().equals(id)){
                indexDel=i;
            }
        }
        // thực hiện xóa
        for (int i = indexDel; i < size-1 ; i++) {
            songs[i] = songs[i+1];
        }
        songs[size] =null;
        size--;
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
    public  boolean existsBySongId(String songId){
        return findById(songId)!=null;
    }
    @Override
    public  boolean existsSongBySingerId(int singerId){
        for (int i = 0; i < size; i++) {
            if (songs[i].getSinger().getSingerId()==singerId){
                return true;
            }
        }
        return false;
    }

    @Override
    public Song[] findSongBySingerNameOrGenre(String name) {
        Song[] searchList  = new Song[size];
        int index= 0;
        for (int i = 0; i < size; i++) {
            if(songs[i].getSinger().getSingerName().contains(name)||songs[i].getSinger().getGenre().contains(name)){
                searchList[index] = songs[i];
                index++;
            }
        }
        if (index ==0){
            return new Song[0];
        }
        return searchList;
    }
    @Override
    public Song[] sortByName() {
        Song[] sortSong = songs.clone();
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                if(sortSong[i].getSongName().compareTo(sortSong[j].getSongName())>0){
                    Song temp = sortSong[i];
                    sortSong[i]=sortSong[j];
                    sortSong[j]=temp;
                }
            }
        }
        return sortSong;
    }
}
