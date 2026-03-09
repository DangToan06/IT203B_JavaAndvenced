import java.time.LocalDate;
import java.util.Scanner;

public class Bai1 {
    public static void tinhTuoi(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập năm sinh của bạn: ");
        String namString = sc.nextLine();

        try{
            int namInt = Integer.parseInt(namString);
            int year = LocalDate.now().getYear();
            System.out.println("Tuổi bạn là: " + (year - namInt));
        }catch (NumberFormatException e){
            System.err.println("Năm sinh phải nhập số!!!!!!!!!!!");
        }finally {
            sc.close();
            System.out.println("Dọn dẹp tài nguyên");
        }

    }

    public static void chiaNhom(){
        Scanner sc = new Scanner(System.in);



        try {
            System.out.println("Nhập số lượng người dùng: ");
            int numUser = sc.nextInt();

            System.out.println("Nhập số nhóm muốn chia: ");
            int group = sc.nextInt();

            System.out.println("Số lượng người trong 1 nhóm là: " + numUser/group);
        }catch (ArithmeticException e){
            System.out.println("Số nhóm không được phép bằng 0");
        }
    }
}
