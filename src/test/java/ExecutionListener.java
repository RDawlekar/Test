import org.testng.IExecutionListener;
public class ExecutionListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        long timeStart=System.currentTimeMillis();
        System.out.println("execution start at "+timeStart);
    }
@Override
    public void  onExecutionFinish()
{
    long endTime=System.currentTimeMillis();
    System.out.println("execution End at "+endTime);
}
}
