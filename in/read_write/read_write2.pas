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
   const_bool = false;
   const_str = 'constante';

begin

    int := 2;
    float := 3;
    bool := true;
    str := 'teste';

    vetorInt[0] := 4;
    vetorFloat[0] := 3.2;
    vetorBool[0] := const_bool;

    writeln(2 < 3);
    writeln(2.0 < 3.2);
    writeln(false > true);
    writeln(str > 'teste');
    writeln('-------------');

    writeln(vetorInt[0] <= 3);
    writeln(vetorFloat[0] >= vetorFloat[0]);
    writeln(vetorBool[0] <> true);
    writeln(vetorBool[0] = true);

    float := vetorFloat[0] + vetorInt[0] + 1;
    write(float);

end.