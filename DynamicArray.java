public class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;

    public DynamicArray() {
        capacity = 10;
        array = new int[capacity];
        size = 0;
    }

    public void add(int element) {
        ensureCapacity();
        array[size++] = element;
    }

    public void insertAt(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        array[index] = element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size >= capacity) {
            capacity *= 2;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.printArray(); 

        dynamicArray.insertAt(1, 4);
        dynamicArray.printArray(); 

        dynamicArray.removeAt(2);
        dynamicArray.printArray(); 

        System.out.println(dynamicArray.get(1));     dynamicArray.set(1, 5);
        dynamicArray.printArray(); 

        System.out.println(dynamicArray.size()); 
        System.out.println(dynamicArray.isEmpty());
    }
}
