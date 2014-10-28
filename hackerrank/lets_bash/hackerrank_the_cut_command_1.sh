#! /bin/bash

# hackerrank_the_cut_command_1
#
# https://www.hackerrank.com/contests/lets-bash/challenges/text-processing-cut-1

set -e

main() {
    while read line; do
        echo $line | cut -c 3
    done
}

main
