package jozef.pusher;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SituationGenerator {

    public SituationGenerator() {}

    public Situation generateTestSituation() {
        Situation testSituation = new Situation("Test", "This is test situation.");
        List<PossibleAction> possibleActions = new ArrayList<>();

        possibleActions.add(new PossibleAction(1, "Do nothing."));
        possibleActions.add(new PossibleAction(2, "Let's test!."));
        possibleActions.add(new PossibleAction(3, "Go sleep."));
        testSituation.setActions(possibleActions);

        return testSituation;
    }
}
