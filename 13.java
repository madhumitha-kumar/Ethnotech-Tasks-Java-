public class std {
    public static void main(String[] args) {

        String[] names = {"Alice", "Bob", "Charlie", "David","Hema","chiranth"};
        int[] marks = {20, 92, 78, 90,85,43};

        if (names.length != marks.length) {
            System.out.println("Error: Arrays must be same length");
            return;
        }

        System.out.println("--- Student Result ---\n");

        System.out.println("Name      | Marks | Grade");
        System.out.println("-------------------------");

        for (int i = 0; i < names.length; i++) {

            char grade;

            if (marks[i] >= 90)
                grade = 'A';
            else if (marks[i] >= 80)
                grade = 'B';
            else if (marks[i] >= 70)
                grade = 'C';
            else if (marks[i] >= 60)
                grade = 'D';
            else
                grade = 'F';

            System.out.printf("%-9s | %-5d | %c \n", names[i], marks[i], grade);
        }
    }
}
