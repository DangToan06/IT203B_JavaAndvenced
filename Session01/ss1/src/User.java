public class User {
    private int age;

    public User(int age) {
        setAge(age);
    }

    public void setAge(int age) {
        if(age < 0 || age > 100){
            //Bai3
//            throw new IllegalArgumentException("Tuổi không thể âm (bai3)");
            //Bai5
                throw  new InvalidAgeException("Tuổi không thể âm (bai5)");
        }else {
            this.age = age;
            System.out.println("Thêm tuổi thành công");
        }
    }
}
