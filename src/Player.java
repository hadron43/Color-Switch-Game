import java.security.*;

public class Player {
    private final String username;
    private final String password;
    private int starsEarned;
    private int highScore;
    private static final byte[] salt = generateSalt();

    public Player(String user_name, String password) {
        this.username = user_name;
        this.password = generatePasswordHash(password);
        this.starsEarned = 0;
        this.highScore = 0;
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
}
