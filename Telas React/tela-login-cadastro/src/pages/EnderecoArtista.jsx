import Logo from '../imgs/SOUNDRY_3.png'
import ImagemFundoDireitra from '../imgs/Rectangle 200 verde.png'
import ImagemSombraDireita from '../imgs/Rectangle glass verde.png'
import ImagemDireita from '../imgs/Saly-44 Endereco.png'
import LinhasCirculo from '../imgs/decoration verde.png'
import LinhaLaranja from '../imgs/path (Stroke).png'
import SetaVoltar from '../imgs/seta voltar tela.png'

import React, { useEffect, useState } from "react";
import api from "../services/api"

import "../css/style_pagina.css"
import "../css/style_formulario.css"

function EnderecoArtista(){
    const [ceps, setCEPs] = useState([]);

    useEffect(() => {
        api.get("/01001000/json").then((resposta) => {
            setCEPs(resposta.data)
        })
      }, []);
    
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
                            {/* {
                                ceps.map((res) => 
                                    <h1> {res} </h1>
                                )
                            } */}
                            <img src={LinhaLaranja} alt="" />
                            <h3>Artista ▶ <b className="endereco-sublinhado">Endereço</b></h3>
                        </div>
            
                        <form method="get">
                            <div className="div_input_formulario">
                                <label for="cep" className="texto">CEP</label>
                                <input id="cep" className="input_formulario" type="text" placeholder="Digite o seu CEP"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="logradouro" className="texto">Logradouro</label>
                                <input id="logradouro" className="input_formulario" type="text" placeholder="Escreva seu logradouro"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="numero" className="texto">Número</label>
                                <input id="numero" className="input_formulario" type="text" placeholder="Digite o número da sua residência"/>
                            </div>
                            <div className="div_input_formulario_uf">
                                <label for="uf" className="texto">UF</label>
                                <div className="input_uf">
                                    <input id="uf" className="input_formulario" type="text" placeholder="XX"/>
                                    <input className="input_formulario" type="text" placeholder="Escreva sua cidade"/>
                                </div>
                            </div>
                            <div className="div_input_formulario">
                                <label for="bairro" className="texto">Bairro</label>
                                <input id="bairro" className="input_formulario" type="text" placeholder="Escreva seu bairro"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="cidade" className="texto">Cidade</label>
                                <input id="cidade" className="input_formulario" type="text" placeholder="Escreva seu e-mail"/>
                            </div>
                            <div className="button">
                                <button type="submit">Finalizar cadastro</button>
                            </div>
                            <div className="footer-botao">
                                <p className="cadastrar">Já tem cadastro?</p>
                                <p className="cadastrar">Clique aqui e começe já</p>
                            </div>
                        </form>
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