import sys
import random
def PlayNextMove(boardRow,boardCol,inputArray):
   startRow = int(boardRow)*3
   startCol = int(boardCol)*3
   while(1):
	   playCol = random.randint(startCol, startCol+2)
	   playRow = random.randint(startRow, startRow+2)
   	   if(inputArray[playRow][playCol] == '-'):
                print(str(boardRow)+" "+str(boardCol)+" "+str(playRow-startRow)+" "+str(playCol-startCol))
		break

def checkIfSelfTurn(inputList):
	boardToPlay = inputList[1]
	(row,col) = boardToPlay.split()
        if((row == '-1') and (col == '-1')):
		col = random.randint(0,2)
		row = random.randint(0,2)
        PlayNextMove(row,col,inputList[2:])

inputList = [];
for line in sys.stdin.readlines():
	line = line.strip()
	inputList.append(line)		
checkIfSelfTurn(inputList)
