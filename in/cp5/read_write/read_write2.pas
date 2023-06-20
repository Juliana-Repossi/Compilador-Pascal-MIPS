program ex1;
var
    x1 : integer;
    x2 : real;
    x3 : boolean;
    x4 : string;

    vetor : array[0..9] of integer;
    vetor1 : array[0..3] of real;
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

    write(x1 + vetor[1] * PI);
    write(x2 + vetor1[2] / 4);
    write(x2 + vetor[1]);
    writeln(x3);
    write('HELLO');
    write(x4);

end.