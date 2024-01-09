ADT Set
---

Type Set[Item]
import Bool, Nat
Operators
  empty_set:            --> Set
  is_empty:  Set        --> bool
  insert:    Set x Item --> Set
  is_in:     Set x Item --> bool

  size:      Set        --> Nat
  union:     Set x Set  --> Set
  intersect: Set x Set  --> Set

Axioms
  for all s, t: Set[Item]; i, j: Item

  insert(insert(s,i),j)) = insert(insert(s,j),i) //commutativity
  insert(insert(s,i),i)) = insert(s,i)      // no duplicate elements

  is_empty(empty_set)    = true
  is_empty(insert(s, i)) = false

  is_in(empty_set, i) = false
  is_in(insert(s, i), j) =
    if i=j then true else is_in(s, j)
  
  // folgend stellt insert(s, i) bzw. insert(t, j) sicher, dass s und t != empty_set

  size(empty_set) = 0
  size(insert(s, i)) =
    if is_in(s, i) then size(s) else size(s) + 1
  size(union(insert(s, i), insert(t, j))) = size(insert(s,i)) + size(insert(t, j)) - size(intersect(insert(s,i), insert(t, j))
  size(intersect(insert(s, i), insert(t, j))) =
    if is_empty(union(insert(s, i), insert(t, j))) then 0 else size(insert(s, i)) + size(insert(t, j)) - size(union(insert(s, i), insert(t, j)))
  
  union(empty_set, empty_set) = empty_set
  union(empty_set, insert(t, j)) = insert(t, j)
  union(insert(s, i), empty_set) = insert(s, i)
  union(insert(s, i), insert(t, j)) =
    if is_in(s, j) then insert(union(s, t), i) else if is_in(t, i) then insert(union(s, t), j) else insert(insert(union(s, t), i), j)
  
  intersect(empty_set, empty_set) = empty_set
  intersect(empty_set, insert(t, j)) = empty_set
  intersect(insert(s, i), empty_set) = empty_set
  intersect(insert(s, i), insert(t, j)) =
    if is_in(s, j) then insert(intersect(s, t), j) else if is_in(t, i) then insert(intersect(s, t), i) else intersect(s, t)
  
Beispiele:
s = {1, 2, 3}, t = {3, 4, 5}

empty_set → {} (leere Menge wird erzeugt)

insert(s, 6) → {1, 2, 3, 6} (6 wird dem Set hinzugefügt)
insert(s, 2) → {1, 2, 3} (2 wird dem Set kein zweites Mal hinzugefügt, da Duplikate nicht erlaubt sind)

is_empty({}) = true (ein leeres Set ist leer)
is_empty(s) = false (s ist nicht leer)

is_in({}, i) = false (in einem leeren Set ist nichts)
is_in(s, 3) = true (in dem Set s befindet sich der Wert 3)

size({}) = 0 (leeres Set hat keine Werte)
size(s) = 3 (s hat 3 Werte)
size(union(s, t)) = size({1, 2, 3, 4, 5}) = 5 (Die Anzahl der Werte durch Vereinigung von s und t beträgt 5)
size(intersect(s, t)) = size({3}) = 1 (Die Anzahl der Werte durch Schnitt von s und t beträgt 1)

union({}, {}) = {} (Die Vereinigung zwei leerer Mengen ergibt eine leere Menge)
union({}, t) = t (Die Vereinigung einer leeren Menge mit einer nicht leeren Menge ergibt die nicht leere Menge)
union(s, {}) = s (Kommutativität)
union(s, t) = {1, 2, 3, 4, 5} (Es werden alle Werte aus t und s berücksichtigt, allerdings maximal einmal)

intersect({}, {}) = {} (Der Schnitt zwei leerer Mengen ergibt eine leere Menge)
intersect({}, t) = {} (Der Schnitt einer leeren Menge mit einer nicht leeren Menge ergibt die leere Menge)
intersect(s, {}) = {} (Kommutativität)
intersect(s, t) = {3} (Es bleiben nur die Werte über, die sich sowohl in s als auch in t befinden)