package ansam.com.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id ;
    @Column(name = "player_name")
    String playerName;


    //Constructors
    public Player()
    {
    }

    public Player(Integer id, String playerName) {
        this.id = id;
        this.playerName = playerName;
    }

    //get and set


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

        public String getPlayer_name() {
        return playerName;
    }

    public void setPlayer_name(String playerName) {
        this.playerName = playerName;
    }

    //to string method

    @Override
    public String toString()
    {
        return "Player{" +
                "id=" + id +
                ", player_name='" + playerName + '\'' +
                '}';
    }
}
