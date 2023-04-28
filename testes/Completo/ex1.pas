program notasAlunos;

var
  ap1,bp1,cp1,ap2,bp2,cp2 : real;
  reprovado : boolean;

function soma_notas(nota1,nota2: real) : real;
begin
  soma_notas := nota1 + nota2;
end;

function media(nota1,nota2: real) : real;
const
  dois = 2.0;
begin
  media:= soma_notas(nota1,nota2) / dois;
end;

procedure verifica_aprovado(media: real);
  const 
    ap = 7;

begin
    if (media >=7) then 
    begin
      writeln('Aprovado');
    end
    else
    begin
      writeln('Reprovado');
    end;    
end;

begin
  ap1:= 5.0;
  ap2:= 3.6;

  bp1:=10.0;
  bp2:=7.85;

  cp1:=9.8;
  cp2:=5.54;

  verifica_aprovado(media(ap1,ap2));
  verifica_aprovado(media(bp1,bp2));
  verifica_aprovado(media(cp1,cp2)); 
  verifica_aprovado(media(2.5+3.2,2/5)); 

  reprovado:= media(ap1,ap2) > 7;

  write(reprovado);

end.