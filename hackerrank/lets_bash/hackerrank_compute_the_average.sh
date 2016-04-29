#! /bin/bash

# hackerrank_compute_the_average.sh
#
# https://www.hackerrank.com/contests/lets-bash/challenges/bash-tutorials---compute-the-average


round_off() {
    printf "%.${2}f" "$1"
}

main() {
    read n
    sum=0
    decimal_precision=3

    for i in `seq 1 ${n}`; do
        read num;
        let sum+=num
    done

    num=$(echo "scale=4; $sum / $n" | bc -l)

    round_off $num $decimal_precision
}

main
