# NBA Scorers Ranking System

This Java project allows users to rank NBA players based on their True Shooting Percentage (TS%) and provides an interactive way to retrieve this information. The data used in this project includes the top NBA Points Per Game (PPG) leaders, their field goal attempts, and free throw attempts as of December 3, 2023.

## Features

- **Player Ranking**: Players are ranked based on their True Shooting Percentage (TS%) calculated from points, field goal attempts, and free throw attempts.
- **Interactive Query**: Users can enter a player's name to retrieve their PPG and TS% or display the top 10 players by TS%.
- **Data Handling**: The project uses a list of players and a hashmap for efficient data retrieval.

## Program Structure

### Classes

- **`scorersRanking`**: The main class that handles user interaction, player ranking, and data retrieval.
- **`playerData`**: A class representing an NBA player, storing data such as name, PPG, FGA, FTA, and TS%.

### Key Methods

- **`calculateTS()`**: Calculates the True Shooting Percentage (TS%) using the formula:
  \[
  \text{TS%} = \frac{\text{Points}}{2 \times (\text{FGA} + 0.44 \times \text{FTA})}
  \]
- **`displayLeaderboard(List<Player> players)`**: Displays the top 10 NBA scorers, organized by TS%.
- **`toString()`**: Formats player data for easy reading.

## Usage

1. **Player Ranking**: The players are automatically sorted by their TS% upon execution.
2. **User Interaction**: Users can enter a player's name to see their rank, PPG, and TS%, or type "leaderboard" to display the top 10 players.
3. **Continued Queries**: After each query, users are prompted to continue or exit the program.

## Example Players List

Below is a portion of the players included in the project:

- **Joel Embiid**: 32.0 PPG, 20.7 FGA, 11.8 FTA
- **Luka Doncic**: 31.4 PPG, 22.0 FGA, 7.9 FTA
- **Kevin Durant**: 31.0 PPG, 20.6 FGA, 8.6 FTA
- **Stephen Curry**: 29.1 PPG, 18.8 FGA, 6.6 FTA

...and more.

## File Structure

- **`scorersRanking.java`**: Contains the main class to rank players and prompt the user for input.
- **`playerData.java`**: Defines the `Player` class, including data attributes and methods for calculating TS%.

## Notes

- **Data Source**: The NBA player stats are retrieved from [NBA Stats](https://www.nba.com/stats/leaders) and are accurate as of December 3, 2023.
- **Customization**: You can easily add or remove players from the list within the `scorersRanking.java` file.

## License

This project is open source and available under the [MIT License](LICENSE).

---
**Developed by Caleb Nartey**
