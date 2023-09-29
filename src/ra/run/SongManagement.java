package ra.run;

import ra.business.controller.ISong;
import ra.business.controller.implement.SongController;
import ra.business.entity.Song;
import ra.util.InputMethods;

public class SongManagement {
    public static final ISong songController = new SongController();
    public static void songManagement(){
        while (true){
            System.out.println("**********************SONG-MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới (có validate dữ\n" +
                    "liệu nhập vào) [10 điểm]\n" +
                    "2.Hiển thị danh sách tất cả bài hát đã lưu trữ [5 điểm]\n" +
                    "3.Thay đổi thông tin bài hát theo mã id [10 điểm]\n" +
                    "4.Xóa bài hát theo mã id [5 điểm]\n" +
                    "5.Thoát");

            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    // thêm mới
                    addNewSong();
                    break;
                case 2:
                    // hiển thị
                    displayAllSong();
                    break;
                case 3:
                    // chỉnh sửa
                    editSong();
                    break;
                case 4:
                    // xóa
                    deleteSong();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nhạp sai");
            }
        }
    }

    public static void addNewSong(){
        if(SingerManager.singerController.findAll().isEmpty()){
            System.out.println("bạn cần thêm ca sĩ trước");
            return;
        }
        // nhập số lượng
        System.out.println("Nhập số lượng bài hát cân thêm");
        byte count = InputMethods.getByte();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho bài hát thứ "+(i+1));
            Song newSong = new Song();
            newSong.inputData();
            // đã có dữ liệu thì tiến hanh thêm mới
            songController.add(newSong);
            System.out.println("Thêm mới thành công");
        }
    }
    public  static void displayAllSong(){
        if(songController.findAll().isEmpty()){
            System.out.println("Danh sách trống");
            return;
        }
        System.out.println("Danh sách ca sĩ");
        for (Song s:songController.findAll()
             ) {
            s.displayData();
        }
    }
    public static void editSong(){
        System.out.println("Nhập id cần sửa");
        String idEdit = InputMethods.getString();
        Song songEdit = songController.findById(idEdit);
        if (songEdit == null){
            System.out.println("Id không tôn tại");
            return;
        }
        // hiển thị thông tin cũ
        System.out.println("Thông tin cũ của ca sĩ");
        songEdit.displayData();
        // cho phép sửa
        songEdit.inputData();
        // lưu lại
        songController.update(songEdit);
        System.out.println("Cập nhật thành công");
    }

    public static  void deleteSong(){
        System.out.println("Nhập id cần xóa");
        String idDel = InputMethods.getString();
        if (songController.findById(idDel)== null){
            System.out.println("Id không tôn tại");
            return;
        }
        songController.delete(idDel);
        System.out.println("xóa thành công");
    }
}
