package com.calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Controller implements ActionListener {

	/**
	 * 计算器核心
	 */
	private CalcModel calc;// 模型

	// private CalcCallBack callback;
	//
	// public void setCallback(CalcCallBack callback) {
	// this.callback = callback;
	// }

	private StringBuilder input = new StringBuilder();

	Stack<String> out = new Stack();

	/**
	 * 构造方法
	 */
	public Controller() {
		// super();
		// this.calc = calc;
	}

	/**
	 * 设置依赖模型
	 * 
	 * @param model
	 */
	// 控制器要获得模型，通过set方法获取
	public void setModel(CalcModel model) {
		calc = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
//		String top = calc.peek();
		switch (command) {
		case "=":
			calc.setInput(input.toString());
			calculate(input.toString());
			
			input.setLength(0);
			break;
		case "C":
			calc.clear();
			input.setLength(0);
			break;
		case "Del":

			break;
		
		default:
			input.append(command);
			calc.setSinge(input.toString());
			break;
		}
		
	}
	
	public void calculate(String str){
		
	}
	
}

// switch (command) {
// case "+":
// case "-":
// if (calc.size() == 0 || top.equals("(")) {
// calc.push(command);
// } else {
// boolean isBig = true;
// while ("*".equals(top) || "/".equals(top) || isBig) {
//
// input.append(calc.pop());
// isBig = calc.size() == 0 ? false : true;
// }
// calc.push(command);
// }
// break;
// case "*":
// case "/":
//
// break;
// case "=":
// calc.push(input.toString());
// input.delete(0, input.length());
// calc.push(command);
// break;
// case "C":
// calc.clear();
// break;
// case "Del":
//
// break;
// case ".":
//
// break;
//
// default:
// input.append(command);
// calc.push(input.toString());
// input.delete(0, input.length());
// break;
// }