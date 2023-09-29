package ra.business.entity;

import ra.util.InputMethods;
import ra.util.SongValidateInput;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Song implements IOData{
//    @Override
//    public int compareTo(Song o) {
//        return o.getSongName().compareTo(this.getSongName());
//    }

    @Override
    public void inputData() {
        if(songId==null){
        System.out.println("Nhập id cho bài hát(có 4 kí tự , bắt đầu bằng chữ S)");
        this.songId = SongValidateInput.inputSongId();
        }
        System.out.println("Nhập tên Bài hát ");
        this.songName = InputMethods.getString();
        System.out.println("Nhập người sáng tác");
        this.songWriter = InputMethods.getString();
System.out.println("Nhập mô tả");
        this.descriptions = InputMethods.getString();

        this.singer = SongValidateInput.inputSinger();
        this.createdDate = new Date();
        System.out.println("nhập trạng thái bài hát (true/false)");
        this.songStatus = InputMethods.getBoolean();
    }

    @Override
    public void displayData() {
        SimpleDateFormat sp = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("---------------------------------------");
        System.out.println("ID : "+songId+" - SongName : -"+songName);
        System.out.println("Description : "+descriptions);
        System.out.println("Song writer: "+songWriter+" - Singer : "+singer.getSingerName());
        System.out.println("CreatedDate : "+createdDate+" - Status : -"+(songStatus?"hiện":"ẩn"));
    }

    private  String songId;
    private  String songName;
    private  String descriptions;
    private  String songWriter;
    private Singer singer;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
    }

    public Song(String songId, String songName, String descriptions, String songWriter, Singer singer, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.songWriter = songWriter;
        this.singer = singer;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }
}
