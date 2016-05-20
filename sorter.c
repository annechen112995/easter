/**
 * Anne Chen
 * CS 11, Spring 2016 Lab 3
 * 
 * This program takes in numerical input (ranging from 1582 - 39999) 
 * in the form of a file or raw input from the command line. This number
 * represents a year, and the program will then calculate the day Easter 
 * lands/landed on for that year. If the number is out of that range, 
 * the program will return an usage error. 
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_SIZE 32

/*
 * This is the minimal element sort function. It takes up to 32 integers 
 * from the command line and sorts them in order from the least to 
 * greatest. Each number is printed onto a new line. If more than 32 or 
 * no integers are given, it displays a standard usage message to the 
 * user before exitting.
 * 
 * This function also takes into account two command - line arguments, 
 * [-b] and [-q]. [-b] changes the function and tells it to use the 
 * bubble sort algorithm in place of the minimal element sort algorithm. 
 * [-q] tells the function to supress its output. 
 * 
 * arguments:
 * j: This is used to index the number of elements in the array. 
 * k: This is the index for the smallest element in the array. 
 * l: This is used to swap the two values of arr[] around such that they
 * are in order.
 */
 
void msort(int val[], int argc)
 
{
    int j, k;
    for(j = 0; j < argc; j++) {
        for(k = 0; k < argc; k++) {
            if (val[k] > val[j]) {
                int l = val[k];
                val[k] = val[j];
                val[j] = l;
            }
        }
    }
}

/*
 * This is the bubble sort function. It takes in up to 32 integers at 
 * the command line and sorts them in order of least to greatest. Each 
 * number is printed onto a new line. If more than 32 or no integers are 
 * given, it displays a standard usage message to the user before 
 * exitting.
 * 
 * arguments: 
 * m: This is the index for the number of elements in the array. 
 * n: This is the index for the smallest elements in the array.
 * o: This is used to swap the two values of arr[] around such that they 
 * are in order.
 */

void bsort(int val[], int argc)
 
{
    int m, n, o;
    for (m = 0; m < ( argc - 1 ); m++) {
        for (n = 0; n < argc - m - 1; n++) {
            if (val[n] > val[n + 1]) {
                o = val[n];
                val[n] = val[n + 1];
                val[n + 1] = o;
            }
        }
    }
}

/*
 * The main function calls and tests the bsort or the msort function, 
 * depending on the presence of the optional command line argument. 
 * 
 * This function also takes into account two command - line arguments, 
 * [-b] and [-q]. [-b] changes the function and tells it to use the 
 * bubble sort algorithm in place of the minimal element sort algorithm. 
 * [-q] tells the function to supress its output. 
 * 
 * arguments:
 * index: The index for the array argv[].
 * num_elements: The number of elements.
 * b: The number of times [-b] shows up in the command line. 
 * q: The number of times [-q] shows up in the command line. 
 * arr[i]: This array contains the same elements as argv, but it is 
 * stored as integers. 
 * msort(): The minimal element sort function.
 * bsort(): The bubble sort function. 
 */

int main(int argc, char *argv[])

{
    int index;
    int num_elements = 0;
    int b = 0;
    int q = 0;
    int val[MAX_SIZE];
    for(index = 1; index < argc; index++) {
        if (strcmp(argv[index], "-b") == 0) {
            b = 1;
        }
        else if (strcmp(argv[index], "-q") == 0) {
            q = 1;
        }
        else {
            val[num_elements] = atoi(argv[index]);
            num_elements++;
        }
    }
    if (num_elements > MAX_SIZE || num_elements == 0) {
        fprintf(stderr, "Usage: sorter [-b] [-q] num1 [num2 ...] \
              (maximum 32 nums)\n");
        return 0;
    }
    if (b == 0) {
        msort(val, num_elements);
    }
    else {
        bsort(val, num_elements);
    }
    if (q == 0) {
        for(index = 0; index < num_elements; index++) {
            printf("%d\n", val[index]);
        }
    }
    return 0;
}
