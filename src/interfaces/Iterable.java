package interfaces;

/**
 * Created by Karol Pokomeda on 2017-03-17.
 * Has Method which returns iterator for class which implements this interface
 */
public interface Iterable<T> {
    /**
     * Method generates basic iterator for ListInterface object
     * @return {IteratorInterface<T>} iterator for this list
     */
    IteratorInterface<T> iterator();
}
