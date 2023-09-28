package ra.business.service.implement;

import ra.business.entity.Singer;
import ra.business.entity.Song;
import ra.business.service.ISinger;

public class SingerService implements ISinger {
    private Singer[] singers;
    private int size=2;
    private int idMax = 1;

    public SingerService() {
        singers =  new Singer[100];
    }

    @Override
    public Singer[] findAll() {
        return singers;
    }

    @Override
    public Singer findById(Integer id) {
        for (int i = 0; i < size; i++) {
            if(singers[i].getSingerId()==id){
                return singers[i];
            }
        }
        return null;
    }

    @Override
    public void add(Singer singer) {
       singers[size] = singer;
       size++;
       idMax++;
    }

    @Override
    public void update(Singer singer) {
        for (int i = 0; i < size; i++) {
            if (singers[i].getSingerId()==singer.getSingerId()){
                // cập nhật
                singers[i] = singer;
                break;
            }
        }
    }

    @Override
    public void delete(Integer id) {
        int indexDel = -1;
        // tìm ra vị trí cần xóa
        for (int i = 0; i < size; i++) {
            if (singers[i].getSingerId()==id){
                indexDel=i;
            }
        }
        // thực hiện xóa
        for (int i = indexDel; i < size-1 ; i++) {
                singers[i] = singers[i+1];
        }
        singers[size] =null;
        size--;
    }

    public int getSize() {
        return size;
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

    public int getIdMax() {
        return idMax;
    }

    @Override
    public Singer[] findAllByNameOrGenre(String name) {
        Singer[] searchList  = new Singer[size];
        int index= 0;
        for (int i = 0; i < size; i++) {
            if(singers[i].getSingerName().contains(name)||singers[i].getGenre().contains(name)){
                searchList[index] = singers[i];
                index++;
            }
        }
        if (index ==0){
            return new Singer[0];
        }
        return searchList;
    }
}
