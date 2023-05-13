program ex2;
var
  w, t: real;
  x: real;
  y: string;
  z: boolean;

begin
  
  t := 586.45;
  w := 15.4 * t + t * t;
  x := 2 * w - t;
  x := x + 1;
  x := (x + w) * 2;
  x := (w - t) * (8 + 6) - 750 / 30.5; 
  y := 'anything' + 'written';
  z := true and false or true and not false;
  z := (5 > 2) and (5 = 5) and (3 + 6 <> 89 * 1) or not (5 <= 10);
  z := 5 > 2 and 5 = 5 and 3 + 6 <> 89 * 1 or not 5 <= 10;
end.
