import Logo from '../imgs/SOUNDRY_3.png'
import ImagemFundoDireitra from '../imgs/Rectangle 200 laranja.png'
import ImagemSombraDireita from '../imgs/Rectangle glass laranja.png'
import ImagemDireita from '../imgs/Saly-12 Cadastro Artista.png'
import LinhasCirculo from '../imgs/decoration laranja.png'
import LinhaLaranja from '../imgs/path (Stroke).png'
import SetaVoltar from '../imgs/seta voltar tela.png'

import { useEffect, useState } from "react";
import api from '../api'

import "../css/style_pagina.css"
import "../css/style_formulario.css"

function CadastroArtista(){



    return (
        <>
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Lato" />
        <div class="pagina">
            <div class="div-esquerda">
                <div class="logo">
                    <img src={Logo} alt="Logo do servico Soundry"/>
                </div>
                <img src={SetaVoltar} alt="" className="seta-voltar"/>
                <div class="formulario-login">
                    <div class='titulo-login'>
                        <h2>Cadastre-se</h2>
                        <img src={LinhaLaranja} alt="" />
                    </div>
        
                    <form method="get">
                        <div class="div_input_formulario">
                            <label for="nome" class="texto">Nome</label>
                            <input id="nome" class="input_formulario" type="text" placeholder="Escreva seu nome"/>
                        </div>
                        <div class="div_input_formulario">
                            <label for="telefone" class="texto">Telefone</label>
                            <input id="telefone" class="input_formulario" type="text" placeholder="() 00000-0000"/>
                        </div>
                        <div class="div_input_formulario">
                            <label for="cnpj" class="texto">CNPJ</label>
                            <input id="cnpj" class="input_formulario" type="text" placeholder="00.000.000/0000-00"/>
                        </div>
                        <div class="div_input_formulario">
                            <label for="genero" class="texto">Gênero</label>
                            <input id="genero" class="input_formulario" type="text" placeholder="Escreva seu e-mail"/>
                        </div>
                        <div class="div_input_formulario">
                            <label for="qtdArtistasSuportados" class="texto">Quantidade de artistas suportados</label>
                            <input id="qtdArtistasSuportados" class="input_formulario" type="text" placeholder="Digite a quantidade de artistas suportados"/>
                        </div>
                        <div class="div_input_formulario">
                            <label for="email" class="texto">E-mail</label>
                            <input id="email" class="input_formulario" type="text" placeholder="Escreva seu e-mail"/>
                        </div>
                        <div class="div_input_formulario">
                            <label for="senha" class="texto">Senha</label>
                            <input id="senha" class="input_formulario" type="password" placeholder="Escreva sua senha"/>
                        </div>
                        <div class="button">
                            <button type="submit">Próximo Passo</button>
                        </div>
                        <div class="footer-botao">
                            <p class="cadastrar">Já tem cadastro?</p>
                            <p class="cadastrar">Clique aqui e começe já</p>
                        </div>
                    </form>
                </div>
                <p class="copywrite">© 2022 Soundry. Todos os direitos reservados</p>
            </div>
            <div class="div-direita">
                <div className="titulo-pagina">
                    <p>Entre agora para a revolução das apresentações artisticas</p>
                </div>
                <img src={ImagemFundoDireitra} alt="" className="imagem-fundo"/>
                <img src={LinhasCirculo} alt="" className="linhas-circulo"/>
                <img src={ImagemSombraDireita} alt="" className="imagem-sombra"/>
                <img src={ImagemDireita} alt="" className="imagem-direita-celular"/>
            </div>
        </div>
        </>
    );
}

export default CadastroArtista;