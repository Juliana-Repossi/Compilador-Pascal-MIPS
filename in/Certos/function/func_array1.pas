program functiontest;
var
    k: array[0..5] of real;
    i: integer;

function funcarray(x: array of real) : integer;
var
    y: array[0..5] of integer;
    j: integer;
begin 
    j:=0;
    while j < 6 do
    begin
        x[j] := j ;
        y[j] := 1;
        j := j + 1;
    end;
    j:= 0;
    while j < 6 do
    begin
        x[j] := x[j] + y[j];
        writeln(x[j]);
        j := j+1;
    end;

    j := 0;
    writeln('printing array declarado dentro');
    while j < 6 do begin
        writeln(y[j]);
        j := j + 1;
    end;
end;

begin 

    while i < 6 do
    begin
        k[i] := 1;
        i := i+1;
    end;
    i := 0;

    funcarray(k);

    writeln('printing array');
    while i < 6 do begin
        writeln(k[i]);
        i := i + 1;
    end;
end.
