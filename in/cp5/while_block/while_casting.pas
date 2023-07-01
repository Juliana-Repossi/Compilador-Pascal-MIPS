program while_block;

var
    i, j : integer;

begin
    i := 0;
    j := 0;
    while i <= 3.0 do begin
        while j <= 3.0 do begin
            write('(');
            write(i);
            write(', ');
            write(j);
            writeln(')');

            j := j + 1;
        end;
        i := i + 1;
        j := 0;
    end;

  
end.