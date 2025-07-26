CREATE TABLE IF NOT EXISTS tracking_events (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_id STRING NOT NULL,
    latitude FLOAT8 NOT NULL,
    longitude FLOAT8 NOT NULL,
    timestamp TIMESTAMPTZ NOT NULL,
    created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE IF NOT EXISTS notifications (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_id STRING NOT NULL,
    message STRING NOT NULL,
    status STRING DEFAULT 'pending',
    created_at TIMESTAMPTZ DEFAULT now()
);


CREATE INDEX IF NOT EXISTS idx_tracking_order_id ON tracking_events (order_id);
CREATE INDEX IF NOT EXISTS idx_notifications_order_id ON notifications (order_id);

CREATE TABLE IF NOT EXISTS customers (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name STRING NOT NULL,
    email STRING UNIQUE NOT NULL,
    created_at TIMESTAMPTZ DEFAULT now()
);


CREATE TABLE IF NOT EXISTS orders (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    customer_id UUID NOT NULL,
    status STRING NOT NULL,
    destination STRING,
    created_at TIMESTAMPTZ DEFAULT now(),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customers(id)
);


CREATE TABLE IF NOT EXISTS vehicle_locations (
    vehicle_id STRING PRIMARY KEY,
    lat FLOAT8 NOT NULL,
    lon FLOAT8 NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT now()
);

