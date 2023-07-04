program sort;
var
    list: array[0..100] of integer;
    i: integer;
    size: integer;
   
procedure initializeArray(list: array of integer);
var
    i: integer;
    size: integer;
   
begin
    i := 0;
    size := 100;
    while i < size do begin
        list[i] := 100 - i;
        i := i + 1;
    end;
end;


procedure printArray(list: array of integer);
var
    i: integer;
    size: integer;
   
begin
    i := 0;
    size := 100;
    while i < size do begin
        write(list[i]);
        write(' ');
        i := i + 1;
    end;
end;

procedure sort(list: array of integer);
var
    i, j: integer;
    size: integer;
    tmp: integer;

begin
    i := 0;
    size := 100;
    while i < size do begin
        j := 0;
        while j < size - 1 do begin
            if list[j] > list[j + 1] then begin
                tmp := list[j];
                list[j] := list[j + 1];
                list[j + 1] := tmp;
            end;
           
            j := j + 1;
        end;
        i := i + 1;
    end;
end;

begin
    initializeArray(list);
   
    writeln('Antes de ordenar:');
    printArray(list);
   
    sort(list);
   
    writeln('');
    writeln('Depois de ordenar:');
    printArray(list);
end.