program sample_while;
var
  i, j: integer;

begin
  i := 0;
  j := 0;
  while (i < 10) and (j >= -5) do begin
    write('i: ');
    writeln(i);
    write('j: ');
    writeln(j);
    i := i + 1;
    j := j - 1;
  end;
end.
