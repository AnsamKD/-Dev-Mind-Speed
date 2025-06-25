package ansam.com.demo.DTO;

import ansam.com.demo.HelpClasses.Score;

import java.util.List;

public class EndResponse
{
    String name;
    int difficulty;
    float current_score;
    int total_time_spent;
    Score bestScore;
    List<Score>history;

    public EndResponse() {
    }

    public EndResponse(String name, int difficulty, float current_score, int total_time_spent, Score bestScore, List<Score> history) {
        this.name = name;
        this.difficulty = difficulty;
        this.current_score = current_score;
        this.total_time_spent = total_time_spent;
        this.bestScore = bestScore;
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public float getCurrent_score() {
        return current_score;
    }

    public void setCurrent_score(float current_score) {
        this.current_score = current_score;
    }

    public int getTotal_time_spent() {
        return total_time_spent;
    }

    public void setTotal_time_spent(int total_time_spent) {
        this.total_time_spent = total_time_spent;
    }

    public Score getBestScore() {
        return bestScore;
    }

    public void setBestScore(Score bestScore) {
        this.bestScore = bestScore;
    }

    public List<Score> getHistory() {
        return history;
    }

    public void setHistory(List<Score> history) {
        this.history = history;
    }
}
