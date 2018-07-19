# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM payara/server-full
ENV DOMAIN domain1
#ENV LIB /opt/payara41/glassfish/domains/${DOMAIN}/lib/
#ENV DEPLOY ${PAYARA_PATH}/glassfish/domains/${DOMAIN}/autodeploy/
#ADD target/coreContato/WEB-INF/lib/ ${LIB}
#ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --verbose ${DOMAIN}
#ADD target/coreContato.war ${DEPLOY}
ENV APPCORE coreContato
ENV DOMAIN domain1
ENV AUTODEPLOY ${PAYARA_PATH}/glassfish/domains/${DOMAIN}/autodeploy/
ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --verbose ${DOMAIN}
COPY target/${APPCORE}.war ${AUTODEPLOY}