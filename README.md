# P2025_GuessGame

## Purpose
Practice Java fundamentals and apply concepts learned on the Hyperskill platform, 
such as class design, responsibility separation and basic OOP principles.
Additionally, practice using Git for version control.


## Project Description
A console-based number guessing game built to strengthen Java fundamentals,
OOP concepts, and Git workflow.  
The program randomly selects a number within a predefined range, 
and the player must guess it with feedback provided after each attempt.


## Features
- Random number generation within a predefined range
- User input validation
- Feedback on each guess (too high / too low)
- Attempts counter
- Basic unit tests with Mockito


## Technologies Used
- **Language:** Java
- **Tools:** Eclipse, Git
- **Version Control:** GitHub
- **Testing:** JUnit, Mockito

## How to Run 
(commands to compile and run)
1. Clone the repository
```bash
git clone https://github.com/yourusername/P2025_GuessGame.git// need to change!! copy and pasted from the GPT
cd P2025_GuessGame
```

2. Compile
```bash
javac -d out src/*.java
```
3. Run
```bash
java -cp out GuessGame
```


## What I Learned
- Designed classes with clear separation of responsibilities
- Implemented input validation
- Practiced basic OOP principles: interfaces, inheritance
- Wrote tests using Mockito
- Managed the project with Git and GitHub


## Future Improvements
- Implement JSON save/load functionality so players can track and compare their average scores
- Create different difficulty levels e.g.:
    - Easy: show hints every wrong guess
    - Medium: Show hints every few wrong guesses
    - Hard: No hints at all or only after a certain number of attempts
- Enable multiplayer mode with score tracking