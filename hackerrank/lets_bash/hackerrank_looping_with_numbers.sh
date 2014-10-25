#! /bin/bash

# hackerran_looping_with_numbers
#
# https://www.hackerrank.com/contests/lets-bash/challenges/bash-tutorials---looping-with-numbers

set -s


main() {
    for i in `seq 1 50`; do
        echo $i
    done
}


main
