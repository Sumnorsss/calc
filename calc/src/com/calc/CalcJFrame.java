package com.calc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

/**
 * 计算器视图
 * 
 * @author as Chenqingling
 *
 *         下午3:07:21
 */
public class CalcJFrame extends JFrame implements Observer{

	/**
	 * 显示计算结果
	 */
	private JLabel labelResult;
	/**
	 * 按钮上的标签
	 */
	private String[] titles = { "", "", "", "C", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "=", ".",
			"0", "/" };
	/**
	 * 按钮
	 */
	private JButton[] buttons = new JButton[titles.length];

	/**
	 * 按钮的事件监听器
	 */
	private Controller controller;

	/**
	 * 设置方法注入 视图所需的控制器
	 * 
	 * @param controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * 构造方法
	 */
	public CalcJFrame(Controller controller) {
		this.controller = controller;
		initUi();
		setVisible(true);
	}

	private void initUi() {
		setTitle("计算器--cql作品");
		setSize(320, 480);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// 添加结果标签
		labelResult = new JLabel("0.0");
		// 设置四边间距
		labelResult.setBorder(new EmptyBorder(30, 10, 30, 10));
		// 设置右对齐
		labelResult.setHorizontalAlignment(SwingConstants.RIGHT);
		// 设置字体
		labelResult.setFont(new Font("微软雅黑", Font.PLAIN, 32));
		// 添加文本框到最上边
		add(labelResult, BorderLayout.NORTH);

		// 按钮面板
		JPanel buttonPanel = new JPanel();
		// 设置布局
		buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
		// 按钮面板添加到窗口的中间
		add(buttonPanel, BorderLayout.CENTER);

		for (int i = 0; i < titles.length; i++) {
			if (titles[i].length() == 0) {
				// 不显示内容的标签
				buttonPanel.add(new JLabel(""));
			} else {
				// 按钮
				buttons[i] = new JButton(titles[i]);
				
				buttons[i].setActionCommand(titles[i]);

				// 设置按钮的点击事件监听器
				buttons[i].addActionListener(controller);
				buttonPanel.add(buttons[i]);

			}
		}

	}

	@Override
	/*
	 * 模型更新视图，是模型调用的 (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		String result = (String) arg;
		labelResult.setText(result);

	}

	// @Override
	// public void showInput() {
	// labelResult.setText(calc.getResult());
	//
	// }
	//
	// @Override
	// public void showResult() {
	//
	// }

}
