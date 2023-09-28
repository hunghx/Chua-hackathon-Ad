package ra.run;

import ra.business.entity.Singer;
import ra.business.entity.Song;
import ra.util.InputMethods;

public class SearchSong {
    public static void menuSearch(){
        while (true){
            System.out.println("*********************SEARCH-MANAGEMENT************************\n" +
                    "1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại . [5 điểm]\n" +
                    "2.Tìm kiếm ca sĩ theo tên hoặc thể loại [5 điểm]\n" +
                    "3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần [5 điểm]\n" +
                    "4.Hiển thị 10 bài hát được đăng mới nhất [10 điểm]\n" +
                    "5.Thoát");

            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    findSongBySingerNameOrGenre();
                    break;
                case 2:
                    findSingerBySingerNameOrGenre();
                    break;
                case 3:
                   sortSongByName();
                    break;
                case 4:
                    findTop10Song();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nhạp sai");
            }
        }
    }
    public  static void  findSongBySingerNameOrGenre(){
        System.out.println("Nhập tên ca sĩ hoặc thể loại cần tìm");
        String searchName = InputMethods.getString();
        Song[] list = SongManagement.songController.findSongBySingerNameOrGenre(searchName);
        if (list.length==0){
            System.out.println("Không có kết ủa phù hợp");
            return;
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i]!=null){
                list[i].displayData();
            }
        }
    }
    public  static void  findSingerBySingerNameOrGenre(){
        System.out.println("Nhập tên ca sĩ hoặc thể loại cần tìm");
        String searchName = InputMethods.getString();
        Singer[] list = SingerManager.singerController.findAllByNameOrGenre(searchName);
        if (list.length==0){
            System.out.println("Không có kết ủa phù hợp");
            return;
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i]!=null){
                list[i].displayData();
            }
        }
    }
    public  static void  sortSongByName(){
        System.out.println("Danh sách bài hát sắp xếp tătng dần");
        Song[] list = SongManagement.songController.sortByName();
        for (int i = 0; i < SongManagement.songController.getSize(); i++) {
                list[i].displayData();
        }
    }
    public static void findTop10Song(){
        int size = SongManagement.songController.getSize();
        if(size<=10){
            SongManagement.displayAllSong();
            return;
        }
        for (int i = SongManagement.songController.getSize()-1; i > SongManagement.songController.getSize()-11 ; i--) {
            SongManagement.songController.findAll()[i].displayData();
        }
    }
}
