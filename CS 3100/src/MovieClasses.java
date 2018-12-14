import java.lang.*;
import java.util.*;
public class MovieClasses {
	Scanner keyboard = new Scanner(System.in);

	public static int binarySearch( ArrayList list, Object key ) {
	    Comparable comp = (Comparable)key;

	    int res = -1, min = 0, max = list.size() - 1, pos;
	    while( ( min <= max ) && ( res == -1 ) ) {
	        pos = (min + max) / 2;
	        int comparison = comp.compareTo(pos);
	        if( comparison == 0)
	            res = pos;
	        else if( comparison < 0)
	            max = pos - 1;
	        else
	            min = pos + 1;
	    }
	    return res;
	}
	public void PrintMovie(ArrayList<MovieList> ml) 								//prints the list of movies we have
	{
		System.out.println();
		System.out.println("These are our movies!");
		for(int i=0;i<ml.size();i++)
		{
			MovieList movielist1 = ml.get(i);
			System.out.println("Screen " + movielist1.gettheatrenum() + ". " + " " + movielist1.getName());

		}
		System.out.println();
	}

	public void DetailMovie(ArrayList<MovieList> ml)			//gives details for the movie, This should be the binary search function
	{
		System.out.println();
		System.out.println("Which movie number would you like to see more detail about?");
		int movierequest = keyboard.nextInt();
		int moviemod = binarySearch(ml, movierequest-1);						//searches for movie's positiong
		System.out.println(ml.get(moviemod));
		keyboard.nextLine();
	}
	public void AddMovie(ArrayList<MovieList> ml) 				//needs a way to catch for if user doesn't enter something properly
	{
		boolean tester=true;
		String inputmovie = null;
		double inputdouble = 0;
		String inputdesc = null;
		
		System.out.println("Please enter the new movie name:");
		inputmovie = keyboard.nextLine();					//adds movie name
		do {
			try {
				System.out.println("Please enter rating: (out of 10)");
				inputdouble = keyboard.nextDouble();					//adds movie rating //needs to catch errors
				keyboard.nextLine();			//need after a nextInt or nextDouble to read the nextline
				if(inputdouble>10||inputdouble<0)
					System.out.println("Invalid input, try again.");
				tester=true;
			}catch(InputMismatchException e)
			{
				tester = false;
				System.out.println("Invalid input, try again. error");
				keyboard.nextLine();
			}
		}while(inputdouble>10||inputdouble<0 || tester==false);
		System.out.println("Please enter a description of the movie");
		inputdesc = keyboard.nextLine();			//adds movie desc
		
		ml.add(new MovieList(ml.size()+1, inputmovie, inputdouble, inputdesc));				//adds all elements of the movie. by default adds to new theatre

		System.out.println();
	}

	public void RemoveMovie(ArrayList<MovieList> ml)			//should be able to match the movies 
	{
		int input;
		System.out.println("What movies do you want to remove?");
		System.out.println("(Please enter the movie number):");
		input = keyboard.nextInt();
		int temp;
		for(int i=input; i<ml.size();i++)
		{
			temp = ml.get(i).gettheatrenum();
			ml.get(i).settheatrenum(temp-1);				//swaps the theatre numbers
		}
		ml.remove(input-1);
		keyboard.nextLine();
	}
	
