public class SuperAdmin implements AdminActions,UserActions{
    @Override
    public void logActivity(String activity){
        // Chon interface thuc thi
        AdminActions.super.logActivity(activity);
        // Hoac tu dinh nghia
        System.out.println("-> SuperAdmin has processed this log.");
    };
}
