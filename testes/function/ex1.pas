program funcao;

var 
  vetor : array[0..9] of integer;
  vetor1 : integer;

function soma(x,y : integer; a: real; b: boolean; s: string; vetor: array of integer; const constante : real) : integer;
  const
    PI = 3.14;
  
  var 
    qtd : integer;

  const 
    e = 2.5;

  var 
    str : string;

  begin
    soma := x+y;
  end;
  
begin

  write(soma(2,3,5.7,false,'oi','c',vetor,3.14));

   
end.