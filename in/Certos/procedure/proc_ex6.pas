program proc_ex5;
var
    x: array[0..5] of integer;
    z: array[0..5] of integer;
    j : integer;

procedure test(l: array of integer);
var
  i: integer;
  local: array[0..3] of integer;
  local2: array[0..6] of real;
begin
  local[0] := 2;
  
  i := 0;
  writeln('----test----');
  while i < 6 do
  begin
    writeln(l[i] * 2);
    l[i] := 70;
    i := i + 1;
  end;
end;

procedure sum(i: integer; arr: array of integer);
begin
  i := 0;
  test(arr);
  writeln('----sum-------');
  while i < 6 do
  begin
    writeln(arr[i] * 2);
    arr[i] := 50;
    i := i + 1;
  end;

end;


begin
  j:= 0;
  while j < 6 do
  begin
    x[j] := j ;
    j := j + 1;
  end;
  sum(0, x);

  writeln('-----main-------');
  j := 0;
  while j < 6 do
  begin
    writeln(x[j]);
    j := j + 1;
  end;
  // z[2] := 10;
  // writeln(z[2]);

end.
