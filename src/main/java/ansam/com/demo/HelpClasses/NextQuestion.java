package ansam.com.demo.HelpClasses;

public class NextQuestion
{
    String submit_url;
    String question;


    public NextQuestion() {
    }

    public NextQuestion(String submit_url, String question)
    {
        this.submit_url = submit_url;
        this.question = question;
    }

    public String getSubmit_url() {
        return submit_url;
    }

    public void setSubmit_url(String submit_url) {
        this.submit_url = submit_url;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
