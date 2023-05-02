import java.util.Scanner;

class StudentData extends Student implements HostelAllotment{


    String inputs [] = {"Kaustubh", "17", "1", "MnC", "Yes", "4", "MA-111", "60",
            "Shishir", "19", "1", "MnC", "Yes", "2", "CSO-102", "57",
            "Jishu", "19", "1", "MnC", "No", "3", "MA-102", "75",
            "Hardik", "19", "1", "MnC", "No", "2", "EO-102", "81",
            "Anmol", "20", "1", "MnC", "No", "3", "MA-104", "64",
            "Anurag","21","2","MnC","Yes","4","MA-111","89"};
    int inpIndex = 0;

    Student students[] = new Student[6]; // Array of all Students

    private int studentTop = -1; // Implementing it as a Stack


    static Scanner console = new Scanner(System.in);

    // function to push a student's data in the stack
    public void addStudent()
    {
        // Stack overflow condition
        if(studentTop == students.length - 1)
        {
            System.out.println("No more students in this course!");
            return;
        }

        studentTop++;
        students[studentTop] = new Student(); // create a new student object
        setStudentDetails();
        setStudentMarks();
    }


    // Function to set the personal details of the student
    void setStudentDetails()
    {
        // Take in the name of the student
        //System.out.println("Enter Student Name: ");
        // students[studentTop].setName(console.nextLine());
        students[studentTop].setName(inputs[inpIndex++]);

        // Take in the age of the student
        //System.out.println("Enter Student Age: ");
        // students[studentTop].setAge(console.nextInt());
        students[studentTop].setAge(Integer.parseInt(inputs[inpIndex++]));

        // Take in the year of study of the student
        //System.out.println("Enter the year student is studying in: ");
        // students[studentTop].setYear(console.nextInt());
        // console.nextLine(); // Flushing the console
        students[studentTop].setYear(Integer.parseInt(inputs[inpIndex++]));

        // Take in the course the student is studying
        //System.out.println("Enter the course the student is studying: ");
        // students[studentTop].setBranch(console.nextLine());
        students[studentTop].setBranch(inputs[inpIndex++]);

        // Take in if the student plays any sport
        //System.out.println("Does the student play any sport?");
        if(inputs[inpIndex++].equalsIgnoreCase("No"))
        {
            students[studentTop].playsSport = false;
        }
        else{
            students[studentTop].playsSport = true;
        }

        // Take in the number of programming languages known to the student
        //System.out.println("How many programming languages has the student learned?");
        students[studentTop].setLanguages(Integer.parseInt(inputs[inpIndex++]));
    }

    // Function to set the marks of each subject the student studies
    public void setStudentMarks()
    {
        for (int i = 0; i < totalSubjects; i++) {

            // Creating a new subject the student is studying
            Subjects newSubject = new Subjects();

            // Take in the name of that subject
            //System.out.println("Enter Subject name");
            //  = console.next();
            newSubject.subject = (inputs[inpIndex++]);

            // Take in the marks the student got
            //System.out.println("Enter the marks of the subject: ");
            //  = console.nextInt();
            // console.nextLine(); // flushing the console
            newSubject.marks = Integer.parseInt(inputs[inpIndex++]);

            // Adding the new subject to the list of subjects the student studies
            students[studentTop].subjects[i] = newSubject;
        }   }


    static void printSpaces(int spaces)
    {
        for(int i = 0; i < spaces; i++)
        {
            System.out.print(" ");
        }
    }
    @Override
    public String allotHostel(int year) {
        String hostel = "";
        switch(year) {
            case 1:
                hostel = "Aryabhatta";
                break;
            case 2:
                hostel = "Dhanrajgiri";
                break;
            case 3:
                hostel = "Rajputana";
                break;
            case 4:
                hostel = "Limbdi";
                break;
            default:
                hostel = "Not eligible for hostel allotment";
                break;
        }
        return hostel;
    }

    // Function for all student details

    public void displayAllStudentData()
    {
        // Format of the output
        System.out.print("Name\t\tAge\t\tYear\t\tBranch\n");

        // printing each students details
        for (int i = studentTop; i >= 0; i--) {
            System.out.print(students[i].getName());
            printSpaces(16 - students[i].getName().length());
            System.out.print(students[i].getAge()+"\t\t"+students[i].getYear()+"\t\t"+students[i].getBranch() + "\t\t");

            for(int j = 0; j < students[i].subjects.length; j++)
            {
                System.out.print(students[i].subjects[j].subject + " " + students[i].subjects[j].marks + "\t");
            }
            System.out.print("\tPercentage: " + students[i].percentage() + "%");
            System.out.print("\t Attendance Percent: " + getAttendance(students[i].getName()));
            System.out.print("\t Hostel Alloted: " + allotHostel(students[i].getYear()));
            if(getAttendance(students[i].getName())<75 && students[i].percentage()<=75.0){
                System.out.println("\t Passing Status: Fail");
            }
            else if(getAttendance(students[i].getName())>75 && students[i].percentage()<=75.0){
                System.out.println("\t Passing Status: Fail");
            }
            else if(getAttendance(students[i].getName())<75 && students[i].percentage()>=75.0){
                System.out.println("\t Passing Status: Fail");
            }
            else if(getAttendance(students[i].getName())>75 && students[i].percentage()>=75.0){
                System.out.println("\t Passing Status: Pass");
            }
            System.out.println();
        }
    }

    // Function for specific student's details
    public void displaySpecificData(int index)
    {
        if(index > studentTop)
        {
            System.out.println("Student's data does not exists!");
            return;
        }
        System.out.println("\nName: " + students[index].getName());
        System.out.println("Age: " + students[index].getAge());
        System.out.println("Year: " + students[index].getYear());
        System.out.println("Branch: " + students[index].getBranch());

        System.out.println("Subject\tMarks");
        for (int i = 0; i < students[index].subjects.length; i++) {
            System.out.println(students[index].subjects[i].subject+"\t"+students[index].subjects[i].marks);
        }

        // Final greeting in the languages known to the student
        students[index].greet();
    }
}
