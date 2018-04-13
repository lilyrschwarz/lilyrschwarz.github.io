package Homework2;

import java.util.Scanner;

public class SongDLL

{  

    public static void main(String[] args)

    {          

        Scanner scan = new Scanner(System.in);

        //Creating object of SongList 

        SongList list = new SongList();

        System.out.println("Doubly Linked List Test\n");        

        char ch;

        //Perform list operations 

        do

        {

            System.out.println("\nDoubly Linked List Operations. Press a number to perform an action.\n");

            System.out.println("1. Playlist ");

            System.out.println("2. Add song to List ");

            System.out.println("3. Add song after a position index");

            System.out.println("4. Delete Song");

            System.out.println("5. Shuffle Play");

            System.out.println("6. Get Size");
            

            int choice = Integer.parseInt(scan.nextLine());         

            switch (choice)

            {

            case 1 :

               System.out.println("\n\n Playing");
                list.play();                 

                break;                        

            case 2 :

                System.out.println("Enter Song title to Add ");
              
                list.AddToTail( scan.nextLine() );                   

                break;                       

            case 3 :

                System.out.println("Enter Song title to Add");

                String songTitle = scan.nextLine() ;

                System.out.println("Enter index position to put song after");

                int index = Integer.parseInt(scan.nextLine());

                if (index < 1 || index > list.getSize() )

                    System.out.println("Invalid position\n");

                else

                    list.addAfterIndex(songTitle, index);

                break;                                        

            case 4 :

                System.out.println("Enter SongTitle to delete ");

                String songTitle1 = scan.nextLine();

                if (songTitle1 !=null)

                   list.deleteSong(songTitle1);

       

                break;   

            case 5 :

                System.out.println("\n\n Shuffle Play ");
                System.out.println("Enter number of songs to play ");
                int numberSongsToPlay = Integer.parseInt(scan.nextLine());
                list.shufflePlay(numberSongsToPlay);

                break;          

            case 6 :

                System.out.println("Size = "+ list.getSize() +" \n");
              
                break;                       

            default :

                System.out.println("Wrong Entry \n ");

                break;

            }  

         
            System.out.println("\nDo you want to continue? (Type y or n) \n");
          
          

            ch = scan.next().charAt(0);  
            scan.nextLine();
          
        } while (ch == 'Y'|| ch == 'y');       //repeating menu continuous loop       

    }
}