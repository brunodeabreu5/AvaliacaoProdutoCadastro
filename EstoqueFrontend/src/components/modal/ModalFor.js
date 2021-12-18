import React from "react";

import Modal from 'react-modal'
import api from '../../api/api'

export default function ModalFor({modalIsOpenFor,customStyles,closeModalFor,handlefor,closeModal}){


 

  const[data,setData] = React.useState({
    NomeDoFornecedor:''
  })

  function submitFor(e) {
   
    api
      .post('/fornecedor', {
        NomeDoFornecedor:data.NomeDoFornecedor
      })
      .then(response => {
        console.log(response.data)
       
      })
  }

  function handlefor(e) {
    const newdata = { ...data }
    newdata[e.target.id] = e.target.value
    setData(newdata)
    
  }

  return(
    <Modal
    isOpen={modalIsOpenFor}
    onRequestClose={closeModal}
    contentLabel="Example Modal"
    style={customStyles}
  >
    <form onSubmit={e => submitFor(e)}>
      <div className="modal">
        Nome Fornecedor:
        <input
          onChange={e => handlefor(e)}
          value={data.NomeDoFornecedor}
          type="text"
          id="NomeDoFornecedor"
        />
      </div>
    </form>
    <button onClick={closeModalFor}>close</button>
    <button type="submitFor">Salvar</button>
  </Modal>


  )

}