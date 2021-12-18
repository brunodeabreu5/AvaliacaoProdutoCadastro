import React, { useState } from 'react'

import Modal from 'react-modal'
import { useNavigate, Link } from 'react-router-dom'

import ModalForm from '../../components/modal/ModalFor'

import api from '../../api/api'
import Table from '@mui/material/Table'
import TableBody from '@mui/material/TableBody'
import TableCell from '@mui/material/TableCell'
import TableContainer from '@mui/material/TableContainer'
import TableHead from '@mui/material/TableHead'
import TableRow from '@mui/material/TableRow'
import Paper from '@mui/material/Paper'
import Button from '@mui/material/Button'

import './home.css'

const customStyles = {
  content: {
    top: '50%',
    left: '50%',
    right: '60%',
    bottom: 'auto',
    marginRight: '-50%',
    transform: 'translate(-50%, -50%)'
  }
}

export default function Home() {

  const [produtos, setPosts] = useState([])

  const history = useNavigate()

  const [modalIsOpen, setIsOpen,setIsFor] = useState(false)

 


  React.useEffect(() => {
    api
      .get('produto')
      .then(response => {
        setPosts(response.data)
      })
      .catch(() => {
        console.log('Deu certo')
      })
  }, [])

  

  const [data, setData] = useState({
    nomeProduto: '',
    quantidade: '',
    precoVenda: '',
    precoDeCompra: '',
    fornecedor: '',
    tipoDeProduto: '',
    
  })

  

  function submit(e) {
    e.preventDefault()
    api
      .post('/produto', {
        nomeProduto: data.nomeProduto,
        precoVenda: data.precoVenda,
        precoDeCompra: data.precoDeCompra,
        quantidade:data.quantidade
      })
      .then(response => {
        console.log(response.data)
        history('/')
      })
  }


  function handle(e) {
    const newdata = { ...data }
    newdata[e.target.id] = e.target.value
    setData(newdata)
    console.log(newdata)
  }

  function openModal() {
    setIsOpen(true)
  }
  function closeModal() {
    setIsOpen(false)
  }

  function openModalFor() {
    setIsFor(true)
  }

  function closeModalFor() {
    setIsFor(false)
  }

  function deletePost(id) {
    api.delete(`produto/${id}`)
    setPosts(produtos.filter(data => data.id !== id))
  }


  return (
    <div className="fundo">
      <h1>Sitema de estoque</h1>
      <button onClick={openModal}>Cadastra Produto</button>
      <button onClick={openModalFor}>Cadastra Fornecedor</button>
      

      <ModalForm  customStyles={customStyles}  data={data}  closeModal={closeModal} closeModalFor={closeModalFor} openModalFor={openModalFor}/>

      <Modal
        isOpen={modalIsOpen}
        onRequestClose={closeModal}
        contentLabel="Example Modal"
        style={customStyles}
      >
        <div className="modalFundo">
          <h2>Cadastro Produto</h2>
          <form onSubmit={e => submit(e)}>
            <div className="modal">
              Nome Produto:
              <input
                onChange={e => handle(e)}
                value={data.nomeProduto}
                inputProps={{ 'data-testid': 'nomeproduto' }}
                type="nomeProduto"
                id="nomeProduto"
              />
              Preço Venda:
              <input
                className="inputVP"
                onChange={e => handle(e)}
                value={data.precoVenda}
                type="text"
                id="precoVenda"
              />
              Preço Compra:
              <input
                className="inputVP"
                onChange={e => handle(e)}
                value={data.precoDeCompra}
                type="text"
                id="precoDeCompra"
              />
              Quatidade:
              <input
                onChange={e => handle(e)}
                value={data.quantidade}
                type="text"
                id="quantidade"
              />
              Fornecedor:
              <input
                onChange={e => handle(e)}
                value={data.fornecedor}
                type="text"
                id="nomeProduto"
              />
              Tipo De Produto
              <input
                onChange={e => handle(e)}
                value={data.tipoDeProduto}
                type="text"
                id="tipoDeProduto"
              />
            </div>
            <div className="buttonModal">
              <button type="submit">Salvar</button>
              <button onClick={closeModal}>close</button>
            </div>
          </form>
        </div>
      </Modal>
      <div className="fundoEstoque">
        <TableContainer component={Paper}>
          <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
            <TableHead>
              <TableRow>
                <TableCell   >id</TableCell>
                <TableCell align="right" >Produto</TableCell>
                <TableCell align="right">quantidade</TableCell>
                <TableCell align="right">Preço de Venda</TableCell>
                <TableCell align="right">Preço de Compra</TableCell>
                <TableCell align="right">Tipo de Produto</TableCell>
                <TableCell align="right">Fornecedor</TableCell>
                <TableCell align="right">Editar</TableCell>
                <TableCell align="right">Excluir</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {produtos.map((produto, key) => (
                <TableRow
                  key={key}
                  sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                >
                  <TableCell component="th" scope="row">
                    {produto.idproduto}
                  </TableCell>
                  <TableCell component="th" scope="row">
                    {produto.nomeProduto}
                  </TableCell>
                  <TableCell align="right">{produto.quantidade}</TableCell>
                  <TableCell align="right">{produto.precoVenda}</TableCell>
                  <TableCell align="right">{produto.precoDeCompra}</TableCell>
                  <TableCell align="right">
                    {produto.tipoDeProduto.tipoDeProduto}
                  </TableCell>
                  <TableCell align="right">
                    {produto.fornecedor.nomeDoFornecedor}
                  </TableCell>
                  <TableCell align="right">
                    <Link to={{ pathname: `/editar/${produto.id}` }}>
                      <Button variant="contained">Editar</Button>
                    </Link>
                  </TableCell>
                  <TableCell  align="right"><Button onClick={() => deletePost(produto.id)}>Deletar</Button></TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </div>
    </div>
  )
}
