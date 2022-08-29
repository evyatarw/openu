#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>

#define MAX_LENGTH 100 /* max length of input line */
#define NO_FILE "0"

void print_num(char*, char*);/* get two names of files - the first is the sourse of the input
                             - the numbers to print. the second is the name of the output file.
                             if instead of file name the function get the constant variable 
                             NO_FILE, the input or the output is the standart. the function
                             check the input character character goes through and recognize
                             if it white-space or number (one-digit number or two-digit number)
                             and print the number.
                             guess the input includes white-space and digit characters only. */
void initialize_array(char*, int);/*get array and it length and initialize the array to NULL*/
