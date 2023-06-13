program sum;
var 
    X, Y, A: real;
    z, i: boolean;


const
    const_1 = 10.5;
begin
    write('This program operates with 2 numbers!');

    write('Please, type the first one: ');
    read(X);

    write('Please, type the another one: ');
    read(Y);

    A := X + Y;
    write('X + Y =  ');
    writeln(A);

    A := X - Y;
    write('X - Y =  ');
    writeln(A);

    A := X * Y;
    write('X * Y =  ');
    writeln(A);

    A := X / Y;
    write('X / Y =  ');
    writeln(A);

    A := X > Y;
    write('X > Y =  ');
    writeln(A);

    A := X >= Y;
    write('X >= Y =  ');
    writeln(A);

    A := X < Y;
    write('X < Y =  ');
    writeln(A);

    A := X <= Y;
    write('X <= Y =  ');
    writeln(A);

    write(const_1);
end.
