/* gcc -Wall -O2 substr.c */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * @brief Prints a messages and exists with failure code
 *
 * @param serror Error message
 */
static void panic(const char *serror)
{
    fprintf(stderr, "%s", serror);
    exit(EXIT_FAILURE);
}

/**
 * @brief Allocates memory and panics on allocation error
 *
 * @param size Size in bytes to allocate
 * @return void* Pointer to allocated memory
 */
static void *xmalloc(size_t size)
{
    void *ptr;
    if (size == 0) {
        panic("Size is 0!\n");
    }
    ptr = malloc(size);
    if (!ptr) {
        panic("No mem left!\n");
    }
    return ptr;
}

/**
 * @brief Retrieves a substring of a string
 *
 * @param str The string to retrieve a substring from.
 * @param pos The zero-based starting character position of a substring in str.
 * @param len The number of characters in the substring.
 * @return char* A string that is equivalent to the substring of length len that begins at pos in str.
 */
static char *substring(const char *str, size_t pos, size_t len)
{
    if (str == NULL)
    {
        panic("String cannot be NULL.");
    }
    else if (pos > strlen(str) || pos + len > strlen(str))
    {
        panic("The substring's starting position is invalid or its length exceeds string boundaries!");
    }

    char *substr = xmalloc(len + 1); // dem Substring Speicher zur Verfügung stellen

    for (size_t i = 0; i < len; i++)
    {
        substr[i] = str[i + pos];
    }

    substr[len] = '\0'; // "Nullterminator" (NUL) signalisiert das Ende eines Strings

    return substr;
}

int main(int argc, char **argv)
{
    char *foo = "Hello";
    char *bar = substring(foo, 1, 3);
    printf("%s", bar);
    free(bar);
    return 0;
}