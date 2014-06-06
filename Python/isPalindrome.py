'''
def is_palindrome(input_string):
	input_str_list = list(input_string)
	strlen = len(input_string) - 1
	for index in range(len(input_string)/2):
		if input_str_list[index] != input_str_list[strlen - index]:
			return False
	return True
'''
def is_palindrome(input_string,start,end):
	input_str_list = list(input_string[start:end])
	strlen = len(input_str_list) - 1
	for index in range(len(input_string)/2):
		if input_str_list[index] != input_str_list[strlen - index]:
			return False
	return True

def longest_palindrome(input_string):
	longest_length = 0
	longest_string = ""
	for index in range(len(input_string)/2):
		end_length = len(input_string) - index
		if(is_palindrome(input_string,index,end_length)):	
			if(longest < end_length):
				longest = end_length
				longest_string = input_string[index:end_length]
		else
print is_palindrome("malayalam",0,len("malayalam"))
print is_palindrome("not",0,len("not"))
