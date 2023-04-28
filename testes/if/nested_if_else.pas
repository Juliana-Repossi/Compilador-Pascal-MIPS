program nested_if_else;
begin
  if 2 > 1 then begin
    if 2 = 3 then begin
      write('inside nested if!');
    end;
  end
  else begin
    if 'string' = 'string2' then begin
      writeln('inside nested else!');
    end;
  end;
end.
