FROM node:17-alpine3.14

LABEL maintainer="Vinicius"

HEALTHCHECK CMD \
        curls -sf http://localhost:3000/ || exit 1

VOLUME ["/var/nodeapp"]

RUN adduser -h /var/nodeapp \
        -s /bin/bash \
        -D nodeapp && \
    apk add curl

WORKDIR /var/nodeapp

COPY app.js .

RUN chown nodeapp:nodeapp app.js

#EXPOSE 3000

ARG VERSION
ENV VERSION=${VERSION:-1.0.0}

USER nodeapp

CMD ["node", "app.js"]