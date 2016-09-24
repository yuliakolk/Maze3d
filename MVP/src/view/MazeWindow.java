package view;
import java.util.Observable;
import java.util.Observer;
import algorithms.mazeGenerators.Position;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;

public class MazeWindow extends BaseWindow implements View, Observer {

	private MazeDisplay mazeDisplay;
	private Character character;
	private int[][] crossSection;
	
	
	@Override
	protected void initWidgets() {
		GridLayout grid = new GridLayout(2, false);
		shell.setLayout(grid);
		
		Composite buttons = new Composite(shell, SWT.NONE);
		RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
		buttons.setLayout(rowLayout);
		
		Button btnGenerateMaze = new Button(buttons, SWT.PUSH);
		btnGenerateMaze.setText("Generate maze");
		
		btnGenerateMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GenerateMazeWindow win = new GenerateMazeWindow();	
				win.addObserver(MazeWindow.this);
				win.start(display);
				
				//notifyObservers("generate_3d_maze chen 5 5 3" );
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button btnSolveMaze = new Button(buttons, SWT.PUSH);
		btnSolveMaze.setText("Solve maze");
		
		mazeDisplay = new MazeDisplay(shell, SWT.BORDER);	
		this.setMazeDisplay(mazeDisplay);
		mazeDisplay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		mazeDisplay.setFocus();
		
		btnSolveMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				SolveWindow win = new SolveWindow();
				win.addObserver(MazeWindow.this);
				win.start(display);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public MazeDisplay getMazeDisplay() {
		return mazeDisplay;
	}

	public void setMazeDisplay(MazeDisplay mazeDisplay) {
		int[][] mazeData={
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,1,1,0,1,0,0,1},
				{0,0,1,1,1,1,1,0,0,1,0,1,0,1,1},
				{1,1,1,0,0,0,1,0,1,1,0,1,0,0,1},
				{1,0,1,0,1,1,1,0,0,0,0,1,1,0,1},
				{1,1,0,0,0,1,0,0,1,1,1,1,0,0,1},
				{1,0,0,1,0,0,1,0,0,0,0,1,0,1,1},
				{1,0,1,1,0,1,1,0,1,1,0,0,0,1,1},
				{1,0,0,0,0,0,0,0,0,1,0,1,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,0,1,1}
			};
		this.mazeDisplay.setMazeData(mazeData);
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	@Override
	public void notifyMazeIsReady(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMaze(Maze3d maze,String name) {
		Position startPos =maze.getStartPosition();
		//this.mazeDisplay.setCharacterPos(startPos);
		this.crossSection = maze.getCrossSectionByZ(0);
		int [][]mazeData=maze.getCrossSectionByZ(0);
		mazeDisplay.setMazeData(mazeData);
//		for(int i=0 ; i<maze.getFloors();i++){
//			int [][]mazeData=maze.getCrossSectionByZ(i);
//			mazeDisplay.setMazeData(mazeData);
//		}
		
	}

	@Override
	public void dir(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displaySolution(Solution sol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printCrossSectionBy(int[][] arr, int a, int b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayMessage(String name) {
		//MessageBox msg = new MessageBox(shell, SWT.OK);
		//msg.setText("Title");
		//msg.setMessage("maze " + name + " is ready");
		notifyObservers("display "+name);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		notifyObservers(arg);
	}

}
