import java.util.Random;

public class Attendance  {
    private int jishuAttendance;
    private int shishirAttendance;
    private int hardikAttendance;    private int anmolAttendance;
    private int kasutubhAttendance;
    private int anuragAttendance;

    public Attendance() {
        Random random = new Random();
        jishuAttendance = random.nextInt(101);
        shishirAttendance = random.nextInt(101);
        hardikAttendance = random.nextInt(101);
        anmolAttendance = random.nextInt(101);
        kasutubhAttendance = random.nextInt(101);
        anuragAttendance=random.nextInt(101);
    }


    public int getJishuAttendance() {
        return jishuAttendance;
    }

    public int getShishirAttendance() {
        return shishirAttendance;
    }

    public int getHardikAttendance() {
        return hardikAttendance;
    }

    public int getAnmolAttendance() {
        return anmolAttendance;
    }

    public int getKaustubhAttendance() {
        return kasutubhAttendance;
    }

    public int getAnuragAttendance() {
        return anuragAttendance;
    }

    public int getAttendance(String name) {
        if (name.equalsIgnoreCase("Jishu")) {
            return getJishuAttendance();
        } else if (name.equalsIgnoreCase("Shishir")) {
            return getShishirAttendance();
        } else if (name.equalsIgnoreCase("Hardik")) {
            return getHardikAttendance();
        } else if (name.equalsIgnoreCase("Anmol")) {
            return getAnmolAttendance();
        } else if (name.equalsIgnoreCase("Kaustubh")) {
            return getKaustubhAttendance();
        }
        else if(name.equalsIgnoreCase("Anurag")){
            return getAnuragAttendance();
        }else {
            System.out.println("\tInvalid name entered.");
            return -1;
        }
    }

}

