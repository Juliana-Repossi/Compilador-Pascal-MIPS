program functiontest;

function maior_numero (a: real; b: real) : real;
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
    writeln(maior_numero(10,11));
    write(maior_numero(10.5,10.4));
end.