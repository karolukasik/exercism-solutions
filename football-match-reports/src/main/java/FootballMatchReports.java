import java.util.Scanner;

public class FootballMatchReports {
    public static String onField(int shirtNum) throws IllegalArgumentException {

        String playerDescription = "";
        switch (shirtNum) {
            case 1:
                playerDescription = "goalie";
                break;
            case 2:
                playerDescription = "left back";
                break;
            case 3:
            case 4:
                playerDescription = "center back";
                break;
            case 5:
                playerDescription = "right back";
                break;
            case 6:
            case 7:
            case 8:
                playerDescription = "midfielder";
                break;
            case 9:
                playerDescription = "left wing";
                break;
            case 10:
                playerDescription = "striker";
                break;
            case 11:
                playerDescription = "right wing";
                break;
            default:
                throw new IllegalArgumentException("The shirt number must be between 1 and 11");
        }
        return playerDescription;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Give shirt number, enter to escape:");
            String shirtNum = scanner.nextLine();
            if (shirtNum.equals("")) {
                break;
            }
            System.out.println(onField(Integer.parseInt(shirtNum)));
        }
        scanner.close();
    }
}
