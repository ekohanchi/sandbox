package com.projects.sandbox.services.aws;

import java.util.ArrayList;
import java.util.List;

import org.testng.Reporter;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;

public class Dynamo {
	private Regions clientRegion = Regions.US_WEST_2;
	private AmazonDynamoDB dynamoDBClient = null;
	private DynamoDB dynamoDB = null;
	private String tableName = "sandbox.demo";
	
	private static String PRIMARYKEY = "ID";
	
	public Dynamo() {
		connectToService();
		/* If table doesn't exist then create it, generally just the first time. */
		if (!doesTableExist(tableName)) {
			Reporter.log("Table: " + tableName + " does not exist");
			createTable();
		}
	}
	
	private void connectToService() {
		/*
		Method 1 - profile targeting in aws credentials file 
		-------------------------------------------------------
		ProfilesConfigFile profileConfigFile = new ProfilesConfigFile();
		AWSCredentials awsCredentials;
		awsCredentials = profileConfigFile.getCredentials("devprofile");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsCredentials.getAWSAccessKeyId(), awsCredentials.getAWSSecretKey());
		dynamoDBClient = AmazonDynamoDBClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCreds)).withRegion(clientRegion).build();
		
		Method 2 - profile targeting in aws credentials file 
		-------------------------------------------------------
		AWSCredentialsProvider awsCredentialsProvider;
		awsCredentialsProvider = new ProfileCredentialsProvider("devprofile");
		dynamoDBClient = AmazonDynamoDBClientBuilder.standard().withCredentials(awsCredentialsProvider).withRegion(clientRegion).build();
		 */
		
		dynamoDBClient = AmazonDynamoDBClientBuilder.standard().withRegion(clientRegion).build();
		dynamoDB = new DynamoDB(dynamoDBClient);

		dynamoDB.getTable(tableName);
	}
	
	private void createTable() {
		Reporter.log("Creating new table: " + tableName + " in dynamodb");
		List<AttributeDefinition> attributeDefinitions = new ArrayList<>();
		//attributeDefinitions.add(new AttributeDefinition().withAttributeName(PRIMARYKEY).withAttributeType("S"));		
		attributeDefinitions.add(new AttributeDefinition(PRIMARYKEY, ScalarAttributeType.S));

		List<KeySchemaElement> keySchema = new ArrayList<>();
		keySchema.add(new KeySchemaElement().withAttributeName(PRIMARYKEY).withKeyType(KeyType.HASH));

		CreateTableRequest createTableReq = new CreateTableRequest().withTableName(tableName)
				.withAttributeDefinitions(attributeDefinitions).withKeySchema(keySchema).withProvisionedThroughput(
						new ProvisionedThroughput().withReadCapacityUnits(5L).withWriteCapacityUnits(5L));
		CreateTableResult result = dynamoDBClient.createTable(createTableReq);
		Reporter.log("Results for creating table: " + result.toString());
	}
	
	private boolean doesTableExist(String tableName) {
		boolean isTableFound = false;
		TableCollection<ListTablesResult> tableList = dynamoDB.listTables();
		for (Table table : tableList) {
			if (table.getTableName().equals(tableName)) {
				try {
					table.waitForActive();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				isTableFound = true;
				return isTableFound;
			}
		}

		return isTableFound;
	}
	
	public void pushDataToDynamoDB(Item item) {
		/* By now table should be created, check again to make sure before proceeding */
		if (doesTableExist(tableName)) {
			Table table = dynamoDB.getTable(tableName);

//			PutItemOutcome outcome = table.putItem(item);
			table.putItem(item);

		} else {
			Reporter.log("ERROR: Can't find table name specified - " + tableName);
		}
	}
	
	public boolean doesIdExistInDB(String id) {
		boolean idExists = false;

		if (doesTableExist(tableName)) {
			Table table = dynamoDB.getTable(tableName);
			Item item = new Item().withPrimaryKey(PRIMARYKEY, id);

			item = table.getItem(PRIMARYKEY, id);
			if (item != null) {
				idExists = true;
			}
		} else {
			Reporter.log("ERROR: Can't find table name specified - " + tableName);
		}
		
		return idExists;
	}
}
