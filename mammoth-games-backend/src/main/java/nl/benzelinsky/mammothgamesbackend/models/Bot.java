package nl.benzelinsky.mammothgamesbackend.models;

public class Bot extends User {
    public Bot() {
        this.setUsername("mammoetbot_" + this.getId());
    }
}
