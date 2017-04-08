package com.calc;

import java.util.Stack;
import java.util.*;

/**
 * 计算器的模型
 * 
 * 模型中的数据发布出去（成为被订阅的主题）
 * 
 * @author as Chenqingling
 *
 *         下午4:28:50
 */
public class CalcModel extends Observable{
	// 逆波兰表达式（后序表达式）

	// 操作数和运算符
	Stack<String> stack;
	
	String con ;
	
	public CalcModel(){
		stack = new Stack<>();
	}
	
	public void push(String e) {
		stack.push(e);
		System.out.println(stack);
		
		//数据该变了，通知观察者
		setChanged();
		notifyObservers(stack.toString());
	}

	public String pop(){
		return stack.pop();
		//System.out.println(stack);
	}
	
	public int size(){
		int s = stack.size();
		return s ;
	}
	
	public String peek(){
		return stack.peek();
	}
	
	public void clear() {
		stack.clear();
	
		setChanged();
		notifyObservers();
	}

	public String getResult() {
		return null;
	}
	
	public void todo(){
		//运算
		
		notifyObservers("数据");
	}
	
	
	public void setInput(String input){
		con = input;
		System.out.println("model:" + input);
		
		setChanged();
		notifyObservers(input);
	}
	
	public void setSinge(String single){
		con = single;
		setChanged();
		notifyObservers(single);
	}
	
	
	
	
	
}
