def find_min_max(input_list):
	isOdd = len(input_list)
	if (len(input_list) % 2) == 1:
		 isOdd = len(input_list) - 1
	counter = 0
	while(counter < isOdd):
		if(input_list[counter] > input_list[counter+1]):
			item = input_list[counter]
			input_list[counter] = input_list[counter+1]
			input_list[counter+1] = input_list[counter]
		counter += 2
	min = input_list[0]
	max = input_list[1]
	counter = 2
	while(counter < isOdd):
		if min > input_list[counter]:
			min = input_list[counter]
		counter += 2
	counter = 3
	while(counter < isOdd):
		if max < input_list[counter]:
			max = input_list[counter]
		counter += 2
	if(isOdd < len(input_list)):
		last_element = input_list[len(input_list) - 1]
		if min > last_element: 
			min = last_element
		if max < last_element:
			max = last_element
	return [min,max]

minMax = find_min_max([1,2,3,4,5,6,7])	
print minMax
minMax = find_min_max([1,2,3,4,5,6])
print minMax
minMax = find_min_max([6,5,4,3,2,1])
print minMax
minMax = find_min_max([3,7,4,6,2,3])
print minMax
