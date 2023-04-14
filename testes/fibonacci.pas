program fibonacci;

var
  n: integer;
  
function fibonacciTerm(n: integer) : integer;
begin
  if (n = 0) or (n = 1) then begin
    fibonacciTerm := 1;
  end
  else begin
    fibonacciTerm := fibonacciTerm(n - 1) + fibonacciTerm(n - 2);
  end;
end;

begin
  read(n);
  write(fibonacciTerm(n));
end.
