package ra.run;

import ra.business.controller.ISinger;
import ra.business.controller.implement.SingerController;
import ra.business.entity.Singer;
import ra.business.service.implement.SingerService;
import ra.util.InputMethods;

public class SingerManager {
    public static ISinger singerController = new SingerController();
    public static void singerManagement(){
        while (true){
            System.out.println("**********************SINGER-MANAGEMENT*************************\n" +
                    "1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới (có validate dữ\n" +
                    "liệu nhập vào) [10 điểm]\n" +
                    "2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ [5 điểm]\n" +
                    "3.Thay đổi thông tin ca sĩ theo mã id [10 điểm]\n" +
                    "4.Xóa ca sĩ theo mã id (kiểm tra xem nếu ca sĩ có bài hát thì không xóa được)[5 điểm]\n" +
                    "5.Thoát");

            System.out.println("Nhập lựa chọn");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    // thêm mới
                    addNewSinger();
                    break;
                case 2:
                    // hiển thị
                    displayAllSinger();
                    break;
                case 3:
                    // chỉnh sửa
                    editSinger();
                    break;
                case 4:
                    // xóa
                    deleteSinger();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Nhạp sai");
            }
        }
    }

    public static void addNewSinger(){
        // nhập số lượng
        System.out.println("Nhập số lượng ca sĩ cân thêm");
        byte count = InputMethods.getByte();
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho ca sĩ thứ "+(i+1));
            Singer newSinger = new Singer();
            // có id tự tăng
            newSinger.setSingerId(singerController.getIdMax());
            newSinger.inputData();
            // đã có dữ liệu thì tiến hanhhf thêm mới
            singerController.add(newSinger);
            System.out.println("Thêm mới thành công");
        }
    }
    public  static void displayAllSinger(){
        if(singerController.findAll().isEmpty()){
            System.out.println("Danh sách trống");
            return;
        }
        System.out.println("Danh sách ca sĩ");
        for (Singer s: singerController.findAll()
             ) {
            s.displayData();
        }
    }
    public static void editSinger(){
        System.out.println("Nhập id cần sửa");
        int idEdit = InputMethods.getInteger();
        Singer singerEdit = singerController.findById(idEdit);
        if (singerEdit == null){
            System.out.println("Id không tôn tại");
            return;
        }
        // hiển thị thông tin cũ
        System.out.println("Thông tin cũ của ca sĩ");
        singerEdit.displayData();
        // cho phép sửa
        singerEdit.inputData();
        // lưu lại
        singerController.update(singerEdit);
        System.out.println("Cập nhật thành công");
    }

    public static  void deleteSinger(){
        System.out.println("Nhập id cần xóa");
        int idDel = InputMethods.getInteger();

        if (singerController.findById(idDel)== null){
            System.out.println("Id không tôn tại");
            return;
        }
        if(SongManagement.songController.existsSongBySingerId(idDel)){
            System.out.println("Ca sĩ này có bài hát , không thể xóa");
            return;
        }
        singerController.delete(idDel);
        System.out.println("xóa thành công");
    }
}
