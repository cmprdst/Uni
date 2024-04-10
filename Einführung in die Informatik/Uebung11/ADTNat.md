ADT Nat
---

type Nat
import Bool

operators
          0:    -> Nat                 -- Konstruktor
          suc:  Nat -> Nat             -- Konstruktor, Nachfolger
          add:  Nat x Nat -> Nat       -- Addition
          =*:   Nat x Nat -> Bool      -- Gleichheitsrelation
          >:    Nat x Nat -> Bool      -- Vergleich

          pred: Nat -> Nat             -- Konstruktor, Vorgänger
          sub:  Nat x Nat -> Nat       -- Subtraktion
          mult: Nat x Nat -> Nat       -- Multiplikation
          div:  Nat x Nat -> Nat       -- Ganzzahldivision
          mod:  Nat x Nat -> Nat       -- ganzzahliger Rest
          even: Nat -> Bool            -- Prädikat der Geradzahligkeit

axioms
          x, y, a: Nat
          add(0, 0)          = 0
          add(x, 0)          = x
          add(x, suc(y))     = suc(add(x, y))

          0 =* 0             = true
          0 =* suc(x)        = false
          suc(x) =* 0        = false
          suc(x) =* suc(y)   = x =* y

          0 > suc(y)         = false
          suc(x) > 0         = true
          suc(x) > suc(y)    = x > y

          0 > pred(x)        = false
          pred(a) > 0        = if a *= 1 then false else true
          pred(x) > pred(y)  = x > y

          sub(0, 0)          = 0
          sub(a, 0)          = suc(a)
          sub(suc(x), a)     = if suc(x) > a then sub(pred(suc(x)), pred(a)) else 0

          mult(0, 0)         = 0
          mult(a, 0)         = 0
          mult(suc(x), a)    = if pred(a) > 1 add(mult(suc(x), pred(a)), suc(x)) else suc(x)

          div(0, a)          = 0
          div(a, a)          = suc(0)
          div(suc(x), a)     = if suc(x) > a add(div(sub(suc(x), a), a), 1) else 0

          mod(0, a)          = 0
          mod(a, a)          = 0
          mod(suc(x), a)     = if suc(x) > a mod(sub(suc(x), a), a) else suc(x)

          even(0)                    = true
          even(add(a, a))            = true
          even(add(suc(x), x))       = false
          even(add(a, pred(a)))      = false
          even(add(suc(a), pred(a))) = true

preconditions

          a =* 0 = false