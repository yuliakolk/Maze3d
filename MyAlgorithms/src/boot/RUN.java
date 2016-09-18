package boot;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;
import algorithms.demo.SearchableMaze3d;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.State;

public class RUN {

	public static void main(String[] args) throws IOException {
	
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
//				
//		View view = new MyView(in, out);
//		Model model = new MyModel();
//		
//		Presenter controller = new MyController(view, model);
//		model.setController(controller);
//		
//		view.start();
		
//		Maze3dGenerator generator = new GrowingTreeGenerator();
//		Maze3d maze = generator.generate(5, 5, 3);
//		System.out.println(maze);
//		
//		// save it to a file
//		OutputStream out=new MyCompressorOutputStream(new FileOutputStream("1.maz"));
//		out.write(maze.toByteArray());
//		out.flush();
//		out.close();
//		InputStream in=new MyDecompressorInputStream(new FileInputStream("1.maz"));
//		byte b[]=new byte[maze.toByteArray().length];
//		in.read(b);
//		in.close();
//		Maze3d loaded=new Maze3d(b);
//		System.out.println(loaded.equals(maze));
		
//		Maze3dGenerator generator = new GrowingTreeGenerator();
//		Maze3d maze = generator.generate(5, 5, 3);
//		System.out.println(maze);
		
//		//creating a searcher with BFS searcher
//		Searcher tester1=new BFS();
//		//saving the solution with the BFS algorithm on local var "sol"
//		Solution sol1=tester1.search(new SearchableMaze3d(maze));
//		displaySolution(sol1);
//		
//		System.out.println();
//		
//		//creating a searcher with DFS searcher
//		Searcher tester2=new DFS();
//		//saving the solution with the DFS algorithm on local var "sol"
//		Solution sol2=tester2.search(new SearchableMaze3d(maze));
//		displaySolution(sol2);
//	}
//		
//		public static void displaySolution(Solution sol){
//			for (int i = sol.getStates().size()-1; i >= 0 ; i--) 
//			{
//				State<Position> state = (State<Position>)sol.getStates().get(i);
//				
//				if (state != null)
//				{
//					System.out.println(state.getValue());
//					System.out.flush();
//				}
//			}
//	}
	}}


