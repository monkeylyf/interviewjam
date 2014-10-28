#! /bin/bash

# hackerrank_the_cut_command_3
#
# https://www.hackerrank.com/contests/lets-bash/challenges/text-processing-cut-3

set -e

main() {
    while read line; do
        echo $line | cut -c2-7
    done

}

main
