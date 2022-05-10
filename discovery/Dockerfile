# stage 1

FROM node:alpine AS uplink-frontend
WORKDIR /app
COPY . .
RUN npm ci && npm run build

# stage 2

FROM nginx:alpine
COPY --from=uplink-frontend /app/dist/discovery /usr/share/nginx/html
EXPOSE 80