package boot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import algorithms.demo.SearchableMaze3d;
import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Maze3dGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.Bfs;
import algorithms.search.Solution;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

public class Run {
	public static void main(String[] args) throws IOException {		
		Maze3dGenerator generator = new GrowingTreeGenerator();
		Maze3d maze = generator.generate(5, 5, 3);
		System.out.println(maze);
		MyCompressorOutputStream out =new MyCompressorOutputStream(new FileOutputStream("2.maz"));
		out.write(maze.toByteArray());
		MyDecompressorInputStream in=new MyDecompressorInputStream(new FileInputStream("2.maz"));
		byte n[]=new byte[maze.toByteArray().length];
		in.read(n);
		in.close();
		System.out.println(n);
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
		
//		System.out.println(maze);
		
//		SearchableMaze3d adapter = new  SearchableMaze3d(maze);
//		BFS<Position> bfs = new BFS<Position>();
//		Solution<Position> solution = bfs.search(adapter);
//		System.out.println(solution);
		
//		// save it to a file
//		OutputStream out;
//		try {
//			out = new MyCompressorOutputStream(
//					new FileOutputStream("1.maz"));
//			byte[] arr = maze.toByteArray();
//			
//			out.write(arr.length);
//			out.write(arr);
//			out.flush();
//			out.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		
//		InputStream in;
//		try {
//			in = new MyDecompressorInputStream(
//				new FileInputStream("1.maz"));
//			int size = in.read();			
//			byte b[]=new byte[size];
//			in.read(b);
//			in.close();	
//			
//			Maze3d loaded = new Maze3d(b);
//			System.out.println("maze loaded from file:");
//			System.out.println(loaded.equals(maze));
//			//System.out.println(loaded);
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
}
