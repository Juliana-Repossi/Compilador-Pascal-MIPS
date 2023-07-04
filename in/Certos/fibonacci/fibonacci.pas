program fib;

function fibonacci(n: integer): integer;
begin
    if n = 0 then begin
        fibonacci := 0;
    end;
   
    if n = 1 then begin
        fibonacci := 1;
    end;
   
    if (n <> 0) and (n <> 1) then begin
        fibonacci := fibonacci(n - 1) + fibonacci(n - 2);
    end;
end;

begin
  writeln(fibonacci(0));
  writeln(fibonacci(1));
  writeln(fibonacci(2));
  writeln(fibonacci(3));
  writeln(fibonacci(4));
  writeln(fibonacci(5));
  writeln(fibonacci(6));
end.