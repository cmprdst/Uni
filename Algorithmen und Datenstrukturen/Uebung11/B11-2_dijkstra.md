Dijkstra Algorithmus
---

    1.      0           1.      d[0] = 0                p[0] = -1   PQ: 0 
          ╱ │ ╲         2.  0:  d[2] = 0 + 5 = 5        p[2] = 0    PQ: 2
      ⁵ ╱  ³│   ╲ ²             d[3] = 0 + 3 = 3        p[3] = 0    PQ: 3, 2
      ╱  ₁  │     ╲             d[1] = 0 + 2 = 2        p[1] = 0    PQ: 1, 3, 2     → 0 abgeschlossen (kürzester Weg: 0)
    2 ───── 3      1    3.  1:  d[5] = 2 + 4 = 6        p[5] = 1    PQ: 3, 2, 5     → 1 abgeschlossen (kürzester Weg: 2)
    │ ╲     │     ╱     4.  3:  d[2] = 3 + 1 = 4 < 5 →  p[2] = 3    PQ: 2, 5
    │⁷  ╲⁸  │⁶  ╱⁴              d[5] = 3 + 6 = 9 > 6                PQ: 2, 5        → 3 abgeschlossen (kürzester Weg: 3)
    │  ₉  ╲ │ ╱         5.  2:  d[4] = 4 + 7 = 11       p[4] = 2    PQ: 5, 4
    4 ───── 5                   d[5] = 4 + 8 = 12 > 6               PQ: 5, 4        → 2 abgeschlossen (kürzester Weg: 5) 
                        6.  5:  d[4] = 6 + 9 = 15 > 11              PQ: 4           → 5 abgeschlossen (kürzester Weg: 6)
                        7.  4:  ----                                PQ: ----        → 4 abgeschlossen (kürzester Weg:11)


    2.      0   1.      d[0] = 0        p[0] = -1   PQ: 0                       3.  2 ────→ 3   1.      d[2] = 0
          ╱ │   2.  0:  d[2] = 8        p[2] = 0    PQ: 2                           │   ⁸   │   2.  2:  d[4] = 5
       ⁸╱   │¹          d[3] = 1        p[3] = 0    PQ: 3, 2    → 0 fertig          │⁵    -₂│           d[3] = 8
      ╱  ₆  │   3.  3:  d[2] = 7 < 8 →  p[2] = 3                                    ↓   ₂   ↓   3.  4:  d[5] = 7
    2 ───── 3           d[5] = 3        p[5] = 3    PQ: 5, 2    → 3 fertig          4 ────→ 5   4.  5:  fertig
      ╲     │   4.  5:  d[2] = 6 < 7 →  p[2] = 5    PQ: 2       → 5 fertig                      5.  3:  fertig
       ³╲   │²  5.  2:  ----                        PQ: ----    → 2 fertig          → aber kürzester Weg (2 → 5) = 6 ↯
          ╲ │
            5