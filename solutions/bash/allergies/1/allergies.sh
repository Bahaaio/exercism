#!/usr/bin/env bash

((value = $1 % 256))

list=0
if [[ "$2" == "list" ]]; then
    list=1
else
    item=$3
fi

allergies=()

check() {
    if [[ list -eq 1 ]]; then
        allergies=("$1" "${allergies[@]}")
    elif [[ "$item" == "$1" ]]; then
        echo true
        exit 0
    fi

    ((value = value - $2))
}

while [[ $value -ne 0 ]]; do
    if [[ $value -ge 128 ]]; then
        check "cats" 128
    elif [[ $value -ge 64 ]]; then
        check "pollen" 64
    elif [[ $value -ge 32 ]]; then
        check "chocolate" 32
    elif [[ $value -ge 16 ]]; then
        check "tomatoes" 16
    elif [[ $value -ge 8 ]]; then
        check "strawberries" 8
    elif [[ $value -ge 4 ]]; then
        check "shellfish" 4
    elif [[ $value -ge 2 ]]; then
        check "peanuts" 2
    elif [[ $value -ge 1 ]]; then
        check "eggs" 1
    fi
done

([[ list -eq 1 ]] && echo "${allergies[@]}") || echo false
