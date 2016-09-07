import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        System.out.println("Started");
        sticks = new Node[3];
        for(int i = 1; i <4; i++)
        {
            int xpos = STICK_X_MULTIPLIER*i-(STICK_X_MULTIPLIER/2);
            sticks[i-1] = new Node(new PlaceHolder("stick.png"),(byte)0, new Stack(xpos,367));
            this.addObject(sticks[i-1].getPlaceHolder(),xpos,STICK_Y);
            System.out.println("Stick created: x:"+xpos+ ", y:"+STICK_Y);
        }        
        
        for(byte i = 1; i<9; i++)
        {
            //deve ter um erro aqui, só vamos ter certeza qnd alguém bugar msm.
            
            Node n = new Node(new PlaceHolder(),(byte)(9-i));
            PlaceHolder disk = new PlaceHolder(9-i+".png",n);  
            n.setPlaceHolder(disk);
            sticks[0].getStack().insert(new Node(disk,(byte)(9-i)));
            this.addObject(disk,sticks[0].getStack().getX(),
                           sticks[0].getStack().getY()-(DISK_HEIGHT*(sticks[0].getStack().size()-1)));
            System.out.println("Disk "+(9-i));
        }
    }
    
    public void act()
    {
        wincondition();

    }
    
    public boolean holding()
    {
        return selected != null;
    }
    
    public void wincondition()
    {
        if(sticks[2].getStack().size() == 8) Greenfoot.stop();
        
    }
    
    public void select(PlaceHolder selected)
    {
        if(getSelected() != selected && getSelected() !=null)
        {
            if(selected.getNode().getSize() == 0)
            {
                selected.setLocation(selected.getNode().getStack().getX(),
                         selected.getNode().getStack().getY()-(DISK_HEIGHT*(selected.getNode().getStack().size()-1)));
            }
            
            setSelected(null);
        }
    }
    
    public void setSelected(PlaceHolder selected)
    {
        System.out.println("Player clicked:" + selected.getNode().getSize());
        this.selected = selected;
    }
    
    public PlaceHolder getSelected()
    {
        return this.selected;
    }
    
    Node[] sticks;
    public PlaceHolder selected;
    private static final int DISK_HEIGHT = 30;
    private static final int STICK_Y = 250;
    private static final int STICK_X_MULTIPLIER = 200;    
}
