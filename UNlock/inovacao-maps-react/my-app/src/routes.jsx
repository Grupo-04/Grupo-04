import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import CadastroArtista from './pages/CadastroArtista'
import CadastroEstabelecimento from './pages/CadastroEstabelecimento'
import EnderecoArtista from './pages/EnderecoArtista'
import Login from './pages/Login'
import TelaInicial from './pages/TelaInicial'


function Rotas() {
  return (
      <Routes>
          <Route path="/" exact component={Login} />
          <Route path="/cadastro/" component={TelaInicial} />
      </Routes>
  );
}

export default Rotas;