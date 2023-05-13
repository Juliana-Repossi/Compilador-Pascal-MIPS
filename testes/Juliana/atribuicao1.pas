program atribuicoes;
  var
    a,x: integer;
    b,y: boolean;
    s : string;
    r: real;
    vetor : array[0..5] of integer;
    

begin

    a:=5;
    b:=true;
    s:= 'ju';
    r := 3.600;

    x:=a;
    y:=b;

    x:=a*2 + 1;
    y:= not true;
    y:= (not b) and (not y);
    r:= r * 2.0;
    y:= (not b) or (not y);
    y:= x > a;
    
    

end.