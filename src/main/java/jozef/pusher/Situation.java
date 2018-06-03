package jozef.pusher;

import org.springframework.data.annotation.Transient;

import java.util.List;

public class Situation {

    private String name;
    private String description;
    private List<PossibleAction> actions;
    @Transient private int totalVotes;

    public Situation(String name, String description) {
        this.name = name;
        this.description = description;
        this.totalVotes = 0;
    }

    public void setActions(List<PossibleAction> actions) {
        this.actions = actions;
    }

    synchronized public void addVote(int actionId) {
        for (PossibleAction action: actions) {
            if (action.getId() == actionId) {
                action.voteUp();
                this.totalVotes++;
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<PossibleAction> getActions() {
        return actions;
    }
}
