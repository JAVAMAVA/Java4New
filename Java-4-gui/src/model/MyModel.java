package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import algorithms.mazeGenerators.DFSMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.RandomMazeGenerator;
import algorithms.search.AStar;
import algorithms.search.BFS;
import algorithms.search.Solution;
import algorithms.search.TestSearcher;

/**
 * 
 * MyModel is an observable type class from the MVP pattern that implements Model
 * 
 * @author Michael & Amit
 * @see Model
 * @see java.util.Observable
 * 
 */

public class MyModel extends java.util.Observable implements Model { 
	
	ThreadPoolExecutor pool;
	HashMap<Maze,Solution> mazeSolutions;
	HashMap<String,Maze> mazeNames;
	Maze currMaze;
	Solution currSol;
	String mazeAlg="DFS";
	String solveAlg="Bfs";
	
	
	public MyModel(int SizeOfThreadPool) {
		mazeNames=new HashMap<>();
		mazeSolutions =new HashMap<>();
		pool = new ThreadPoolExecutor(0, SizeOfThreadPool, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4));
		ConcurrentHashMap<Maze,Solution> mazeSolutions = new ConcurrentHashMap<Maze,Solution>();
		ConcurrentHashMap<String,Maze> mazeNames = new ConcurrentHashMap<String, Maze>();
	}
	/**
	 * generateMaze is a public method for generating a maze
	 * the method uses the threadpool
	 * @param maze hold the generated maze 
	 *  
	 */

	@Override
	public void generateMaze(String name,int rows, int cols ) { 
		System.out.println("Generating Maze");
		Maze maze = null;
		checkMaze(name);
		
		switch(mazeAlg){
		case "DFS":
			Future<Maze> m = pool.submit(new Callable<Maze>(){
				@Override
				public Maze call() throws Exception {
					DFSMazeGenerator dm = new DFSMazeGenerator();
					return (dm.generateMaze(rows, cols));
				}
			}
			);
			try {
				maze  = m.get();
				mazeNames.put(name, maze);
				currMaze = maze;
				mazeNames.put(name, currMaze);
				setChanged();
				notifyObservers("Maze generated");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} catch (ExecutionException e) {
				
				e.printStackTrace();
			}
			break;
		case "Random":
			Future<Maze> mr = pool.submit(new Callable<Maze>(){
				@Override
				public Maze call() throws Exception {
					RandomMazeGenerator dm = new RandomMazeGenerator();
					return (dm.generateMaze(rows, cols));
				}
			}
			);
			try {
				maze  = mr.get();
				mazeNames.put(name, maze);
				currMaze = maze;
				mazeNames.put(name, currMaze);
				setChanged();
				notifyObservers("Maze generated");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			} catch (ExecutionException e) {
				
				e.printStackTrace();
			}
			break;
		}	
	}
	/**
	 * getMaze sends the maze that was generated last
	 */
	@Override
	public Maze getMaze() {
		return currMaze;
	}
	/**
	 * solveMaze a public method that gets a maze name, and solves the main if exists
	 * the method uses the threadpool pool
	 * @param solution holds the solution that was made
	 */
	@Override
	public void solveMaze(String name) {
		if(mazeNames!=null && mazeNames.get(name)!=null)
		{
		
		System.out.println("Solving Maze");
		Solution solution;
		
		switch(solveAlg){
		case "Bfs":
			Future<Solution> sm = pool.submit(new Callable<Solution>(){
				@Override
				public Solution call() throws Exception {
					NewMazeDomain m = new NewMazeDomain(mazeNames.get(name));
					m.setMatrix(mazeNames.get(name));
					TestSearcher ts = new TestSearcher();
					ts.Test(new BFS(),m );
				
					return ts.getSolutionSearcher();
				}	
			});
			try {
				solution = sm.get();
				currSol = solution;
				mazeSolutions.put(mazeNames.get(name), currSol);
				setChanged();
				notifyObservers("maze solved");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			break;
		case "Astar":
			Future<Solution> am = pool.submit(new Callable<Solution>(){
				@Override
				public Solution call() throws Exception {
					NewMazeDomain m = new NewMazeDomain(mazeNames.get(name));
					m.setMatrix(mazeNames.get(name));
					TestSearcher ts = new TestSearcher();
					ts.Test(new AStar(),m );
				
					return ts.getSolutionSearcher();
				}	
			});
			try {
				solution = am.get();
				currSol = solution;
				mazeSolutions.put(mazeNames.get(name), currSol);
				setChanged();
				notifyObservers("maze solved");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			break;
		}
		}
		
		else
			{
			setChanged();
			notifyObservers("Maze was not found");
			
			}
		
		
		
		
	}
	/**
	 * getSolution sends the solution that was generated last
	 */
	@Override
	public Solution getSolution(String name) {	
		return currSol;
	}

	@Override
	public void stop() {
		try {
			pool.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
		
		
		
	}
	/**
	 * this method checks if the maze solution is already in the hashmap
	 * @param mazeName used to check if solution exists already 
	 */
	
	public void checkSolution(String name){
		if(mazeNames.get(name) != null){
			currMaze = mazeNames.get(name);
			if(mazeSolutions.get(currMaze) != null){
				setChanged();
				notifyObservers("solution found");
			}
			else{
				setChanged();
				notifyObservers("solution not found");
			}
		}
		else{
			setChanged();
			notifyObservers("Maze was not found");
		}
	}
	/**
	 * the method checks if the maze exists
	 * @param name the maze name we got
	 */
	public void checkMaze(String name){
		if(mazeNames!=null)
		{
		if(mazeNames.get(name) != null){
			currMaze = mazeNames.get(name);
			setChanged();
			notifyObservers("Maze already exists");
		}
		}
	}
	/**
	 * saveToFile takes the mazeSolution map and compresses it using zip format
	 * @param arg saves the hashmap as a string
	 * @param zos the zip outputstream 
	 */
	
	public void saveToFile(){
		
		String arg = mazeSolutions.toString();
		ZipOutputStream zos = null;
	    try {
	    	File file= new File(arg);
	      String name = file.getName();
	      zos = new ZipOutputStream(new FileOutputStream("myHashZip.zip"));

	      ZipEntry entry = new ZipEntry(name);
	      zos.putNextEntry(entry);

	      FileInputStream fis = null;
	      try {
	        fis = new FileInputStream(file);
	        byte[] byteBuffer = new byte[1024];
	        int bytesRead = -1;
	        while ((bytesRead = fis.read(byteBuffer)) != -1) {
	          zos.write(byteBuffer, 0, bytesRead);
	        }
	        zos.flush();
	      } finally {
	        try {
	          fis.close();
	        } catch (Exception e) {
	        }
	      }
	      zos.closeEntry();

	      zos.flush();
	    } catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
	      try {
	        zos.close();
	      } catch (Exception e) {
	      }
	    }
	}
	/**
	 * readFromFile is a method that takes a compressed zip file with an hashmap<maze,solution> and decompresses it
	 */
	public void readFromFile(){
		 byte[] buffer = new byte[1024];
	     File file= new File("myHashZip.zip");
	     
	     try{
	 
	    	//create output directory is not exists
	    	File folder = new File(file.getParent());
	    	if(!folder.exists()){
	    		folder.mkdir();
	    	}
	 
	    	//get the zip file content
	    	ZipInputStream zis = 
	    		new ZipInputStream(new FileInputStream("myHashZip.zip"));
	    	//get the zipped file list entry
	    	ZipEntry ze = zis.getNextEntry();
	 
	    	while(ze!=null){
	 
	    	   String fileName = ze.getName();
	           File newFile = new File(file.getParent() + File.separator + fileName);
	 
	           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
	 
	            //create all non exists folders
	            //else you will hit FileNotFoundException for compressed folder
	            new File(newFile.getParent()).mkdirs();
	 
	            FileOutputStream fos = new FileOutputStream(newFile);             
	 
	            int len;
	            while ((len = zis.read(buffer)) > 0) {
	       		fos.write(buffer, 0, len);
	            }
	 
	            fos.close();   
	            ze = zis.getNextEntry();
	    	}
	 
	        zis.closeEntry();
	    	zis.close();
	 
	    	System.out.println("Done");
	 
	    }catch(IOException ex){
	       ex.printStackTrace(); 
	    }
		
	}
	/**
	 * the method gets the maze from the hashtable if exists and notifies the Observer
	 */
	@Override
	public void getMazeInModel(String arg) {
		if(mazeNames!=null)
		{
			if(mazeNames.get(arg)!=null)
				{
					setChanged();
					currMaze=mazeNames.get(arg);
					notifyObservers("Maze was found");
				
				}
		}
		else {
			setChanged();
			notifyObservers("Maze was not found");
			}
		
		
	}
	/**
	 *  the method gets the solution from the hashtable if exists and notifies the Observer
	 */
	@Override
	public void getSolutionInModel(String arg) {
		
		if(mazeNames.get(arg)!=null)
		{
			if(mazeSolutions.get(mazeNames.get(arg))!=null)
			{
				setChanged();
				currSol=mazeSolutions.get(mazeNames.get(arg));
				notifyObservers("Solution was found");
				
			}
		}
		else {
			setChanged();
			notifyObservers("Maze was not found");
			}
		
	}
	
	
}