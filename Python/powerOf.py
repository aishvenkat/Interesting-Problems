def power_of(num,power):
	result = 1;
	while(power > 0):
		result *= num
		power -= 1
	return result

print power_of(2,3)
print power_of(2,10)
