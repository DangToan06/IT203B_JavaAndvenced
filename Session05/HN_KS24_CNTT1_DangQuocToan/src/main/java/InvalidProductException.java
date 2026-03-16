public class InvalidProductException extends  Exception {
    public static void createProduct() throws InvalidProductException {
        System.out.println("Nhập id: ");
        int id = Main.sc.nextInt();
        Main.sc.nextLine();
        System.out.println("Nhập tên: ");
        String name = Main.sc.nextLine();
        System.out.println("Nhập giá bán: ");
        double price = Main.sc.nextDouble();
        System.out.println("Nhập số lượng: ");
        int quantity = Main.sc.nextInt();
        Main.sc.nextLine();
        System.out.println("Nhập danh mục: ");
        String category = Main.sc.nextLine();

        if (Main.products.isEmpty()){
            Main.products.add(new Product(id,name,price,quantity,category));
        }else {
            if (!Main.products.contains(id)){
                Main.products.add(new Product(id, name, price, quantity, category));
            }else  {
                throw new InvalidProductException();
            }
        }
    }
}
