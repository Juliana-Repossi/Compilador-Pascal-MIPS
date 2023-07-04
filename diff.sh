#!/bin/bash
# ROOT=/home/fgasouza/compiladores-labs/lab3
# ROOT=/home/filipe/git/Compilador-Pascal-MIPS
ROOT=/home/jcrepossi/Compilador-Pascal-MIPS
# ROOT=/home/juliana/Compilador-Pascal-MIPS
# ROOT=/home/elaine/git/Compilador-Pascal-MIPS
ANTLR_PATH=$ROOT/tools/antlr-4.11.1-complete.jar
CLASS_PATH_OPTION="-cp .:$ANTLR_PATH"

BIN_PATH=bin

DATA=$ROOT
IN=$DATA/in/Certos/
OUT=$DATA/out_correct
#IN=$DATA/in/Certos

for dir in $IN/*; do
    basedir=$(basename $dir)
    
   if [ ! -d $OUT/$basedir ];
    then
        mkdir $OUT/$basedir
    fi

    for infile in $dir/*.pas; do
        base=$(basename $infile)

        outfile=$OUT/$basedir/${base/.pas/.txt}
        echo Running $base
        # dotfile=$OUT/$basedir/${base/.pas/.dot}
        # pdffile=$OUT/$basedir/${base/.pas/.pdf}
        
        # make run < $infile 2> $dotfile > /dev/null
        # fpc $infile
        # .$infile > $outfile
        # make run FILE=$infile | diff -w $outfile -
        java $CLASS_PATH_OPTION:$BIN_PATH Main $infile | diff -w $outfile -
        # dot -Tpdf $dotfile -o $pdffile 2> /dev/null
    done
done 




