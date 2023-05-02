public class Student extends Attendance implements SportsGrace, Programming, Marks{

    private String name; // Name of the Student
    private int age; // Age of the Student
    private int year; // Current Year of the Student's Study
    private String branch; // Branch the Student is studying in
    public boolean playsSport; // Does the Student play any Sport?

    private int languagesKnown;//How many languages does the student know

    // A class of subjects and their marks
    class Subjects
    {
        String subject;
        int marks;
    }

    Subjects subjects[] = new Subjects[totalSubjects]; // Array of all the subjects of the student


    // Calculates Percentage of the Student
    @Override
    public double percentage()
    {
        int totalMarks = 0;
        for (int i = 0; i < subjects.length; i++) {
            totalMarks += subjects[i].marks;
        }

        double percentage = (double)totalMarks/(subjects.length * maxMarks) * 100;
        if(totalMarks <= subjects.length * maxMarks - 5)
            return finalPercentage(playsSport, percentage);
        else
            return percentage;
    }


    // To add grace marks if needed
    @Override
    public double finalPercentage(boolean playsSport, double currentPercentage)
    {
        if(playsSport)
        {
            double per = (currentPercentage + sportsGrace*100/(subjects.length * maxMarks));
            per *= 100;
            per = ((int)per)/100;
            return per;
        }
        else
            return currentPercentage;

    }


    // Greets in known different programming languages
    public void greet()
    {
        System.out.println("I have to learn printing in "+languagesToLearn+" languages.");
        for (int i = 0; i < languagesKnown; i++) {
            System.out.println(greetings[i]);
        }
    }


    // Getter and Setter for name
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }


    // Getter and Setter for age
    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return this.age;
    }


    // Getter and Setter for year
    public void setYear(int year)
    {
        this.year = year;
    }

    public int getYear()
    {
        return this.year;
    }


    // Getter and Setter for branch
    public void setBranch(String branch)
    {
        this.branch = branch;
    }

    public String getBranch()
    {
        return this.branch;
    }

    // Getter and Setter for languagesKnown
    public void setLanguages(int num)
    {
        this.languagesKnown = num;
    }

    public int getLanguages()
    {
        return this.languagesKnown;
    }

}
