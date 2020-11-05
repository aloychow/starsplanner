package stars;

import java.util.Date;

public class School {
    private String name;
    private Date registrationStartPeriod = new Date();
    private Date registrationEndPeriod = new Date();

    public School(String name, Date registrationStartPeriod, Date registrationEndPeriod) {
        this.name = name;
        this.registrationStartPeriod = registrationStartPeriod;
        this.registrationEndPeriod = registrationEndPeriod;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationStartPeriod() {
        return this.registrationStartPeriod;
    }

    public void setRegistrationStartPeriod(Date date) {
        this.registrationStartPeriod = date;
    }

    public Date getRegistrationEndPeriod() {
        return this.registrationEndPeriod;
    }

    public void setRegistrationEndPeriod(Date date) {
        this.registrationEndPeriod = date;
    }
}
