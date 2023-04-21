program sum;
var 
    X, Y : real;

const
    const_1 = 10.5;
begin
    write('This program operates with 2 numbers!');

    write('Please, type the first one: ');
    read(X);

    write('Please, type the another one: ');
    read(Y);

    writeln('X + Y =  ' , X + Y);
    writeln('X - Y =  ' , X - Y);
    writeln('X * Y =  ' , X * Y);
    writeln('X / Y =  ' , X / Y);
    writeln('X > Y =  ' , X > Y);
    writeln('X >= Y =  ' , X >= Y);
    writeln('X < Y =  ' , X < Y);
    writeln('X <= Y =  ' , X <= Y);

    write(const_1);
end.
