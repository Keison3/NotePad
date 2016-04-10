/*
 * 编写一个记事本（界面+功能）
 */
package com.notepad;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class NotePad extends JFrame implements ActionListener{
	
	//定义组件
	TextArea jta = null;
	
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
		jta = new TextArea("",50,50,TextArea.SCROLLBARS_VERTICAL_ONLY);//参数设置了TextArea的一行的长度还有滚动条
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
		this.setSize(600,500);
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
	public void actionPerformed(ActionEvent e)//监听器监听到动作后的执行函数 ：ActionEvent是一个对控件的获取的一个类
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
			
			//显示了文件选择的dialog后可以选择具体路径下的文件
			//得到所选路径
			//得到所选文件的全路径
			String filePath = jfc.getSelectedFile().getAbsolutePath();
			if (filePath==null) {
				return;
			}
			//测试看是否获取了改文件
			//System.out.println(filePath);
			//使用缓冲字符流读取所选文件的内容
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			try {
				fileReader = new FileReader(filePath);
				bufferedReader = new BufferedReader(fileReader);
				
				//读取后显示信息在jta上
				String string = "";
				String allContent = "";
				while ((string=bufferedReader.readLine())!=null) {
					//System.out.println(string);//测试返回到string的是什么信息:经测试得到的是读取的内容
					allContent +=string+"\r\n";				
				}
				
				jta.setText(allContent);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {//对于打开的IO流一定要给予关闭
				try {
					bufferedReader.close();
					fileReader.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		}
		else if (e.getActionCommand().equals("save")) {
			//System.out.println("save");
			//设置选择文件组件的标题
			jfc.setDialogTitle("保存");
			//选择打开的方式
			jfc.showSaveDialog(null);
			//显示
			jfc.setVisible(true);
			//获取保存的路径
			String filePath =jfc.getSelectedFile().getAbsolutePath();
			if (filePath==null) {
				return;
			}
			
			//获取到内容后写进文件中
			FileWriter fileWriter = null;
			BufferedWriter bufferedWriter = null;
			try {
				fileWriter = new FileWriter(filePath);
				bufferedWriter = new BufferedWriter(fileWriter);
				
				//写内容进去
				bufferedWriter.write(jta.getText());
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}finally {
				try {
					bufferedWriter.close();
					fileWriter.close();
				} catch (Exception e3) {
					// TODO: handle exception
					e3.printStackTrace();
				}
			}
			
		}
		
	}

}
