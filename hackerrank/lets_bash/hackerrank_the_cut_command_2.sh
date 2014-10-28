#! /bin/bash

# hackerrank_the_cut_command_2
#
# https://www.hackerrank.com/contests/lets-bash/challenges/text-processing-cut-2


set -e


main() {
    while read line; do
        first=`echo $line | cut -f 2`
        second=`echo $line | cut -f 7`
        echo "$first$second"
    done
}

main
