program function_sem_param;

function maior_numero () : integer;
var
    a,b: integer;
begin 
    a := 100;
    b:= 85;

    if (a>b) then
    begin
        maior_numero:=a;
        end
    else
    begin
        maior_numero :=b;
    end;

end

begin 
    writeln(maior_numero());
    write(maior_numero());
end.