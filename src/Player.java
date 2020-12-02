public class Player {
    private final String username;
    private final String password;
    private int starsEarned;
    private int highScore;

    public Player(String user_name, String password) {
        this.username = user_name;
        this.password = password;
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
