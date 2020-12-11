# TicTacToe Kata - Tim Verté

# How to run the tests

Navigate to the source directory of the code and run 'mvn test'

# How to build/run

Navigate to the source directory of the code and use 'mvn clean install' to build the application.

Navigate to the source directory of the code and use 'mvn spring-boot:run' to run the application.

# Way of work

- Started by thinking about the class design ==> what classes do I need, how are they related, which method should go where.
- Writing tests. 
  - Looking at the rules, I tried to figure out where to implement and test these rules
  - Looking at the application from bottom to top: Player -> Board -> Game -> GameService for writing tests  
  - Player had no tests at all in the beginning, until introducing the 'Player-X should always start'
  - Writing tests for Board class was the next step
    - First I tried to figure out which methods I would need to manipulate the board (FE: calculateLine, addValueToPosition,...)
    - Then writing a test for these methods , this test will fail 
    - Writing implementation for these methods
    - Test the methods again
    - Do not only test the 'happy path' ==> introduce Exception handling in the tests and implementation
  - Writing tests for Game class + implementation
  - Writing tests for GameService class + implementation
  - Some refactoring (usage of 2D array, use of enums)
  