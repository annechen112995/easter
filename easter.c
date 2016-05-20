/**
 * This program takes in numerical input (ranging from 1582 - 39999) 
 * in the form of a file or raw input from the command line. This number
 * represents a year, and the program will then calculate the day Easter 
 * lands/landed on for that year. If the number is out of that range, 
 * the program will return a 
 */
 
#include <stdio.h>

/*
 * This function takes in a file input, containing different years. It 
 * calculates the days on which Easter will be for those years and adds
 * the information to the output file.
 * 
 * arguments: 
 * year: The year for which the date of Easter is to be 
 * determined.
 * gold: The Golden Year in the 19 - year Metonic cycle. 
 * cent: The century. 
 * X: The skipped leap years.
 * Z: The correction factor for the moon's orbit. 
 * D: March ((-D) mod 7 + 7) is a Sunday.
 * epact: If e is 25 and gold is greater than 11 or if e is 24, 
 * increment e. e is the epact, which specifies when a full moon occurs. 
 * N: March N is a calendar full moon. 
 */

int calculate_Easter_date(int year)
 
{

    int gold = (year % 19) + 1; /* calculates the golden year */
    int cent = (year / 100) + 1; /* calculates the century */
    int X = ((3 * cent) / 4) - 12; /*calculates skipped leap years */
    int Z = (((8 * cent) + 5) / 25) - 5; /* correction factor */
    int D = ((5 * year) / 4) - X - 10;
    int epact = ((11 * gold) + 20 + Z - X) % 30;
    int N = 0;
    
    if (epact == 25) {
        if (gold > 11) {
            epact += 1;
        }
    }

    if (epact == 24) {
        epact += 1;
    }

    N = (44 - epact);

    if (N < 21) {
        N += 30;
    }

    N = N + 7 - ((D + N) % 7);

    if (N > 31) {
        return (N - 31); /* Easter is in April */
    }
    else {
        return (0 - N); /* Easter is in March */
    }
}

/*
 * The main function links to and tests the calculate_Easter_date 
 * function. It also does the error handling for the function.
 * 
 * arguments:
 * a: This is the lowerbound of the year the function can calculate, -1.
 * b: This is the upperbound of the year the function can calculate, +1.
 * EOF: End of file. This breaks the infinite while loop.
 * date: The date returned by the function calculate_Easter_date in the
 * form of a positive or a negative integer.  
 */

int main()
 
{
    int year = 0;
    int a = 1581;
    int b = 40000;
    int result;
    int date;
    while(1) {
        result = scanf("%d", &year);
        if (result == EOF) {
            break; /* stops scanning for new dates */
        }
        if ((year > a) && (year < b)) {
            date = calculate_Easter_date( year );
            if (date > 0) {
                printf("%d - April %d\n", year, date);
            }
            else {
                printf("%d - March %d\n", year, 0 - date);
            }
        }
        else {
            fprintf(stderr, "Value Error: Only years 1582 - 39999.\n");
        }
    }
    return 0;
    
}
