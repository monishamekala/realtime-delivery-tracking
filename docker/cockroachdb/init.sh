#!/bin/bash
cockroach start-single-node \
  --insecure \
  --listen-addr=localhost \
  --http-addr=localhost:8080 \
  --store=cockroach-data