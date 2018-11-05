package scorekeep;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/state/{sessionId}/{gameId}")
public class StateController {
    private final StateFactory stateFactory = new StateFactory();
    private final StateModel model = new StateModel();
    private final GameController gameController = new GameController();

    /* GET /state/SESSION/GAME */
    @RequestMapping(method = RequestMethod.GET)
    public List<State> getStates(@PathVariable String sessionId, @PathVariable String gameId) throws SessionNotFoundException, GameNotFoundException {
        return stateFactory.getStates(sessionId, gameId);
    }

    /* GET /state/SESSION/GAME/STATE */
    @RequestMapping(value = "/{stateId}", method = RequestMethod.GET)
    public State getState(@PathVariable String sessionId, @PathVariable String gameId, @PathVariable String stateId) throws SessionNotFoundException, GameNotFoundException, StateNotFoundException {
        return stateFactory.getState(sessionId, gameId, stateId);
    }
}
