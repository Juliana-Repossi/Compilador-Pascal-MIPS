program ex1;
var
    int: integer;
    float: real;
    bool: boolean;
    str: string;

    vetorFloat: array[0..9] of real;
    vetorInt: array[0..9] of integer;
    vetorBool: array[0..9] of boolean;

const
   PI = 3.14;
   const_int = 3;
   const_bool = true;
   const_str = 'constante';

begin
    // x1 := 1;
    // x2 := 2.5;
    // x3 := true;
    // x4 := 'compiladores trab';

    // read(vetor[1]);
    // read(vetor1[2]);

    // writeln(x2);
    // writeln(x1 + PI);
    // writeln(x2 + vetor1[2] / 4);
    // writeln(x2 + vetor[1]);
    // writeln(x3);
    // writeln('HELLO');
    // writeln(x4);
    int := 2;
    float := 3;
    bool := true;
    str := 'teste';

    vetorInt[0] := 4;
    vetorFloat[0] := 3.2;
    vetorBool[0] := bool;

    writeln(2 <= 3);
    writeln(2.0 <= 3.2);
    writeln(false <= true);
    writeln(str <= 'teste');
    writeln('-------------');

    writeln(vetorInt[0] <= 3);
    writeln(vetorFloat[0] <= vetorFloat[0]);
    writeln(vetorBool[0] <= true);

    float := vetorFloat[0] + vetorInt[0] + 1;
    write(float);

end.