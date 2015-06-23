package viewGui;

import jaco.mp3.player.MP3Player;

import java.io.File;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze;



public class MyBoard extends AbstractBoard{
 public boolean startgame;
 public String goal;
 
 public void setGoal(String goal) {
  this.goal = goal;
 }
 
 public String getGoal() {
  return goal;
 }
 
 public MyBoard(Composite parent, int style,Display display,Shell shell,Maze m) {
  super(parent, style | SWT.DOUBLE_BUFFERED,m);
  startgame=false;
  myMaze = new MyMazeDisplayer(this, this.matrix);
  this.character=new MyGameCharacter(new Image(this.getDisplay(), "ImagesCharacters//BlueBoy//BHSF.png"), 0, 0);
  addPaintListener(new PaintListener() {
   
   @Override
   public void paintControl(PaintEvent e) {
    if(boardGame==null)
     drawMaze(e);
    
    System.out.println(startgame);
    if(startgame==true)
    {
     if(character.getXCharater()!=0 && character.getYCharater()!=0)
     {
      character.setXCharater(0);
      character.setYCharater(0);
      startgame=false;
     }
    
    }
    
    character.paint(e.gc, getSize().x/matrix.getRows(), getSize().y/matrix.getCols());
    
    
    setGoal((matrix.getRows()-1)+","+(matrix.getCols()-1)); //setting goal
    
   }
 
  });
  addKeyListener(new KeyListener() { //listening to the client key arrows
   
   
   
   @Override
   public void keyReleased(KeyEvent arg0) {
    
     if (arg0.keyCode == SWT.ARROW_UP){
      character.chImage=new Image(getDisplay(), "ImagesCharacters//BlueBoy//BHSB.png");
      redraw();
      if (matrix.getCell(character.getXCharater(),character.getYCharater()).getUp()==false)
      {
      character.setMoved(true);
      
      boardGame[character.getXCharater()][character.getYCharater()].redraw();
      character.setXCharater(character.getXCharater()-1);
      String[] temp = getGoal().split(",");
      redraw();
      if (character.getXCharater()== Integer.parseInt(temp[0]) && character.getYCharater()==Integer.parseInt(temp[0]))
      {
       System.out.println("THE END");
       victory();
      }
      
      }
     }
     if (arg0.keyCode == SWT.ARROW_DOWN){
      character.chImage=new Image(getDisplay(), "ImagesCharacters//BlueBoy//BHSF.png");
      redraw();
      if (matrix.getCell(character.getXCharater(),character.getYCharater()).getDown()==false)
      {  
     
       character.setXCharater(character.getXCharater()+1);
       String[] temp = getGoal().split(",");
       redraw();
       if (character.getXCharater()== Integer.parseInt(temp[0]) && character.getYCharater()==Integer.parseInt(temp[0]))
       {
        System.out.println("THE END");
        victory();
       }
      }
     }
     if (arg0.keyCode == SWT.ARROW_LEFT){
      character.chImage=new Image(getDisplay(), "ImagesCharacters//BlueBoy//BHSL.png");
      redraw();
      if (matrix.getCell(character.getXCharater(),character.getYCharater()).getLeft()==false)
      {
      
      character.setYCharater(character.getYCharater()-1);
      String[] temp = getGoal().split(",");
       redraw();
       if (character.getXCharater()== Integer.parseInt(temp[0]) && character.getYCharater()==Integer.parseInt(temp[0]))
       {
        System.out.println("THE END");
        victory();
       }
      }
     }
     if (arg0.keyCode == SWT.ARROW_RIGHT){
      character.chImage=new Image(getDisplay(), "ImagesCharacters//BlueBoy//BHSR.png");
      redraw();
      if (matrix.getCell(character.getXCharater(),character.getYCharater()).getRight()==false)
      {
       character.setYCharater(character.getYCharater()+1);
       String[] temp = getGoal().split(",");
       redraw();
       if (character.getXCharater()== Integer.parseInt(temp[0]) && character.getYCharater()==Integer.parseInt(temp[0]))
       {
        System.out.println("THE END");
        victory();
       }
      }
     }
    
   }
   
   @Override
   public void keyPressed(KeyEvent arg0) {
    
    
   }
  });
 
  addMouseListener(new MouseListener() {
   int mousei=getSize().x/matrix.getCols();
   int mousej=getSize().y/matrix.getRows();
   @Override
   public void mouseUp(MouseEvent arg0) {
    if(character.y==mousei && character.x==mousej)
    {
     
     mousei=arg0.x/(getSize().x/matrix.getRows());
     mousej=arg0.y/(getSize().y/matrix.getCols());
     character.y=mousei;
     character.x=mousej;
     redraw();
     forceFocus();
    }
    
   }
   
   @Override
   public void mouseDown(MouseEvent arg0) {
      
   }
   
   @Override
   public void mouseDoubleClick(MouseEvent arg0) {
    // TODO Auto-generated method stub
    
   }
  });
  

 }


 @Override
 public void drawBoard() {
  
  redraw();
  
 }
 
 /**
  * victory plays a sound whenever the player hit the goal
  */
 public void victory(){
  
  MP3Player victory = new MP3Player();
  victory.addToPlayList(new File("Music//Sound2.mp3"));
  victory.play();
  
  
  
  
//  Clip victorysound;
//  File music = new File("Images//Anac.wav");
//  try {
//   if(music.exists()){
//    AudioInputStream sound;
//    sound = AudioSystem.getAudioInputStream(music);
//    try {
//     victorysound = AudioSystem.getClip();
//     victorysound.open(sound);
//    } catch (LineUnavailableException e) {
//     // TODO Auto-generated catch block
//     e.printStackTrace();
//    }
//    
//   }
//   else{
//    System.out.println("File Not Found");
//   }
//   
//  } catch (UnsupportedAudioFileException e) {
//   // TODO Auto-generated catch block
//   e.printStackTrace();
//  } catch (IOException e) {
//   // TODO Auto-generated catch block
//   e.printStackTrace();
//  }  
   
 }
 
 
 
 
 
 
 
// Image wallHorizontal;
// Canvas[][] boardGame;
// Image wallVertical;
// Image way;
// private Display display;
// private Shell shell;
//
// public MyBoard(Composite parent, int style,Display display,Shell shell) {
//  super(parent, style);
//  
//  this.display=display;
//  this.shell=shell;
//  way=new Image(display,"Grass.jpg");
//  
//  setBackground(new Color(null, 255, 255, 255));
//  addPaintListener(new PaintListener() {
//   @Override
//   public void paintControl(PaintEvent e) {
//    int x=getSize().x;
//    int y=getSize().y;
//    e.gc.drawImage(way,0,0,way.getImageData().width,way.getImageData().height,0,0,x,y);
//    
//   }
//  });
// }
//
//  

//  
// }
// public void ChangeWallHorizonal(Image wallHorizontal)
// {
//  this.wallHorizontal=wallHorizontal;
// }
// 
// public void ChangeWallVertical(Image wallVertical)
// {
//  this.wallVertical=wallVertical;
// }
// 
// public void ChangeWay(Image way)
// {
//  this.way=way;
// }
// 
}