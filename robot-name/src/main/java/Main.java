public class Main {
    public static void main(String[] args) {
        Robot arrayOfRobots[] = new Robot[5];

        for (int i = 0; i < 5; i++) {
            Robot iBot = new Robot();
            arrayOfRobots[i] = iBot;
        }

        for (Robot robot : arrayOfRobots) {
            System.out.println(robot);
        }

        arrayOfRobots[0].reset();

        System.out.println("---");
        for (Robot robot : arrayOfRobots) {
            System.out.println(robot);
        }

    }
}
