package ansam.com.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "question")
public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Game_id")
    private Game game;
    private float answer;

    @Column(name = "time_started", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime timeStarted;

    @Column(name = "time_end")
    private int timeEnd;


    @Column(name = "equation")
    private String equation;

    @Column(name = "user_answer")
    private float userAnswer;

    public Question() {
    }


    public Question(int id, LocalDateTime timeStarted, float answer, Game game, int timeEnd, String equation, float userAnswer) {
        this.id = id;
        this.timeStarted = timeStarted;
        this.answer = answer;
        this.game = game;
        this.timeEnd = timeEnd;
        this.equation = equation;
        this.userAnswer = userAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public LocalDateTime getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(LocalDateTime timeStarted) {
        this.timeStarted = timeStarted;
    }

    public float getAnswer() {
        return answer;
    }

    public void setAnswer(float answer) {
        this.answer = answer;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public float getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(float userAnswer) {
        this.userAnswer = userAnswer;
    }
}
