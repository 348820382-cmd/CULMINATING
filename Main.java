import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Adding songs in the library
		ArrayList<String> songNames = new ArrayList<String>();
		songNames.add("Exit Music (for a Film)"); songNames.add("Go with the Flow"); songNames.add("Frogs"); songNames.add("Crutch"); songNames.add("Alone Again (Naturally)");
		ArrayList<String> artistNames = new ArrayList<String>();
		artistNames.add("Radiohead"); artistNames.add("Queens of the Stone Age"); artistNames.add("Failure"); artistNames.add("Pinback"); artistNames.add("Gilbert O'Gullivan");
		ArrayList<Double> ratings = new ArrayList<Double>();
		ratings.add(90.4);ratings.add(91.0);ratings.add(85.4);ratings.add(88.6);ratings.add(77.4);
		

		
		//Greeting message
		System.out.println("Hello user and welcome to... \n------------- THE MUSIC LIBRARY MANAGER ------------");
		
		//Lets the user choose options
		boolean unfinished = true;
		int ID = 0;
		while (unfinished){
			
			//Options
			System.out.println("Pick one of the following options by typing in the designated number: "
					+ "\n1. Add A Song \n2. Average Rating Of Library "
					+ "\n3. Minimum and Maximum rated song \n4. Display the list of songs "
					+ "\n5. Display the Rating Distribution \n6. Search a song "
					+ "\n7. Display the top and bottom 20% \n8. Exit the program");
			int choiceInt = Integer.parseInt(sc.nextLine());
			
			switch (choiceInt){
			case 1:
				System.out.println("\n Enter the following: \nSong's Name\nArtist Who Made It\nRating out of 100");
				songNames.add(sc.nextLine());
				artistNames.add(sc.nextLine());
				ratings.add(Double.parseDouble(sc.nextLine()));
				
				break;
			case 2: 
				double sum = 0;
				// Calculates overall ratings
				for (double rating:ratings){
					sum += rating;
				}
				sum = sum / ratings.size();
				System.out.println("\nThe average rating of all songs is: " + sum + "\n");
				break;
				
			case 3:
				double high = 0;
				double low = 0;
				boolean firstTime = true;
				//Algorithm for finding the highest and lowest
				for (double rating:ratings){
					for (double compare:ratings){
						if (rating>compare&&rating>high){
							high = rating;
							
						} else if (rating<compare&&(rating<low || firstTime)){
							low = rating;
							firstTime=false;
							
						}
					}
				}
				//Gets the index for the name of the song correlated to the rating
				int highestRated = ratings.indexOf(high);
				int lowestRated = ratings.indexOf(low);
				System.out.println("\nThe highest rated song is: "+ songNames.get(highestRated) +" by " + artistNames.get(highestRated)+
						" with a rating of " + high);
				System.out.println("\nThe lowest rated song is: "+ songNames.get(lowestRated) +" by " + artistNames.get(lowestRated)+
						" with a rating of " + low + "\n");
				break;
			case 4:
				int i = 0;
				System.out.println();
				for (String songName :songNames){
					System.out.println(i + 1+": " + songName + " by "+ artistNames.get(i) + ". Rating: "+ ratings.get(i));
					i++;
				}
				
				while (choiceInt!=3){
					System.out.println("\nPick one of the following options:\n1.Edit A Song\n2.Remove A Song\n3.Go Back to Main Menu");
					choiceInt = Integer.parseInt(sc.nextLine());
					//Lets the user choose which option
					switch (choiceInt){
						case 1:
					
							System.out.println("\nEnter the ID of the song you want to edit and select a function:\n1: Change Song Name\n2: Change Artist Name\n3: Change Rating");
							ID = Integer.parseInt(sc.nextLine()) -1 ;
							choiceInt = Integer.parseInt(sc.nextLine());
							switch (choiceInt){
							case 1:
								System.out.println("Enter the new name of the song");
								songNames.set(ID, sc.nextLine());
								break;
							case 2:
								System.out.println("Enter the new name of the artist");
								artistNames.set(ID, sc.nextLine());
								break;
							case 3:
								System.out.println("Enter the new rating of the song");
								ratings.set(ID, Double.parseDouble(sc.nextLine()));
								
							break;
						}
						//Spacing for clarity
						System.out.println("");
						break;
						case 2:
							System.out.println("\nEnter the ID of the song you want to remove");
							ID = Integer.parseInt(sc.nextLine()) -1 ;
							songNames.remove(ID);
							artistNames.remove(ID);
							ratings.remove(ID);
							break;
						case 3:
							break;
						default:
							System.out.println("You did not pick a correct number, try again");
					}
				}
				
				System.out.println();
				break;
			case 5:
				//IMPORTANT PLEASE FINISH IT IS NOT DONNNNNNNEEEEE
				//CREATE LINE THING THEN SET IT TO HIGHEST NUMBER THEN CHECK FO EACH SPACE IF THE NUMBER IS BIGGER OR EQUAL TO THAT NUMBER. IF SO GENERATE A #
				int songs1 = 0;
				int songs2 = 0;
				int songs3 = 0;
				int songs4 = 0;
				int songs5 = 0;
				for (double rating:ratings){
					if (rating>=90){
						songs5++;
					} else if (rating>= 75){
						songs4++;
					} else if (rating>=60){
						songs3++;
					} else if (rating>=40){
						songs2++;
					} else if (rating<40){
						songs1++;
					}
				}
				//Add hashtags to graph
				System.out.println("1 2 3 4 5 \n----------");
				while (songs1 > 0 || songs2 > 0 || songs3 > 0 || songs4 > 0 || songs5 > 0){
					if (songs1>0){
						System.out.print("# ");
						songs1--;
					} else {
						System.out.print("  ");
					}
					if (songs2>0){
						System.out.print("# ");
						songs2--;
					} else {
						System.out.print("  ");
					}
					if (songs3>0){
						System.out.print("# ");
						songs3--;
					} else {
						System.out.print("  ");
					}
					if (songs4>0){
						System.out.print("# ");
						songs4--;
					} else {
						System.out.print("  ");
					}
					if (songs5>0){
						System.out.println("#");
						songs5--;
					} else {
						System.out.print("  ");
					}
				}
				//Spacing for clarity
				System.out.println();
				break;
			case 6:
				
				System.out.println("\nEnter the song you want to look at (or a part of it)");
				String input = sc.nextLine();
				String songKey = "";
				int key = 0;
				int j = 0;
				boolean containsName = false;
				boolean containsArtist = false;
				//Checks if its contained in artist or song name
				for(String name : songNames){
					if (name.toUpperCase().contains(input.toUpperCase())){
						songKey = name;
						containsName = true;
						break;
					} else if (artistNames.get(j).toUpperCase().contains(input.toUpperCase())){
						songKey = artistNames.get(j);
						containsArtist = true;
						break;
					}
					j++;
				}
				
				if (containsName){
					//Prints out all information based of song name
					key = songNames.indexOf(songKey);
					System.out.println(songNames.get(key) + " by " + artistNames.get(key) + ". Rating: "+ ratings.get(key));
					double avRating = 0;
					for (double rating:ratings){
						avRating += rating;
					}
					avRating/=songNames.size();
					//Used to see if the songs rating is above the average, exactly, or lower
					
					if (ratings.get(key) > avRating){
						System.out.println("This song's rating is greater than the average rating in this library\n");
					} else if (ratings.get(key) == avRating){
						System.out.println("This song's rating is exactly the average rating in this library\n");
					} else {
						System.out.println("This song's rating is lower than the average rating in this library\n");
					}
				} else if (containsArtist){
					//Prints out all information based of artist name
					key = artistNames.indexOf(songKey);
					System.out.println(songNames.get(key) + " by " + artistNames.get(key) + ". Rating: "+ ratings.get(key));
					double avRating = 0;
					for (double rating:ratings){
						avRating += rating;
					}
					avRating/=songNames.size();
					//Used to see if the songs rating is above the average, exactly, or lower (Same code as before)
					
					if (ratings.get(key) > avRating){
						System.out.println("This song's rating is greater than the average rating in this library\n");
					} else if (ratings.get(key) == avRating){
						System.out.println("This song's rating is exactly the average rating in this library\n");
					} else {
						System.out.print("This song's rating is lower than the average rating in this library\n");
					}
					
				} else {
					System.out.println("Sorry, we could not find anything in our library");
				}
				break;
			case 7:
				double total = 0;
				for (double rating:ratings){
					total += rating;
				}
				double low20 = total*0.2;
				double high20 = total*0.8;
				ArrayList<String> low20Names = new ArrayList<String>();
				ArrayList<String> high20Names = new ArrayList<String>();
				
				//Adds songs to arraylists if their within the higher or lower threshold
				for (double rating:ratings){
					if (rating<=low20){
						low20Names.add(songNames.get(ratings.indexOf(rating)));
					}
					if (rating>=high20){
						high20Names.add(songNames.get(ratings.indexOf(rating)));
					}
				}

				System.out.println("The following songs are in the bottom 20%: " + low20Names);
				System.out.println("The following songs are in the top 20%: " + high20Names + "\n");
				break;
			case 8:
				System.out.println("Hope you enjoyed using MLM!");
				unfinished = false;
				break;
			default:
				//Error Protection (VERY important)
				System.out.println("!!! ERROR !!!\nYou did not input a number 1-8. Try again");
			}
		}
		
		
	}
}


