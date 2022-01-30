import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StudentStack<E> implements LIFOStack<E>{
    //Attributes
    private ArrayList<E> data=new ArrayList<>();
    private Node<E> top;


    public StudentStack(){
        top = null;
    }

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<E>();
        newNode.setData(element);
        newNode.setNext(top);
        top = newNode;
        if (data.isEmpty()){
            data.add(element);
            return;
        }
        data.add(0 , element);
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        E result = top.data;
        top = top.next;
        return result;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return top.data;
    }

    private static class Node<E> {
        public E data;
        public Node<E> next;

        public Node() {
            data = null;
            next = null;
        }

        public Node(E dataEntry) {
            data = dataEntry;
            next = null;
        }
        public Node(E dataEntry, Node<E> nodeRef) {
            data = dataEntry;
            next = nodeRef;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public E getData() {
            return data;
        }
    }

    public String toString() {
        String result = "";
        Node<E> nodePtr = top;
        while (nodePtr != null) {
            result += nodePtr.data + " ";
            nodePtr = nodePtr.next;
        }
        return result;
    }
}