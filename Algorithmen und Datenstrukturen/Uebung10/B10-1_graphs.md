Darstellung von Graphen
---

1. 
Unter einem Graphen versteht man ein Netzwerk aus endlich vielen Knoten (nodes/vertices), die beliebig durch Kanten
(edges) miteinander verbunden sein können. Man unterscheidet drei Arten von Graphen:

    - ungerichteter Graph: Die Kanten verbinden die Knoten maximal einmal miteinander, aber nie mit sich selbst.
    - gerichteter Graph: Die Kanten verbinden die Knoten nur in eine (beide) Richtung miteinander, auch mit sich selbst.
    - gewichteter Graph: Die Kanten verbinden die Knoten gerichtet oder ungerichtet miteinander mit einem bestimmten
    Gewicht wie bspw. die Distanz zueinander.

2.
G = (V, E) mit V = {1, 2, 3, 4, 5} und E = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 4}, {2, 5}, {3, 4}, {4, 5}}

    ╭─────────╮
    2       3 │
    │ ╲   ╱ │ │
    │   1   │ │
    │ ╱   ╲ │ │
    5 ───── 4 ╯

3.


    Kantenliste: {5 (|V|), 8 (|E|); 1, 2; 1, 3; 1, 4; 1, 5; 2, 4; 2, 5; 3, 4; 4, 5} → int[] edgelist

    Knotenliste: {5 (|V|), 8 (|E|); 4, 2, 3, 4, 5; 2, 4, 5; 1, 4; 1, 5; 0} → int[] nodelist
        alternativ: {2, 3, 4, 5; 4, 5; 4; 5} → int[] neighborhoods, {0, 4, 6, 7, 8, 8} → int[] nodeNhd

                        ╭   1 1 1 1 ╮
                        │ 1     1 1 │
    Adjazenzmatrix: A = │ 1     1   │ → int[|V|][|V|] adjacency_matrix
                        │ 1 1 1   1 │
                        ╰ 1 1   1   ╯

    Adjazenzliste:  1 → 2 - 3 - 4 - 5 → bspw. int[] oder SList adjacency_list oder SList[|V|]
                    2 → 1 - 4 - 5
                    3 → 1 - 4
                    4 → 1 - 2 - 3 - 5
                    5 → 1 - 2 - 4

4.


    int[] edgelist = {...};
    int[][] adjacency_matrix = new int[|V|][|V|];

    for (int i = 2; i < edgelist.length; i + 2) {
        adjacency_matrix[i][i + 1] = 1; // oder Gewichtung
        if (ungerichtet) adjacency_matrix[i + 1][i] = 1; // oder Gewichtung


    SList[] adjacency_list = new SList[|V|];
    
    for (int i = 2; i < edgelist.length; i + 2) {
        adjacency_list[edgelist[i]].push_back(edgelist[i + 1]);
        if (ungerichtet) adjacency_list[edgelist[i + 1]].push_back(edgelist[i]);
