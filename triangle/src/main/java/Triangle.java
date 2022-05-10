import java.util.Arrays;

class Triangle {
    private double[] sortedSides;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        checkIfItIsTriangle(arrayOfSortedSides(side1, side2, side3));
        this.sortedSides = arrayOfSortedSides(side1, side2, side3);
    }

    boolean isEquilateral() {
        if (this.sortedSides[0] == this.sortedSides[1] && this.sortedSides[1] == this.sortedSides[2]) {
            return true;
        }
        return false;
    }

    boolean isIsosceles() {
        if (this.sortedSides[0] == this.sortedSides[1]) {
            return true;
        } else if (this.sortedSides[1] == this.sortedSides[2]) {
            return true;
        }
        return false;
    }

    boolean isScalene() {
        if (this.sortedSides[0] != this.sortedSides[1] && this.sortedSides[1] != this.sortedSides[2]) {
            return true;
        }
        return false;
    }

    private void checkIfItIsTriangle(double[] sides) throws TriangleException {
        if (sides[0] + sides[1] < sides[2] || sides[0] == 0 || sides[1] == 0 ||
                sides[2] == 0) {
            throw new TriangleException();
        }
    }

    private double[] arrayOfSortedSides(double side1, double side2, double side3) {
        double[] sides = { side1, side2, side3 };
        Arrays.sort(sides);
        return sides;
    }

    public static void main(String[] args) throws TriangleException {
        Triangle triangle = new Triangle(4, 4, 4);
        System.out.println(triangle);

        System.out.println("is isosceles: " + triangle.isIsosceles());
        System.out.println("is equilateral: " + triangle.isEquilateral());
        System.out.println("is scalene: " + triangle.isScalene());
    }

}
