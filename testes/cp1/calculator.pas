program calculator;
var
  a, b, result: real;
  op, space: char;

begin
  read(a);
  read(op);
  read(b);
  
  if op = '+' then
  begin
    result := a + b;
  end
  else
  begin
    if op = '-' then
    begin
      result := a - b;
    end
    else
    begin
      if op = '*' then
      begin
        result := a * b;
      end
      else
      begin
        if op = '/' then
        begin
          result := a / b;
        end;
      end;
    end;
  end;
  write(result);
end.