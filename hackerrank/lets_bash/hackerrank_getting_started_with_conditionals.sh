#! /bin/bash

# hackerrank_looping_getting_started_with_conditionals
#
# https://www.hackerrank.com/contests/lets-bash/challenges/bash-tutorials---getting-started-with-conditionals

set -e


main() {
    read input
    case $input in
        Y|y)
            echo "YES"
            ;;
        N|n)
            echo "NO"
            ;;
    esac
}

main
