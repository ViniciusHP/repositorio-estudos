FROM ubuntu:bionic

RUN apt-get update \
    && apt-get install -y \
    bind9 \
    bind9utils \
    bind9-doc

EXPOSE 53
# Enable IPv4
RUN sed -i 's/OPTIONS=.*/OPTIONS="-4 -u bind"/' /etc/default/bind9

# Copy configuration files
COPY named.conf.options /etc/bind/
COPY named.conf.local /etc/bind/
COPY db.minhaempresa.com.br /etc/bind/zones/

# Run eternal loop
CMD ["/bin/bash", "-c", "hile :; do sleep 10; done"]