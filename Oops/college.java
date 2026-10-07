package Oops;
public class college{
    public static void main(String[] args){
        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "Anish";
        s1.age = 22;
        s1.rollNumber = 100;
        s1.college = "NMIMS";

        s2.name = "Malay";
        s2.age = 22;
        s2.rollNumber = 101;
        s2.college = "NMIMS";

        s1.markAttendance();
        s1.print();
        s2.markAttendance();
        s2.print();




    }

}

class Student{
    String name;
    int age;
    int rollNumber;
    String college;


    void markAttendance(){
        System.out.println("Attendance marked by " + name);
    }

    void print(){
        System.out.println(name +", "+age+", "+rollNumber+", "+college);
    }

}
