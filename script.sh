#!/bin/bash
ROOT=/home/filipe/git/Compilador-Pascal-MIPS
# ROOT=/home/fgasouza/compiladores-labs/lab5
# ROOT=/home/elaine/git/Compilador-Pascal-MIPS
ANTLR_PATH=$ROOT/tools/antlr-4.11.1-complete.jar
CLASS_PATH_OPTION="-cp .:$ANTLR_PATH"

BIN_PATH=bin
TEST_PATH=function

DATA=$ROOT
# IN=$DATA/in/cp5/$TEST_PATH
OUT=$DATA/out
IN=$DATA/in/cp5

for dir in $IN/*; do
    basedir=$(basename $dir)
    
    if [ ! -d $OUT/$basedir ];
    then
        mkdir $OUT/$basedir
    fi

    for infile in $dir/*.pas; do
        base=$(basename $infile)
        echo Running $base
        dotfile=$OUT/$basedir/${base/.pas/.dot}
        pdffile=$OUT/$basedir/${base/.pas/.pdf}
        make run < $infile 2> $dotfile > /dev/null
        dot -Tpdf $dotfile -o $pdffile 2> /dev/null
    done
done 

# for infile in ls $IN/*.pas; do
#     base=$(basename $infile)
#     echo Running $base
#     dotfile=$OUT/${base/.pas/.dot}
#     make run < $infile 2> $dotfile > /dev/null
#     dot -Tpdf $dotfile -o $OUT/$base.pdf 
# done
