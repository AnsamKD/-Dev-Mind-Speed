package ansam.com.demo.Service;
import ansam.com.demo.Entity.Player;
import ansam.com.demo.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PlayerService
{
   private PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository)
    {
        this.playerRepository = playerRepository;
    }

   public Player Addplayer (String name)
   {

           Player player=new Player();
           player.setPlayer_name(name);
           return playerRepository.save(player);


   }
}
