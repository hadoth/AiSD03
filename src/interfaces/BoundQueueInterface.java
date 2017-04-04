package interfaces;

/**
 * Created by Karol Pokomeda on 2017-04-03.
 * Defines interface for implementations of bounded queues
 * @extends QueueInterface
 */
public interface BoundQueueInterface<T> extends QueueInterface<T> {

    /**
     * Method adds new element to the specific location of internal data structure
     * @param {T} t new enqueued element
     * @throws IndexOutOfBoundsException
     */
    void push(T t) throws IndexOutOfBoundsException;

    /**
     * Method checks if number of elements is equal to the maximum size of queue
     * @return {boolean} result of test
     */
    boolean isFull();
}
