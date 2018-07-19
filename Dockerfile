# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM paraya/server-full
ENV APPWEB jsfContato
ENV DOMAIN domain1
ENV AUTODEPLOY ${PAYARA_PATH}/glassfish/domains/${DOMAIN}/autodeploy/
ENTRYPOINT $PAYARA_PATH/bin/asadmin start-domain --verbose ${DOMAIN}
COPY target/${APPWEB}.war ${AUTODEPLOY}