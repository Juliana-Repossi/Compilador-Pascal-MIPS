program atrib;

var
    a,b : integer;
    c,d : real;

begin
    a:= 2;
    b:= 5;
    a:= a+b;
    b:= 2+3*2;
    b:= -(2 + 3) + 2;
    b:=-2;

    c:= +2.2;
    d:= -5.2;
    c:= c+d;
    d:=-2.0+(-5.0);
    c:= -(12.5+9);
    writeln(a);
    writeln(b);
    writeln(c);
    writeln(d);
    writeln(a + b + c + d);
end.