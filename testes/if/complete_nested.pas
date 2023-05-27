program complete_nested;
var 
  x : real;
  y : integer;
  z : boolean;
  w : string;
begin
  x := 3.5;
  y := 2;
  z := true;
  w := 'str';

  if x > x then begin
  // if 2 > 1 then begin
    if 2 = 3 then begin
      write('inside nested if!');
    end
    else begin
      write('any message...');
    end;
  end
  else begin
    if 'string' = 'string2' then begin
      writeln('inside nested else!');
    end
    else begin
      write('do something...');
    end;
  end;
end.
