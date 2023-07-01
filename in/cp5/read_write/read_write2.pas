program ex1;
var
    x1 : integer;
    x2 : real;
    x3 : boolean;
    x4 : string;

    vetor1 : array[0..3] of real;
    vetor : array[0..9] of integer;
    vetor2 : array[0..5] of boolean;

const
   PI = 3.14;
   const_int = 3;
   const_bool = true;
   const_str = 'constante';

begin

    x1 := 1;
    x2 := 2.5;
    x3 := true;
    x4 := 'compiladores trab';

    read(vetor[1]);
    read(vetor1[2]);

    writeln(x2);
    writeln(x1 + PI);
    writeln(x2 + vetor1[2] / 4);
    writeln(x2 + vetor[1]);
    writeln(x3);
    writeln('HELLO');
    writeln(x4);

end.