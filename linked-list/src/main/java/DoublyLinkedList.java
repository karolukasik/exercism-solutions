
public class DoublyLinkedList<T> {

    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void push(T value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
            return;
        }
        Node temp = this.tail;
        this.tail.nextNode = newNode;
        this.tail = newNode;
        this.tail.previousNode = temp;
    }

    public T pop() {
        if (this.head == this.tail) {
            T value = this.tail.value;
            this.head = null;
            return value;
        }
        T value = this.tail.value;
        Node temp = this.tail.previousNode;
        this.tail = temp;
        return value;
    }

    public T shift() {
        if (this.head == this.tail) {
            T value = this.head.value;
            this.head = null;
            this.tail = null;
            return value;

        }
        T value = this.head.value;
        this.head = this.head.nextNode;
        this.head.previousNode = null;
        return value;
    }

    public void unshift(T value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        }
        newNode.nextNode = this.head;
        this.head.previousNode = newNode;
        this.head = newNode;

    }

    class Node {
        Node previousNode;
        Node nextNode;
        T value;

        public Node(T value) {
            this.value = value;
            this.previousNode = null;
            this.nextNode = null;
        }
    }
}
