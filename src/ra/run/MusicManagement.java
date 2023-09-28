package ra.run;


import ra.util.InputMethods;

public class MusicManagement {
//    public static ISinger singerController =new SingerController();
//    public static ISong songController =new SongController();
    public static void main(String[] args) {
        while (true){
            System.out.println("************************MUSIC-MANAGEMENT*************************\n" +
                    "1. Quản lý ca sĩ [20 điểm]\n" +
                    "2. Quản lý bài hát [20 điểm]\n" +
                    "3. Tìm kiếm bài hát [25 điểm]\n" +
                    "4. Thoát [5 điểm]");

            System.out.println("Nhập lựa chọn của bạn");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    // quan li ca sĩ
                    SingerManager.singerManagement();
                    break;
                case 2:
//                    quản li bai hat
                    SongManagement.songManagement();
                    break;
                case 3:
                    // tìm kiếm
                    SearchSong.menuSearch();
                    break;
                case 4:
                    System.out.println("Thoát");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập không đúng");
            }
        }
    }



}
