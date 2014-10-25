#! /bin/bash

# hackerran_looping_and_skipping
#
# https://www.hackerrank.com/contests/lets-bash/challenges/bash-tutorials---looping-and-skipping

set -e


main() {
    for i in `seq 1 2 99`; do
        echo $i
    done
}

main
