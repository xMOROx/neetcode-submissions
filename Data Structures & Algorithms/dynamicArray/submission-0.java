class DynamicArray {

    private int[] array;
    private int size = 0;
    private int capacity;

    public DynamicArray(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        this.array[i] = n;
    }

    public void pushback(int n) {
        if(this.size >= this.capacity) {
            resize();
        }
        this.array[this.size++] = n;
    }

    public int popback() {
        this.size -= 1;
        return this.array[this.size];
    }

    private void resize() {
        int[] newA = new int[capacity * 2];

        for(int i = 0; i < capacity; i++) {
            newA[i] = array[i];
        }
        this.array = newA;
        this.capacity *= 2;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
