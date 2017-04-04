package interfaces;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 * Defines interface for implementation of queues
 * @param <T> Class of internally stored elements
 */
public interface QueueInterface<T> {

    /**
     * Method adds new element to the specific location of internal data structure
     * @param {T} t new enqueued element
     */
    void push(T t);

    /**
     * Method removes element from specific location in the internal data structure
     * and returns it as a result
     * @return {T} element deleted from data structure
     * @throws IndexOutOfBoundsException if called when queue is empty
     */
    T pop() throws IndexOutOfBoundsException;

    /**
     * Method clears the data structure and sets its size to zero
     */
    void clear();

    /**
     * @return (int) number of elements stored in the queue
     */
    int size();

    /**
     * Method checks if number of elements in the queue is equal to zero
     * @return {boolean} result of the test
     */
    boolean isEmpty();
}