program booleanCalc;

var
  a, b: integer;
  op: string;
  aBoolean, bBoolean: boolean;

begin
  read(op);
  read(a, b);

  if a <> 0 then begin
    aBoolean := true;
  end
  else begin
    aBoolean := false;
  end;

  if b <> 0 then begin
    bBoolean := true;
  end
  else begin
    bBoolean := false;
  end;

  // and, or, xor
  if op = 'and' then begin
    write(aBoolean);
    write(' and ');
    write(bBoolean);
    write(' = ');
    write(aBoolean and bBoolean);
  end
  else begin
    if op = 'or' then begin
      write(aBoolean);
      write(' or ');
      write(bBoolean);
      write(' = ');
      write(aBoolean or bBoolean);
    end
    else begin
      if op = 'xor' then begin
        write(aBoolean);
        write(' and ');
        write(bBoolean);
        write(' = ');
        write((aBoolean and not bBoolean) or (not aBoolean and bBoolean));
      end
      else begin
        write('unknown operator');
      end;
    end;
  end;
end.
