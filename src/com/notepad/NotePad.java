/*
 * 编写一个记事本（界面+功能）
 */
package com.notepad;

import javax.swing.*;

public class NotePad extends JFrame{
	
	//定义组件
	JTextArea jta = null;
	
	//添加菜单
	JMenuBar jmb = null;
	JMenu jmFile = null;
	
	//菜单的item
	JMenuItem jmiOpen = null;
	JMenuItem jmiSave = null;
	
	public static void main(String[] args) {
		NotePad notePad = new NotePad();
	}
	
	//构造函数
	public NotePad()
	{
		jta = new JTextArea();
		jmb = new JMenuBar();
		jmFile = new JMenu("文件");
		//为菜单设置提示标识符
		jmFile.setMnemonic('F');
		jmiOpen = new JMenuItem("打开");
		jmiSave = new JMenuItem("保存");
		
		//调用添加Menu到JFrame的方法
		setMenu();
		
		//添加到JFrame
		this.add(jta);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//将JMenu加入到JFrame的方法
	public void setMenu() {
		this.setJMenuBar(jmb);
		jmb.add(jmFile);
		jmFile.add(jmiOpen);
		jmFile.add(jmiSave);
		
	}

}
