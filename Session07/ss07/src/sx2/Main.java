package sx2;
import java.util.Scanner;

import sx2.core.ISalesChannelFactory;
import sx2.factories.MobileAppFactory;
import sx2.factories.StorePOSFactory;
import sx2.factories.WebsiteFactory;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CHON KENH BAN HANG:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. Store POS");

        String choice = scanner.nextLine();
        ISalesChannelFactory factory = switch (choice) {
            case "1" -> new WebsiteFactory();
            case "2" -> new MobileAppFactory();
            case "3" -> new StorePOSFactory();
            default -> null;
        };

        if (factory != null) {
            System.out.println("--- Xu ly don hang ---");
            factory.createDiscount().apply();
            factory.createPayment().process();
            factory.createNotification().send();
        } else {
            System.out.println("Lua chon khong hop le.");
        }

        scanner.close();
    }
}
