def reverse_string(sstr):
	lstr = list(sstr)
	strlen = (int)((len(lstr))/2)
	for index in range(0,strlen):
		st = lstr[index]
		lstr[index] = lstr[len(lstr) - index - 1]
		lstr[len(lstr) - index - 1] = st
	return	("".join(lstr))

reversedString = reverse_string("hell0");
print reversedString;
