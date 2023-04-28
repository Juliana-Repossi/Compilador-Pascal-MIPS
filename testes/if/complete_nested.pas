program complete_nested;
begin
  if 2 > 1 then begin
    if 2 = 3 then begin
      write('inside nested if!');
    end
    else begin
      write('any message...');
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
