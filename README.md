# CULMINATING
The code works by creating 3 arraylists
  - 1 for song names
  - 2 for artist names
  - 3 for rating out of 100
Each index in all 3 arraylists represents all the information for 1 song
For example, in the index 0, the values are:
  - Song Names: Exit Music (for a film)
  - Artist Names: Radiohead
  - Ratings: 90.4

The code loops (until option 8 is clicked) 
The options are chosen using switch case and default is used for any number not 1-8 (Error Check)

Option 1 lets the user input 3 things and adds them to the following arraylists
  - songNames
  - artistNames
  - ratings

Option 2 finds the average rating for all ratings in the ratings ArrayList
It does this by using a for each loop applied to ratings and adds all values together then divides by the amount of items in ratings

Option 3 finds the highest and lowest values
It does this by comparing the current valuye to every number after as well as the current highest value (vice versa for lowest value)

Option 4 does a variety of options 
First, before options are chosen by user, it outputs all song names, the artist who made them and the rating attributed
Then in a while loop (that is active as long as the choice is not 3) there is a switch case that lets the user pick 3 options
  - 1: Edit a song
    If the user chooses this options, there is another switch case to see what they want to change about which song (Found using user inputed id)
    The ID is -1 (As to account for the first value in the arraylist being 0) then that value is edited based on the value they enter
  - 2: Remove a song
    Simply removes a song (And all its other attributes) from all arraylists using .remove
  - 3: Exit to main menu
    Disactivates the while loop

Option 5 creates a bar graph representing the distrubution of ratings
It does this by first counting up how many songs are in the categories: 1* - 5*
Then the code enters a while loop that is activate as long as all the values do not equal 0 (So that the graph does not go on forever)
The graph goes 1 through 5 stars and if the amount of ratings within that category is above 0, it subtracts it by on and creates a # 
This effectivally goes through all the songs and converts the amount of songs in that category into hashtags which represent the amount of them in the graph

Option 6 lets the user search a song 
The user puts in a string that if a song name or artist name in the database contains it, it output all attributes of the song (Name, artist and rating)
It finds if both values equal eachother when they are both uppercase so it is not case sensitive
The last part of the code finds if this songs rating is above, equal or below the average rating
It does this by finding the average then checking the rating to see how it compares

Option 7 checks the top and bottom 20% of the ratings
It finds this by finding the total them multiplying it by 0.2 for lowest and 0.8 for highest
this is because 100*0.2 is 20 (The bottem 20%) and 100*0.8 is the top 20%
Then it adds all songs with rating below total*0.2 and adds it to low20 arraylist and ones above total*0.8 and adds it to high20 arraylist
After doing this it prints both

Option 8 exits code


