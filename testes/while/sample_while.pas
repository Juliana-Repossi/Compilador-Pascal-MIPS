program sample_while;
var
  i: integer;

  x : real;
  y : integer;
  z : boolean;
  w : string;

begin
  i := 0;

  x := 3.5;
  y := 2;
  z := true;
  w := 'str';

  while i < 10 do begin
    writeln(i);
    i := i + 1;
  end;
end.
