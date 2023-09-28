package ra.util;

public class SingerValidateInput {
    private static final String AGE_ERROR = "===>> Tuổi phải lớn hơn 0";
    public static int inputAge(){
        while (true) {
            int age = InputMethods.getInteger();
          if(age<1){
              System.out.println(AGE_ERROR);
              continue;
          }
          return age;
        }
    }
}
