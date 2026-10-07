package Oops;

public class test {
    public static void main(String[] args){
        Stu s1 = new Stu();
        Stu s2 = new Stu();
        s1.name = "Anish";
        s2.name = "Olise";
        
        s1.markAttendance();
        s2.markAttendance();
    }
    
}

class Stu{
    String name;
    int rollNumber;
    int age;
    String college;

    void printDet(){
        System.out.println(name + "\n" + rollNumber + "\n" + college + "\n" +age);
    }
    void markAttendance(){
        System.out.println(name + " has marked the attendance.");
    }
}