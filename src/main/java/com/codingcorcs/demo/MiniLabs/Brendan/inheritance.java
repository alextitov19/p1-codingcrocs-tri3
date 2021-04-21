package com.codingcorcs.demo.MiniLabs.Recursion;

public class inheritance {
}
class Teacher {
    String designation = "Professor";
    String collegeName = "lecture hall";
    void does(){
        System.out.println("Teaching");
    }
}

 class PhysicsTeacher extends Teacher{
    String mainSubject = "Calculus";
    public static void main(String args[]){
        PhysicsTeacher obj = new PhysicsTeacher();
        System.out.println(obj.collegeName);
        System.out.println(obj.designation);
        System.out.println(obj.mainSubject);
        obj.does();
    }
}
