class Solution {
    public int[] sortArray(int[] nums) {
        return Heap.sort(nums);
    }

    static class Heap
    {
        private final int[] backedArray;
        private int size;

        public Heap(int ... values) {
            this.size = values.length;
            backedArray = new int[this.size];
            System.arraycopy(values, 0, backedArray, 0, this.size);
            buildHeap();
        }

        private int parent(int idx) {
            return (idx - 1) >> 1;
        }

        private int left(int idx) {
            return 2 * idx + 1;
        }

        private int right(int idx){
            return 2 * idx + 2;
        }

        public static int[] sort(int[] nums) {
            var heap = new Heap(nums);
            int[] result = new int[nums.length];
            int currentSize = heap.size;
            for(int i = 0; i < currentSize; i++) {
                result[currentSize - 1 - i] = heap.backedArray[0];
                heap.backedArray[0] = heap.backedArray[heap.size - 1];
                heap.size--;
                heap.heapify(0);
            }

            return result;
        }

        private void buildHeap() {
            for(int i = (this.size / 2) - 1; i >= 0; i--) {
                heapify(i);
            }
        }

        private void heapify(int idx) {
            int largest = idx; 
            

            while(true) {
                
                int left = this.left(idx);
                int right = this.right(idx);

                if(left < size && backedArray[left] > backedArray[largest]) {
                    largest = left;
                }

                if(right < size && backedArray[right] > backedArray[largest]) {
                    largest = right;
                }

                if(largest != idx) {
                    swap(largest, idx);
                    idx = largest;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            int tmp = this.backedArray[i];
            this.backedArray[i] = this.backedArray[j];
            this.backedArray[j] = tmp;
        }
    }
}