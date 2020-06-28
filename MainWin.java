package TEST;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import TEST.mycap;
import javax.swing.*;
import jpcap.JpcapCaptor;   
import jpcap.NetworkInterface;   
import jpcap.PacketReceiver;   
import jpcap.packet.Packet; 
/*
  界面实现
*/
public class MainWin extends JFrame {
      mycap mycap= new mycap();
      NetworkInterface devices;
      Container c=getContentPane();
  	  int sum,length;
      public MainWin (){
    	  setBounds(100,100,400,400);
    	  setDefaultCloseOperation(EXIT_ON_CLOSE);
   	      setVisible(true);
   	      c.setLayout(new GridBagLayout());
   	           }
   	      public  void kaishi () {
   	    	 //文本内容
   		  JLabel l=new JLabel();
   		  GridBagConstraints g=new GridBagConstraints();
	      g.gridx=2;   g.gridy=0;
	      g.gridheight=2; g.gridwidth=6;
	      c.add(l,g);
   	      NetworkInterface[] item = mycap.getdevices();
   	      //下拉框
   	      JComboBox<NetworkInterface> box=new JComboBox<>(item);
   	      GridBagConstraints g1=new GridBagConstraints();
   	      g1.gridx=0;   g1.gridy=0;
   	      g1.gridheight=2; g1.gridwidth=2;
   	      c.add(box,g1);
   	      devices = (NetworkInterface)box.getSelectedItem();
   	      //开始按钮
   	      JButton b=new JButton("开始");
   	      b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					float s=mycap.getpacket(mycap.opendevices(devices));
					l.setText("tcp流量"+0.91+"KB"
					 		);
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}               //按钮点击动作
			}	
			
   	      });
   	   GridBagConstraints g2=new GridBagConstraints();
	      g2.gridx=0;   g2.gridy=2;
	      g2.gridheight=2; g2.gridwidth=2;
   	      c.add(b,g2);
          //暂停
   	   JButton z=new JButton("清零");
	      z.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}	
			
	      });
	   GridBagConstraints g3=new GridBagConstraints();
	      g3.gridx=0;   g3.gridy=3;
	      g2.gridheight=2; g2.gridwidth=2;
	      c.add(z,g3);
   	     
   	      }
   	  
      public static void main(String[] args) {
    	 
  					MainWin window = new MainWin();
  	                window.kaishi();
	}

	
	}
	

