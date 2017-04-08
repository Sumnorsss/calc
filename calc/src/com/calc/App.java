package com.calc;
import java.util.*;
public class App {

	public static void main(String[] args) {
		//不改变程序的功能，调整代码的结构（重构）
		
		//模型
		CalcModel model = new CalcModel() ;
		
		//控制器
		Controller controller = new Controller();
		controller.setModel(model);//控制器获得模型
		
		//视图
		CalcJFrame view = new CalcJFrame(controller);
		
		//订阅，添加观察者
		model.addObserver(view);
		
		//
		
		//装配(依赖关系)
		//解决组件之间的依赖关系：
		//1）构造方法注入
		//2）setter 方法注入依赖的组件
		view.setController(controller);//视图获得控制器

	}

}
