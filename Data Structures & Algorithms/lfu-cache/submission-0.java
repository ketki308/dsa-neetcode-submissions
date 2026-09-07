class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {
            if (size == 0) {
                return null;
            }

            Node node = tail.prev;
            remove(node);

            return node;
        }
    }

    private int capacity;
    private int size;
    private int minFreq;

    private HashMap<Integer, Node> keyToNode;
    private HashMap<Integer, DoublyLinkedList> freqToList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;

        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
    }

    public int get(int key) {

        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);

        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (keyToNode.containsKey(key)) {

            Node node = keyToNode.get(key);

            node.value = value;

            increaseFrequency(node);

            return;
        }

        // Cache is full
        if (size == capacity) {

            DoublyLinkedList list = freqToList.get(minFreq);

            Node nodeToRemove = list.removeLast();

            keyToNode.remove(nodeToRemove.key);

            size--;
        }

        // Insert new node
        Node newNode = new Node(key, value);

        keyToNode.put(key, newNode);

        DoublyLinkedList list =
                freqToList.computeIfAbsent(
                        1,
                        k -> new DoublyLinkedList()
                );

        list.addFirst(newNode);

        minFreq = 1;
        size++;
    }

    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList =
                freqToList.get(oldFreq);

        oldList.remove(node);

        // If this was the last node with minFreq,
        // minFreq must increase.
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList =
                freqToList.computeIfAbsent(
                        node.freq,
                        k -> new DoublyLinkedList()
                );

        // Add to front because this node was
        // just used, so it is now most recently used.
        newList.addFirst(node);
    }
}



/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */