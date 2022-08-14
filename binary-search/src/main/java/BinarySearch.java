
import java.util.List;

public class BinarySearch {

    List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list;
    }

    public int indexOf(int searchedValue) throws ValueNotFoundException {
        if (this.list.isEmpty()) {
            throw new ValueNotFoundException("Value not in array");
        }
        return indexOf(searchedValue, 0, this.list.size() - 1);
    }

    private int indexOf(int searchedValue, int minIndex, int maxIndex)
            throws ValueNotFoundException {

        while (minIndex <= maxIndex) {

            double middleIndexDouble = (((double) maxIndex + (double) minIndex) / 2);
            int middleIndex = (int) Math.round(middleIndexDouble);
            int middleValue = this.list.get(middleIndex);

            if (searchedValue == middleValue) {
                return middleIndex;
            } else if (searchedValue > middleValue) {
                return indexOf(searchedValue, middleIndex + 1, maxIndex);
            } else if (searchedValue < middleValue) {
                return indexOf(searchedValue, minIndex, middleIndex - 1);
            }
        }

        throw new ValueNotFoundException("Value not in array");

    }

    public static void main(String[] args) throws ValueNotFoundException {
        List<Integer> sortedList = List.of(1, 3, 4, 6, 8, 9, 11);
        BinarySearch search = new BinarySearch(sortedList);

        System.out.println(search.indexOf(3));
    }
}
