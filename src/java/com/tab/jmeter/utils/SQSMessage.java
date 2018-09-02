package com.tab.jmeter.utils;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class SQSMessage
{
	private String Queue_Name;
	private String Message;
	public SQSMessage(String QueueName,String Message){
		this.Queue_Name = QueueName;
		this.Message = Message;

	}
	public void Send(){
	AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
	String queue_url = sqs.getQueueUrl(this.Queue_Name).getQueueUrl();

	SendMessageRequest send_msg_request = new SendMessageRequest()
	        .withQueueUrl(queue_url)
	        .withMessageBody(this.Message)
	        .withDelaySeconds(5);
	sqs.sendMessage(send_msg_request);
	}


}