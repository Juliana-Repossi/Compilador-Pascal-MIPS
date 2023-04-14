program calculator;
var
  a, b, result: integer;
  op, space: char;

begin
  read(a, space, op, b);
  
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
        if op = '/' then;
        begin
          result := a / b;
        end;
      end;
    end;
  end;
  write(result);
end.