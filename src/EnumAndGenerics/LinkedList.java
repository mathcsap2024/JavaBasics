package EnumAndGenerics;

public class LinkedList<T> {
    public static class Node<T> {
        private T data;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this(data, null);
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        private Node<T> next;

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> first;

    public Node<T> getFirst() {
        return first;
    }

    public void pushFront(T data) {
        first = new Node<>(data, first);
    }

    public void clear() {
        first = null;
    }

    @Override
    public String toString() {
        String result = "[";

        Node<T> current = first;
        while(current != null) {
            result = result.concat(current.data.toString());
            current = current.getNext();

            if(current!=null) {
                result = result + " -> ";
            }
        }

        return result + "]";
    }

    Integer getSize() {
        int result = 0;

        Node<T> current = first;
        while(current != null) {
            current = current.getNext();
            result++;
        }

        return result;
    }
}
