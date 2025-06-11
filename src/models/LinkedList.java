package models;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void appendToTail(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public T findByValue(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }

    public T deleteByValue(T value) {
        if (head == null) return null;

        if (head.getValue().equals(value)) {
            T deletedValue = head.getValue();
            head = head.getNext();
            size--;
            return deletedValue;
        }

        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().getValue().equals(value)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            T deletedValue = current.getNext().getValue();
            current.setNext(current.getNext().getNext());
            size--;
            return deletedValue;
        }

        return null;
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        Node<T> current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.getValue();
            }
            current = current.getNext();
            count++;
        }

        return null;
    }

    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}