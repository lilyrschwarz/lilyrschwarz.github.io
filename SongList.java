package Homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Class linkedList 

class SongList

{

    protected Node start;

    protected Node end ;

    public int size;

//constructor
    public SongList()

    {

        start = null;

        end = null;

        size = 0;

    }

    //Function to check if Songlist is empty 

    public boolean isEmpty()

    {

        return start == null;

    }

    /* Function to get size of Songlist */

    public int getSize()

    {

        return size;

    }

    //Function to insert song at beginning 

    public void insertAtStart(String val)

    {

        Node nptr = new Node(val, null, null);      

        if(start == null)

        {

            start = nptr;

            end = start;

        }

        else

        {

            start.setLinkPrev(nptr);

            nptr.setLinkNext(start);

            start = nptr;

        }

        size++;

    }

    //Function to insert song at end 

    public void AddToTail(String songTitle)

    {

        Node nptr = new Node(songTitle, null, null);      

        if(start == null)

        {

            start = nptr;

            end = start;

        }

        else

        {

            nptr.setLinkPrev(end);

            end.setLinkNext(nptr);

            end = nptr;

        }

        size++;

    }
  
  

    //Function to insert song After index position 

    public void addAfterIndex(String songTitle , int index)

    {

        Node nptr = new Node(songTitle, null, null);  

        if (index == 1)

        {

            insertAtStart(songTitle);

            return;

        }
        else if (index == size)

        {

            AddToTail(songTitle);

            return;

        }     

        Node ptr = start;

        for (int i = 2; i < size; i++)

        {
           ptr = ptr.getLinkNext();

            if (i == index)

            {

                Node tmp = ptr.getLinkNext();

                nptr.setLinkNext(tmp);

                nptr.setLinkPrev(ptr);

                tmp.setLinkPrev(nptr);
                ptr.setLinkNext(nptr);

            }

                     

        }

        size++ ;

    }

    //Function to delete Song at position 

    public void deleteAtPos(int pos)

    {      

        if (pos == 1)

        {

            if (size == 1)

            {

                start = null;

                end = null;

                size = 0;

                return;

            }

            start = start.getLinkNext();

            start.setLinkPrev(null);

            size--;

            return ;

        }

        if (pos == size)

        {

            end = end.getLinkPrev();

            end.setLinkNext(null);

            size-- ;

        }

        Node ptr = start.getLinkNext();

        for (int i = 2; i <= size; i++)

        {

            if (i == pos)

            {

                Node p = ptr.getLinkPrev();

                Node n = ptr.getLinkNext();

                p.setLinkNext(n);

                n.setLinkPrev(p);

                size-- ;

                return;

            }

            ptr = ptr.getLinkNext();

        }      

    }  

    //Function Play to display Song list 

    public void play()

    {

        System.out.print("\nPlayList = \n");

        if (size == 0)

        {

            System.out.print("empty\n");

            return;

        }

        if (start.getLinkNext() == null)

        {

            System.out.println(start.getData() );

            return;

        }

        Node ptr = start;

        System.out.print(start.getData()+ "\n");

        ptr = start.getLinkNext();

        while (ptr.getLinkNext() != null)

        {

            System.out.print(ptr.getData()+ "\n");

            ptr = ptr.getLinkNext();

        }

        System.out.print(ptr.getData()+ "\n");

    }
  
  
    //Function to Get element by index position 

    public String getAtPos(int pos)

    {

   
        Node ptr = start;
        String data= " ";
      

        for (int i = 1; i <= size; i++)

        {
          
            if (i == pos)

            {

                data= ptr.getData();

            }
          
            ptr = ptr.getLinkNext();
                     

        }

      
        return data;
    }
  
    //Function to DeleteSong by title 

    public void deleteSong(String songTitle)

    {

   
        Node ptr = start;
      
        for (int i = 1; i <= size; i++)

        {
          
            if (ptr.getData().equals(songTitle))

            {

                deleteAtPos(i);
                System.out.println("Song removed from List");
                return;

            }
          
            ptr = ptr.getLinkNext();
                     

        }
      
        System.out.println("Invalid name or Song not exist ");
    }
  
  
    //Function to Shuffle Play 

    public void shufflePlay(int numSongsToPlay)

    {
       List<Integer> numbers = new ArrayList<>();
       for (int i = 1; i <= size; i++)
               numbers.add(i);
      
       Collections.shuffle(numbers);
       int count=0;
      
       for(int i=0;count<numSongsToPlay;i++){
           if(i<numbers.size())
           {
               int index=numbers.get(i);
               System.out.println("\n "+getAtPos(index));
               count++;
           }
           else
           {
               Collections.shuffle(numbers);
               i=0;
           }
       }
    
    }

}

