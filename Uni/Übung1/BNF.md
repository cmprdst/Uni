Spielzeug in Backus-Naur-Form
-------------------------
<Kiste> ::= leer | <Spielzeug> | <Spielzeug> <Zusatz> | weitere <Kiste>
<Zusatz> ::= <Lokalbestimmung> <Spielzeug> | <Lokalbestimmung> <Spielzeug> <Zusatz>
<Lokalbestimmung> ::= unter | auf | neben | bei
<Spielzeug> ::= Puppe | Auto | Puzzle | Eisenbahn | Blöcke