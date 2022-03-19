import java.util.ArrayList;

class Scrabble {
    private char[] wordAsChars;

    Scrabble(String word) {
        this.wordAsChars = word.toLowerCase().toCharArray();
    }

    int getScore() {
        int score = 0;
        for (char c : wordAsChars) {
            score += letterValue(c);
        }
        return score;
    }

    int letterValue(char letter) {
        ArrayList<char[]> arraysOfPoints = new ArrayList<>();
        char[] onePoint = { 'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't' };
        char[] twoPoints = { 'd', 'g' };
        char[] threePoints = { 'b', 'c', 'm', 'p' };
        char[] fourPoint = { 'f', 'h', 'v', 'w', 'y' };
        char[] fivePoints = { 'k' };
        char[] eightPoints = { 'j', 'x' };
        char[] tenPoints = { 'q', 'z' };
        arraysOfPoints.add(onePoint);
        arraysOfPoints.add(twoPoints);
        arraysOfPoints.add(threePoints);
        arraysOfPoints.add(fourPoint);
        arraysOfPoints.add(fivePoints);
        arraysOfPoints.add(eightPoints);
        arraysOfPoints.add(tenPoints);

        for (int i = 0; i < arraysOfPoints.size(); i++) {
            for (int j = 0; j < arraysOfPoints.get(i).length; j++) {
                if (arraysOfPoints.get(i)[j] == letter) {
                    return checkNumberOfPoints(i);
                }
            }
        }

        return -1;
    }

    int checkNumberOfPoints(int arrayIterationNumber) {
        if (arrayIterationNumber == 0) {
            return 1;
        } else if (arrayIterationNumber == 1) {
            return 2;
        } else if (arrayIterationNumber == 2) {
            return 3;
        } else if (arrayIterationNumber == 3) {
            return 4;
        } else if (arrayIterationNumber == 4) {
            return 5;
        } else if (arrayIterationNumber == 5) {
            return 8;
        } else {
            return 10;
        }
    }

}
