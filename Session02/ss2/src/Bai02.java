import java.util.function.Predicate;

public class Bai02 {
    public static void kiemTraMatKhau(){
        Predicate<String> isValid = p -> p.length() >= 8;

        System.out.println(isValid.test("12345678"));
        System.out.println(isValid.test("1234"));

    }
}
