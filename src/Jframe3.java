import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Jframe3 extends JFrame implements MouseListener{
	BufferedImage img=null;
	int x=0,y=0;
	public Jframe3()
	{
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("五子棋");
		this.setSize(330,510);
		this.setLocation((width-500)/2, (height-500)/2);
		this.addMouseListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try{
			img=ImageIO.read(new File("src\\picture\\3.jpeg"));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		this.repaint();
	}
	@Override
	public void paint(Graphics g)
	{
		g.drawImage(img, 0,20,this);
		/*g.drawRect(88,165, 140, 30);
		g.drawRect(88,225, 140, 30);
		g.drawRect(88,280, 140, 30);*/
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x=e.getX();
		y=e.getY();
		if(x>=88&&x<=228&&y>=165&&y<=195){
			this.setVisible(false);
			Jframe4 jframe4=new Jframe4();
			
		}
		else if(x>=88&&x<=228&&y>=225&&y<=255)
		{
			this.setVisible(false);
			@SuppressWarnings("unused")
			Jframe1 jframe1=new Jframe1();
		}
		else if(x>=88&&x<=228&&y>=280&&y<=310)
		{
			JOptionPane.showMessageDialog(this, "暂无其他相关信息");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
