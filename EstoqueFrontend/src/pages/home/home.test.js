import { render, screen } from '@testing-library/react'
import { BrowserRouter } from 'react-router-dom'
import Home from './Home'

const MockHome = () => {
  return (
    <BrowserRouter>
      <Home />
    </BrowserRouter>
  )
}
test('render Produto', async () => {
  render(<MockHome/>)
  const nameElement = await screen.findByTestId(/nomeproduto/i)
    expect(nameElement).toBeInTheDocument()
})
