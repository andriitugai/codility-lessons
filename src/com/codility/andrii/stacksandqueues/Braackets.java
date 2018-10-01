package com.codility.andrii.stacksandqueues;
/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]",
the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
 */

public class Braackets {

	class IntStack {
		private int[] stackArray;
		private int top = 0;

		IntStack(int size){
			stackArray = new int[size];
		}

		public int pop() {
			int result;
			if(top > 0) {
				top -= 1;
				result = stackArray[top];
			}
			else
				throw new IndexOutOfBoundsException("Stack is Empty");

			return result;
		}

		public void push(int elem){
			if(top < stackArray.length){
				stackArray[top] = elem;
				top += 1;
			}
			else
				throw new IndexOutOfBoundsException("Stack is Full");
		}

		public boolean isEmpty(){
			return this.top == 0;
		}

	}

	public static void main(String[] args) {
		String test1 = "{[()()]}";
		String test2 = "([)()]";
		String test3 = "(";

		Braackets br = new Braackets();

		System.out.println(br.solution(test1));
		System.out.println(br.solution(test2));
		System.out.println(br.solution(test3));
	}

	public int solution(String S){
		char[] brackets = S.toCharArray();
		IntStack stack = new IntStack(brackets.length);
		char symb;

		for(int i = 0; i < brackets.length; i++){
			symb = brackets[i];
			try {
				if(symb == '{') stack.push(1);
				else
					if(symb == '(') stack.push(2);
				else
					if(symb == '[') stack.push(3);
				else
					if(symb == '}' && stack.pop() != 1) return 0;
				else
					if(symb == ')' && stack.pop() != 2) return 0;
				else
					if(symb == ']' && stack.pop() != 3) return 0;
			} catch (IndexOutOfBoundsException e){
				e.printStackTrace();
				return 0;
			}
		}
		if(stack.isEmpty()) return 1;
		return 0;
	}
}
