Insertion-Sort: O(n²)
Selection-Sort: O(n²)
Bubble-Sort: O(n²)
Mergesort: O(nlogn)
Quicksort: O(nlogn)
binäres Suchen: O(logn)
lineares Suchen: O(n)
schnelles Potenzieren: O(logn)
Berechnung der Quersumme einer Dezimalzahl: O(logn)
Fibonacci-Zahlen: iterativ O(n), rekursiv O(2^n)

(a) for (int i = 0; i < n; ++i); -> O(n)

(b) for (int i = 100; i < n; ++i); -> O(n)

(c) for (int i = 1; i <= n; i=i+i); -> O(logn)

(d) for (int i = 1; i <= n; ++i)
        for (int j = n; j > i; --j); -> O(n²)

(e) for (int i = n/2; i < n; ++i); -> O(n)

(f) for (int i = 0; i < n ; ++i)
        for (int j = 1; j <= n*n; ++j); -> O(n²)