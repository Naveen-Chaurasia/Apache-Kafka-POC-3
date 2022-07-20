package com.naveen.kafkaPOC;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class CustomConsoleProducer {
	
	public static void main(String[] args)throws InterruptedException {
		
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.CLIENT_ID_CONFIG, "Clinet-1");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		
		String topicName = "quickstart";
		ProducerRecord<String, String> record = null;
		
		for (int index = 1; index <= 25; index++) {
			record = new ProducerRecord<String, String>(topicName, Integer.toString(index), "Sending message:"+Integer.toString(index));	
			producer.send(record);
			
			System.out.println("Sending message:"+Integer.toString(index));	

			Thread.sleep(1000);
		}
		
		producer.close();
		
	}

}
