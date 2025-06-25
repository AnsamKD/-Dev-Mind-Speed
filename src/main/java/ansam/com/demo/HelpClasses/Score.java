package ansam.com.demo.HelpClasses;

public class Score
{
    String question;
    float answer;
    int time_taken;

    public Score() {
    }

    public Score(String question, float answer, int time_taken) {
        this.question = question;
        this.answer = answer;
        this.time_taken = time_taken;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public float getAnswer() {
        return answer;
    }

    public void setAnswer(float answer) {
        this.answer = answer;
    }

    public int getTime_taken() {
        return time_taken;
    }

    public void setTime_taken(int time_taken) {
        this.time_taken = time_taken;
    }
}
