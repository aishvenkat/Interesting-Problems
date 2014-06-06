def new_permutation(input_string):
	if(len(input_string) == 1):
		return input_string
	output_string = []
	for index in range(len(input_string)):
		returned_list = [];
		if(index == 0):
			returned_list = new_permutation(input_string[index+1:])
		else:
			if(index == (len(input_string) -1)):
				returned_list = new_permutation(input_string[0:index])
			else:
				returned_list = new_permutation(input_string[index+1:]+input_string[0:index])
		for item in returned_list:
			new_item = (input_string[index] + item)
			if(new_item not in output_string):
				output_string.append(new_item)
	return output_string

strings = new_permutation(list("coo"))
print strings
