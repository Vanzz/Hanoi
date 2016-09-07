import greenfoot.*; 

public class  PlaceHolder extends Actor
{
    public PlaceHolder(){}
    
    public PlaceHolder (String imgname)
    {
        this.setImage(new GreenfootImage(imgname));
    }
    
    public PlaceHolder (String imgname, Node n)
    {
        this.setImage(new GreenfootImage(imgname));
        this.node = n;
    }
    
    public void act()
    {
        
        if(Greenfoot.mouseClicked(this))
        {
            try{
                System.out.println("Selected size: "+this.getNode().getSize());
            }   
            catch(Exception e)
            {
                System.out.println("Selected stick");
            }
            if(((MyWorld)getWorld()).getSelected() == this)
            {
                ((MyWorld)getWorld()).setSelected(null);
            }
            else
            {
                ((MyWorld)getWorld()).select(this);
            }
        }
    }
    
    public Node getNode()
    {
        return this.node;
    }
    Node node;
}