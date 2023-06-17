program functiontest;

var
    value1,value2 : boolean;

function maior_numero (a,b: real) : real;
begin 
    if (a > b) then
    begin
        maior_numero:=a;
        end
    else
    begin
        maior_numero :=b;
    end;
end;

begin 
    value1 := true;
    value2 := false;
    writeln(maior_numero(value2,value1));
end.