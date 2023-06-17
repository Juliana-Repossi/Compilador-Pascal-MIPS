program if_block;
begin
// a expressão do if não é boolean
  if 2 + 1 then 
    begin
    if 2 = 3 then 
        begin
            write('Não era pra isso acontecer!');
        end;
    write('essa saida não sera impressa');
  end;
end.