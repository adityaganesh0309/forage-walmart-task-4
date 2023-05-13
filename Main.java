import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(5);

        heap.insert(10);
        heap.insert(15);
        heap.insert(8);
        heap.insert(12);

        int maxElement = heap.popMax();
        System.out.println("Maximum element: " + maxElement);
        System.out.println("Heap contents: " + Arrays.toString(heap.toArray()));
    }
}
