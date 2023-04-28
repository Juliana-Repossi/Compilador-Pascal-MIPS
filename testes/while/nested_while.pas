program nested_while;
var
  i, j: integer;

begin
  i := 0;
  while i < 3 do begin
    j := 0;
    while j < 3 do begin
      write('(');
      write(i);
      write(', ');
      write(j);
      writeln(')');
      
      j := j + 1;
    end;

    i := i + 1;
  end;
end.
