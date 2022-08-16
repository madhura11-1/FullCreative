package com.example.fullcreative;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import java.util.Vector;

public class Collection {

    /*
    Container to store multiple items and perform ops(update,search,sort,delete) on them

    Iterable Interface (iterator to iterate and its methods)
      |
    Collection Interface (add, addall etc mehods)
       |                             |                                 |
     List                          Queue                             Set     Interfaces
     ArrayList c                 Priority Queue c                    Hashset c
     LinkedList c                Deque interface (extends queue)    LinkedHashSet c
      Vector c                   ArrayDeque c
     x Stack c (extends vector)

     map interface
     HashMap c
     HashTable c

     SortedMap Interface extends Map
     treemap c


     */

    /*

    List : interface having collection of ele (duplicate also)(indexing)

    ArrayList : add, clear, indexof, clone; (generic/non generic)
    LinkedList : ele linked   -> singly (data, add of next node)
                              -> doubly (data, two add of nex  and pre)
                              add, addfirst, indexof, contains, addLast, remove;
    Vector : same as arraylist but is synchornized(thread safe -> multiple threads execute a method or a block of code without causing any side effect to shared resources / objects.)
             add, clear, add(inx,obj), contains, remove(obj), indexof


     Priority Queue :  sorts data for us (does not take null)
              add, remove, peel -> get head of queue, poll -> remvoe head

     Set : unique values only (use hashing technique)

     Hashset : use hashtable for storage (no indexing approach)
               no insertion order maintained but printing order is same always
                add, remove, contains, clear, iterator,clone
                 hash table search performs O(1) in the average case. In the worst case, the hash table search performs O(n)

     LinkedHashSet : use hashtable  (inherits from : set,obj,abstractset,hashset,set)
                     maintains insertion order

    TreeSet : tree for storage   (sorted version of hashset)
               sorted data always and unique and no insertion order maintained

     */


    public void list() {
       ArrayList q = new ArrayList();
        //Vector q = new Vector();
       // LinkedList q = new LinkedList();
       // PriorityQueue q = new PriorityQueue(); not possible
        q.add(0.8);
        q.add(1);
        q.add(7.9);
        q.add(0.3);
       q.add(new Contact());
       q.add(1,7);

       HashSet h = new HashSet();     //allows only one null value whereas array list anynumber  (no get method only object based retireval)
        //LinkedHashSet h = new LinkedHashSet();
       //  TreeSet h = new TreeSet();   not possible
        h.add("helloi");
        h.add(2);
        h.add(0.9);
        h.add("ott");
        h.add("ptt");
        h.add("htt");


        Iterator i = q.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }

        Iterator it = h.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

    public static void main(String[] args){

        Collection c = new Collection();
        c.list();

    }

}
