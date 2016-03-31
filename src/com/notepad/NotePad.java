/*
 * ��дһ�����±�������+���ܣ�
 */
package com.notepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class NotePad extends JFrame implements ActionListener{
	
	//�������
	JTextArea jta = null;
	
	//��Ӳ˵�
	JMenuBar jmb = null;
	JMenu jmFile = null;
	
	//�˵���item
	JMenuItem jmiOpen = null;
	JMenuItem jmiSave = null;
	
	public static void main(String[] args) {
		NotePad notePad = new NotePad();
	}
	
	//���캯��
	public NotePad()
	{
		jta = new JTextArea();
		jmb = new JMenuBar();
		jmFile = new JMenu("�ļ�");
		//Ϊ�˵�������ʾ��ʶ��
		jmFile.setMnemonic('F');
		jmiOpen = new JMenuItem("��");
		
		//ע�����jmiOpen
//		jmiOpen.addActionListener(this);
//		jmiOpen.setActionCommand("open");
		
		jmiSave = new JMenuItem("����");
		//�������������ĺ���
		setListening();
		
		//�������Menu��JFrame�ķ���
		setMenu();
		
		//��ӵ�JFrame
		this.add(jta);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//��JMenu���뵽JFrame�ķ���
	public void setMenu() {
		this.setJMenuBar(jmb);
		jmb.add(jmFile);
		jmFile.add(jmiOpen);
		jmFile.add(jmiSave);
		
	}
	
	//���ʵ�ֱ�JFrame�����ĺ���,�����ø������ActionCommand
	public void setListening() {
		jmiOpen.addActionListener(this);
		jmiOpen.setActionCommand("open");
		jmiSave.addActionListener(this);
		jmiSave.setActionCommand("save");
	}

	@Override
	public void actionPerformed(ActionEvent e)//�������������������ִ�к��� 
	{
		//newһ���ļ�ѡ�����
		JFileChooser jfc = new JFileChooser();
		
		//�жϼ�����һ�������˼��������������ˣ�Ȼ��ִ����Ӧ�Ķ���
		if (e.getActionCommand().equals("open")) {
			//System.out.println("open");
			//����ѡ���ļ�ѡ������ı���
			jfc.setDialogTitle("��ѡ���ļ�...");
			//ѡ��򿪵ķ�ʽ
			jfc.showOpenDialog(null);
			//��ʾ
			jfc.setVisible(true);
		}
		else if (e.getActionCommand().equals("save")) {
			//System.out.println("save");
			//����ѡ���ļ�����ı���
			jfc.setDialogTitle("����");
			//ѡ��򿪵ķ�ʽ
			jfc.showSaveDialog(null);
			//��ʾ
			jfc.setVisible(true);
		}
		
	}

}
