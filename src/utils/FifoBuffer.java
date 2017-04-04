package utils;

import interfaces.BoundQueueInterface;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 * Class provides First-In-First-Out bound queue functionality with internal implementation based on table
 * @implements BoundQueueInterface<T>
 */
public class FifoBuffer<T> implements BoundQueueInterface<T> {
    private T[] internalList;
    private int headIndex;
    private int tailIndex;
    private int size;

    public FifoBuffer(int bufferSize){
        this.internalList = (T[]) new Object[bufferSize];
        this.clear();
    }

    // push evaluation
    // add/sub: 3
    // compare: 2
    // create:  0
    // assign:  1
    @Override
    public void push(T t) throws IndexOutOfBoundsException{
        if (this.isFull()) throw new IndexOutOfBoundsException("Cannot add to full queue;");
        this.internalList[this.headIndex] = t;
        this.headIndex++;
        if (this.headIndex >= this.internalList.length) this.headIndex = this.headIndex - this.internalList.length;
        this.size++;
    }

    // pop evaluation
    // add/sub: 3
    // compare: 2
    // create:  0
    // assign:  1
    @Override
    public T pop() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("Cannot remove from empty queue;");
        T result = this.internalList[this.tailIndex];
        this.tailIndex++;
        if (this.tailIndex >= this.internalList.length) this.tailIndex = this.tailIndex - this.internalList.length;
        this.size--;
        return result;
    }

    @Override
    public void clear() {
        this.headIndex = 0;
        this.tailIndex = 0;
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

    @Override
    public boolean isFull() {
        return this.size == this.internalList.length;
    }
}
