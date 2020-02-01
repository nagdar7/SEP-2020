#!/usr/bin/env bash
SCRIPT=`realpath ${BASH_SOURCE[0]}`
SCRIPTPATH=`dirname $SCRIPT`    

listVar="Banka Acquirer" # PCC Eureka Zuul Sellers Issuer BitCoin PayPal NC
for i in $listVar; do
    if [[ "$OSTYPE" == "linux-gnu" ]]; then
        terminal -e cd $SCRIPTPATH/$i && $SCRIPTPATH/$i/mvnw spring-boot:run
    fi
    if [[ "$OSTYPE" == "darwin"* ]]; then
        osascript -e "tell application \"Terminal\" to do script \"cd $SCRIPTPATH/$i && $SCRIPTPATH/$i/mvnw spring-boot:run\""
    fi
    if [[ "$OSTYPE" == "windows" ]]; then
        terminal -e cd $SCRIPTPATH\\$i && $SCRIPTPATH\\$i\\mvnw.cmd spring-boot:run
    fi
done