#! /bin/bash

# hackerrank_the_tr_command_1
#
# https://www.hackerrank.com/contests/lets-bash/challenges/text-processing-tr-1


set -e

main() {
    # Quite interesting:
    # If handling individual line using while read line and the submission
    # will skip the second line and all after that.

    #while read line; do
    #    echo $line | tr "(" "[" | tr ")" "]"
    #done
    tr "(" "[" | tr ")" "]"
}

main
