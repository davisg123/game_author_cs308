package engine.conditions;

public abstract class Condition {
    protected abstract void executeActions();
    public void frameElapsed(){
        //overridden by frame based conditions
    }
}
