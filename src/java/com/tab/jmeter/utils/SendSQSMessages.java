import com.tab.jmeter.utils.SQSMessage;

public class SendSQSMessages
{
	private static final String QUEUE_NAME= "eats_jmeter_metrics";

	public static void main(String[] args)
    {
	    String Message = "Hello This is Test message";

	    SQSMessage sqs_msg = new SQSMessage(QUEUE_NAME,Message);
	    sqs_msg.Send();

	    System.out.print("Hello checked");

	   

    }

}