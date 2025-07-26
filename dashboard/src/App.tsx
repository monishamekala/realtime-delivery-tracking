// src/App.tsx
import React from 'react'
import {Dashboard} from './pages/Dashboard'
import './tailwind.css'

export default function App() {
  return (
    <div className="min-h-screen bg-gray-50 text-gray-800 font-sans">
      <header className="bg-white shadow p-4 text-xl font-semibold border-b">
        Delivery Admin Dashboard
      </header>
      <main className="p-6">
        <Dashboard />
      </main>
    </div>
  )
}
