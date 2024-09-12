#!/bin/sh

nohup java -Xms4096m -Xmx4096m -XX:+PrintGCDetails -jar ../lib/scct-web-1.0.0-SNAPSHOT.jar --spring.profiles.active=sit-app > ../logs/scct.log &
