#include <stdio.h>
#include <stdlib.h>

static int fibonacci(int n)
{
    if (n == 0) return 0;
    else if (n == 1) return 1;
    else return fibonacci(n - 1) + fibonacci(n - 2);
}

int main(int argc, char **argv)
{
    if (argc == 2 && *argv[1] > 47 && *argv[1] < 58)
    {
        printf("The n-th Fibonacci-number is %d.\n", fibonacci(atoi(argv[1])));
        return 0;
    }
    else
    {
        printf("Please put in a number n >= 0!\n");
        return -1;
    }
}