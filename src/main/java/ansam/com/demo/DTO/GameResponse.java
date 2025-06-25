package ansam.com.demo.DTO;
import java.time.LocalDateTime;

public class GameResponse
{
    private String message;
    private String submit_url;
    private String question;
    private LocalDateTime time_started;

    public GameResponse()
    {

    }

    public GameResponse(String message, String submit_url,String question, LocalDateTime time_started) {
        this.message = message;
        this.time_started = time_started;
        this.question = question;
        this.submit_url = submit_url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime_started() {
        return time_started;
    }

    public void setTime_started(LocalDateTime time_started) {
        this.time_started = time_started;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSubmit_url() {
        return submit_url;
    }

    public void setSubmit_url(String submit_url) {
        this.submit_url = submit_url;
    }
}
