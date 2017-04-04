package utils;

import interfaces.QueueInterface;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 * Class provides First-In-First-Out queue functionality with internal implementation based on linked-list-like Element
 * @implements QueueInterface<T>
 */
public class FifoQueue<T> implements QueueInterface<T> {
    private Element<T> head;
    private Element<T> tail;
    private int size;

    public FifoQueue(){
        this.clear();
    }

    @Override
    public void push(T t) {
        Element<T> newElement = new Element<>(t);
        if (this.tail != null) this.tail.setNext(newElement);
        this.tail = newElement;
        this.size++;
        if (this.size == 1) this.head = newElement;
    }

    @Override
    public T pop() {
        if (this.size == 0) throw new IndexOutOfBoundsException("Cannot pop from empty queue");
        Element<T> result = this.head;
        this.head = result.getNext();
        this.size--;
        if (this.size == 0) this.clear();
        return result.current;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private final class Element<T> {
        private T current;
        private Element<T> next;

        Element(T t){
            this.current = t;
            this.next = null;
        }

        Element<T> getNext() {
            return next;
        }

        void setNext(Element<T> next) {
            this.next = next;
        }
    }
}
