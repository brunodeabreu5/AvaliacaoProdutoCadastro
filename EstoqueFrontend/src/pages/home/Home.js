import React, { useState } from 'react'

import Modal from 'react-modal'
import { useNavigate } from 'react-router-dom'

import api from '../../api/api'

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
  const [modalIsOpen, setIsOpen] = useState(false)

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
    precoVenda: '',
    precoDeCompra: ''
  })

  function submit(e) {
    e.preventDefault()
    api
      .post('/produto', {
        nomeProduto: data.nomeProduto,
        precoVenda: data.precoVenda,
        precoDeCompra: data.precoDeCompra
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

  return (
    <div className="fundo">
      <h1>Sitema de estoque</h1>
      <button onClick={openModal}>Cadastra</button>
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
                type="text"
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
            </div>
            <div className="buttonModal">
              <button type="submit">Salvar</button>
              <button onClick={closeModal}>close</button>
            </div>
          </form>
        </div>
      </Modal>

      <div className="fundoEstoque">
        <main>
          <div>
            <di className="barraDeNome">
              <p className="nome">Id</p>
              <p className="nome">Nome Produto</p>
              <p className="nome">Nome Produto</p>
              <p className="nome">Nome Produto</p>
              <p className="nome">Estoque</p>
            </di>

            {produtos.map((produto, key) => {
              return (
                <div key={key}>
                  <div className="produtosList">
                  <div className="nomeid">
                      <p>{produto.idproduto}</p>
                    </div>
                    <div className="nomePro">
                      <p>{produto.nomeProduto}</p>
                    </div>
                    <di className="precoVenda">
                      <p>R$  {produto.precoVenda}</p>
                    </di>
                    <div className="precoCompra">
                      {' '}
                      <p>R$  {produto.precoDeCompra}</p>
                      <button>Editar</button>
                      <button>Adicina Estoque</button>
                    </div>
                  </div>
                </div>
              )
            })}
          </div>
        </main>
      </div>
    </div>
  )
}
