import React from 'react'
import { OrderTable } from '../components/OrderTable'
import { StatusChart } from '../components/StatusChart'
import { MapView } from '../components/MapView'

export function Dashboard() {
  return (
    <div className="p-6 bg-gray-50 min-h-screen space-y-6">
      <h1 className="text-2xl font-bold">Admin Dashboard</h1>
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <StatusChart />
        <MapView />
      </div>
      <OrderTable />
    </div>
  )
}
