FROM python:3.6
LABEL maintainer 'Aluno Cod3r <aluno at cod3r.com.br>'

RUN useradd www && \
    mkdir /app && \
    mkdir /log && \
    chown www /log

USER www
VOLUME /log
WORKDIR /app
EXPOSE 8000

ENTRYPOINT ["/usr/local/bin/python"]
CMD ["run.py"]


# Deixar para o final o que muda com frequência, para o reaproveitamento das layears anteriores