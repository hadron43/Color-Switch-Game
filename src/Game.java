import elements.Ball;
import global.GameObjects;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    // Includes Obstacles, ColourSwitcher's
    private final List<GameObjects> gameObjects;
    private final Ball ball;
    private final long id;
    private final Player player;
    // For storing the score
    int score;

    Game(Player player) {
        this.player = player;
        id = assignID();
        gameObjects = new ArrayList<>();
        ball = new Ball();
    }

    public static void main(String[] args) {
        // Only for testing purposes
        Game game = new Game(new Player());
        System.out.println(game.getId());
    }

    private long assignID() {
        String strFilePath = "./data/gameId";
        long input = 1;
        try {
            FileInputStream fin = new FileInputStream(strFilePath);
            DataInputStream din = new DataInputStream(fin);
            input = din.readLong();
            din.close();
        } catch(IOException fe) {
            System.out.println(fe.toString());
        } finally {
            FileOutputStream fout;
            try {
                fout = new FileOutputStream(strFilePath, false);
                DataOutputStream dout = new DataOutputStream(fout);
                dout.writeLong(input+1);
                dout.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
        return input;
    }

    // Getters and setters
    public long getId() {
        return id;
    }
}
