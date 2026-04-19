class LinkedList {

        static class Node {
            private Node next;
            private int value;

            public Node(int value) {
                this.value = value;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        public LinkedList() {
            head = null;
            tail = null;
        }

        public int get(int index) {
            if (head == null) return -1;
            if (index < 0 || index >= size) return -1;

            var node = head;
            int i = 0;
            while(node != null) {
                if(i == index) return node.value;
                i++;
                node = node.next;
            }

            return -1;
        }

        public void insertHead(int val) {
            if (head == null) {
                var node = new Node(val);
                this.head = node;
                this.tail = node;
                this.size++;
                return;
            }

            var next = head;
            this.head = new Node(val);
            this.head.next = next;
            this.size++;
        }

        public void insertTail(int val) {
            if (head == null) {
                var node = new Node(val);
                this.head = node;
                this.tail = node;
                this.size++;
                return;
            }
            var node = new Node(val);
            tail.next = node;
            tail = node;
            this.size++;
        }

        public boolean remove(int index) {
            if (head == null) return false;
            if (index < 0 || index >= size) return false;
            if(size == 1) {
                this.head = null;
                this.tail = null;
                this.size--;
                return true;
            }
            if(index == 0) {
                this.head = head.next;
                this.size--;
                return true;
            }

            var node = head;
            Node prev = null;
            int i = 0;
            while(node != null) {
                if(i == index) {
                    if(prev.next == tail) {
                        this.tail = prev;
                    }
                    prev.next = node.next;
                    this.size--;
                    return true;
                }
                i++;
                prev = node;
                node = node.next;
            }
            return false;
        }

        public ArrayList<Integer> getValues() {
            if(head == null) {
                return new ArrayList<>();
            }

            ArrayList<Integer> vals = new ArrayList<>();

            var node = head;
            while(node != null) {
                vals.add(node.value);
                node = node.next;
            }
            return vals;
        }
    }
