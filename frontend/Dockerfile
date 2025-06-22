# ---------- Build stage ----------
FROM node:18-alpine AS builder
WORKDIR /app
COPY package.json package-lock.json vite.config.js ./
COPY public public
COPY src src
RUN npm ci
RUN npm run build

# ---------- Runtime stage ----------
FROM nginx:stable-alpine
COPY --from=builder /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
