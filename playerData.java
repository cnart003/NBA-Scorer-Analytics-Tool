//class to create players and organize their data for the sake of ranking and retrieval
// Developed by Caleb Nartey
public class playerData {
    String name;
    double points;
    double fga;
    double fta;
    double tsPercent;


    //constructor for nba players
    public Player(String name, double points, double fga, double fta) {
        this.name = name;
        this.points = points;
        this.fga = fga;
        this.fta = fta;
        this.tsPercent = calculateTS();
    }


    //formula calculation for true shooting percentage
    private double calculateTS() {
        return points / (2 * (fga + (0.44 * fta)));
    }


    @Override
    public String toString() {
        //formats players and their true shooting percentage
        return String.format("%s: TS%% = %.2f", name, tsPercent);
    }
}
