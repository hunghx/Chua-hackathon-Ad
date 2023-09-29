package ra.business.service.implement;

import ra.business.entity.Singer;
import ra.business.service.ISinger;

import java.util.ArrayList;
import java.util.List;

public class SingerService implements ISinger {
    private List<Singer> singers;
    private int idMax = 1;

    public SingerService() {
        singers =  new ArrayList<>();
    }

    @Override
    public List<Singer> findAll() {
        return singers;
    }

    @Override
    public Singer findById(Integer id) {
        for (Singer s:singers) {
            if(s.getSingerId()==id){
                return s;
            }
        }
        return null;
    }

    @Override
    public void add(Singer singer) {
       singers.add(singer);
       idMax++;
    }

    @Override
    public void update(Singer singer) {
        singers.set(singers.indexOf(findById(singer.getSingerId())),singer);
    }

    @Override
    public void delete(Integer id) {
       singers.remove(findById(id));
    }

    public int getIdMax() {
        return idMax;
    }

    @Override
    public List<Singer> findAllByNameOrGenre(String name) {
       List<Singer> searchList = new ArrayList<>();
        for (Singer s:singers) {
            if(s.getSingerName().contains(name)|| s.getGenre().contains(name)){
                searchList.add(s);
            }
        }
        return searchList;
    }
}
