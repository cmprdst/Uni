### Vermutungen, was die einzelnen Set-Implementierungen laut meinen Tests falsch machen:

1. Set-Implementierung: "Trying to add null is invalid! expected:<0> but was:<1>"
   → Dem Set wurde vermutlich ein ungültiger Wert hinzugefügt.

2. Set-Implementierung: "Trying to add duplicate Integers is invalid! expected:<3> but was:<4>"
   → Dem Set wurde vermutlich ein Duplikat hinzugefügt.

3. Set-Implementierung: "Removing all Integers failed! expected:<0> but was:<3>"
   → Dem Set wurde vermutlich kein Wert entnommen.

4. Set-Implementierung: ✔

5. Set-Implementierung: "Trying to add duplicate Integers is invalid! expected:<3> but was:<4>"
   → siehe 2.

6. Set-Implementierung: "Trying to add null is invalid! expected:<0> but was:<1>"
   → siehe 1.

7. Set-Implementierung: "Trying to add null is invalid! expected:<0> but was:<1>"
   → siehe 1.?

8. Set-Implementierung: "NullPointerException: Cannot invoke "Object.toString()" because "<parameter1>" is null"
   → Set<parameter1> deklariert aber nicht initialisiert?