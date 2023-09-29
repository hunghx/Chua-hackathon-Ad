package ra.business.controller.implement;

import ra.business.controller.ISinger;
import ra.business.entity.Singer;
import ra.business.service.implement.SingerService;

import java.util.List;

public class SingerController implements ISinger {
    public SingerService singerService = new SingerService();


    @Override
    public List<Singer> findAll() {
        return singerService.findAll();
    }

    @Override
    public List<Singer> findAllByNameOrGenre(String name) {
        return singerService.findAllByNameOrGenre(name);
    }

    @Override
    public Singer findById(Integer id) {
        return singerService.findById(id);
    }

    @Override
    public void add(Singer singer) {
        singerService.add(singer);
    }

    @Override
    public void update(Singer singer) {
        singerService.update(singer);
    }

    @Override
    public void delete(Integer id) {
        singerService.delete(id);
    }



    //    public  int getNewId(){
//        int idMax = 0;
//        for (int i = 0; i <size ; i++) {
//            if (singers[i].getSingerId()>idMax){
//                idMax= singers[i].getSingerId();
//            }
//        }
//        return idMax+1;
//    }
    @Override
    public int getIdMax() {
        return singerService.getIdMax();
    }


}
