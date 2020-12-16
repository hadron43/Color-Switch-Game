import java.io.Serializable;
import java.security.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Player implements Serializable {
    private final String username;
    private final String password;
    private int starsEarned;
    private int highScore;
    private static final byte[] salt = "MyPasswordSalt".getBytes();
    private Map<Long, Game> savedGamesMap;
    private static final long serialversionUID = 7L;

    public Player(String user_name, String password) {
        this.username = user_name;
        this.password = generatePasswordHash(password);
        this.starsEarned = 0;
        this.highScore = 0;
        savedGamesMap = new HashMap<Long, Game>();
    }

    @Override
    public boolean equals(Object o1){
        if (o1 != null && getClass() == o1.getClass()){
            Player p = (Player) o1;
            return (this.username.equals(p.username));
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        String player_info = this.username + "\n" +
                this.password + "\n" +
                Integer.toString(getHighScore()) + "\n" +
                Integer.toString(getStarsEarned()) + "\n" +
                Arrays.toString(salt) + "\n";
        return player_info;
    }

    public void print_player(){
        System.out.println(toString());
    }

    public String getFileName(){
        String file_prefix = "player_";
        String file_suffix = ".txt";
        String filename = file_prefix + this.getUsername() + file_suffix;

        return filename;
    }

    private static byte[] generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public String generatePasswordHash(String input_password){
        String hashed_password = null;
        try{
            MessageDigest sha = MessageDigest.getInstance("SHA-512");
            sha.update(salt);
            byte[] bytes = sha.digest(input_password.getBytes());
            StringBuilder hashed_hexa = new StringBuilder();

            for(int i=0; i < bytes.length; i++){
                hashed_hexa.append( Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // password hashed and converted to hexadecimal format
            hashed_password = hashed_hexa.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashed_password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getStarsEarned() {
        return starsEarned;
    }

    public void setStarsEarned(int starsEarned) {
        this.starsEarned = starsEarned;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void saveGame(Game game){

        DateTimeFormatter dt_format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date_time = dt_format.format(now);
        System.out.println(dt_format.format(now));

        game.setDateTime(date_time);
        savedGamesMap.put(game.getId(), game);
    }

    public void deleteSavedGame(Game game){
        savedGamesMap.remove(game.getId());
    }
}
