#!/bin/bash
ROOT=/home/filipe/git/Compilador-Pascal-MIPS
# ROOT=/home/fgasouza/compiladores-labs/lab5
# ROOT=/home/elaine/git/Compilador-Pascal-MIPS
ANTLR_PATH=$ROOT/tools/antlr-4.11.1-complete.jar
CLASS_PATH_OPTION="-cp .:$ANTLR_PATH"

BIN_PATH=bin

DATA=$ROOT
IN=$DATA/testes/cp5/statement/read_write
# OUT=$DATA/out05
MYOUT=$DATA/myout

for infile in ls $IN/*.pas; do
    base=$(basename $infile)
    echo Running $base
    dotfile=$MYOUT/${base/.pas/.dot}
    # dotfileout=$OUT/${base/.ezl/.dot}
    make run < $infile 2> $dotfile > /dev/null
    dot -Tpdf $dotfile -o $MYOUT/$base.pdf 
    # diff -w $dotfile $dotfileout
done