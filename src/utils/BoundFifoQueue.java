package utils;

import interfaces.BoundQueueInterface;

/**
 * Created by Karol Pokomeda on 2017-04-02.
 * Class provides First-In-First-Out bound queue functionality with internal implementation based on linked-list-like
 * Element
 * @extends FifoQueue<T>
 * @implements BoundQueueInterface<T>
 */
public class BoundFifoQueue<T> extends FifoQueue<T> implements BoundQueueInterface<T> {
    private int maxSize;

    public BoundFifoQueue(int maxSize){
        super();
        this.maxSize = maxSize;
    }

    // push evaluation
    // add/sub: 1
    // compare: 3
    // create:  1
    // assign:  3
    @Override
    public void push(T t) {
        if (this.isFull()) throw new IndexOutOfBoundsException("Cannot add to full queue;");
        super.push(t);
    }

    // pop evaluation
    // add/sub: 1
    // compare: 2
    // create:  1
    // assign:  2

    @Override
    public boolean isFull(){
        return super.size() == this.maxSize;
    }
}