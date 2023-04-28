program atribuicoes;
  var
    a,x: integer;
    b,y: boolean;
    c,z:char;
    s : string;
    r: real;
    vetor : array[0..2] of integer;
    

begin

    a:=5;
    b:=true;
    c:='J';
    s:= 'ju';
    r := 3.600;

    x:=a;
    y:=b;
    z:=c;

    x:=a*2 + 1;
    y:= not true;
    y:= (not b) and (not y);
    r:= r * 2.0;
    y:= (not b) or (not y);
    y:= x > a;
    
    

end.