import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class  Node
{
    /**
     * Recebe um disco PlaceHolder e o tamanho pro disco.
     * 
     * @param _placeHolder: Classe PlaceHolder, que armazena a imagem
     * e representa a node como ator dentro do game
     * 
     * @param _size: Tamanho do disco, variando de 1 a 8
       */
    public Node(PlaceHolder _placeHolder, byte _size)
    {
        this.placeHolder = _placeHolder;
        this.size = _size;
    }
    public Node(PlaceHolder _placeHolder, byte _size, Stack _stack)
    {
        this.placeHolder = _placeHolder;
        this.size = _size;
        this.stack = _stack;
    }
    public Node(){};
    public Node getNext()
    {
        return this.next;
    }
    public void setNext(Node _carta)
    {
        this.next = _carta;
    }
    public PlaceHolder getPlaceHolder()
    {
        return this.placeHolder;
    }
    public Stack getStack()
    {
        return this.stack;
    }
    public int getSize()
    {
        return this.size;
    }
    public void setPlaceHolder(PlaceHolder _placeHolder)
    {
        this.placeHolder = _placeHolder;
    }
    PlaceHolder placeHolder;
    byte size;
    Node next;
    Stack stack;
}