program func;


function concatena(x, y: string) : string;
var
    a: string;
begin 
    a := '!';
    concatena := x + y + a;
end;

procedure hello();
begin
    write('hello world');
end;

function get123(): integer;
begin
    get123 := 123;
end;

begin 
    writeln(concatena('hel', 'lo'));
    hello();
    get123();
end.