program proc_ex5;
var
    x: array[0..5] of integer;
    j : integer;

procedure sum(i: integer; arr: array of integer);
begin
  i := 0;
  while i < 5 do
  begin
    write(arr[i] + i);
    i := i + 1;
  end;
end;

begin
  j:= 0;
  while j < 5 do
  begin
    x[j] := j ;
    j := j + 1;
  end;
  sum(0, x);
end.
