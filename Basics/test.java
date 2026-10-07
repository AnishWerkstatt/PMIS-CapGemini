//Convert a total number of seconds into hours, minutes, and remaining seconds.

package Basics;
import java.util.*;
class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total seconds: ");

        long totalSeconds = sc.nextLong();

        long hours = totalSeconds / 3600;
        long remainingSeconds = totalSeconds % 3600;
        long minutes = remainingSeconds / 60;
        long seconds = remainingSeconds % 60;

        System.out.println(hours + "hours" + minutes +" mins" + seconds);



    }
}