import java.util.*;
import java.util.concurrent.TimeUnit;
public class MovieMain {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);						//Creates a scanner named keyboard
		String input = "0";
		int n = 0;		
		boolean check = false;
		int theatrenum[] = {1, 2, 3};
		String name[] = {"Venom", "Halloween", "The Grinch"};
		double rating[] = {8.6, 7.3, 5.9};
		String desc[] = {"Tougher Spiderman saves day", "Sad lonely boy tries to \nkill other people", "Anti-social green man \nmakes others feels sad."};
		//our movies
		ArrayList<Movielist> ml = new ArrayList<Movielist>();

		ArrayList movies = new ArrayList();		//obsolete, stays cuz others wont break from removing
		
	
		MovieClasses printfunc = new MovieClasses();
		printfunc.addValues(ml, theatrenum, name, rating, desc);

		while(check == false) {
			System.out.println("What would you like to do?");  //asks user what they want to do, gives 5 options
			System.out.println("1. Show what movies are available");			//view all movies
			System.out.println("2. Add a movie");					//add a movie- up to 15 max
			System.out.println("3. Remove a movie");			//removes a movie
			System.out.println("4. Modify a movie");			//gives option to change movie; edit name
			System.out.println("5. Check if a movie is in the catalog");		//ask if a specific movie is available
			System.out.println("0. to exit");		//ask if a specific movie is available
			System.out.println("Please enter here:");
			input = keyboard.nextLine();						//takes input user to run

			switch(input)
			{
			case "1":									//print function
				printfunc.PrintMovie(ml);
					//printfunc.DetailMovie(ml, theatrenum, name, rating, desc);			//maybe keep for search function
				break;
			case "2":
				printfunc.PrintMovie(ml);
				printfunc.AddMovie(ml, theatrenum, name, rating, desc);
				break;
			case "3":
				printfunc.PrintMovie(movies);
				printfunc.RemoveMovie(movies);
				printfunc.PrintMovie(movies);
				break;
			case "4":
				printfunc.PrintMovie(movies);
				printfunc.ModifyMovie(movies);
				printfunc.PrintMovie(movies);
				break;
			case "5":
				printfunc.Search(movies);
				printfunc.DetailMovie(ml, theatrenum, name, rating, desc);
				break;
			case "0":
				System.out.println("Goodbye!");
				System.exit(0);
				break;
		/*	case "password":
				printfunc.DevMode(movies);
				break;*/
			default:
				System.out.println("You didn't put any of options!");
				break;
			}
			
			
		}		
	}

}
