
import java.util.*;

public class Main2{
    public static void main(String[] args) {
        StudentData obj = new StudentData();
        obj.addStudent();
        obj.addStudent();
        obj.addStudent();
        obj.addStudent();
        obj.addStudent();
        obj.addStudent();
        obj.displayAllStudentData();
        obj.displaySpecificData(1);
        obj.displaySpecificData(3);
    }
}
