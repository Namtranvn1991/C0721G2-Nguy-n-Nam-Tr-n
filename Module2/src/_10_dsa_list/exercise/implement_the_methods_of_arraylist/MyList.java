package _10_dsa_list.exercise.implement_the_methods_of_arraylist;

import java.util.Arrays;

public class MyList<E> {
    int size = 0;
    private static final int DEFAULT_CAPACITY = 5;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public boolean add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
        return true;
    }
    public void add(int index,E e) {
        if (index>= size || index <0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        } else {
            if (size == elements.length) {
                ensureCapacity();
            }
            size++;
            for (int i = size;i>index;i--){
                elements[i] = elements[i-1];
            }
            elements[index] = e;
        }
    }

    public E remove(int index){
        E elementRemove;
        if (index>= size || index <0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        } else {
            elementRemove = (E) elements[index];
            for (int i = index;i<size;i++){
                elements[index] = elements[index+1];
            }
        }
        elements[size--] = null;
        return elementRemove;
    }

    public int indexOf(E e){
        int index=-1;
        for (int i = 0;i<size;i++){
            if(e == (E) elements[i]){
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean contains (E e){
        if (indexOf(e)!=-1){
            return true;
        } else {
            return false;
        }
    }


    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }

    public MyList<E> clone(){
        MyList<E> newList = new MyList<>();
        for (int i=0;elements[i]!=null;i++){
            newList.add((E) elements[i]);
        }
        return newList;
    }

    public void clear(){
        for (int i=0;elements[i]!=null;i++){
            elements[i]=null;
        }
        size = 0;
    }
}