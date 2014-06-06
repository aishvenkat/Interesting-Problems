using System;
using System.Collections.Generic;
public class BalancedParenthesisQuestions
{
	//Checks whether an input string of Parenthesis is balanced or not
	public bool areParenBalanced (string inputString)
	{
		Stack<char> parenStack = new Stack<char>();
		List<char> openParen = new List<char> {'(','{','['};
		List<char> CloseParen = new List<char> {')','}',']'};
		for(int i = 0; i < inputString.Length; i++)
		{
			if(openParen.Contains(inputString[i]))
				parenStack.Push(inputString[i]);
			else
			{
				if(CloseParen.Contains(inputString[i]))
				{
					if(parenStack.Count < 1)
						return false;
					if(openParen.IndexOf(parenStack.Pop()) != CloseParen.IndexOf(inputString[i])) 
						return false;
				}
			}
		}
		return true;
	}
	
	//Given a number, generates all possible permuations of balanced Parenthesis
	public List<string> generateAllPermutations(int num)
	{
		List<string> permutations = new List<string>();
		if((permutations.Count < 1) && (num > 0))
			{
				permutations.Add("()");
			}
		for(int i = 1; i < num; i++)
		{
			List<string> newPermutation = new List<string>();
			foreach(string permutation in permutations)
			{
				if(!newPermutation.Contains("()"+permutation))
					newPermutation.Add("()"+permutation);
				if(!newPermutation.Contains("("+permutation+")"))
					newPermutation.Add("("+permutation+")");
				if(!newPermutation.Contains(permutation+"()"))
					newPermutation.Add(permutation+"()");
			}
			permutations = newPermutation;
		}
		return permutations;
	}
	
	public void displayAllPermutations(List<string> allPermutations)
	{
		foreach(string permutation in allPermutations)
		{
			Console.WriteLine(permutation);
		}
	}
       
        public static void Main(string[] args){
           BalancedParenthesisQuestions bp = new BalancedParenthesisQuestions();
           // Check if the input string has balanced parenthesis
           Console.WriteLine(bp.areParenBalanced("()("));
           Console.WriteLine(bp.areParenBalanced("(())()"));

           //Given the number of pairs, generate all possible permuations of balanced parenthesis
           bp.displayAllPermutations(bp.generateAllPermutations(3));
        }
}
