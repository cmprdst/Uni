Answer
----------------------------------------------------------------------
"whatRec(int n)" berechnet rekursiv die Quersumme einer Zahl n ∈ N₀.

bspw. 47142:

    47142 > 10 -> return whatRec(47142 / 10 == 4714) + 47142 % 10 == +2
    4714  > 10 -> return whatRec(4714  / 10 == 471 ) + 4714  % 10 == +4
    471   > 10 -> return whatRec(471   / 10 == 47  ) + 471   % 10 == +1
    47    > 10 -> return whatRec(47    / 10 == 4   ) + 47    % 10 == +7
    4     < 10 -> return                                          == +4
                                                                  == 18 