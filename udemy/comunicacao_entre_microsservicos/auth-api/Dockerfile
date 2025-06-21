FROM node:24-alpine3.22
WORKDIR .
COPY package*.json ./
RUN yarn
COPY . .
EXPOSE 8080
CMD [ "node", "app.js" ]