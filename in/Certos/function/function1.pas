program funcao;

var 
  a: integer;
  b: integer;
  c : real;
 
function soma(a, b: integer) : integer;
  begin
    soma := a + b;
  end;
  
begin
  a := 2;
  b := 5;
  c := soma(a, b);
  writeln(c);
end.
