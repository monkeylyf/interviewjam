#! /bin/bash

# hackerrank_arithmetic_operations.sh
#
# https://www.hackerrank.com/contests/lets-bash/challenges/bash-tutorials---arithmetic-operations

set -e

round_up() {
    echo $(printf %.$2f $(echo "scale=$2;(((10^$2)*$1)+0.5)/(10^$2)" | bc))
}

round_off() {
    printf "%.${2}f" "$1"
}

main() {
    scale=4
    decimal_precision=3

    read line
    num=$(echo "scale=$scale;$line" | bc -l)

    echo $num
    #round_off $num $decimal_precision
    round_up $num $decimal_precision
}

main
