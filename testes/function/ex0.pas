program funcao;

var 
  vetor : array[0..9] of integer;
  vetor1 : integer;
  i, x, y : integer;
  boleano: boolean;

function soma(vetor: array of integer) : integer;
  begin
    soma := 1;
  end;

procedure subtracao(vetor: array of real);
begin

end;
  
begin

 i := 0;

    while i < 10 do
    begin
        vetor[i]:= i;
        i := i + 1;
    end;

  soma(vetor);
end.