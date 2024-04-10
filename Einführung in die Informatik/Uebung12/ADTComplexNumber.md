#### ADT Real
##### operator
    sqrt: Real -> Real
##### axioms
    sqrt(x*x) = x
##### precondition
    sqrt(x): x >= 0


ADT Complex
---

#### type
    Complex[Real, Imaginary[Real, Constant]]

#### import
    Real, (+, -, *, /, sqrt)

#### operator
    0:      -> Complex
    add:    Complex x Complex -> Complex
    mult:   Complex x Complex -> Complex
    abs:    Complex -> Real

#### axioms
    for all z, y, x: Complex; a, b, c, d: Real; (b, i), (d, i): Imaginary; i: Constant

    z, a, b, i    = a + b * i

    add((z, a, b, i), 0)            = z, a, b, i
    add((z, a, b, i), (y, c, d, i)) = add((y, b, d, i), (z, a, b, i))
    add((z, a, b, i), (y, c, d, i)) = x, a + c, b + d, i

    mult((z, a, b, i), 0)               = 0 
    mult((z, a, b, i), (y, c, d, i))    = mult((y, c, d, i), (z, a, b, i))
    mult((z, a, b, i), (y, c, d, i))    = x, a * c - b * d, a * d + b * c, i

    abs(0)          = 0
    abs(z, a, b, i) = sqrt(a * a + b * b)

#### preconditions
    i² = -1