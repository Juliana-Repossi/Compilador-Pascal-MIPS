program functiontest;
var
    k: array[0..5] of real;

function funcarray(x: array of boolean) : integer;
var
    y: array[0..5] of integer;
begin 
    funcarray := 2;
end;

begin 
    funcarray(k);
end.
