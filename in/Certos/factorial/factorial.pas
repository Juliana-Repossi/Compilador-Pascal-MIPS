program fat;
var
    n: integer;
   
function fatorial(n: integer): integer;
var
    aux: integer;
begin
    if n = 0 then begin
        fatorial := 1;
    end
    else begin
        fatorial := n * fatorial(n - 1);
    end;
end;
begin
  writeln(fatorial(0));
  writeln(fatorial(1));
  writeln(fatorial(2));
  writeln(fatorial(3));
  writeln(fatorial(4));
  writeln(fatorial(5));
  writeln(fatorial(6));
end.