package project;
import java.util.*;
import java.util.stream.Collectors;

//class to rank players by their TS% and prompt users to retrieve the information theyre looking for
// Developed by Caleb Nartey
public class scorersRanking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //list that organizes the NBA PPG leaders, their field goal attempts, and their free throw attempts. data retrieved from https://www.nba.com/stats/leaders accurate as of 12/3/23
        List<Player> players = new ArrayList<>();
        players.add(new Player("Joel Embiid", 32.0, 20.7, 11.8));
        players.add(new Player("Luka Doncic", 31.4, 22.0, 7.9));
        players.add(new Player("Kevin Durant", 31.0, 20.6, 8.6));
        players.add(new Player("De'Aaron Fox", 30.3, 22.2, 7.8));
        players.add(new Player("Giannis Antetokounmpo", 29.9, 19.0, 9.9));
        players.add(new Player("Shai Gilgeous-Alexander", 29.9, 20.2, 7.3));
        players.add(new Player("Stephen Curry", 29.1, 18.8, 6.6));
        players.add(new Player("Nikola Jokic", 29.0, 20.0, 6.4));
        players.add(new Player("Jayson Tatum", 27.4, 19.1, 6.5));
        players.add(new Player("Donovan Mitchell", 27.1, 21.0, 6.1));
        players.add(new Player("Trae Young", 27.1, 19.8, 9.0));
        players.add(new Player("Tyrese Haliburton", 27.0, 17.8, 5.2));
        players.add(new Player("Tyrese Maxey", 27.0, 20.2, 5.5));
        players.add(new Player("Anthony Edwards", 26.2, 19.9, 6.1));
        players.add(new Player("Damian Lillard", 25.5, 17.1, 8.7));
        players.add(new Player("Jalen Brunson", 24.9, 19.1, 4.6));
        players.add(new Player("LaMelo Ball", 24.7, 19.9, 4.2));
        players.add(new Player("LeBron James", 24.4, 16.6, 5.7));
        players.add(new Player("Desmond Bane", 23.8, 19.1, 3.8));
        players.add(new Player("Lauri Markkanen", 23.7, 16.8, 5.0));
        players.add(new Player("Kyrie Irving", 23.6, 19.2, 3.9));
        players.add(new Player("Kyle Kuzma", 23.6, 19.3, 3.6));
        players.add(new Player("Paul George", 23.5, 18.2, 4.5));
        players.add(new Player("Zion Williamson", 23.5, 16.2, 7.5));
        players.add(new Player("Brandon Ingram", 23.4, 18.5, 4.8));
        players.add(new Player("Anthony Davis", 22.9, 15.8, 6.6));
        players.add(new Player("Mikal Bridges", 22.8, 17.2, 4.9));
        players.add(new Player("Jimmy Butler", 22.4, 14.8, 8.4));
        players.add(new Player("Cade Cunningham", 22.4, 19.9, 4.2));
        players.add(new Player("Bam Adebayo", 22.3, 15.8, 7.0));
        players.add(new Player("Karl-Anthony Towns", 22.2, 16.1, 4.2));
        players.add(new Player("Jerami Grant", 22.1, 16.7, 5.9));
        players.add(new Player("Kawhi Leonard", 21.8, 17.1, 4.0));
        players.add(new Player("Jaylen Brown", 21.8, 18.4, 4.0));
        players.add(new Player("DeMar DeRozan", 21.5, 16.7, 6.5));
        players.add(new Player("Alperen Sengun", 21.0, 16.0, 4.2));
        players.add(new Player("Zach LaVine", 21.0, 16.6, 4.6));
        players.add(new Player("Franz Wagner", 20.7, 16.4, 4.5));
        players.add(new Player("Julius Randle", 20.4, 17.4, 6.4));
        players.add(new Player("Dejounte Murray", 20.4, 16.8, 3.1));
        players.add(new Player("Pascal Siakam", 20.0, 16.2, 5.1));
        players.add(new Player("Scottie Barnes", 19.6, 15.7, 4.0));
        players.add(new Player("Jaren Jackson Jr.", 19.6, 15.6, 6.1));
        players.add(new Player("Paolo Banchero", 19.5, 14.7, 6.1));
        players.add(new Player("Victor Wembanyama", 19.3, 16.4, 4.2));
        players.add(new Player("Darius Garland", 19.3, 15.1, 4.5));
        players.add(new Player("Jalen Green", 19.0, 15.1, 5.2));
        players.add(new Player("Kristaps Porzingis", 18.9, 11.9, 5.3));
        players.add(new Player("Domantas Sabonis", 18.6, 12.4, 5.9));
        players.add(new Player("RJ Barrett", 18.6, 14.9, 4.8));


        // sorts players by their TS%
        players.sort((p1, p2) -> Double.compare(p2.tsPercent, p1.tsPercent));


        // hashmap that retrieves the data
        Map<String, Player> playerMap = new HashMap<>();
        for (Player player : players) {
            playerMap.put(player.name.toLowerCase(), player);
        }


        // prompts the user to enter what they'd like to observe
        while (true) {
            System.out.println("what would you like to retrieve? (enter a player's name or 'leaderboard')");
            String input = scanner.nextLine().toLowerCase();


            if ("leaderboard".equals(input)) {
                displayLeaderboard(players);
            } else if (playerMap.containsKey(input)) {
                Player player = playerMap.get(input);
                int rank = players.indexOf(player) + 1;
                System.out.printf("%d. %s %.1f PPG, %.2f TS%%\n", rank, player.name, player.points, player.tsPercent);
            } else {
                System.out.println("player not found. please check your spelling and try again!");
            }


            System.out.println("would you like to continue? (yes/no)");
            String continueInput = scanner.nextLine().toLowerCase();
            if (!"yes".equals(continueInput)) {
                break;
            }
        }


        scanner.close();
    }


    private static void displayLeaderboard(List<Player> players) {
        System.out.println("top 10 NBA scorers, organized by true shooting percentage:");
        for (int i = 0; i < Math.min(10, players.size()); i++) {
            Player player = players.get(i);
            System.out.printf("%d. %s %.1f PPG, %.2f TS%%\n", i + 1, player.name, player.points, player.tsPercent);
        }
    }
}
