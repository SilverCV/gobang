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
public class Jframe2 extends JFrame implements MouseListener{
	BufferedImage img=null;
	int x=0,y=0;
	public Jframe2()
	{
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("五子棋");
		this.setSize(330,600);
		this.setLocation((width-500)/2, (height-500)/2);
		this.addMouseListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try{
			img=ImageIO.read(new File("src\\picture\\2.jpg"));
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
		/*g.drawRect(85,190, 145, 45);
		g.drawRect(85,250, 145, 45);
		g.drawRect(85,310, 145, 45);*/
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
		if(x>=85&&x<=230&&y>=190&&y<=235){
			this.setVisible(false);
			@SuppressWarnings("unused")
			Jframe3 jframe3=new Jframe3();
		}
		else if(x>=85&&x<=230&&y>=250&&y<=295)
		{
			JOptionPane.showMessageDialog(this, "暂无");
		}
		else if(x>=85&&x<=230&&y>=310&&y<=355)
		{
			JOptionPane.showMessageDialog(this, "暂无");
		}
		else if(x>=85&&x<=230&&y>=370&&y<=415)
		{
			System.exit(0);
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
