import java.util.ArrayList;
import java.util.List;

public class PowerOfTwoMaxHeap {

    private List<Integer> data;
    private int factor;
    private int size;

    public PowerOfTwoMaxHeap(int factor) {
        this.factor = factor;
        this.data = new ArrayList<>();
        this.size = 0;
    }

    public void insert(int value) {
        // Add the new element to the end of the list
        data.add(value);
        size++;

        // Compare the new element to its parent and swap until it satisfies the heap property
        int currentIndex = size - 1;

        while (currentIndex > 0 && data.get(currentIndex) > data.get(getParentIndex(currentIndex))) {
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    public int popMax() {
        // Save the value of the root element
        int max = data.get(0);

        // Replace the root element with the last element in the list
        data.set(0, data.get(size - 1));
        data.remove(size - 1);
        size--;

        // Compare the new root element to its children and swap until it satisfies the heap property
        int currentIndex = 0;

        while (currentIndex < size) {
            int maxChildIndex = getMaxChildIndex(currentIndex);

            // If the root element is smaller than the largest child, swap them
            if (data.get(currentIndex) < data.get(maxChildIndex)) {
                swap(currentIndex, maxChildIndex);
                currentIndex = maxChildIndex;
            } else {
                break;
            }
        }

        // Return the value of the original root element
        return max;
    }

    private int getParentIndex(int index) {
        return (index - 1) / (int) Math.pow(2, factor);
    }

    private int getMaxChildIndex(int index) {
        int maxChildIndex = index;

        // Find the largest child
        for (int i = 1; i <= (int) Math.pow(2, factor); i++) {
            int childIndex = (int) Math.pow(2, factor) * index + i;
            if (childIndex < size && data.get(childIndex) > data.get(maxChildIndex)) {
                maxChildIndex = childIndex;
            }
        }

        return maxChildIndex;
    }

    private void swap(int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    public Integer[] toArray() {
        return data.toArray(new Integer[size]);
    }
}



