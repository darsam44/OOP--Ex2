package Gui_graph;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JFrame;

import utils.Point3D;

public class Gui_Graph extends JFrame implements ActionListener, MouseListener
{
	LinkedList<Point3D> points = new LinkedList<Point3D>();

	public static void main(String[] args) 
	{
		Gui_Graph window = new Gui_Graph();
		window.setVisible(true);
	}
	
	public Gui_Graph()
	{
		initGUI();
	}
	
	private void initGUI() 
	{
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		menuBar.add(menu);
		this.setMenuBar(menuBar);
		
		MenuItem item1 = new MenuItem("Item 1");
		item1.addActionListener(this);
		
		MenuItem item2 = new MenuItem("Item 2");
		item2.addActionListener(this);
		
		menu.add(item1);
		menu.add(item2);
		
		this.addMouseListener(this);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Point3D prev = null;
		
		for (Point3D p : points) 
		{
			g.setColor(Color.BLUE);
			g.fillOval((int)p.x(), (int)p.y(), 10, 10);
			
			if(prev != null)
			{
				g.setColor(Color.RED);
				g.drawLine((int)p.x(), (int)p.y(), 
						(int)prev.x(), (int)prev.y());
				
				g.drawString("5", (int)((p.x()+prev.x())/2),(int)((p.y()+prev.y())/2));
			}
			
			prev = p;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();
		
		if(str.equals("Item 1"))
		{
			Point3D p1 = new Point3D(100,100);
			Point3D p2 = new Point3D(50,300);
			Point3D p3 = new Point3D(400,150);
			
			points.add(p1);
			points.add(p2);
			points.add(p3);
			
			repaint();
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	
	
}