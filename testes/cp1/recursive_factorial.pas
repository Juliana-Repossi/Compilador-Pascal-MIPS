program recursive_factorial;

var
  n: integer;

function factorial(const n: integer) : integer;
begin
  if (n = 0) or (n = 1) then 
  begin
    factorial := 1;
  end
  else 
  begin
    factorial := n * factorial(n - 1);
  end;
end;

begin
  readln(n);
  writeln(factorial(n));
end.
