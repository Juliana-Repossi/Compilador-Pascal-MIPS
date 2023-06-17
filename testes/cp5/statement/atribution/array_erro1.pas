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

    i: integer;



const
   PI = 3.14;
   const_int = 3;
   const_bool = true;
   const_str = 'constante';

begin
 
 i := 0;
 
//estouro de capacidade
while i < 10 do
    begin
        vetor1[i]:= i + PI;
        i := i + 1;
    end;
end.