import React from "react";
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom";

import CadastroArtista from './pages/CadastroArtista'
import CadastroEstabelecimento from './pages/CadastroEstabelecimento'
import EnderecoArtista from './pages/EnderecoArtista'
import Login from './pages/Login'
import TelaInicial from './pages/TelaInicial'


function Rotas() {
  return (
    <Router>
        <Routes>

            <Link to="/" className="seta-voltar-login">Cadastre-se</Link>

            <Route path="/" exact component={Login} />
            <Route path="/cadastro/" component={TelaInicial} />
        </Routes>
    </Router>
  );
}

export default Rotas;