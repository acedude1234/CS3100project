import java.util.*;
import java.util.concurrent.TimeUnit;
public class MovieMain {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);						//Creates a scanner named keyboard
		int input = -1;
		int n = 0;		
		boolean check = false;
		
		ArrayList<MovieList> ml = new ArrayList<MovieList>();
		
		ml.add(new MovieList (1, "Venom", 6.9, "Journalist gets a parasite that gets mad when it's called that."));
		ml.add(new MovieList (2, "Bohemian Rhapsody",  7.3, "The Queen Documentary."));
		ml.add(new MovieList (3, "The Grinch", 5.7, "Green man gets annoyed by other people celebrating."));
		ml.add(new MovieList (4, "Spiderman: Into the Spiderverse", 8.6, "Animated spiderman movie with all the spiderpeople."));
		ml.add(new MovieList (5, "Ralph Breaks the Internet", 7.5, "The second Wreck it Ralph movie, which for some reason \nwas not called \"Ralph Wrecks the Internet\"."));
		ml.add(new MovieList (6, "Creed II", 7.8, "Under the tutelage of Rocky Balboa, heavyweight contender \nAdonis Creed faces off against Viktor Drago, son of Ivan Drago. "));
		//these are our movies	
		
		MovieClasses printfunc = new MovieClasses();

		do{
				try {
					
					System.out.println("What would you like to do?");  //asks user what they want to do, gives 5 options
					System.out.println("1. Show what movies are available");			//view all movies
					System.out.println("2. Add a movie");					//add a movie- up to 15 max
					System.out.println("3. Remove a movie");			//removes a movie
					System.out.println("4. Modify a movie");			//gives option to change movie; edit name
					System.out.println("5. See more information about a movie");		//ask if a specific movie is available
					System.out.println("6. See the movies sorted by ratings");
					System.out.println("0. to exit");		//ask if a specific movie is available
					System.out.println("Please enter here:");
					input = keyboard.nextInt();						//takes input user to run
					int lSize = ml.size();
					int loopcount = 0;

				
				switch(input)
				{
				case 1:									//print function
					printfunc.PrintMovie(ml);
					break;
				case 2:
					printfunc.PrintMovie(ml);
					printfunc.AddMovie(ml);
					break;
				case 3:
					printfunc.PrintMovie(ml);
					printfunc.RemoveMovie(ml);
					printfunc.PrintMovie(ml);
					break;
				case 4:
					printfunc.PrintMovie(ml);
					printfunc.ModifyMovie(ml);
					break;
				case 5:
					printfunc.PrintMovie(ml);
					printfunc.DetailMovie(ml);
					break;
				case 6:
					printfunc.ratingSort(ml, lSize, loopcount);
					printfunc.ratingPrint(ml);
					loopcount = 0;
					printfunc.theaterSort(ml, lSize, loopcount);
					break;
				case 0:
					System.out.println("Goodbye!");
					System.exit(0);
					break;
				default:
					System.out.println("You didn't put any of options!");
					break;
				}
			
			}catch(InputMismatchException e) {		//catches if one of the choices wasn't a number
				System.out.println("You didn't put a valid choice!");
			}
				keyboard.nextLine();

		}while (-1 <= input && input <= 6);		//runs as long as input is between -1 and 6
	}

}
