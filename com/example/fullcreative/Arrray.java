package com.example.fullcreative;

import java.util.ArrayList;

public class Arrray {

    /*

    store multiple values of single data type
    at contagious location (consecutive locations/fixed gap)

    int a[]=new int[5];
Or

    int[] a=new int[5];   / int a[]={7,12,9}  / int a[]=new int[] {12,18,6}

    Integer[] array1 = {};   //empty arrays
    Integer[] array2 = null;


    a (reference -> stack)
    5 locations (in heap)


    2 D :

     */

    public void array(){

        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 2;

        int[] arr1,arr2;
        arr1 = arr;
        if(arr1 == arr){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }

        arr2 = arr.clone();        //creates another copy in memory
        if(arr2 == arr){
            System.out.println("Yes 2");
        }else{
            System.out.println("No 2");
        }

        //arr[2] = 3;

        //System.out.println(arr[2]);   // runtime error
        //System.out.println(arr[6]);


        int[][] multi = new int[3][3];
        int count = 0;

        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                multi[i][j] = count++;
            }
        }

        int[][] multi2 = multi.clone();   // shallow copy (1 d array and then subarray only one)

        System.out.println(multi == multi2);

        int[][] arr3 = new int[3][];
        arr3[0] = new int[4];
        arr3[1] = new int[7];
        arr3[2] = new int[3];

        arr3[0] = new int[7];

        for(int i =0;i<3;i++){
            for(int j=0;j<arr3[i].length;j++){
                System.out.print(arr3[i][j]);
            }
            System.out.println('\n');
        }






    }

    public static void main(String[] args){

        Arrray arrray = new Arrray();           //referncing to others do it
        arrray.array();
    }

}
