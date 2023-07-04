program functiontest;
var
    k: array[0..5] of real;
    i: integer;

function funcarray(x: array of real) : integer;
var
    y: array[0..5] of integer;
    i: integer;
    sum: integer;
begin
    sum := 0;
    i := 0;
    
    while i<6 do 
    begin
        y[i] := i mod 2;
        i := i + 1;
    end; 
    
    i := 0;
    while i<6 do 
    begin
        if y[i] < x[i] then begin
            sum := sum + 1;
        end;
        i := i + 1;
    end;
    funcarray := sum;
end;

begin 
i:=0;
while i<6 do 
    begin
        k[i] := i;
        i := i + 1;
    end;
    writeln(funcarray(k));
end.
