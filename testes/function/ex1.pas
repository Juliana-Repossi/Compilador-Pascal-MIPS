program funcao;

function soma(x,y:integer; a: real; b: boolean; s: string; c: char; vetor: array of integer) : integer;
  const
    PI = 3.14;
  begin
    soma := x+y;
  end;
  
begin

  write(soma(2,3,5.7,false,'oi','c'));
   
end.