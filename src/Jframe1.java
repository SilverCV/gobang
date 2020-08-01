import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

@SuppressWarnings("serial")
public class Jframe1 extends JFrame implements MouseListener,Runnable{
	boolean GamePlay=false;
	boolean isBlack=true;
	boolean isWhite=false;
	Image ImageBuffer=null;
	int x=0,y=0;
	Thread t=new Thread(this);
	int[][] allchess=new int[19][19];
	//MouseClick m=new MouseClick();
	String Message="�ڷ�����";
	BufferedImage img=null;
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	File destFile=new File("src\\picture\\1.jpg");
	public Jframe1()
	{
		this.setTitle("������ ");
		this.setSize(600,500);
		this.setLocation((width-500)/2, (height-500)/2);
		this.setVisible(true);
		this.addMouseListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try{
			img=ImageIO.read(destFile);
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		t.start();
	}
	@Override
	 public void update(Graphics g){
		if(ImageBuffer==null)
        ImageBuffer = this.createImage(this.getWidth(), this.getHeight());//����ͼ�λ�����  
        Graphics GraImage = ImageBuffer.getGraphics();//��ȡͼ�λ�������ͼ��������  
       paint(GraImage);//��paint�����б�д�Ļ�ͼ���̶�ͼ�λ�������ͼ  
       GraImage.dispose();//�ͷ�ͼ����������Դ  
       g.drawImage(ImageBuffer, 0, 0, this);//��ͼ�λ��������Ƶ���Ļ��  
   }
	@SuppressWarnings("static-access")
	@Override
	public void paint(Graphics g)
	{
		Color c=g.getColor();
		g.drawImage(img, 0, 20, this);
		g.setFont(new Font("����",Font.BOLD,20));
		g.drawString("��Ϸ��Ϣ:"+Message, 30,60);
		for(int i=0;i<19;i++)
		{
			g.drawLine(30, 70+20*i, 390, 70+20*i);
			g.drawLine(30+20*i, 70, 30+20*i, 430);
		}
		g.setColor(c.blue);
		g.drawRect(450, 70, 80, 40);
		g.fillRect(450, 70, 80, 40);
		g.drawRect(450, 250, 80, 40);
		g.fillRect(450, 250, 80, 40);
		g.drawRect(450, 390, 80, 40);
		g.fillRect(450, 390, 80, 40);
		g.setColor(c.black);
		g.setFont(new Font("",Font.PLAIN,20));
		g.drawRect(30, 450, 160,40);
		g.drawString(new String("�ڷ�ʱ�䣺"), 30, 470);
		g.drawRect(230, 450, 160,40);
		g.drawString(new String("�׷�ʱ��:"), 230, 470);
		g.setFont(new Font("����",Font.BOLD,20));
		g.drawString(new String("���ڿ�ʼ"), 450, 90);
		g.drawString(new String("Ͷ������"), 450, 270);
		g.drawString(new String("�˳�����"), 450, 410);
		g.drawOval(108, 128, 4, 4);
		g.fillOval(108, 128, 4, 4);
		g.drawOval(108, 248, 4, 4);
		g.fillOval(108, 248, 4, 4);
		g.drawOval(108, 368, 4, 4);
		g.fillOval(108, 368, 4, 4);
		g.drawOval(208, 128, 4, 4);
		g.fillOval(208, 128, 4, 4);
		g.drawOval(208, 248, 4, 4);
		g.fillOval(208, 248, 4, 4);
		g.drawOval(208, 368, 4, 4);
		g.fillOval(208, 368, 4, 4);
		g.drawOval(308, 128, 4, 4);
		g.fillOval(308, 128, 4, 4);
		g.drawOval(308, 248, 4, 4);
		g.fillOval(308, 248, 4, 4);
		g.drawOval(308, 368, 4, 4);
		g.fillOval(308, 368, 4, 4);
		for(int i=0;i<19;i++)
		for(int j=0;j<19;j++)
		{
			if(allchess[i][j]==1)
			{
				g.setColor(c.black);
				g.drawOval(i*20+23, j*20+63, 14, 14);
				g.fillOval(i*20+23, j*20+63, 14, 14);
			}
			else if(allchess[i][j]==2)
			{
				g.setColor(c.white);
				g.drawOval(i*20+23, j*20+63, 14, 14);
				g.fillOval(i*20+23, j*20+63, 14, 14);
			}
		}
	}
	public int Check(int x,int y)
	{
		int i=x,j=y;
		int flag=0;
		if(allchess[i][j]!=0)
		{
			int count=1;//�ж���������
			int m=i,k=j;
			while(j>0&&allchess[i][j]==allchess[i][j-1]&&flag!=1)
			{
				count++;
				if(count==5)
				{
					GamePlay=false;
					flag=1;
					break;
				}
				j--;
			}
			j=k;
			while(j<18&&allchess[i][j]==allchess[i][j+1]&&flag!=1)
			{
				count++;
				if(count==5)
				{
					GamePlay=false;
					flag=1;
					break;
				}
				j++;
			}
			//�жϺ�ֱ�����
			count=1;
			j=k;
			while(i>0&&allchess[i][j]==allchess[i-1][j]&&flag!=1)
			{
				count++;
				if(count==5)
				{
					GamePlay=false;
					flag=1;
					break;
				}
				i--;
			}
			i=m;
			while(j<18&&allchess[i][j]==allchess[i+1][j]&&flag!=1)
			{
				count++;
				if(count==5)
				{
					GamePlay=false;
					flag=1;
					break;
				}
				i++;
			}
			//�жϴ����ϵ�����
			count=1;
			i=m;j=k;
			while(j>0&&i>0&&allchess[i][j]==allchess[i-1][j-1]&&flag!=1)
			{
				count++;
				if(count==5)
				{
					GamePlay=false;
					flag=1;
					break;
				}
				i--;
				j--;
			}
			i=m;j=k;
			while(j<18&&i<18&&allchess[i][j]==allchess[i+1][j+1]&&flag!=1)
			{
				count++;
				if(count==5)
				{
					GamePlay=false;
					flag=1;
					break;
				}
				j++;
				i++;
			}
			//�жϴ����µ�����
			count=1;
			i=m;j=k;
			while(i>0&&j<18&&allchess[i][j]==allchess[i-1][j+1]&&flag!=1)
			{
				count++;
				if(count==5)
				{
					GamePlay=false;
					flag=1;
					break;
				}
				i--;
				j++;
			}
			i=m;j=k;
			while(j>0&&i<18&&allchess[i][j]==allchess[i+1][j-1]&&flag!=1)
			{
				count++;
				if(count==5)
				{
					GamePlay=false;
					flag=1;
					break;
				}
				j--;
				i++;
			}
		}
		return flag;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		int flag;
		 x=arg0.getX();
		 y=arg0.getY();
		if(x>=450&&x<=530&&y>=70&&y<=110){
			GamePlay=true;
			JOptionPane.showMessageDialog(this, "��Ϸ��ʼ");
		}
		else if(x>=450&&x<=530&&y>=250&&y<=290&&GamePlay==true){
			if(isBlack==true){
				JOptionPane.showMessageDialog(this, "�ڷ�Ͷ�����׷�ʤ��");
				GamePlay=false;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "�׷�Ͷ�����ڷ�ʤ��");
				GamePlay=false;
			}
		}
		else if(x>=450&&x<=530&&y>=390&&y<=430&&GamePlay==true)
		{
			JOptionPane.showConfirmDialog(this, "�Ƿ��˳���Ϸ��");
			GamePlay=false;
		}
		x=(x-30)/20;
		y=(y-70)/20;
		if(GamePlay==true&&x>=0&&x<19&&y>=0&&y<19)
		{
			if(isBlack==true)
			{
				if(allchess[x][y]==0){
				allchess[x][y]=1;
				Message="�ֵ�����";
				isBlack=false;
				isWhite=true;
				flag=Check(x,y);
				if(flag==1)
					JOptionPane.showMessageDialog(this, "��Ϸ�������ڷ�ʤ�����׷�ʧ��");
				}
				else
					JOptionPane.showMessageDialog(this, "�˴��Ѿ���������");
			}
			else
			{
				if(allchess[x][y]==0){
				allchess[x][y]=2;
				isBlack=true;
				isWhite=false;
				Message="�ֵ�����";
				flag=Check(x,y);
				if(flag==1)
					JOptionPane.showMessageDialog(this, "��Ϸ�������׷�ʤ�����ڷ�ʧ��");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "�˴��Ѿ���������");
				}
			}
			
		}
		else if(GamePlay!=true)
		{
			for(int i=0;i<19;i++)
				for(int j=0;j<19;j++)
					allchess[i][j]=0;
			Message="�ڷ�����";
			isBlack=true;
			isWhite=false;
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(true){
		this.repaint();
		try{
			Thread.sleep(500);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	}
}
