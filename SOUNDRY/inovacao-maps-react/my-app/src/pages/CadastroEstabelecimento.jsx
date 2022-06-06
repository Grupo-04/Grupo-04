import Logo from '../imgs/SOUNDRY_3.png'
import ImagemFundoDireitra from '../imgs/Rectangle 200 rosa.png'
import ImagemSombraDireita from '../imgs/Rectangle glass rosa.png'
import ImagemDireita from '../imgs/Saly-11 Cadastro Estabelecimento.png'
import LinhasCirculo from '../imgs/decoration rosa.png'
import LinhaLaranja from '../imgs/path (Stroke).png'
import SetaVoltar from '../imgs/seta voltar tela.png'

import "../css/style_pagina.css"
import "../css/style_formulario.css"

function CadastroEstabelecimento(){
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
                        </div>
            
                        <form method="get">
                            <div className="div_input_formulario">
                                <label for="nome" className="texto">Nome</label>
                                <input id="nome" className="input_formulario" type="text" placeholder="Escreva seu nome"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="telefone" className="texto">Telefone</label>
                                <input id="telefone" className="input_formulario" type="text" placeholder="() 00000-0000"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="cnpj" className="texto">CNPJ</label>
                                <input id="cnpj" className="input_formulario" type="text" placeholder="00.000.000/0000-00"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="genero" className="texto">Gênero</label>
                                <input id="genero" className="input_formulario" type="text" placeholder="Escreva seu e-mail"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="qtdArtistasSuportados" className="texto">Quantidade de artistas suportados</label>
                                <input id="qtdArtistasSuportados" className="input_formulario" type="text" placeholder="Digite a quantidade de artistas suportados"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="email" className="texto">E-mail</label>
                                <input id="email" className="input_formulario" type="text" placeholder="Escreva seu e-mail"/>
                            </div>
                            <div className="div_input_formulario">
                                <label for="senha" className="texto">Senha</label>
                                <input id="senha" className="input_formulario" type="password" placeholder="Escreva sua senha"/>
                            </div>
                            <div className="button">
                                <button type="submit">Próximo Passo</button>
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
                        <p>Entre agora para fazer as melhores apresentações no seu estabelecimento</p>
                    </div>
                    <img src={ImagemFundoDireitra} alt="" className="imagem-fundo"/>
                    <img src={LinhasCirculo} alt="" className="linhas-circulo"/>
                    <img src={ImagemSombraDireita} alt="" className="imagem-sombra"/>
                    <img src={ImagemDireita} alt="" className="imagem-direita-homem-computador"/>
                </div>
            </div>
        </>
    );
}

export default CadastroEstabelecimento;