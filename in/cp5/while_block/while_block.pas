program while_block;

var
    i : integer;

begin
    i := 0;
    while i < 5 do begin
        i := i + 1;
        writeln(2 * i);
    end;
end.
