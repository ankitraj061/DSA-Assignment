class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void insertAt(int index, int data) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) return;
            current = current.next;
        }
        if (current == null) return;
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAt(int index) {
        if (head == null) return;
        if (index == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) return;
            current = current.next;
        }
        if (current.next == null) return;
        current.next = current.next.next;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void rotateRight(int k) {
        if (head == null || k == 0) return;
        int size = size();
        k = k % size;
        if (k == 0) return;
        Node current = head;
        int count = 1;
        while (count < size - k && current != null) {
            current = current.next;
            count++;
        }
        if (current == null) return;
        Node newHead = current.next;
        current.next = null;
        Node temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        head = newHead;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void merge(SinglyLinkedList other) {
        if (head == null) {
            head = other.head;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = other.head;
    }

    public void interleave(SinglyLinkedList other) {
        Node current1 = head;
        Node current2 = other.head;
        while (current1 != null && current2 != null) {
            Node next1 = current1.next;
            Node next2 = current2.next;
            current1.next = current2;
            if (next1 == null) break;
            current2.next = next1;
            current1 = next1;
            current2 = next2;
        }
    }

    public int middleElement() {
        if (head == null) return -1;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public int indexOf(int data) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data == data) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public SinglyLinkedList splitAt(int index) {
        SinglyLinkedList newList = new SinglyLinkedList();
        if (index == 0) {
            newList.head = head;
            head = null;
            return newList;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null || current.next == null) return newList;
            current = current.next;
        }
        newList.head = current.next;
        current.next = null;
        return newList;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.printList();

        list.insertAt(2, 6);
        list.printList();

        list.deleteAt(3);
        list.printList();

        System.out.println(list.size());

        System.out.println(list.isEmpty());

        list.rotateRight(2);
        list.printList();

        list.reverse();
        list.printList();

        System.out.println(list.middleElement());

        System.out.println(list.indexOf(5));

        SinglyLinkedList otherList = new SinglyLinkedList();
        otherList.append(7);
        otherList.append(8);
        otherList.append(9);
        list.merge(otherList);
        list.printList();

        SinglyLinkedList splitList = list.splitAt(4);
        list.printList();
        splitList.printList();

        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.append(1);
        list1.append(3);
        list1.append(5);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.append(2);
        list2.append(4);
        list2.append(6);

        list1.interleave(list2);
        list1.printList();
    }
}
