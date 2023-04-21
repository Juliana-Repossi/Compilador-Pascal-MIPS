program triangle;

var
  height: integer;

procedure drawTriangle(height: integer);
var
  i, j, low, high, base: integer;
begin
  low := height;
  high := height;
  base := 2 * height - 1;
  i := 1;
  while i <= height do begin
    j := 1;

    while j <= base do begin
      if (j >= low) and (j <= high) then begin
        write('*');
      end
      else begin
        write(' ');
      end;

      j := j + 1;
    end;
    //writeln();
    
    low := low - 1;
    high := high + 1;
    i := i + 1;
  end; 
end;

begin
  read(height);
  drawTriangle(height);
end.
