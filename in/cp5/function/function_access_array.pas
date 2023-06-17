program functiontest;

var
    vetor : array[0..1] of integer;

function maior_numero (a,b: real) : real;
begin 
    if (a >= b) then
    begin
        if(a = b ) then
        begin
            write('os numeros são iguais');
            maior_numero := a;
        end
        else
        begin
            maior_numero:=a;
        end;
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