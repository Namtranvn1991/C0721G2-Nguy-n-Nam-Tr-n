package test.fixbug;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object[] elements;

    MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    MyList(int capacity) {
        elements = new Object[capacity];
    }

    void add(int index, E element) {

        for (int i = size + 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
    }

    E remove(int index) {

        E eRemove = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size - 1] = null;
        size--;

        return eRemove;
    }

    public int size() {
        return this.size;
    }

    public MyList<E> clone() {
        MyList<E> otherMyList = new MyList<E>();
        otherMyList.elements = Arrays.copyOf(elements, size);
        otherMyList.size = this.size;

        return otherMyList;
    }

    public boolean contains(E o) {
        return this.indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(o)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public boolean add(E e) {
        this.elements[size++] = e;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
            this.size = newSize;
        }
    }

    public E get(int i) {
        if (i >= 0) {
            return (E) this.elements[i];
        }

        return null;
    }

    public void clear() {
        Arrays.fill(this.elements, null);
        this.size = 0;
    }
}
