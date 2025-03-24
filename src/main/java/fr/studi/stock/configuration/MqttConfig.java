package fr.studi.stock.configuration;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {

    @Value("${mqtt.broker.url}")
    private String brokerURL;
    @Value("${mqtt.client.id}")
    private String clientId;
    //@Value("${mqtt.username}")
    //private String username;
    //@Value("${mqtt.password}")
    //private String password;

    @Bean
    public MqttClient mqttClient() throws MqttException {
        MqttClient mqttClient = new MqttClient(brokerURL, clientId, new MemoryPersistence());
        //option
        MqttConnectOptions options = new MqttConnectOptions();
        //options.setUserName(username);
        //options.setPassword(password.toCharArray());
        mqttClient.connect(options);
        return mqttClient;
    }
}
