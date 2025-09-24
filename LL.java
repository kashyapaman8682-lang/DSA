// Define Node structure
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Linked List implementation
class LinkedList {
    Node head;

    // Create linked list from an array of values
    public void createList(int[] values) {
        if (values.length == 0) return;
        head = new Node(values[0]);
        Node temp = head;
        for (int i = 1; i < values.length; i++) {
            temp.next = new Node(values[i]);
            temp = temp.next;
        }
    }

    // Insert x after nth element (1-based index)
    public void insertAfterNth(int n, int x) {
        Node temp = head;
        int count = 1;
        while (temp != null && count < n) {
            temp = temp.next;
            count++;
        }
        if (temp == null) {
            System.out.println("Position not found!");
            return;
        }
        Node newNode = new Node(x);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Insert x at the end
    public void insertAtEnd(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Remove nth element (1-based index)
    public void removeNth(int n) {
        if (head == null) return;
        if (n == 1) {
            head = head.next;
            return;
        }
        Node temp = head;
        int count = 1;
        while (temp != null && count < n - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position not found!");
            return;
        }
        temp.next = temp.next.next;
    }

    // Print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

// Main class
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Step 1: Create Linked List: 1->2->3->4
        list.createList(new int[]{1, 2, 3, 4});
        System.out.print("Initial List: ");
        list.printList();

        // Step 2: Insert x=5 after 3rd element
        list.insertAfterNth(3, 5);
        System.out.print("After inserting 5 after 3rd element: ");
        list.printList();

        // Step 3: Insert x=5 at the end
        list.insertAtEnd(5);
        System.out.print("After inserting 5 at the end: ");
        list.printList();

        // Step 4: Remove 2nd element
        list.removeNth(2);
        System.out.print("After removing 2nd element: ");
        list.printList();
    }
}