import java.util.Comparator;

/**
 * Custom resizeable ArrayList based on Array. Realization provides adding element, adding by index,
 * getting element by index, removing element by index, clearing all elements, getting size of CustomArrayList
 * and quick sort of elements
 * @param <T> the type of elements in this list
 * @author Roman Kusov
 */

public class CustomArrayList<T> {
    private final int INIT_LENGTH = 1;
    private final int LENGTH_DELTA_FOR_ADD = 1;
    private final int LENGTH_DELTA_FOR_REMOVE = 0;
    private int elementsAmount = 0;

    /**
     * Array instance for data storage
     */
    private T[] objects = (T[]) new Object[INIT_LENGTH];

    /**
     * Default constructor without parameters, creates new instance of list with default capacity
     */
    public CustomArrayList()
    {

    }

    /**
     * Method for adding element to the end of list.
     * @param element instance of T
     */
    public void add(T element)
    {
        int index = elementsAmount;
        add(index, element);
    }

    /**
     * Method for adding element by index.
     * @param index index of array instance (objects) for adding element
     * @param element element instance of T (could be any java object)
     * @throws IndexOutOfBoundsException if index is out of array's elements amount
     */
    public void add(int index, T element)
    {
        if (index > elementsAmount)
        {
            throw new IndexOutOfBoundsException();
        }
           else
        {
            resize(LENGTH_DELTA_FOR_ADD);
            for (int i = index + 1; i < elementsAmount; i++)
            {
                objects[i] = objects[i + 1];
            }
            objects[index] = element;
            elementsAmount++;
        }
    }

    /**
     * Method for extracting element from list by index
     * @param index index of element in array instance (objects) for extracting
     * @return instance of T which is stored in objects
     * @throws IndexOutOfBoundsException if index is out of array's elements amount
     */
    public T get(int index)
    {
        if (index > objects.length -1)
        {
            throw new IndexOutOfBoundsException();
        }
        return (T) objects[index];
    }

    /**
     * Method for removing element from list by index
     * @param index index of element in objects for remove
     * @throws IndexOutOfBoundsException if index is out of array's elements amount
     */
    public void remove(int index)
    {
        if (index > elementsAmount - 1)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            for (int i = index; i < elementsAmount - 1; i++)
            {
                objects[i] = objects[i + 1];
            }
            elementsAmount--;
            resize(LENGTH_DELTA_FOR_REMOVE);

        }
    }

    /**
     * Method of clearing list from all elements by assigning new empty array to objects
     */
    public void clear()
    {
        objects = (T[]) new Object[INIT_LENGTH];
    }

    /**
     * Method for getting size of this list
     * @return length of objects
     */
    public int size()
    {
        return objects.length;
    }

    /**
     * Method for quick sort elements of list
     * @param comparator instance of Comparator for comparing elements of list
     */
    public void quickSort(Comparator<? super T> comparator)
    {
        int begin = 0;
        int end = objects.length - 1;
        recursiveSort(objects, begin, end, comparator);

    }

    private void recursiveSort(T[] array, int begin, int end, Comparator<? super T> comparator)
    {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end, comparator);

            recursiveSort(array, begin, partitionIndex - 1, comparator);
            recursiveSort(array, partitionIndex + 1, end, comparator);
        }
    }

    private int partition(T[] array, int begin, int end, Comparator<? super T> comparator)
    {
        T pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++)
        {
            if (comparator.compare(array[j], pivot) > 0)
            {
                i++;
                T swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }
        T swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;
        return i + 1;
    }

    private void resize(int lengthDelta)
    {
        int capacity = elementsAmount + lengthDelta;
        T[] newArray = (T[])new Object[capacity];
        System.arraycopy(objects, 0, newArray, 0, elementsAmount);
        objects = newArray;
    }

}
