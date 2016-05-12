/* pseudocode for the Boggle Grid


//instance variables:
2D array 
list of all possible words

constructor:
-get input from reader for size of board
-create a 2D array with a side = input from reader
-create array of the 26 letters (see letter class)
-for each spot in array, assign a random letter according to guidelines (create a method)

fillGrid method:
-fill in vowels first
-fill in remaining letters randomly, Q can only come in if there's already a U, and Q is limited to the areas around U
-after filling, check. If a letter has surpassed 20% of the board, replace it with another


