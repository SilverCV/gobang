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
	String Message="黑方先行";
	BufferedImage img=null;
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	File destFile=new File("src\\picture\\1.jpg");
	public Jframe1()
	{
		this.setTitle("五子棋 ");
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
        ImageBuffer = this.createImage(this.getWidth(), this.getHeight());//创建图形缓冲区  
        Graphics GraImage = ImageBuffer.getGraphics();//获取图形缓冲区的图形上下文  
       paint(GraImage);//用paint方法中编写的绘图过程对图形缓冲区绘图  
       GraImage.dispose();//释放图形上下文资源  
       g.drawImage(ImageBuffer, 0, 0, this);//将图形缓冲区绘制到屏幕上  
   }
	@SuppressWarnings("static-access")
	@Override
	public void paint(Graphics g)
	{
		Color c=g.getColor();
		g.drawImage(img, 0, 20, this);
		g.setFont(new Font("黑体",Font.BOLD,20));
		g.drawString("游戏信息:"+Message, 30,60);
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
		g.drawString(new String("黑方时间："), 30, 470);
		g.drawRect(230, 450, 160,40);
		g.drawString(new String("白方时间:"), 230, 470);
		g.setFont(new Font("宋体",Font.BOLD,20));
		g.drawString(new String("现在开始"), 450, 90);
		g.drawString(new String("投降认输"), 450, 270);
		g.drawString(new String("退出本局"), 450, 410);
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
			int count=1;//判断竖向的情况
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
			//判断横直的情况
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
			//判断从左上到右下
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
			//判断从左下到右上
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
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		int flag;
		 x=arg0.getX();
		 y=arg0.getY();
		if(x>=450&&x<=530&&y>=70&&y<=110){
			GamePlay=true;
			JOptionPane.showMessageDialog(this, "游戏开始");
		}
		else if(x>=450&&x<=530&&y>=250&&y<=290&&GamePlay==true){
			if(isBlack==true){
				JOptionPane.showMessageDialog(this, "黑方投降，白方胜利");
				GamePlay=false;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "白方投降，黑方胜利");
				GamePlay=false;
			}
		}
		else if(x>=450&&x<=530&&y>=390&&y<=430&&GamePlay==true)
		{
			JOptionPane.showConfirmDialog(this, "是否退出游戏？");
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
				Message="轮到白棋";
				isBlack=false;
				isWhite=true;
				flag=Check(x,y);
				if(flag==1)
					JOptionPane.showMessageDialog(this, "游戏结束，黑方胜利，白方失败");
				}
				else
					JOptionPane.showMessageDialog(this, "此处已经有棋子了");
			}
			else
			{
				if(allchess[x][y]==0){
				allchess[x][y]=2;
				isBlack=true;
				isWhite=false;
				Message="轮到黑棋";
				flag=Check(x,y);
				if(flag==1)
					JOptionPane.showMessageDialog(this, "游戏结束，白方胜利，黑方失败");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "此处已经有棋子了");
				}
			}
			
		}
		else if(GamePlay!=true)
		{
			for(int i=0;i<19;i++)
				for(int j=0;j<19;j++)
					allchess[i][j]=0;
			Message="黑方优先";
			isBlack=true;
			isWhite=false;
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
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
