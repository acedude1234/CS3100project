import java.lang.*;
import java.util.*;
public class MovieClasses {
	Scanner keyboard = new Scanner(System.in);
	

	public void addValues(ArrayList<Movielist> ml, int Theatrenum[],String name[],double rating[], String desc[])
	{
		
		for (int i=0; i<3; i++)
		{
			ml.add(new Movielist(Theatrenum[i], name[i], rating[i], desc[i]));
		}
	}
	public void PrintMovie(ArrayList<Movielist> ml) 
	{
		System.out.println();
		System.out.println("These are our movies!");
		for(int i=0;i<ml.size();i++)
		{
			Movielist movielist1 = ml.get(i);
			System.out.println(movielist1.Theatrenum + " " + movielist1.name);

		}
		/*while(itr.hasNext()) //prints the movies
		{	
			Movielist ml =(Movielist)itr.next();
				//System.out.print("Screen " + (i+1) + ". ");						//array position +1, since array position starts at 0
				System.out.println(ml.movies);					//prints the movies
		}
		 Iterator itr=al.iterator();  

	        //traverse elements of ArrayList object  
	        while(itr.hasNext()){  
	            Movielist mm=(Movielist)itr.next();  
	            System.out.println(mm.Theatrenum+". "+mm.name);  
	        } */ 
		System.out.println(ml.size());
		System.out.println();

	}

	public void DetailMovie(ArrayList<Movielist> ml, int Theatrenum[],String name[],double rating[], String desc[])
	{
		int input;
		System.out.println();
		System.out.println("Which movie would you like to see more detail about?");
		input = keyboard.nextInt();
		Movielist movielist1 = ml.get(input-1);
		//System.out.println(movielist1.Theatrenum + " " + movielist1.name + movielist1.rating + movielist1.desc);
		System.out.println(movielist1.name + " is located in theatre: " + movielist1.Theatrenum);
		System.out.println("Rating: " + movielist1.rating + "/10");
		System.out.println("Synopsis: \n\t" + movielist1.desc);
		System.out.println();
	}
	public void AddMovie(ArrayList<Movielist> ml, int Theatrenum[],String name[],double rating[], String desc[]) 				//needs a way to catch for if user doesn't enter something properly
	{
		boolean tester = false;
		int k =0;
		/*do {
			try {
				System.out.println("How many movies do you want to add?");
				k = keyboard.nextInt();											//asks for how many movies the user wants to add
			}catch (InputMismatchException e)
			{
				System.out.println("Hey! That's not a valid number!");
				keyboard.nextLine();											//asks for how many movies the user wants to add

			}

		}while(k<=0);*/
		System.out.println("Please enter movies:");
		String inputmovie = keyboard.nextLine();					//adds movie name

		System.out.println("Please enter rating: (out of 10)");
		double inputdouble = keyboard.nextDouble();					//adds movie rating //needs to catch errors
		keyboard.nextLine();			//need after a nextInt or nextDouble to read the nextline
		System.out.println("Please enter a description of the movie");
		String inputdesc = keyboard.nextLine();			//adds movie desc
		

		//ml.add(new Movielist(Theatrenum[ml.size()], name[ml.size()], rating[ml.size()-1], desc[ml.size()-1]));		
		ml.add(new Movielist(ml.size()+1, inputmovie, inputdouble, inputdesc));				//adds all elements of the movie. by default adds to new theatre
		
		System.out.println(ml.size());
		System.out.println();
	}

	public void RemoveMovie(ArrayList movies)			//should be able to match the movies 
	{
		int k = 0;
		do {
			try {
				System.out.println("How many movies do you want to remove?");
				k = keyboard.nextInt();											//asks for how many movies the user wants to add
			}catch (InputMismatchException e)
			{
				System.out.println("Hey! That's not a valid number!");
				keyboard.nextLine();											//asks for how many movies the user wants to add
			}

		}while(k<=0);
		System.out.println("What movies do you want to remove?");
		System.out.println("(Please enter the movie name(s)):");
		for(int count=-1; count<k; count++) 
		{	
			String input = keyboard.nextLine();
			input = input.replaceAll("[^A-Za-z0-9]+", "").toUpperCase();  				//replaces whatever use inputs to all uppercases w no spaces
			for(int i=0; i<movies.size(); i++)
			{
				String temp = ((String) movies.get(i)).replaceAll("[^A-Za-z0-9]+", "").toUpperCase();			//replaces movie titles temporarily as ALLUPPERCASE w numbers included
				//System.out.println(temp);
				if(temp.equals(input))
				{
					movies.remove(i);
				}
					
			}
		}
	}

	public void ModifyMovie(ArrayList movies)
	{
		System.out.println("What two movie numbers would you like to switch?");
			int i = keyboard.nextInt();
			i = i-1;
			int j = keyboard.nextInt();
			j = j-1;
			//getting the indexes from user input and adjusting them from screen number
			
			if(i < 0 || i > movies.size() || j < 0 || j > movies.size())
			{
				System.out.println("Invalid input.");
			} //check for invalid inputs
			
			else
			{
				String placeholder1 = ((String)movies.get(j));
				String placeholder2 = ((String)movies.get(i));
				//getting the strings from indexes i and j into placeholders to be swapped
			
				movies.remove(j);
				movies.add(j, placeholder2);
				movies.remove(i);
				movies.add(i, placeholder1);
				//swapping of strings
			}
	}


	public void Search(ArrayList movies)
	{
	  boolean check = false;
			System.out.println("What movie do you want to search for");
			System.out.println("Please enter a movie name or names");
				
			String input = keyboard.nextLine();
			input = input.replaceAll("[^A-Za-z0-9]+", "").toUpperCase(); 
			
			System.out.println("That movie is showing on: ");
			
			for(int i = 0; i<movies.size();i++)
			{
				String temp = ((String) movies.get(i)).replaceAll("[^A-Za-z0-9]+", "").toUpperCase();
				
				if(temp.equals(input))
				{
					System.out.print("screen " + (i+1) + " ");
				   	check = true;
				}
				
			}
			if(!check)
				System.out.print("no screens");
			System.out.println();

	}
	/*public void DevMode(ArrayList movies)
	{
		System.out.println("Welcome to dev mode. Please enter an option.");
		System.out.println("1. Add a movie");
		System.out.println("2. Remove a movie");
		System.out.println("3. Modify a movie");
		System.out.println("0. Exit");
		int input2 = keyboard.next().charAt(0);
		
		switch(input2)
		{
		case '1':
			AddMovie(movies);
			PrintMovie(movies);
			DevMode(movies);
			break;
		case '2':
			PrintMovie(movies);
			RemoveMovie(movies);
			PrintMovie(movies);
			DevMode(movies);
			break;
		case '3':
			PrintMovie(movies);
			ModifyMovie(movies);
			PrintMovie(movies);
			DevMode(movies);
			break;
		case '0':
			break;
		default:
			System.out.println("You didn't put any of options!");
			DevMode(movies);
			break;
		}
	}

*/
	
}

