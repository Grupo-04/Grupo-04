import Logo from '../imgs/SOUNDRY_3.png'
import ImagemFundoDireitra from '../imgs/Rectangle 200 verde.png'
import ImagemSombraDireita from '../imgs/Rectangle glass verde.png'
import ImagemDireita from '../imgs/Saly-44 Endereco.png'
import LinhasCirculo from '../imgs/decoration verde.png'
import LinhaLaranja from '../imgs/path (Stroke).png'
import SetaVoltar from '../imgs/seta voltar tela.png'

import React, { useEffect, useState } from "react";
import api from "../api/api"
import { useNavigate } from 'react-router-dom';

import "../css/style_pagina.css"
import "../css/style_formulario.css"

function EnderecoArtista(){

    const [cep, setCep] = useState('');
    const [logradouro, setLogradouro] = useState('');
    const [numero, setNumero] = useState('');
    const [uf, setUf] = useState('');
    const [bairro, setBairro] = useState('');
    const [cidade, setCidade] = useState('');

    const handleCep = (e) =>{
        setCep(e.target.value)
    }

    const handleLogradouro = (e) =>{
        setLogradouro(e.target.value)
    }

    const handleNumero = (e) =>{
        setNumero(e.target.value)
    }

    const handleUf = (e) =>{
        setUf(e.target.value)
    }

    const handleBairro = (e) =>{
        setBairro(e.target.value)
    }

    const handleCidade = (e) =>{
        setCidade(e.target.value)
    }

    const navigate = useNavigate();
    const routeChange = (path) =>{  
        navigate(path);
    }

    const handleApi = () =>{
        let data = {
            nome: window.sessionStorage.getItem("nome"),
            telefone: window.sessionStorage.getItem("telefone"),
            cpf: window.sessionStorage.getItem("cpf"),
            estilo: window.sessionStorage.getItem("estilo"),
            grupo: window.sessionStorage.getItem("grupo"),
            qtdIntegrantes: window.sessionStorage.getItem("qtdIntegrantes"),
            tipo: window.sessionStorage.getItem("tipo"),
            nome_artistico: window.sessionStorage.getItem("nome_artistico"),
            email: window.sessionStorage.getItem("email"),
            senha: window.sessionStorage.getItem("senha"),
            endereco: {
                cep: cep,
                logradouro: logradouro,
                numero: numero,
                uf: uf,
                bairro: bairro,
                cidade: cidade
            }
        }
        api.post('/grupo-artista', data)
        .then(result=>{
            console.log("RESULT: ", result)
            routeChange('/login')
        })
        .catch(error =>{
            console.log("ERROR: ", error);
        })
    }


    return (
        <>
            <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Lato" />
            <div className="pagina">
                <div className="div-esquerda">
                    <div className="logo">
                        <img src={Logo} alt="Logo do servico Soundry"/>
                    </div>
                    
                    <img src={SetaVoltar} alt="" className="seta-voltar"/>
                    <div className="formulario-login">
                        <div className='titulo-login'>
                            <h2>Cadastre-se</h2>
                            <img src={LinhaLaranja} alt="" />
                            <h3>Artista ▶ <b className="endereco-sublinhado">Endereço</b></h3>
                        </div>
            
                        <div >
                            <div className="div_input_formulario">
                                <label for="cep" className="texto">CEP</label>
                                <input id="cep" value={cep} onChange={handleCep} className="input_formulario" type="text" placeholder="Digite o seu CEP"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="logradouro" className="texto">Logradouro</label>
                                <input id="logradouro" value={logradouro} onChange={handleLogradouro} className="input_formulario" type="text" placeholder="Escreva seu logradouro"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="numero" className="texto">Número</label>
                                <input id="numero" value={numero} onChange={handleNumero} className="input_formulario" type="text" placeholder="Digite o número da sua residência"/>
                            </div>
                            <div className="div_input_formulario_uf">
                                <label for="uf" className="texto">UF</label>
                                <div className="input_uf">
                                    <input id="uf" className="input_formulario" value={uf} onChange={handleUf} type="text" placeholder="XX"/>
                                    <input className="input_formulario" value={cidade} onChange={handleCidade} type="text" placeholder="Escreva sua cidade"/>
                                </div>
                            </div>
                            <div className="div_input_formulario">
                                <label for="bairro" className="texto">Bairro</label>
                                <input id="bairro" value={bairro} onChange={handleBairro} className="input_formulario" type="text" placeholder="Escreva seu bairro"/>
                            </div>
                            {/* <div className="div_input_formulario">
                                <label for="cidade" className="texto">Cidade</label>
                                <input id="cidade" className="input_formulario" type="text" placeholder="Escreva seu e-mail"/>
                            </div> */}
                            <div className="button">
                                <button type="submit" onClick={handleApi}>Finalizar cadastro</button>
                            </div>
                            <div className="footer-botao">
                                <p className="cadastrar">Já tem cadastro?</p>
                                <p className="cadastrar">Clique aqui e começe já</p>
                            </div>
                        </div>
                    </div>
                    <p className="copywrite">© 2022 Soundry. Todos os direitos reservados</p>
                </div>
                <div className="div-direita">
                    <div className="titulo-pagina">
                        <p>Diga aonde está!</p>
                        <p>Suas apresentações se tornaram melhores, e próximas</p>
                    </div>
                    <img src={ImagemFundoDireitra} alt="" className="imagem-fundo"/>
                    <img src={LinhasCirculo} alt="" className="linhas-circulo"/>
                    <img src={ImagemSombraDireita} alt="" className="imagem-sombra"/>
                    <img src={ImagemDireita} alt="" className="imagem-direita-planeta"/>
                </div>
            </div>
        </>
    );
}

export default EnderecoArtista;