package com.example.fullcreative;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CustomArrayList<T> implements List<T> {

    private Object[] arr;
    private int size = 0,final_size = 0,flag = 0;
    private final static int default_size = 5;


    //size -> number of ele added

    public CustomArrayList(){
        //final_size = default_size;
        //size = default_size;
        flag = 1;
        arr = new Object[default_size];
        final_size = default_size;
    }

    public CustomArrayList(int size){
       // this.size = size;
        if(size > 0){
        this.final_size = size;
        arr = new Object[this.final_size];}
        else{
            throw new IllegalArgumentException("Size has to be greater than zero");
        }
    }

    public CustomArrayList(Collection collection){
        if(collection.size() > 0) {
            size = collection.size()-1;
            final_size = collection.size();
            arr = collection.toArray();
        }
        else{
            throw new IllegalArgumentException("Size has to be greater than zero");
        }
    }


    @Override
    public int size() {
        return size;
    }

    public int capacity(){
        return final_size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean contains(@Nullable Object o) {
        boolean index = false;
        for(int i =0;i<size;i++){
            if(arr[i].equals(o)){
                index = true;
                break;
            }
        }
        return index;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size && arr[index] != null;
            }

            @Override
            public T next() {
                return (T) arr[index++];
            }
        };
        return it;
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return arr;
    }

    @NonNull
    @Override
    public <T1> T1[] toArray(@NonNull T1[] t1s) {
        return (T1[]) arr;
    }

    private void array_resize(){

        final_size = size + (int)(0.5*size);
        Object[] arr2 = new Object[final_size];
        System.arraycopy(arr,0,arr2,0,size);
        arr = arr2;
    }


    @Override
    public boolean add(T t) {

        if (flag == 1) {
            if (size >= default_size) {
                array_resize();
            }
        } else {

            if (size >= final_size) {
                array_resize();
            }
        }
            arr[size] = t;
            size++;
            return true;
    }

    @Override
    public boolean remove(@Nullable Object o) {

        int index = -1;
        for(int i =0;i<size;i++){
            if(arr[i].equals(o)){
                index = i;
                this.remove(i);
                break;
            }
        }

        return index != -1;
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {

        for(Object c : collection){
            if(!this.contains(c)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends T> collection) {

        Object[] c = collection.toArray();
        int sc = collection.size();
        if(sc <= final_size-size){
            System.arraycopy(c,0,arr,size,sc);
        }else{
            final_size = size + sc;
            Object[] new_array = new Object[final_size];
            System.arraycopy(arr,0,new_array,0,size);
            System.arraycopy(c,0,new_array,size,sc);
            arr = new_array;
            size = final_size;
        }
        return true;
    }

    @Override
    public boolean addAll(int i, @NonNull Collection<? extends T> collection) {


        if(i >= final_size){
            System.out.println("this index is out of bound");
        }else{
            Object[] c = collection.toArray();
            int sc = collection.size();
            if(i >= size){
                if(sc <= final_size-size){
                    System.arraycopy(c,0,arr,size,sc);
                }else{
                    final_size = size + sc;
                    Object[] new_array = new Object[final_size];
                    System.arraycopy(arr,0,new_array,0,size);
                    System.arraycopy(c,0,new_array,size,sc);
                    arr = new_array;
                    size = final_size;
                }
            }else{
                if(sc <= final_size-size){
                    System.arraycopy(arr,i,arr,sc+1,size-i);
                    System.arraycopy(c,0,arr,i,sc);
                    size = size + sc;
                    final_size = size;
                }else{
                    final_size = size + sc;
                    Object[] new_array = new Object[final_size];
                    System.arraycopy(arr,i,new_array,sc+1,size-i);
                    System.arraycopy(c,0,arr,i,sc);
                    size = size +sc;
                }


            }
        }
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {

        for(Object o : collection){
            this.remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

        for(Object obj : arr){
            obj = null;
        }
        size = 0;

    }

    @Override
    public T get(int i) {

        if(i < size && i >=0){
        return (T) arr[i];}
        else{
            throw new IndexOutOfBoundsException("Index out of bound");
        }
    }


    @Override
    public void add(int i, T t) {            //check if there is space in array
        if(i >= final_size || i >= size && i < final_size || i < 0){
            System.out.println("this index is out of bound");
            throw new IndexOutOfBoundsException();
        }else{

//            if(i >= size){
//                arr[i] = t;
//                size++;
//            }
//            if(i < size && i >= 0) {
//            if(size == final_size){
//                arr[i] = t;
//                size++;
//            }else

                array_resize();
                System.arraycopy(arr,i,arr,i+1,size-i);
                arr[i] = t;
                size++;
        }
    }

    @Override
    public T remove(int i) {

        T x = null;
        if(i >= final_size || i < 0 || i >= size){
            throw new IndexOutOfBoundsException("out of bound");
        }
        else {
            x = (T) arr[i];
            System.arraycopy(arr,i+1,arr,i,size-i-1);
            arr[size-1] = null;
            size = size - 1;
        }
        return x;
    }

    @Override
    public int indexOf(@Nullable Object o) {
        int index = -1;
        for(int i =0;i<size;i++){
            if(arr[i].equals(o)){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(@Nullable Object o) {
        int index = -1;
        for(int i =size-1;i>=0;i--) {
            if(arr[i].equals(o)){
                index = i;
            }
        }
        return index;
    }

    @NonNull
    @Override
    public ListIterator<T> listIterator() {
        ListIterator<T> listIterator = new ListIterator<T>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size && arr[index] != null;
            }

            @Override
            public T next() {
                return (T) arr[index++];
            }

            @Override
            public boolean hasPrevious() {
                return index > 0 && arr[index] != null;
            }

            @Override
            public T previous() {
                return (T) arr[index--];
            }

            @Override
            public int nextIndex() {
                if(index < size){
                return index+1;}
                else{
                    return -1;
                }
            }

            @Override
            public int previousIndex() {
                if(index > 0)
                    return index-1;
                else
                    return -1;
            }

            @Override
            public void remove() {

                if(index > final_size || index < 0){
                    throw new IndexOutOfBoundsException("out of bound");
                }
                else {

                    System.arraycopy(arr,index+1,arr,index,size-index-1);
                    arr[size-1] = 0;
                    size -= 1;
                }
            }

            @Override
            public void set(T t) {
                if(index < size && index >=0){
                    arr[index] = t;
                }

            }

            @Override
            public void add(T t) {

                if(index >= final_size){
                    System.out.println("this index is out of bound");
                }else{

                    if(index >= size){
                        arr[index++] = t;
                        size++;
                    }else{
                        array_resize();
                        System.arraycopy(arr,index,arr,index+1,size-index);
                        arr[index++] = t;
                        size++;
                    }
                }

            }
        };
        return listIterator;
    }


    @Override
    public T set(int i, T t) {
        Object o = null;
        if(i < size){
             o = arr[i];
            arr[i] = t;
        }
        return (T) o;
    }

    @NonNull
    @Override
    public ListIterator<T> listIterator(final int i) {

        final ListIterator<T> it = new ListIterator<T>() {

            int index = i;
            @Override
            public boolean hasNext() {
                return index < size && arr[index] != null;
            }

            @Override
            public T next() {
                return (T) arr[index++];
            }

            @Override
            public boolean hasPrevious() {
                return index > 0 && arr[index] != null;
            }

            @Override
            public T previous() {
                return (T) arr[index--];
            }

            @Override
            public int nextIndex() {
                if(index < size){
                    return index+1;}
                else{
                    return -1;
                }
            }

            @Override
            public int previousIndex() {
                if(index > 0)
                    return index-1;
                else
                    return -1;
            }

            @Override
            public void remove() {

                if(index > final_size || index < 0){
                    throw new IndexOutOfBoundsException("out of bound");
                }
                else {

                    System.arraycopy(arr,index+1,arr,index,size-index-1);
                    arr[size-1] = 0;
                    size -= 1;
                }
            }

            @Override
            public void set(T t) {

                if(index < size && index >=0){
                    arr[index] = t;
                }
            }

            @Override
            public void add(T t) {

                if(index >= final_size){
                    System.out.println("this index is out of bound");
                }else{

                    if(index >= size){
                        arr[index++] = t;
                        size++;
                    }else{
                        array_resize();
                        System.arraycopy(arr,index,arr,index+1,size-index);
                        arr[index++] = t;
                        size++;
                    }
                }
            }
        };
        return it;
    }

    @NonNull
    @Override
    public List<T> subList(int i, int i1) {

        if(i < i1) {

            List<T> list = new CustomArrayList<T>(i1-i+1);
            for(int j =i;j <= i1;j++){
                list.add((T) arr[j]);
            }
            return list;

        }else{
            return null;

        }
    }

//    @NonNull
//    @Override
//    public String toString() {
//
//        String customArrayList = "";
//        for(Object c : arr){
//            customArrayList = customArrayList + " " + c.toString();
//        }
//
//        return customArrayList;
//
//    }

    public static void main(String[] args){

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(5);
        q.add(7);

        CustomArrayList<Integer> arrayList = new CustomArrayList<>(q);
        int s = arrayList.size();
        System.out.println(arrayList.indexOf(7));
        System.out.println(arrayList.get(0));
        System.out.println(s);
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.contains(6));
        arrayList.clear();
        System.out.println(arrayList.size());
        arrayList.add(1);
       // arrayList.add(2);
        System.out.println(arrayList.get(0));
      //  arrayList.add(3);
        arrayList.add(1,4);
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(1));

        ArrayList<Integer> a = new ArrayList<>(3);
        a.add(10);
        a.add(11);
        a.add(12);

        arrayList.addAll(a);
        System.out.println(arrayList.size());

        ArrayList<Integer> a2 = new ArrayList<>(2);
        a2.add(11);
        a2.add(17);
        System.out.println(arrayList.containsAll(a2));

        Iterator it = arrayList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

}



