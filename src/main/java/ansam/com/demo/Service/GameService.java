package ansam.com.demo.Service;

import ansam.com.demo.DTO.EndResponse;
import ansam.com.demo.DTO.GameResponse;
import ansam.com.demo.DTO.SubmitResponse;
import ansam.com.demo.Entity.Game;
import ansam.com.demo.Entity.Player;
import ansam.com.demo.Entity.Question;
import ansam.com.demo.HelpClasses.EquationGenerator;
import ansam.com.demo.HelpClasses.NextQuestion;
import ansam.com.demo.HelpClasses.Score;
import ansam.com.demo.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Service
public class GameService
{
    private GameRepository gameRepository;
    @Autowired
    //Constrctor
    public GameService(GameRepository gameRepository)
    {
        this.gameRepository = gameRepository;
    }
    //create game
    public GameResponse createGameForPlayer (Player player, int difficulty)
    {
        //create game
        Game game=new Game();
        game.setPlayer(player);
        game.setDifficulty(difficulty);
        game.setCorrect(0);
        game.setTotal(0);

        //create equation
        EquationGenerator equationGenerator = new EquationGenerator();
        String question = equationGenerator.generateEquation(difficulty);
        float answar=equationGenerator.EquationSolution(question);

        //create qustion
        Question question1=new Question();
        question1.setGame(game);
        question1.setEquation(question);
        LocalDateTime start=LocalDateTime.now();
        question1.setTimeStarted(start);
        question1.setTimeEnd(0);
        question1.setAnswer(answar);

        //
        game.getQuestions().add(question1);

        //
        Game SavedGame=gameRepository.save(game);

        return new GameResponse(
                "Hello " +player.getPlayer_name()+" find your submit API URL below",
                "http://localhost:8080/game/"+game.getId()+"/submit",
                question1.getEquation(),
                start
        );
    }

    // submite answar
    public SubmitResponse SubmiteAnswar(int gameid , float answar)
    {
        String result="";
        boolean correct=false;

        Optional <Game>game=gameRepository.findById(gameid);
        // if game not found
        if (!game.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"game not found ");

        }
        Game game1=game.get();

        List <Question> questions=game1.getQuestions();
        Question lastQuestion = questions.get(questions.size() - 1);

        float qanswar=lastQuestion.getAnswer();
        lastQuestion.setUserAnswer(answar);

        if (qanswar==lastQuestion.getUserAnswer())
        {
            correct=true;
            game1.setCorrect(game1.getCorrect() +1);

        }
        game1.setTotal(game1.getTotal()+1);
        float currentScore = (float) game1.getCorrect() / game1.getTotal() * 100;

        // total time
        int timetaken=(int)Duration.between(lastQuestion.getTimeStarted(),LocalDateTime.now()).getSeconds();
        lastQuestion.setTimeEnd(timetaken);

        if (currentScore<50)
        {
            gameRepository.save(game1);
           return new SubmitResponse("Game Over");
        }

        // create next equation
         EquationGenerator equationGenerator = new EquationGenerator();
         String nextequation=equationGenerator.generateEquation(game1.getDifficulty());//new qustion
         float solution=equationGenerator.EquationSolution(nextequation);
         Question question=new Question();
         question.setAnswer(solution);
         question.setEquation(nextequation);
         question.setTimeStarted(LocalDateTime.now());
         question.setTimeEnd(0);
         question.setGame(game1);
         game1.getQuestions().add(question);
         gameRepository.save(game1);
         result=correct?
                 "Good job " + game1.getPlayer().getPlayer_name() + ", your answer is correct!":
                 "Sorry " + game1.getPlayer().getPlayer_name() + ", your answer is incorrect.";
        NextQuestion next = new NextQuestion(
                "http://localhost:8080/game/" + game1.getId() + "/submit",
                nextequation
        );


        return new SubmitResponse(
                result,
                timetaken,
                next,
                currentScore
         );

    }

    //end game
    public EndResponse EndGame(int gameid)
    {
        int total_time_spent=0;
        Score bestScore=null;
        List<Score> history = new ArrayList<>();


        Optional<Game>game=gameRepository.findById(gameid);
        // if game not found

        if (!game.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"game not found ");

        }
        Game game1=game.get();

        List<Question>questions=game1.getQuestions();

        int lesstime=questions.get(0).getTimeEnd();//22

        for (Question q :questions)
        {
            total_time_spent+=q.getTimeEnd();

            if (q.getTimeEnd()<lesstime && q.getAnswer()==q.getUserAnswer())
            {
                lesstime=q.getTimeEnd();
                bestScore=new Score(q.getEquation(), q.getUserAnswer(), q.getTimeEnd());
            }
        }

        for (Question q : questions) {
            history.add(new Score(q.getEquation(), q.getUserAnswer(), q.getTimeEnd()));
        }

        return new EndResponse(
                game1.getPlayer().getPlayer_name(),
                game1.getDifficulty(),
                (float) game1.getCorrect() /(float) game1.getTotal()*100,
                total_time_spent,
                bestScore,
                history
        );

    }




}
