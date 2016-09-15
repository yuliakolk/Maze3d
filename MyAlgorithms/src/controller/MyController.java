package controller;

import java.util.HashMap;

import model.Model;
import algorithms.mazeGenerators.Maze3d;
import view.View;

public class MyController implements Controller {
	
	private View view;
	private Model model;
	private CommandsManager commandsManager;
	
	
	public MyController(View view,Model model ){
		this.view = view;
		commandsManager = new CommandsManager(model, view);
		view.setCommands(commandsManager.getCommandsMap());
	}

	@Override
	public Maze3d notifyMazeIsReady(String name) {
		return model.displayMaze(name);

	}
	
//
}
