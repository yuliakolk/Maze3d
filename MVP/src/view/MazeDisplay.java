package view;
import java.util.Timer;
import java.util.TimerTask;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;


public class MazeDisplay extends Canvas {
	
	private int[][] mazeData;
	private Position characterPos;
	private Position startPos;
	private Position goalPos;
	private Character character;

	public MazeDisplay(Composite parent, int style) {
		super(parent, style);
		character = new Character();
		character.setPos(new Position(1,1));
						
		this.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				if (mazeData == null)
					return;
				
				   e.gc.setForeground(new Color(null,0,0,0));
				   e.gc.setBackground(new Color(null,0,0,0));

				   int width=getSize().x;
				   int height=getSize().y;

				   int w=width/mazeData[0].length;
				   int h=height/mazeData.length;

				   for(int i=0;i<mazeData.length;i++)
				      for(int j=0;j<mazeData[i].length;j++){
				          int x=j*w;
				          int y=i*h;
				          if(mazeData[i][j]!=0)
				              e.gc.fillRectangle(x,y,w,h);
				      }

				
			}
		});
		
		this.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				e.gc.setForeground(new Color(null,0,0,0));
				   e.gc.setBackground(new Color(null,0,0,0));
				   

				   int width = getSize().x;
				   int height = getSize().y;
				   

				   int w = width / mazeData[0].length;
				   int h = height / mazeData.length;

				   for(int i=0;i<mazeData.length;i++)
				      for(int j=0;j<mazeData[i].length;j++){
				          int x=j*w;
				          int y=i*h;
				          if(mazeData[i][j]!=0)
				              e.gc.fillRectangle(x,y,w,h);
				      }
				   character.draw(w, h, e.gc);
				
			}
		});
		
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {	
				getDisplay().syncExec(new Runnable() {					

					@Override
					public void run() {
						
						character.moveRight();
						redraw();
					}
				});
				
			}
		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 500);
	}

	public int[][] getMazeData() {
		return mazeData;
	}

	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
		try
		{
			getDisplay().syncExec(new Runnable() {					

				@Override
				public void run() {
										
					redraw();
				}
			});					
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
	}

	public Position getStartPos() {
		return startPos;
	}

	public void setStartPos(Position startPos) {
		this.startPos = startPos;
	}

	public Position getGoalPos() {
		return goalPos;
	}

	public void setGoalPos(Position goalPos) {
		this.goalPos = goalPos;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Position getCharacterPos() {
		return characterPos;
	}

	public void setCharacterPos(Position startPos2) {
		this.characterPos = startPos2;
	}
}
