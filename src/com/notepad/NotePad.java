/*
 * ��дһ�����±�������+���ܣ�
 */
package com.notepad;

import javax.swing.*;

public class NotePad extends JFrame{
	
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
		jmiSave = new JMenuItem("����");
		
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

}
