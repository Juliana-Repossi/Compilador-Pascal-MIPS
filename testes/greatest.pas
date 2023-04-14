program greatest;

var 
  i: integer;
  newArray: array[0..9] of real;
  biggest: real;

begin
  i := 0;
  while i <= 9 do begin
    read(newArray[i]);
    i := i + 1;
  end;
  
  biggest := newArray[0];

  i := 1;
  while i <= 9 do begin
    if newArray[i] > biggest then begin
      biggest := newArray[i];
    end;
    i := i + 1;
  end;

  write('greatest number in array:');
  write(biggest);
end.
