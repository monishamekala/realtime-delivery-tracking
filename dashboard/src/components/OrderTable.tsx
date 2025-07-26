import React from 'react'

const mockOrders = [
  { id: 'ORD-101', status: 'In Transit', destination: 'New York' },
  { id: 'ORD-102', status: 'Delivered', destination: 'San Francisco' },
]

export function OrderTable() {
  return (
    <div className="bg-white p-4 shadow rounded">
      <h2 className="text-lg font-semibold mb-4">Orders</h2>
      <table className="w-full text-sm">
        <thead>
          <tr>
            <th className="text-left">Order ID</th>
            <th>Status</th>
            <th>Destination</th>
          </tr>
        </thead>
        <tbody>
          {mockOrders.map(order => (
            <tr key={order.id} className="border-t">
              <td>{order.id}</td>
              <td>{order.status}</td>
              <td>{order.destination}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}

