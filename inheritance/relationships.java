class UserAccount{
    private String username;

    private static int totalUsers = 0;

    public UserAccount(String username){
        this.username = username;
        totalUsers ++;
    }

    public String getUsername(){
        return username;
    }

    public static int getTotalUsers(){
        return totalUsers;

    }
}

