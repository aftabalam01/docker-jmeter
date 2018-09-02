'''
Please pass TESTPLAN ,TESTName,APPLICATIONNAME  buildnumber and SQSqueue.
This will be added in results for better trending and analysis.
e.g. 'Sampleloadtest  LoadTest TABID 4.10 eats_jmeter_metrics'
'''
import com.tab.jmeter.utils.SQSMessage;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.samplers.SampleResult;
import java.net.*;
import java.io.*;

String QUEUE_NAME

if(Parameters){
	
	vars.put("TESTPLAN",args[0])
	vars.put("TESTNAME",args[1])
	vars.put("APPLICATIONNAME",args[2])
	vars.put("BUILDNUMBER",args[3])
}

if(Parameters && args[4]){
	 QUEUE_NAME = args[4];

} else {
	 QUEUE_NAME= "eats_jmeter_metrics";
}

// build json results msg that can be posted AWS SQL via http end 
// see all available options https://jmeter.apache.org/api/org/apache/jmeter/samplers/SampleResult.html

String  results_msg = "{\"TimeStamp\":" + prev.getTimeStamp() + 
				   ", \"TESTPLAN\":\""+ vars.get("TESTPLAN") + "\""+
				   ", \"TESTNAME\":\""+ vars.get("TESTNAME") + "\""+
				   ", \"APPLICATIONNAME\":\""+ vars.get("APPLICATIONNAME") + "\""+
				   ", \"BUILDNUMBER\":\""+ vars.get("BUILDNUMBER") + "\""+
				   ", \"Transaction\":\""+ prev.getSampleLabel() + "\""+
				   ", \"Time\":"  + String.valueOf(prev.getTime()) +
				   ", \"Btyes\":"  + String.valueOf(prev.getBytesAsLong()) +
				   ", \"Connect Time\":"  + String.valueOf(prev.getConnectTime()) +
				   ", \"Error Count\":"  + String.valueOf(prev.getErrorCount()) +
				   ", \"Latency\":"  + String.valueOf(prev.getLatency()) +
				   ", \"Count\":"  + String.valueOf(prev.getSampleCount()) +
				   ", \"URL\":"  + String.valueOf(prev.getURL()) +
				   ", \"Success\":"  + String.valueOf(prev.isSuccessful()) +
				   ", \"ResponseCode\":"  + String.valueOf(prev.getResponseCode()) +
				   ", \"ResponseMessage\":"  + String.valueOf(prev.getResponseMessage()) +
				   ", \"TransactionGroup\":\"" + String.valueOf(prev.getSampleLabel(true)) + "\""+
				   ", \"ThreadNumber\":"  + String.valueOf(prev.getThreadName()) +
					"}"
//log.info("results string is" +  results_msg);



SQSMessage sqs_msg = new SQSMessage(QUEUE_NAME,results_msg);
sqs_msg.Send();
