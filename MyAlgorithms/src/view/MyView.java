package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.search.Solution;
import controller.Command;
import controller.Controller;
import controller.MyController;
import io.MyCompressorOutputStream;

public class MyView implements View {

	private BufferedReader in;
	private PrintWriter out;
	private CLI cli;
	private Controller controller;
	
	public MyView(BufferedReader in, PrintWriter out) {
		this.in = in;
		this.out = out;
				
		cli = new CLI(in, out);
	}
	
@SuppressWarnings("static-access")
	
	/**
	 * this method will get an input from the user and will return the input to the controller
	 * in this layer in mvc design pattern the view layer responsibility on the user input
	 * @return the input 
	 */
	public int OnInputRecieved()
	{
		
			String input = null;
			try {
				input=in.readLine();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		return new Integer(0).parseInt(input);
		
	}
	
	/**
	 * this method will get an string input from the user and will return the input to the controller
	 * in this layer in mvc design pattern the view layer responsibility on the user input
	 * @return the input 
	 */
	public String OnStringRecieved()
	{

		String input = null;
		try {
			input=in.readLine();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	return input;
	}
	
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void notifyMazeIsReady(String name) {
		out.println("maze " + name + " is ready");
		out.flush();

	}

	@Override
	public void displayMaze(Maze3d maze) {
		out.println(maze);
		out.flush();
	}

	@Override
	public void setCommands(HashMap<String, Command> commands) {
		cli.setCommands(commands);
	}
	
	public void start() {
		// TODO Auto-generated method stub
		cli.start();
	}
	
	/**
	 * this method will print all file in the path
	 * @param path
	 */
	public void dir (String path)
	{
        File directory = new File(path);
        //get all the files from a directory
        File[] filesList = directory.listFiles();
        for (File file : filesList){
        	out.println(file.getName());
        }
    }

	/**
	 * 
	 * @param input- witch cross by you want to use x,y,z
	 * @param name of the maze you want to cross by
	 */
	public void printCrossSectionBy(String input,String name){
		int [][] cs;
		
		if (input.equals("x")||input.equals("X")) {
			
			out.println("enter the X section that oyu want to cross by");
			out.flush();
			
			int x=OnInputRecieved();
			cs=controller.notifyMazeIsReady(name).getCrossSectionByX(x);
		}
		if (input.equals("y")||input.equals("Y")) {
			
			out.println("enter the Y section that oyu want to cross by");
			out.flush();
			
			int y=OnInputRecieved();
			cs=controller.notifyMazeIsReady(name).getCrossSectionByY(y);
		}
		if (input.equals("z")||input.equals("Z")) {
			
			out.println("enter the Z section that oyu want to cross by");
			out.flush();
			
			int z=OnInputRecieved();
			cs=controller.notifyMazeIsReady(name).getCrossSectionByZ(z);
	}
}

	public void displaySolution(Solution sol){
		for (int i = 0; i < sol.getStates().size(); i++) 
		{
			out.println(sol.getStates().get(i));
			out.flush();
		}
}
	
	@Override
	public void displayMessage(String msg) {
		out.println(msg);
		out.flush();		
	}

	
}

		
