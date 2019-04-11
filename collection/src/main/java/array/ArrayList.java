package array;

import java.util.RandomAccess;

public class ArrayList<T> implements List<T>,RandomAccess {

    private Object[] table;
    private Object[] EMPTY_TABLE = {};
    private int size;

    public ArrayList() {
        table = EMPTY_TABLE;
    }

    public boolean isEmpty() {
        return table.length == 0;
    }

    public int length() {
        return table.length;
    }

    public T get(int index) {
        return (T)table[index];
    }

    public T set(int index, T data) {
        checkRange(index);
        T old = (T)table[index];
        this.table[index] = data;
        return old;
    }

    public void add(int index, T data) {
        checkRange(index);
        ensureEnoughCapacity(size - 1,table);
        for (int i = size; i > index; i--) {
            table[i] = table[i-1];
        }
        table[index] = data;
        size++;
    }


    public void add(T data) {
        ensureEnoughCapacity(size - 1,table);
        table[size] = data;
        size ++;
    }

    public void remove(int index) {
        checkRange(index);

        size--;
    }

    public boolean remove(T data) {
        return false;
    }

    public boolean removeAll(T data) {
        return false;
    }

    public void clear() {

    }

    public boolean contains(T data) {
        return false;
    }

    public int indexOf(T data) {
        return 0;
    }

    public int lastIndexOf(T data) {
        return 0;
    }

    public void checkRange(int index) {
        if (index < 0 || index > table.length) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void ensureEnoughCapacity(int index, Object[] table) {
        if (index > table.length) {
            table = new Object[table.length * 2];
            ensureEnoughCapacity(index, table);
        }
    }





}
