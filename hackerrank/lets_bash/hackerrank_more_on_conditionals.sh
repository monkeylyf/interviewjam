#! /bin/bash

# hackerrank_more_on_conditionals.sh
#
# https://www.hackerrank.com/contests/lets-bash/challenges/bash-tutorials---more-on-conditionals

set -e

read x
read y
read z


check_triangle() {
    x=$1
    y=$2
    z=$3

    if [ "$x" -ne "$y" ] && [ "$y" -ne "$z" ]; then
        echo "SCALENE"
    elif [ "$x" -eq "$y" ] && [ "$y" -eq "$z" ]; then
        echo "EQUILATERAL"
    elif [ "$x" -eq "$y" ] || [ "$x" -eq "$z" ] || [ "$y" -eq "$z" ]; then
        echo "ISOSCELES"
    else
        return 1
    fi

    return 0
}

check_triangle $x $y $z
