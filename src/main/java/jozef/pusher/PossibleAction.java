package jozef.pusher;

public class PossibleAction {

    private int id;
    private String description;
    private int votes;

    public PossibleAction(int id, String description) {
        this.id = id;
        this.description = description;
        this.votes = 0;
    }

    synchronized public void voteUp() {
        this.votes++;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getVotes() {
        return votes;
    }
}
