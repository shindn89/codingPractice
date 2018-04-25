#!/bin/python3

import sys

n, k = input().strip().split(' ')
n, k = [int(n), int(k)]
x = [int(x_temp) for x_temp in input().strip().split(' ')]

x.sort()
runner = 0
output = 0
while runner < n:
    output += 1
    max_val = x[runner] + k

    while runner < n and max_val >= x[runner]:
        runner += 1
    max_val = x[runner - 1] + k
    while runner < n and max_val >= x[runner]:
        runner += 1

print(output)