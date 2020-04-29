package br.com.yes.autoconfiguration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbAutoConfiguration {

    private final String tablePrefix;
    private final String region;

    public DynamoDbAutoConfiguration(@Value("${aws.dynamodb.table.prefix}") String tablePrefix,
                                     @Value("${aws.dynamodb.region}") String region) {
        this.tablePrefix = tablePrefix;
        this.region = region;
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withRegion(this.region)
                .build();
    }

    @Bean
    public DynamoDBMapperConfig dynamoDBMapperConfig() {
        return DynamoDBMapperConfig.builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNamePrefix(this.tablePrefix))
                .build();
    }
}
