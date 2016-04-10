/*
 * ��дһ�����±�������+���ܣ�
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
	
	//�������
	TextArea jta = null;
	
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
		jta = new TextArea("",50,50,TextArea.SCROLLBARS_VERTICAL_ONLY);//����������TextArea��һ�еĳ��Ȼ��й�����
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
		this.setSize(600,500);
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
	public void actionPerformed(ActionEvent e)//�������������������ִ�к��� ��ActionEvent��һ���Կؼ��Ļ�ȡ��һ����
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
			
			//��ʾ���ļ�ѡ���dialog�����ѡ�����·���µ��ļ�
			//�õ���ѡ·��
			//�õ���ѡ�ļ���ȫ·��
			String filePath = jfc.getSelectedFile().getAbsolutePath();
			if (filePath==null) {
				return;
			}
			//���Կ��Ƿ��ȡ�˸��ļ�
			//System.out.println(filePath);
			//ʹ�û����ַ�����ȡ��ѡ�ļ�������
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			try {
				fileReader = new FileReader(filePath);
				bufferedReader = new BufferedReader(fileReader);
				
				//��ȡ����ʾ��Ϣ��jta��
				String string = "";
				String allContent = "";
				while ((string=bufferedReader.readLine())!=null) {
					//System.out.println(string);//���Է��ص�string����ʲô��Ϣ:�����Եõ����Ƕ�ȡ������
					allContent +=string+"\r\n";				
				}
				
				jta.setText(allContent);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {//���ڴ򿪵�IO��һ��Ҫ����ر�
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
			//����ѡ���ļ�����ı���
			jfc.setDialogTitle("����");
			//ѡ��򿪵ķ�ʽ
			jfc.showSaveDialog(null);
			//��ʾ
			jfc.setVisible(true);
			//��ȡ�����·��
			String filePath =jfc.getSelectedFile().getAbsolutePath();
			if (filePath==null) {
				return;
			}
			
			//��ȡ�����ݺ�д���ļ���
			FileWriter fileWriter = null;
			BufferedWriter bufferedWriter = null;
			try {
				fileWriter = new FileWriter(filePath);
				bufferedWriter = new BufferedWriter(fileWriter);
				
				//д���ݽ�ȥ
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
