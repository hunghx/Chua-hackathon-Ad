package ra.business.entity;

import ra.util.InputMethods;
import ra.util.SingerValidateInput;

public class Singer implements IOData{
    @Override
    public void inputData() {
        System.out.println("Nhập tên ca sĩ");
        this.singerName = InputMethods.getString();
        System.out.println("Nhập tuổi");
        this.age = SingerValidateInput.inputAge();
        System.out.println(" Nhập thể loại");
        this.genre = InputMethods.getString();
        System.out.println("Nhập quốc tịch");
        this.nationality = InputMethods.getString();
        System.out.println("Nhập giới tính : true / false");
        this.gender =InputMethods.getBoolean();
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %d - Name : %s - Age : %d - National: %s - Sex : %s - Genre: %s \n",singerId,singerName,age,nationality,gender?"Nam":"Nữ",genre);
    }

    private  int singerId;
    private String singerName;
    private  int age;
    private  String nationality;
    private  boolean gender;
    private  String genre;

    public Singer() {
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
