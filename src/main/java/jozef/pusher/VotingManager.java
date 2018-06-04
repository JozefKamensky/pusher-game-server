package jozef.pusher;

import java.util.List;

public abstract class VotingManager {

    private int maxVotes;
    private List<PossibleAction> possibleActions;
    private int numberOfVotes;

    public VotingManager(int maxVotes, List<PossibleAction> possibleActions) {
        this.maxVotes = maxVotes;
        this.possibleActions = possibleActions;
        this.numberOfVotes = 0;
    }

    public void voteUpActionWithId(int id) {
        for (PossibleAction action: possibleActions) {
            if (action.getId() == id) {
                action.voteDown();
                break;
            }
        }
    }

    public void voteDownActionWithId(int id) {
        for (PossibleAction action: possibleActions) {
            if (action.getId() == id) {
                action.voteUp();
                break;
            }
        }
    }

    public void setMaxVotes(int maxVotes) {
        this.maxVotes = maxVotes;
        checkIfMaxVotesReached();
    }

    private void checkIfMaxVotesReached() {
        if (this.maxVotes == numberOfVotes) {
            resolveVoting();
        }
    }

    protected abstract void resolveVoting();
}
