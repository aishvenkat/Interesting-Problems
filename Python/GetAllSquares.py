import math
import sys
def get_all_squares(startRange,endRange):
	lowSqrt =  math.ceil((math.sqrt(float(startRange))))
	highSqrt = (math.sqrt(float(endRange)))
        sqCount = int(highSqrt) - int(lowSqrt) + 1
        print sqCount

lines = sys.stdin.readlines()
testcases = int(lines[0].strip())
for line in lines[1:]:
	line = line.strip()
	(st,en) = line.split()
        get_all_squares(st,en)
