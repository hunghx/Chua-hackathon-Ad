package ra.util;

import ra.business.entity.Singer;
import ra.run.MusicManagement;
import ra.run.SingerManager;
import ra.run.SongManagement;

public class SongValidateInput {
    private static final String SONG_ID_INVALID= "ID không hợp lệ, vui lòng thử lại";
    private static final String PATTERN_ID= "^S\\d{3}$";
    private static final String SONG_ID_EXISTS= "ID đã tồn tại, vui lòng thử lại";
    private static final String SONG_ID_NOT_EXISTS= "ID không tồn tại, vui lòng thử lại";
    public static String inputSongId(){
        while (true){
            String input = InputMethods.getString();
            if (!input.matches(PATTERN_ID)){
                System.out.println(SONG_ID_INVALID);
                continue;
            }
            if (SongManagement.songController.existsBySongId(input)){
                System.out.println(SONG_ID_EXISTS);
                continue;
            }
            return input;
        }
    }
    public static Singer inputSinger(){
//        hiển thị danh sách ca sĩ
        SingerManager.displayAllSinger();
        while (true){
        System.out.println("Nhập id ca sĩ cho bài hát");
        int id = InputMethods.getInteger();
        Singer s =SingerManager.singerController.findById(id);
        if(s!=null){
            return s;
        }
            System.out.println(SONG_ID_NOT_EXISTS);
        }

    }
}
