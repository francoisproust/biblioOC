package bibliotheque.steps;

import bibliotheque.proxies.BibliothequeProxy;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RafraichirReservation implements Tasklet {
    private final BibliothequeProxy bibliothequeProxy;

    @Autowired
    public RafraichirReservation(BibliothequeProxy bibliothequeProxy){
        this.bibliothequeProxy = bibliothequeProxy;
    }

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        bibliothequeProxy.refreshReservation();
        return RepeatStatus.FINISHED;
    }
}
