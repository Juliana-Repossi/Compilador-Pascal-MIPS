program ex1;
var
    x1 : integer;
    x2 : real;
    x3 : boolean;
    x4 : string;

    vetor : array[0..9] of integer;
    vetor1 : array[0..3] of real;
    vetor2 : array[0..5] of boolean;

    z1,z2 : integer;    
    z3,z4 : real;
    z5,z6 : boolean;
    z7,z8 : string;


const
   PI = 3.14;
   const_int = 3;
   const_bool = true;
   const_str = 'constante';

begin
    x2 := 3;
    z3 := 5;
    z4 := 65;
    z5 := true;
    z6 := false;

    writeln(x2);
    writeln(z3);
    writeln(z4);
    writeln(z5);
    writeln(z6);

end.

