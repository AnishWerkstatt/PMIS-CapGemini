class App{
    public static void main(String[] args){
        System.out.println("initial user count: " + UserAccount.getTotalUsers());

        UserAccount user1 = new UserAccount("Varun");
        UserAccount user2 = new UserAccount("vaibhav");
        UserAccount user3 = new UserAccount("Durvesh");

        System.out.println("created: " + user1.getUsername());
        System.out.println("created: " + user2.getUsername());
        System.out.println("created: " + user3.getUsername());

        System.out.println("Total users registered: " + UserAccount.getTotalUsers());

    

       
    }
}