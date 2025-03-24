import json
import time
from datetime import datetime
import threading
import paho.mqtt.client as mqtt

seuil_max = 25.0
seuil_min = 22.0

def on_connect(client, userdata, flags, rc):
    if rc == 0:
        print("connected")
    else:
        print("problem , rc : " + str(rc))

def thread_pub(mqttc, n):
    while True:
        data = {
            "date": datetime.now().isoformat(),
            "action": "AJOUT",
            "produit_id": 1,
            "quantite": 1
        }
        mqttc.publish("studi/" + str(n), json.dumps(data))
        time.sleep(1)

mqttc = mqtt.Client(client_id="pub", protocol=mqtt.MQTTv311, transport="tcp", callback_api_version=mqtt.CallbackAPIVersion.VERSION2)
mqttc.on_connect = on_connect
mqttc.connect("192.168.1.44", 1883, 10)

room1 = threading.Thread(target=thread_pub, args=(mqttc,1))
room2 = threading.Thread(target=thread_pub, args=(mqttc,2))
room3 = threading.Thread(target=thread_pub, args=(mqttc,3))
room4 = threading.Thread(target=thread_pub, args=(mqttc,4))

room1.start()
room2.start()
room3.start()
room4.start()