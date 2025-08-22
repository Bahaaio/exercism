#!/usr/bin/env bash

((value = $1 % 256))
mode=$2
item=$3

declare -A allergies=(
    [1]="eggs"
    [2]="peanuts"
    [4]="shellfish"
    [8]="strawberries"
    [16]="tomatoes"
    [32]="chocolate"
    [64]="pollen"
    [128]="cats"
)

results=()

for mask in 1 2 4 8 16 32 64 128; do
    if ((value & mask)); then
        allergy=${allergies[$mask]}

        if [[ "$mode" == "list" ]]; then
            results+=("$allergy")
        elif [[ $item == "$allergy" ]]; then
            echo true
            exit 0
        fi

    fi
done

if [[ "$mode" == "list" ]]; then
    echo "${results[@]}"
else
    echo false
fi
