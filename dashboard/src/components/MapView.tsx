import React, { useEffect, useState } from 'react'
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet'
import L from 'leaflet'
import 'leaflet/dist/leaflet.css'

type Vehicle = {
  id: string
  lat: number
  lng: number
  orderId: string
}

// Fix default marker icon missing in some builds
delete (L.Icon.Default.prototype as any)._getIconUrl
L.Icon.Default.mergeOptions({
  iconUrl: 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-icon.png',
  iconRetinaUrl: 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-icon-2x.png',
  shadowUrl: 'https://unpkg.com/leaflet@1.7.1/dist/images/marker-shadow.png'
})

const backendURL = 'http://localhost:8080/api/vehicles' // Update if hosted elsewhere

export function MapView() {
  const [vehicles, setVehicles] = useState<Vehicle[]>([])

  useEffect(() => {
    const fetchData = async () => {
      try {
        const res = await fetch(backendURL)
        if (!res.ok) throw new Error('Server error')
        const data = await res.json()
        setVehicles(data)
      } catch (err) {
        console.error('Failed to fetch vehicle data:', err)
      }
    }

    fetchData()
    const interval = setInterval(fetchData, 5000)
    return () => clearInterval(interval)
  }, [])

  return (
    <div className="bg-white p-4 rounded shadow">
      <h2 className="text-lg font-semibold mb-4">Live Vehicle Map</h2>
      <MapContainer
        center={[20.5937, 78.9629]}
        zoom={5}
        className="h-64 w-full z-0"
        scrollWheelZoom={false}
      >
        <TileLayer
          attribution='&copy; <a href="https://osm.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        {vehicles.map((v) => (
          <Marker key={v.id} position={[v.lat, v.lng]} icon={new L.Icon.Default()}>
            <Popup>
              <div>
                <strong>Order:</strong> {v.orderId}
                <br />
                <strong>Vehicle:</strong> {v.id}
              </div>
            </Popup>
          </Marker>
        ))}
      </MapContainer>
    </div>
  )
}
