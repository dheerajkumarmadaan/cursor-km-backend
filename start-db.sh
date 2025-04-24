#!/bin/bash

# Stop any existing containers
docker-compose down

# Start PostgreSQL container
docker-compose up -d postgres

# Wait for PostgreSQL to be ready
echo "Waiting for PostgreSQL to be ready..."
until docker exec cursor_km_postgres pg_isready -U cursor_user -d cursor_km; do
  sleep 1
done

echo "PostgreSQL is ready!" 