import java.util.Scanner;

public class CGPACALCULATOR {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int infinity = 1;

        while (infinity == 1) {
            System.out.println("======================================");
            System.out.println("  CGPA JANAR ICCHA THAKLE 1 E TIP DE");
            System.out.println("      ICCHA NA THAKLE 2 E TIP DE");
            System.out.println("======================================");
            int choice = sc.nextInt();

            switch (choice){
                case 1 : {
                    System.out.print("koyta course nisili shantir chele? ");

                    int CourseNumber = EnterCourseNumber();
                    String[] CourseName = EnterCourseName(CourseNumber);
                    int[] Credit = EnterCourseCredit(CourseName, CourseNumber);
                    int[] CourseMarks = EnterCourseMarks(CourseName, CourseNumber);
                    float[] Grade = GradeDecider(CourseName, CourseMarks, CourseNumber);
                    int SumCredit = SumCredit(Credit, CourseNumber);
                    float CGPA = CalculateCGPA(Grade, SumCredit, Credit, CourseNumber);
                    PrintOutput(CourseName, CourseMarks, CourseNumber, SumCredit, CGPA );

                    break;
                }
                case 2 : {
                    System.out.println("Baal falao. gelam ami.............");
                    infinity = 2;
                    break;
                }
                default: {
                    System.out.println("ki baal chapos?");
                    break;
                }
            }
        }
    }
    public static int EnterCourseNumber() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String[] EnterCourseName(int CourseNumber) {
        Scanner sc = new Scanner(System.in);
        String[] CourseName = new String[100];
        for (int i = 0; i < CourseNumber; i++) {
            System.out.print("Course " + (i+1) + "er Name bol: ");
            CourseName[i] = sc.next();
        }
        return CourseName;
    }
    public static int[] EnterCourseCredit(String[] CourseName,int CourseNumber) {
        int [] Credit = new int[CourseNumber];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < CourseNumber; i++) {
            System.out.print("No"+(i+1)+": "+ CourseName[i]+" er credit de baal: ");
            Credit[i] = sc.nextInt();
        }
        return Credit;
    }
    public static int[] EnterCourseMarks(String[] CourseName, int CourseNumber) {
        Scanner sc = new Scanner(System.in);
        int[] CourseMarks = new int[CourseNumber];
        for (int i = 0; i < CourseNumber; i++) {
            System.out.print("No"+(i+1)+": "+ CourseName[i]+" er marks de baal: ");
            CourseMarks[i] = sc.nextInt();
        }
        return CourseMarks;
    }
    public static float[] GradeDecider(String[] CourseName, int[] CourseMarks, int CourseNumber) {
        float[] Grade = new float[CourseNumber];
        for(int i = 0; i < CourseNumber; i++) {
            if (CourseMarks[i] >= 85) {
                Grade[i] = 4.00F;
            } else if (CourseMarks[i] >= 80 && CourseMarks[i] < 85) {
                Grade[i] = 3.8F;
            } else if (CourseMarks[i] >= 75 && CourseMarks[i] < 80) {
                Grade[i] = 3.3F;
            } else if (CourseMarks[i] >= 70 && CourseMarks[i] < 75) {
                Grade[i] = 3.00F;
            }  else if (CourseMarks[i] >= 65 && CourseMarks[i] < 70) {
                Grade[i] = 2.8F;
            }  else if (CourseMarks[i] >= 60 && CourseMarks[i] < 65) {
                Grade[i] = 2.5F;
            }  else if (CourseMarks[i] >= 55 && CourseMarks[i] < 60) {
                Grade[i] = 2.00F;
            } else if (CourseMarks[i] >= 50 && CourseMarks[i] < 55) {
                Grade[i] = 1.5F;
            } else if (CourseMarks[i] <= 49){
                Grade[i] = 0.00F;
            }
        }
        return Grade;
    }
    public static int SumCredit (int[] Credit, int CourseNumber) {
        int SumCredit = 0;
        for (int i = 0; i < CourseNumber; i++) {
            SumCredit = Credit[i] + SumCredit;
        }
        return SumCredit;
    }
    public static float CalculateCGPA(float[] Grade, int SumCredit, int[] Credit, int CourseNumber) {
        float CGPA;
        float[] MultiplybyCredit = new float[CourseNumber];
        float Sum = 0;
        for (int i = 0; i < CourseNumber; i++) {
            MultiplybyCredit[i] = Grade[i] * Credit[i];
        }
        for (int i = 0; i < CourseNumber; i++) {
            Sum = MultiplybyCredit[i] + Sum;
        }
        CGPA = (Sum / SumCredit);
        return CGPA;
    }
    public static void PrintOutput(String[] CourseName, int[] CourseMarks, int CourseNunmber, int SumCredit, float CGPA) {
        System.out.println("============================================");
        if(CGPA <= 4.00 && CGPA >= 3.8){
            System.out.println("     bhai tui manusgh na alien?");
        } else if (CGPA >= 3.00 && CGPA < 3.8 ) {
            System.out.println("          bhaloi korsos re!");
        } else if (CGPA < 3.00 ) {
            System.out.println("        kopale shoni ase!");
        }
        System.out.println("          Tor CGPA hoilo: "+ CGPA);
        System.out.println("============================================");
    }
}