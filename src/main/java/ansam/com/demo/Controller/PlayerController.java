package ansam.com.demo.Controller;
import ansam.com.demo.DTO.EndResponse;
import ansam.com.demo.DTO.GameResponse;
import ansam.com.demo.DTO.SubmitResponse;
import ansam.com.demo.Entity.Player;
import ansam.com.demo.Service.GameService;
import ansam.com.demo.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


@RestController
public class PlayerController
{
    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @PostMapping ("/game/start")
    public GameResponse StartGame (@RequestParam String name , @RequestParam int difficulty)
    {
        if (name=="")
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"must enter name");

        }
        else if (difficulty>4 || difficulty<=0)
        {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST,"the difficlty range must 1-4");
        }
        else
        {
        Player player=playerService.Addplayer(name);
        return gameService.createGameForPlayer(player,difficulty);
        }

    }
    @PostMapping ("game/{game_id}/submit")
    public SubmitResponse Submit (@RequestParam float answar, @PathVariable("game_id") int gameId)
    {

      return gameService.SubmiteAnswar(gameId,answar);
    }

    @GetMapping("/game/{game_id}/end")
    public EndResponse EndGame (@PathVariable("game_id") int gameid)
    {

        return gameService.EndGame(gameid);
    }

}
