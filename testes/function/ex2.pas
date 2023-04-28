program function_and_function;

function maior_numero (a,b: integer) : integer;
begin 
    if (a>b) then
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
    write(maior_numero(20,11));
end.