	public void ModifyMovie(ArrayList<MovieList> ml)			//modify elements in the movies
	{																//to use this you select the movies via numbers, and then type in your choice

		boolean edited = false;						//check to see if it was edited, or else it doesn't show the updated info
		
		String elementedit;
		System.out.println("What movie would you like to modify?");
		int movierequest = keyboard.nextInt();
		int moviemod = this.binarySearch(ml, movierequest-1);						//searches for movie's positiong
		keyboard.nextLine();
		System.out.println("What element would you like to modify?");
		System.out.println("(Name, Rating, Description, Swap, or Exit)");			//gives the user options
		String userchoice = keyboard.nextLine().toLowerCase();				//converts whatever it is that they user wrote into lowercase
		
		if(userchoice.equals("name")) {													//edits name
			System.out.println("Please enter a new movie name");
			elementedit = keyboard.nextLine();
			ml.get(moviemod).setName(elementedit);
			edited=true;
		}
		else if(userchoice.equals("rating"))											//edits rating
		{
			double ratingedit;
			do {
				System.out.println("Please enter the new rating:");
				ratingedit = keyboard.nextDouble();
				keyboard.nextLine();			//need after a nextInt or nextDouble to read the nextline
				if(ratingedit>10||ratingedit<0)
					System.out.println("Invalid input, try again.");
			}while(ratingedit>10||ratingedit<0);
			
			ml.get(moviemod).setRating(ratingedit);
			edited=true;

		}
		else if(userchoice.equals("description"))											//edits description
		{
			System.out.println("Please enter the new Description:");
			elementedit = keyboard.nextLine();
			ml.get(moviemod).setdesc(elementedit);
			edited=true;

		}
		else if(userchoice.equals("exit"))								//exits the program
		{
			System.out.println("Okay!");
		}
		else if(userchoice.equals("swap"))				//swaps movie positions
		{
			System.out.println("Which movie would you like to swap it with?");
			int editmoviename2 = keyboard.nextInt();
			int moviemod2 = this.binarySearch(ml, editmoviename2-1);						//binary searches the movie position
			keyboard.nextLine();

			int tempa = ml.get(moviemod).gettheatrenum();
			int tempb = ml.get(moviemod2).gettheatrenum();

			Collections.swap(ml, moviemod, moviemod2);									//swaps two elements in arraylist
			
			ml.get(moviemod2).settheatrenum(tempb);				//swaps the theatre numbers
			ml.get(moviemod).settheatrenum(tempa);				//swaps the theatre numbers

		}
		else {
			System.out.println("Hey, that's not a choice!");
			}
		if (edited == true) {
			System.out.println("Here is what has been edited:");
			System.out.println(ml.get(moviemod));
			System.out.println();
		}
	}

	public void ratingSort(ArrayList<MovieList> ml, int lSize, int loopcount)
	{
		int istart = 0;
		int j;
		for(int i = istart; i < lSize-1; i++)
		{
			j = i+1;
			MovieList movielist1 = ml.get(j);
			MovieList movielist2 = ml.get(i);
			double ratingj = movielist1.getrating();
			double ratingi = movielist2.getrating();
			if(ratingj>ratingi)
			{
				int numPlace = movielist1.gettheatrenum();		//placeholders for values
				String namePlace = movielist1.getName();
				double ratingPlace = movielist1.getrating();
				String descPlace = movielist1.getdesc();
				ml.get(j).settheatrenum(movielist2.gettheatrenum());	//swapping values for all the information
				ml.get(i).settheatrenum(numPlace);
				ml.get(j).setName(movielist2.getName());
				ml.get(i).setName(namePlace);
				ml.get(j).setRating(movielist2.getrating());
				ml.get(i).setRating(ratingPlace);
				ml.get(j).setdesc(movielist2.getdesc());
				ml.get(i).setdesc(descPlace);
			}
			
		}
		if(lSize > loopcount)
		{
			loopcount++;
			ratingSort(ml, lSize, loopcount);				//recursion to make sure list is fully ordered
		}
		
		
	}
	
	public void ratingPrint(ArrayList<MovieList> ml)
	{
		System.out.println();
		System.out.println("These are our movies!");
		for(int i=0;i<ml.size();i++)
		{
			MovieList movielist1 = ml.get(i);
			System.out.println("Screen " + movielist1.gettheatrenum() + ". " + " " + movielist1.getName());
			System.out.println("           Rating: " + movielist1.getrating());

		}
		System.out.println();
	}

public void theaterSort(ArrayList<MovieList> ml, int lSize, int loopcount)
	{
		int istart = 0;
		int j;
		for(int i = istart; i < lSize-1; i++)
		{
			j = i+1;
			MovieList movielist1 = ml.get(j);
			MovieList movielist2 = ml.get(i);
			int theaterj = movielist1.gettheatrenum();
			int theateri = movielist2.gettheatrenum();
			if(theaterj < theateri)
			{
				int numPlace = movielist1.gettheatrenum();				//placeholders for values
				String namePlace = movielist1.getName();
				double ratingPlace = movielist1.getrating();
				String descPlace = movielist1.getdesc();
				ml.get(j).settheatrenum(movielist2.gettheatrenum());	//swapping values for all the information
				ml.get(i).settheatrenum(numPlace);
				ml.get(j).setName(movielist2.getName());
				ml.get(i).setName(namePlace);
				ml.get(j).setRating(movielist2.getrating());
				ml.get(i).setRating(ratingPlace);
				ml.get(j).setdesc(movielist2.getdesc());
				ml.get(i).setdesc(descPlace);
			}
			
		}
		if(lSize > loopcount)
		{
			loopcount++;
			theaterSort(ml, lSize, loopcount);				//recursion to make sure list is fully ordered
		}
	}


	
	
	
}

