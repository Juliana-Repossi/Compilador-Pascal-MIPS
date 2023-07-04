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

    // read
    read(x1);
    read(x2);
    read(z7);

    read(vetor[1]);
    read(vetor1[2]);

    writeln(x1);
    writeln(x2);
    writeln(z6);
    writeln(z7);

    writeln(vetor[1]);
    writeln(vetor1[2]);
    writeln(vetor2[0]);

end.
