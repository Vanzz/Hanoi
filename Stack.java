public class Stack  
{
    Node first;
    Node last;
    int size; 
    int x;
    int y;
    public Stack(int _X, int _Y)
    {
        this.x = _X;
        this.y = _Y;
    }
    public int getX()
    {
        return this.x;
    }
        public int getY()
    {
        return this.y;        
    }
    public void setFirst(Node _first)
    {
        this.first = _first;
    }

    public void setLast(Node _last)
    {
        this.last = _last;
    }

    public Node getFirst()
    {
        return this.first;
    }

    public Node getLast()
    {
        return this.last;
    }

    public void insert(Node node)
    {
        size++;
        if(first == null)
        {
            this.first = node;
            this.last = node;
        }
        else
        {
            this.getLast().setNext(node);
            this.last = node;
        }
    }

    public Node remove()
    {
        Node ret;
        size--;
        Node aux = this.getFirst();
        if(aux.getNext() !=null)
        {
            while(aux.getNext().getNext() != null)
            {
                aux = aux.getNext();
            }
            ret = aux.getNext();
            this.setLast(aux);
            aux.setNext(null);
        }
        else
        {
            ret = first;
            first = null;
            
        }
        return ret;
    }
    public void setSize(int n)
    {
        this.size = n;
    }
    public int size(){return this.size;}
}