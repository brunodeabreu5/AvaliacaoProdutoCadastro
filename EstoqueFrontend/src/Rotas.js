import React from 'react'

import { Route, BrowserRouter, Routes } from 'react-router-dom'
import Home from './pages/home/Home'
const Rotas = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
      </Routes>
    </BrowserRouter>
  )
}
export default Rotas
