/*
 * 编写一个记事本（界面+功能）
 */
package com.notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NotePad extends JFrame implements ActionListener{
	
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
		
		//注册监听jmiOpen
//		jmiOpen.addActionListener(this);
//		jmiOpen.setActionCommand("open");
		
		jmiSave = new JMenuItem("保存");
		//添加组件被监听的函数
		setListening();
		
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
	
	//组件实现被JFrame监听的函数,并设置该组件的ActionCommand
	public void setListening() {
		jmiOpen.addActionListener(this);
		jmiOpen.setActionCommand("open");
		jmiSave.addActionListener(this);
		jmiSave.setActionCommand("save");
	}

	@Override
	public void actionPerformed(ActionEvent e)//监听器监听到动作后的执行函数 
	{
		//new一个文件选择组件
		JFileChooser jfc = new JFileChooser();
		
		//判断监听哪一个设置了监听的组件被点击了，然后执行相应的动作
		if (e.getActionCommand().equals("open")) {
			//System.out.println("open");
			//设置选择文件选择组件的标题
			jfc.setDialogTitle("请选择文件...");
			//选择打开的方式
			jfc.showOpenDialog(null);
			//显示
			jfc.setVisible(true);
		}
		else if (e.getActionCommand().equals("save")) {
			//System.out.println("save");
			//设置选择文件组件的标题
			jfc.setDialogTitle("保存");
			//选择打开的方式
			jfc.showSaveDialog(null);
			//显示
			jfc.setVisible(true);
		}
		
	}

}
