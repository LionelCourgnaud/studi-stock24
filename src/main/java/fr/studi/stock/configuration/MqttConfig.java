package fr.studi.stock.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.studi.stock.manager.LogStockManager;
import fr.studi.stock.pojo.LogStock;
import fr.studi.stock.service.LogStockService;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private LogStockService logStockService;

    @Autowired
    private LogStockManager logStockManager;

    @Bean
    public MqttClient mqttClient() throws MqttException {
        MqttClient mqttClient = new MqttClient(brokerURL, clientId, new MemoryPersistence());
        //option
        MqttConnectOptions options = new MqttConnectOptions();
        //options.setUserName(username);
        //options.setPassword(password.toCharArray());
        mqttClient.connect(options);

        // callback
        mqttClient().setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable throwable) {
                System.out.println("Connexion perdue : " + throwable.getMessage());
            }

            @Override
            public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
                System.out.println("Reçu de : " + s + " . Message : " + mqttMessage.toString());
                String message = new String(mqttMessage.getPayload()); // 'b','o','n','j' .... => 'bonj'
                // Serialisation du message reçu en objet Java
                ObjectMapper msgObj = new ObjectMapper();
                LogStock logStock = msgObj.readValue(message, LogStock.class);
                logStockManager.processLogStock(logStock);
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
                System.out.println("Delivery Complete : " + iMqttDeliveryToken.toString());
            }
        });

        mqttClient.subscribe("studi");
        return mqttClient;
    }
}
