#include <stdio.h>

int main(int argc, char **argv)
{
    if (argc == 3)
    {
        int a = *argv[1] - '0'; // char = 0 bis 9 repräsentiert Zahlen 48 bis 57 ⇾ - 0 wandelt char-Wert in int-Wert um
        int b = *argv[2] - '0';

        if (a > 0 && a < 9 && b > 0 && b < 9)
        {
            printf("The product of the two numbers is: %d.\n", a * b);
            return 0;
        }
        else
        {
            printf("Only numbers between 0 and 9 are allowed.\n");
            return -1;
        }
    }
    else
    {
        printf("Please put in 2 numbers between 0 and 9.\n");
        return -1;
    }
}