public class minHeap {
    private Integer[] array;
    private int size;

    public minHeap(int capacity) {
        array = new Integer[capacity];
        size = 0;
    }

    public minHeap(Integer[] array) {
        this.array = array;
        size = array.length;
        heapify();
    }

    private void heapify() {
        for(int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public Integer update(int index, Integer element) {
        return 0;

    }

    public void offer(Integer element) { //null is not allowed
        if(size < this.array.length) {
            array[size++] = element;
            percolateUp(size - 1);
        }

    }

    public Integer poll() {
        if(this.size == 0) {
            return null;
        }
        int value = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return value;

    }

    public Integer peek() {
        if(this.size == 0) {
            return null;
        }
        return array[0];

    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void percolateDown(int index) {
        while(2 * index + 1 < this.size) {
            int left = 2 * index + 1;
            int right = left + 1;
            if(right < size && array[right].compareTo(array[left]) < 0) {
                swap(index, right);
                index = right;
            }
            else if(array[left].compareTo(array[index]) < 0) {
                swap(index, left);
                index = left;
            }
            else {
                return;
            }
        }
    }

    private void percolateUp(int index) {
        while(index > 0) {
            int parent = (index - 1) / 2;
            if(array[index].compareTo(array[parent]) < 0) {
                swap(index, parent);
                index = parent;
            }
            else {
                return;
            }
        }
    }

    private void swap(int i, int j) {
        Integer tmp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = tmp;
    }


    public static void main(String[] ags) {
        System.out.println("hello");
        minHeap h = new minHeap(10);
        h.offer(20);
        h.offer(10);
        h.offer(5);
        System.out.println(h.size());
        System.out.println(h.poll());

    }
}
