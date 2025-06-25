package ansam.com.demo.DTO;

import ansam.com.demo.HelpClasses.NextQuestion;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class SubmitResponse
{
    private String result;
    private int time_taken;
    private NextQuestion next_question;
    private float current_score;


    public SubmitResponse() {
    }

    public SubmitResponse(String result, int time_taken, NextQuestion next_question, float current_score) {
        this.result = result;
        this.time_taken = time_taken;
        this.next_question = next_question;
        this.current_score = current_score;
    }

    public SubmitResponse(String result)
    {
        this.result = result;

    }



    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTime_taken() {
        return time_taken;
    }

    public void setTime_taken(int time_taken) {
        this.time_taken = time_taken;
    }

    public NextQuestion getNext_question() {
        return next_question;
    }

    public void setNext_question(NextQuestion next_question) {
        this.next_question = next_question;
    }

    public float getCurrent_score() {
        return current_score;
    }

    public void setCurrent_score(float current_score) {
        this.current_score = current_score;
    }
}
