
import java.util.ArrayList;
import java.util.Random;

public class Robot {
    private String name;
    private static ArrayList<String> listOfRobotsNames = new ArrayList<>();

    public Robot() {
        createRobot();
    }

    private void createRobot() {
        this.name = generateName();
        Robot.listOfRobotsNames.add(this.name);
    }

    private String generateName() {
        Random rand = new Random();
        StringBuilder nameBuilder = new StringBuilder(5);
        for (int i = 1; i <= 2; i++) {
            int characterASCII = rand.nextInt(26) + 65;
            nameBuilder.append((char) characterASCII);
        }
        for (int i = 3; i <= 5; i++) {
            int number = rand.nextInt(10);
            nameBuilder.append(number);
        }
        String generatedName = nameBuilder.toString();

        if (nameAlreadyExist(generatedName)) {
            return generateName();
        }

        return generatedName;

    }

    public boolean nameAlreadyExist(String name) {
        return !(Robot.listOfRobotsNames.isEmpty()) && Robot.listOfRobotsNames.contains(name);
    }

    public String getName() {
        return this.name;
    }

    public void reset() {
        Robot.listOfRobotsNames.remove(this.name);
        createRobot();
    }

    @Override
    public String toString() {
        return "Robot name: " + this.name;
    }

}
