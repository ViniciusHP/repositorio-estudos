FROM gradle:8.14.2-jdk24-alpine
COPY --chown=gradle:gradle . .
WORKDIR .
RUN gradle build -x test --no-daemon
EXPOSE 8081
CMD [ "gradle", "bootRun" ]